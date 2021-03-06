package com.gpl.rpg.AndorsTrail_beta.resource.parsers;

import org.json.JSONException;
import org.json.JSONObject;

import com.gpl.rpg.AndorsTrail_beta.model.item.Inventory;
import com.gpl.rpg.AndorsTrail_beta.model.item.ItemCategory;
import com.gpl.rpg.AndorsTrail_beta.resource.TranslationLoader;
import com.gpl.rpg.AndorsTrail_beta.resource.parsers.json.JsonCollectionParserFor;
import com.gpl.rpg.AndorsTrail_beta.resource.parsers.json.JsonFieldNames;
import com.gpl.rpg.AndorsTrail_beta.util.Pair;

public final class ItemCategoryParser extends JsonCollectionParserFor<ItemCategory> {

	private final TranslationLoader translationLoader;

	public ItemCategoryParser(TranslationLoader translationLoader) {

		this.translationLoader = translationLoader;
	}

	@Override
	protected Pair<String, ItemCategory> parseObject(JSONObject o) throws JSONException {
		final String id = o.getString(JsonFieldNames.ItemCategory.itemCategoryID);
		ItemCategory result = new ItemCategory(
				id
				, translationLoader.translateItemCategoryName(o.getString(JsonFieldNames.ItemCategory.name))
				, ItemCategory.ActionType.fromString(o.optString(JsonFieldNames.ItemCategory.actionType, null), ItemCategory.ActionType.none)
				, Inventory.WearSlot.fromString(o.optString(JsonFieldNames.ItemCategory.inventorySlot, null), null)
				, ItemCategory.ItemCategorySize.fromString(o.optString(JsonFieldNames.ItemCategory.size, null), ItemCategory.ItemCategorySize.none)
		);
		return new Pair<String, ItemCategory>(id, result);
	}
}
