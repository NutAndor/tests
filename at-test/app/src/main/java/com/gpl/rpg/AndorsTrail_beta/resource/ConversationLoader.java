package com.gpl.rpg.AndorsTrail_beta.resource;

import java.util.Collection;
import java.util.HashMap;

import android.content.res.Resources;

import com.gpl.rpg.AndorsTrail_beta.model.conversation.ConversationCollection;
import com.gpl.rpg.AndorsTrail_beta.model.conversation.Phrase;
import com.gpl.rpg.AndorsTrail_beta.resource.parsers.ConversationListParser;

public final class ConversationLoader {
	private final HashMap<String, Integer> resourceIDsPerPhraseID = new HashMap<String, Integer>();

	public void addIDs(int resourceId, Collection<String> ids) {
		for(String s : ids) resourceIDsPerPhraseID.put(s, resourceId);
	}

	public Phrase loadPhrase(String phraseID, ConversationCollection conversationCollection, Resources r) {
		if (conversationCollection.hasPhrase(phraseID)) {
			return conversationCollection.getPhrase(phraseID);
		}

		TranslationLoader translationLoader = new TranslationLoader(r.getAssets(), r);
		ConversationListParser conversationListParser = new ConversationListParser(translationLoader);
		int resourceID = resourceIDsPerPhraseID.get(phraseID);
		conversationCollection.initialize(conversationListParser, ResourceLoader.readStringFromRaw(r, resourceID));
		translationLoader.close();

		return conversationCollection.getPhrase(phraseID);
	}
}
