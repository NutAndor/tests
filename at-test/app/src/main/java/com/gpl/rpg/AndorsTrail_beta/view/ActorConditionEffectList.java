package com.gpl.rpg.AndorsTrail_beta.view;

import java.util.Collection;

import android.content.Context;
import android.content.res.Resources;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.gpl.rpg.AndorsTrail_beta.Dialogs;
import com.gpl.rpg.AndorsTrail_beta.R;
import com.gpl.rpg.AndorsTrail_beta.model.ability.ActorCondition;
import com.gpl.rpg.AndorsTrail_beta.model.ability.ActorConditionEffect;
import com.gpl.rpg.AndorsTrail_beta.model.ability.ActorConditionType;

public final class ActorConditionEffectList extends LinearLayout {

	public ActorConditionEffectList(Context context, AttributeSet attr) {
		super(context, attr);
		setFocusable(false);
		setOrientation(LinearLayout.VERTICAL);
	}

	public void update(Collection<ActorConditionEffect> effects) {
		removeAllViews();
		if (effects == null) return;

		final Context context = getContext();
		final Resources res = getResources();
		LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);

		for (ActorConditionEffect e : effects) {
			String msg;
			final ActorConditionType conditionType = e.conditionType;
			msg = describeEffect(res, e);
			TextView tv = new TextView(context);
			tv.setLayoutParams(layoutParams);

			SpannableString content = new SpannableString(msg);
			content.setSpan(new UnderlineSpan(), 0, content.length(), 0);
			tv.setText(content);
			tv.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View arg0) {
					Dialogs.showActorConditionInfo(context, conditionType);
				}
			});
			this.addView(tv, layoutParams);
		}
	}

	public static String describeEffect(Resources res, ActorConditionEffect effect) {
		StringBuilder sb = new StringBuilder();
		if (effect.isImmunity()) {
			sb.append(res.getString(R.string.actorcondition_info_immunity, effect.conditionType.name));
		} else if (effect.isRemovalEffect()) {
			sb.append(res.getString(R.string.actorcondition_info_removes_all, effect.conditionType.name));
		} else {
			sb.append(effect.conditionType.name);
			if (effect.magnitude > 1) {
				sb.append(" x");
				sb.append(effect.magnitude);
			}
		}
		if (ActorCondition.isTemporaryEffect(effect.duration)) {
			sb.append(' ');
			sb.append(res.getString(R.string.iteminfo_effect_duration, effect.duration));
		}
		String msg = sb.toString();
		if (effect.chance.isMax()) return msg;

		return res.getString(R.string.iteminfo_effect_chance_of, effect.chance.toPercentString(), msg);

	}
}
