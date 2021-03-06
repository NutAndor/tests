package com.gpl.rpg.AndorsTrail_beta.resource.parsers;

import org.json.JSONException;
import org.json.JSONObject;

import com.gpl.rpg.AndorsTrail_beta.AndorsTrailApplication;
import com.gpl.rpg.AndorsTrail_beta.model.ability.ActorCondition;
import com.gpl.rpg.AndorsTrail_beta.model.ability.ActorConditionEffect;
import com.gpl.rpg.AndorsTrail_beta.model.ability.ActorConditionTypeCollection;
import com.gpl.rpg.AndorsTrail_beta.model.ability.traits.AbilityModifierTraits;
import com.gpl.rpg.AndorsTrail_beta.model.ability.traits.StatsModifierTraits;
import com.gpl.rpg.AndorsTrail_beta.model.item.ItemTraits_OnEquip;
import com.gpl.rpg.AndorsTrail_beta.model.item.ItemTraits_OnHitReceived;
import com.gpl.rpg.AndorsTrail_beta.model.item.ItemTraits_OnUse;
import com.gpl.rpg.AndorsTrail_beta.resource.parsers.json.JsonArrayParserFor;
import com.gpl.rpg.AndorsTrail_beta.resource.parsers.json.JsonFieldNames;
import com.gpl.rpg.AndorsTrail_beta.util.ConstRange;
import com.gpl.rpg.AndorsTrail_beta.util.L;

public final class ItemTraitsParser {
	private final JsonArrayParserFor<ActorConditionEffect> actorConditionEffectParser_withDuration;
	private final JsonArrayParserFor<ActorConditionEffect> actorConditionEffectParser_withoutDuration;

	public ItemTraitsParser(final ActorConditionTypeCollection actorConditionTypes) {
		this.actorConditionEffectParser_withDuration = new JsonArrayParserFor<ActorConditionEffect>(ActorConditionEffect.class) {
			@Override
			protected ActorConditionEffect parseObject(JSONObject o) throws JSONException {
				return new ActorConditionEffect(
						actorConditionTypes.getActorConditionType(o.getString(JsonFieldNames.ActorConditionEffect.condition))
						, o.optInt(JsonFieldNames.ActorConditionEffect.magnitude, ActorCondition.MAGNITUDE_REMOVE_ALL)
						, o.optInt(JsonFieldNames.ActorConditionEffect.duration, ActorCondition.DURATION_NONE)
						, ResourceParserUtils.parseChance(o.getString(JsonFieldNames.ActorConditionEffect.chance))
				);
			}
		};
		this.actorConditionEffectParser_withoutDuration = new JsonArrayParserFor<ActorConditionEffect>(ActorConditionEffect.class) {
			@Override
			protected ActorConditionEffect parseObject(JSONObject o) throws JSONException {
				return new ActorConditionEffect(
						actorConditionTypes.getActorConditionType(o.getString(JsonFieldNames.ActorConditionEffect.condition))
						, o.optInt(JsonFieldNames.ActorConditionEffect.magnitude, 1)
						, ActorCondition.DURATION_FOREVER
						, ResourceParserUtils.always
				);
			}
		};
	}

