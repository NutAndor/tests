package com.gpl.rpg.AndorsTrail_beta.model.item;

import java.util.HashMap;

import com.gpl.rpg.AndorsTrail_beta.AndorsTrailApplication;
import com.gpl.rpg.AndorsTrail_beta.resource.parsers.DropListParser;
import com.gpl.rpg.AndorsTrail_beta.util.L;

public final class DropListCollection {
	public static final String DROPLIST_STARTITEMS = "startitems";

	private final HashMap<String, DropList> droplists = new HashMap<String, DropList>();

	public DropList getDropList(String droplistID) {
		if (droplistID == null || droplistID.length() <= 0) return null;

		if (AndorsTrailApplication.DEVELOPMENT_VALIDATEDATA) {
			if (!droplists.containsKey(droplistID)) {
				L.log("WARNING: Cannot find droplist \"" + droplistID + "\".");
			}
		}
		return droplists.get(droplistID);
	}

	public void initialize(final DropListParser parser, String input) {
		parser.parseRows(input, droplists);
	}

	// Unit test method. Not part of the game logic.
	public HashMap<String, DropList> UNITTEST_getAllDropLists() {
		return droplists;
	}
}
