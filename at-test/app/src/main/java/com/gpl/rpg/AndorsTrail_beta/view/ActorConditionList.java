package com.gpl.rpg.AndorsTrail_beta.view;

import android.content.Context;
import android.content.res.Resources;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.gpl.rpg.AndorsTrail_beta.AndorsTrailApplication;
import com.gpl.rpg.AndorsTrail_beta.Dialogs;
import com.gpl.rpg.AndorsTrail_beta.R;
import com.gpl.rpg.AndorsTrail_beta.context.WorldContext;
import com.gpl.rpg.AndorsTrail_beta.model.ability.ActorCondition;
import com.gpl.rpg.AndorsTrail_beta.model.ability.ActorConditionEffect;
import com.gpl.rpg.AndorsTrail_beta.model.ability.ActorConditionType;
import com.gpl.rpg.AndorsTrail_beta.util.ConstRange;

public final class ActorConditionList extends LinearLayout {

	private final WorldContext world;

	public ActorConditionList(Context context, AttributeSet attr) {
		super(context, attr);
		setFocusable(false);
		setOrientation(LinearLayout.VERTICAL);
		AndorsTrailApplication app = AndorsTrailApplication.getApplicationFromActivityContext(context);
		this.world = app.getWorld();
	}

	public void update(Iterable<ActorCondition> conditions, Iterable<ActorCondition> immunities) {
		removeAllViews();
		if (conditions == null) return;

		final Context context = getContext();
		final Resources res = getResources();
		LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);

		for (ActorCondition c : conditions) {
			addConditionEffect(context, res, layoutParams, c, false);
		}

		for (ActorCondition c : immunities) {
			addConditionEffect(context, res, layoutParams, c, true);
		}
	}

	private void addConditionEffect(final Context context, final Resources res, LinearLayout.LayoutParams layoutParams,
			ActorCondition c, boolean immunity) {
		TextView v = (TextView) View.inflate(context, R.layout.actorconditionitemview, null);
		world.tileManager.setImageViewTile(res, v, c.conditionType, immunity);
		SpannableString content = new SpannableString(describeEffect(res, c));
		content.setSpan(new UnderlineSpan(), 0, content.length(), 0);
		v.setText(content);
		final ActorConditionType conditionType = c.conditionType;
		v.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				Dialogs.showActorConditionInfo(context, conditionType);
			}
		});
		this.addView(v, layoutParams);
	}
	
	

	private static final ConstRange MAX_CHANCE = new ConstRange(1,1);
	
	private static String describeEffect(Resources res, ActorCondition c) {
		return ActorConditionEffectList.describeEffect(res, new ActorConditionEffect(c.conditionType, c.magnitude, c.duration, MAX_CHANCE));
	}
}