	public ItemTraits_OnUse parseItemTraits_OnUse(JSONObject o) throws JSONException {
		if (o == null) return null;

		ConstRange boostCurrentHP = ResourceParserUtils.parseConstRange(o.optJSONObject(JsonFieldNames.ItemTraits_OnUse.increaseCurrentHP));
		ConstRange boostCurrentAP = ResourceParserUtils.parseConstRange(o.optJSONObject(JsonFieldNames.ItemTraits_OnUse.increaseCurrentAP));
		ActorConditionEffect[] addedConditions_source = actorConditionEffectParser_withDuration.parseArray(o.optJSONArray(JsonFieldNames.ItemTraits_OnUse.conditionsSource));
		ActorConditionEffect[] addedConditions_target = actorConditionEffectParser_withDuration.parseArray(o.optJSONArray(JsonFieldNames.ItemTraits_OnUse.conditionsTarget));
		if (	   boostCurrentHP == null
				&& boostCurrentAP == null
				&& addedConditions_source == null
				&& addedConditions_target == null
			) {
			if (AndorsTrailApplication.DEVELOPMENT_VALIDATEDATA) {
				L.log("OPTIMIZE: Tried to parseItemTraits_OnUse , where hasEffect=" + o.toString() + ", but all data was empty.");
			}
			return null;
		} else {
			return new ItemTraits_OnUse(
					new StatsModifierTraits(
						null
						,boostCurrentHP
						,boostCurrentAP
					)
					,addedConditions_source
					,addedConditions_target
					);
		}
	}

	public ItemTraits_OnHitReceived parseItemTraits_OnHitReceived(JSONObject o) throws JSONException {
		if (o == null) return null;

		ConstRange boostCurrentHP = ResourceParserUtils.parseConstRange(o.optJSONObject(JsonFieldNames.ItemTraits_OnHitReceived.increaseCurrentHP));
		ConstRange boostCurrentAP = ResourceParserUtils.parseConstRange(o.optJSONObject(JsonFieldNames.ItemTraits_OnHitReceived.increaseCurrentAP));
		ConstRange boostAttackerCurrentHP = ResourceParserUtils.parseConstRange(o.optJSONObject(JsonFieldNames.ItemTraits_OnHitReceived.increaseAttackerCurrentHP));
		ConstRange boostAttackerCurrentAP = ResourceParserUtils.parseConstRange(o.optJSONObject(JsonFieldNames.ItemTraits_OnHitReceived.increaseAttackerCurrentAP));
		ActorConditionEffect[] addedConditions_source = actorConditionEffectParser_withDuration.parseArray(o.optJSONArray(JsonFieldNames.ItemTraits_OnHitReceived.conditionsSource));
		ActorConditionEffect[] addedConditions_target = actorConditionEffectParser_withDuration.parseArray(o.optJSONArray(JsonFieldNames.ItemTraits_OnHitReceived.conditionsTarget));
		if (	   boostCurrentHP == null
				&& boostCurrentAP == null
				&& boostAttackerCurrentAP == null
				&& boostCurrentAP == null
				&& addedConditions_source == null
				&& addedConditions_target == null
			) {
			if (AndorsTrailApplication.DEVELOPMENT_VALIDATEDATA) {
				L.log("OPTIMIZE: Tried to parseItemTraits_OnHitReceived , where hasEffect=" + o.toString() + ", but all data was empty.");
			}
			return null;
		} else {
			return new ItemTraits_OnHitReceived(
					new StatsModifierTraits(
						null
						,boostCurrentHP
						,boostCurrentAP
					)
					, new StatsModifierTraits(
						null
						,boostAttackerCurrentHP
						,boostAttackerCurrentAP
					)
					,addedConditions_source
					,addedConditions_target
					);
		}
	}

	public ItemTraits_OnEquip parseItemTraits_OnEquip(JSONObject o) throws JSONException {
		if (o == null) return null;

		AbilityModifierTraits stats = ResourceParserUtils.parseAbilityModifierTraits(o);
		ActorConditionEffect[] addedConditions = actorConditionEffectParser_withoutDuration.parseArray(o.optJSONArray(JsonFieldNames.ItemTraits_OnEquip.addedConditions));

		if (stats == null && addedConditions == null) {
			if (AndorsTrailApplication.DEVELOPMENT_VALIDATEDATA) {
				L.log("OPTIMIZE: Tried to parseItemTraits_OnEquip , where hasEffect=" + o.toString() + ", but all data was empty.");
			}
			return null;
		} else {
			return new ItemTraits_OnEquip(stats, addedConditions);
		}
	}
}
