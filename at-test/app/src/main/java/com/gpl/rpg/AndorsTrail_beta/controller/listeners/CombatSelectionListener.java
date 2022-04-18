package com.gpl.rpg.AndorsTrail_beta.controller.listeners;

import com.gpl.rpg.AndorsTrail_beta.model.actor.Monster;
import com.gpl.rpg.AndorsTrail_beta.util.Coord;

public interface CombatSelectionListener {
	void onMonsterSelected(Monster m, Coord selectedPosition, Coord previousSelection);
	void onMovementDestinationSelected(Coord selectedPosition, Coord previousSelection);
	void onCombatSelectionCleared(Coord previousSelection);
}
