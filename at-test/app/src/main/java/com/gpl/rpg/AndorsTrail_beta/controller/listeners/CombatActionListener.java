package com.gpl.rpg.AndorsTrail_beta.controller.listeners;

import com.gpl.rpg.AndorsTrail_beta.controller.AttackResult;
import com.gpl.rpg.AndorsTrail_beta.model.ability.ActorConditionEffect;
import com.gpl.rpg.AndorsTrail_beta.model.actor.Monster;

public interface CombatActionListener {
	void onPlayerAttackMissed(Monster target, AttackResult attackResult);
	void onPlayerAttackSuccess(Monster target, AttackResult attackResult);
	void onMonsterAttackMissed(Monster attacker, AttackResult attackResult);
	void onMonsterAttackSuccess(Monster attacker, AttackResult attackResult);
	void onMonsterMovedDuringCombat(Monster m);
	void onPlayerKilledMonster(Monster target);
	void onPlayerStartedFleeing();
	void onPlayerFailedFleeing();
	void onPlayerDoesNotHaveEnoughAP();
	void onPlayerTauntsMonster(Monster attacker);
	void onPlayerReceviesActorCondition(ActorConditionEffect conditionEffect);
	void onMonsterReceivesActorCondition(ActorConditionEffect conditionEffect, Monster target);
	
}
