package com.gpl.rpg.AndorsTrail_beta.controller.listeners;

import com.gpl.rpg.AndorsTrail_beta.model.map.PredefinedMap;
import com.gpl.rpg.AndorsTrail_beta.util.Coord;

public interface PlayerMovementListener {
	void onPlayerMoved(PredefinedMap map, Coord newPosition, Coord previousPosition);
	void onPlayerEnteredNewMap(PredefinedMap map, Coord p);
}
