package com.gpl.rpg.AndorsTrail_beta.model.map;

import com.gpl.rpg.AndorsTrail_beta.model.script.Requirement;
import com.gpl.rpg.AndorsTrail_beta.util.CoordRect;

public final class ReplaceableMapSection {
	public boolean isApplied = false;
	public final CoordRect replacementArea;
	public final MapSection replaceLayersWith;
	public final Requirement requirement;
	private final String group;

	public ReplaceableMapSection(
			CoordRect replacementArea
			, MapSection replaceLayersWith
			, Requirement requirement
			, String group
	) {
		this.replacementArea = replacementArea;
		this.replaceLayersWith = replaceLayersWith;
		this.requirement = requirement;
		this.group = group;
	}

	public void apply(MapSection dest) {
		dest.replaceLayerContentsWith(replaceLayersWith, replacementArea);
		isApplied = true;
	}
}
