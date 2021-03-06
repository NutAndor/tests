package com.gpl.rpg.AndorsTrail_beta.model.ability;

import java.util.HashMap;

import com.gpl.rpg.AndorsTrail_beta.AndorsTrailApplication;
import com.gpl.rpg.AndorsTrail_beta.resource.parsers.ActorConditionsTypeParser;
import com.gpl.rpg.AndorsTrail_beta.util.L;

public final class ActorConditionTypeCollection {
	private final HashMap<String, ActorConditionType> conditionTypes = new HashMap<String, ActorConditionType>();

	public ActorConditionType getActorConditionType(String conditionTypeID) {
		if (AndorsTrailApplication.DEVELOPMENT_VALIDATEDATA) {
			if (!conditionTypes.containsKey(conditionTypeID)) {
				L.log("WARNING: Cannot find ActorConditionType \"" + conditionTypeID + "\".");
			}
		}
		return conditionTypes.get(conditionTypeID);
	}

	public void initialize(final ActorConditionsTypeParser parser, String input) {
		parser.parseRows(input, conditionTypes);
	}

	public HashMap<String, ActorConditionType> UNITTEST_getAllActorConditionsTypes() {
		return conditionTypes;
	}
}
