package com.gpl.rpg.AndorsTrail_beta.savegames;

import java.io.DataInputStream;
import java.io.IOException;

import com.gpl.rpg.AndorsTrail_beta.model.actor.Monster;
import com.gpl.rpg.AndorsTrail_beta.model.actor.MonsterType;
import com.gpl.rpg.AndorsTrail_beta.model.map.MonsterSpawnArea;
import com.gpl.rpg.AndorsTrail_beta.util.Coord;

public final class LegacySavegameFormatReaderForMonster {
	public static Monster newFromParcel_pre_v25(DataInputStream src, int fileversion, MonsterType monsterType, MonsterSpawnArea area) throws IOException {
		Monster m = new Monster(monsterType, area);
		m.position.set(new Coord(src, fileversion));
		m.ap.current = src.readInt();
		m.health.current = src.readInt();
		if (fileversion >= 12) {
			if (src.readBoolean()) m.forceAggressive();
		}
		return m;
	}
}
