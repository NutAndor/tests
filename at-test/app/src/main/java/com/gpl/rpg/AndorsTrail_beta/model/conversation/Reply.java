package com.gpl.rpg.AndorsTrail_beta.model.conversation;

import com.gpl.rpg.AndorsTrail_beta.model.script.Requirement;

public final class Reply {
	public final String text;
	public final String nextPhrase;
	public final Requirement[] requires;

	public boolean hasRequirements() {
		return requires != null;
	}

	public Reply(
			String text
			, String nextPhrase
			, Requirement[] requires
	) {
		this.text = text;
		this.nextPhrase = nextPhrase;
		this.requires = requires;
	}
}
