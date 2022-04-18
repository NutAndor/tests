package com.gpl.rpg.AndorsTrail_beta.controller.listeners;

import com.gpl.rpg.AndorsTrail_beta.model.map.LayeredTileMap;
import com.gpl.rpg.AndorsTrail_beta.model.map.PredefinedMap;
import com.gpl.rpg.AndorsTrail_beta.util.Coord;

public interface MapLayoutListener {
	void onLootBagCreated(PredefinedMap map, Coord p);
	void onLootBagRemoved(PredefinedMap map, Coord p);
	void onMapTilesChanged(PredefinedMap map, LayeredTileMap tileMap);
}
