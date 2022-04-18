package com.gpl.rpg.AndorsTrail_beta.savegames;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import com.gpl.rpg.AndorsTrail_beta.AndorsTrailApplication;
import com.gpl.rpg.AndorsTrail_beta.context.ControllerContext;
import com.gpl.rpg.AndorsTrail_beta.context.WorldContext;
import com.gpl.rpg.AndorsTrail_beta.controller.WorldMapController;
import com.gpl.rpg.AndorsTrail_beta.model.actor.Monster;
import com.gpl.rpg.AndorsTrail_beta.model.map.MonsterSpawnArea;
import com.gpl.rpg.AndorsTrail_beta.model.map.PredefinedMap;
import com.gpl.rpg.AndorsTrail_beta.model.map.WorldMapSegment;
import com.gpl.rpg.AndorsTrail_beta.util.L;

import android.content.res.Resources;

public class LegacySavegamesContentAdaptations {
	
	public static void adaptToNewContentForVersion45(WorldContext world, ControllerContext controllers, Resources res) {
		PredefinedMap fields5Map = world.maps.findPredefinedMap("fields5");
		if (fields5Map != null) {
			for (MonsterSpawnArea area : fields5Map.spawnAreas) {
				if (area.monsters != null) {
					for (Monster m : area.monsters) {
						if (m.getMonsterTypeID().equals("feygard_bridgeguard")) {
							area.resetForNewGame();
							for (MonsterSpawnArea newarea : fields5Map.spawnAreas) {
								if (newarea.areaID.equals("guynmart_robber1")) {
									controllers.monsterSpawnController.spawnAllInArea(fields5Map, 
											(world.model.currentMaps.map == fields5Map ? world.model.currentMaps.tileMap : null),
											newarea, true);
									break;
								}
							}
							break;
						}
					}
				}
			}
		}
		//Force update of existing worldmaps to ensure regenerating the html when needed, using the new UTF-8-enabled template.
		List<String> segmentsCovered = new LinkedList<String>();
		for (WorldMapSegment segment : world.maps.worldMapSegments.values()) {
			if (segment == null || segment.name == null) continue;
			if (segmentsCovered.contains(segment.name)) continue;
			segmentsCovered.add(segment.name);
			try {
				WorldMapController.updateWorldMapSegment(controllers.getContext(), res, world, segment.name);
				if (AndorsTrailApplication.DEVELOPMENT_DEBUGMESSAGES) {
					L.log("Forcing generation of worldmap file for segment " + segment.name);
				}
			} catch (IOException e) {
				L.log("Error creating worldmap file for segment " + segment.name + " : " + e.toString());
			}
		}
	}

}
