package com.gpl.rpg.AndorsTrail_beta.controller.listeners;

import com.gpl.rpg.AndorsTrail_beta.model.actor.Monster;

public interface CombatTurnListener {
	void onCombatStarted();
	void onCombatEnded();
	void onNewPlayerTurn();
	void onMonsterIsAttacking(Monster m);
}
