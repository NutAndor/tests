package com.gpl.rpg.AndorsTrail_beta.model.item;

import com.gpl.rpg.AndorsTrail_beta.model.ability.ActorConditionEffect;
import com.gpl.rpg.AndorsTrail_beta.model.ability.traits.AbilityModifierTraits;

public final class ItemTraits_OnEquip {
	public final AbilityModifierTraits stats;
	public final ActorConditionEffect[] addedConditions;

	public ItemTraits_OnEquip(
			AbilityModifierTraits stats
			, ActorConditionEffect[] addedConditions
	) {
		this.stats = stats;
		this.addedConditions = addedConditions;
	}

	public int calculateEquipCost(boolean isWeapon) {
		final int costStats = stats == null ? 0 : stats.calculateCost(isWeapon);
		return costStats;
	}
}
