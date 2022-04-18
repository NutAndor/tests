package com.gpl.rpg.AndorsTrail_beta.controller.listeners;

import com.gpl.rpg.AndorsTrail_beta.model.actor.Monster;
import com.gpl.rpg.AndorsTrail_beta.model.map.PredefinedMap;
import com.gpl.rpg.AndorsTrail_beta.util.CoordRect;

public interface MonsterMovementListener {
	void onMonsterSteppedOnPlayer(Monster m);
	void onMonsterMoved(PredefinedMap map, Monster m, CoordRect previousPosition);
}
