package com.gpl.rpg.AndorsTrail_beta.resource.parsers;

import org.json.JSONException;
import org.json.JSONObject;

import com.gpl.rpg.AndorsTrail_beta.model.ability.ActorConditionTypeCollection;
import com.gpl.rpg.AndorsTrail_beta.model.item.ItemCategoryCollection;
import com.gpl.rpg.AndorsTrail_beta.model.item.ItemTraits_OnEquip;
import com.gpl.rpg.AndorsTrail_beta.model.item.ItemTraits_OnHitReceived;
import com.gpl.rpg.AndorsTrail_beta.model.item.ItemTraits_OnUse;
import com.gpl.rpg.AndorsTrail_beta.model.item.ItemType;
import com.gpl.rpg.AndorsTrail_beta.resource.DynamicTileLoader;
import com.gpl.rpg.AndorsTrail_beta.resource.TranslationLoader;
import com.gpl.rpg.AndorsTrail_beta.resource.parsers.json.JsonCollectionParserFor;
import com.gpl.rpg.AndorsTrail_beta.resource.parsers.json.JsonFieldNames;
import com.gpl.rpg.AndorsTrail_beta.util.Pair;

public final class ItemTypeParser extends JsonCollectionParserFor<ItemType> {

	private final DynamicTileLoader tileLoader;
	private final TranslationLoader translationLoader;
	private final ItemTraitsParser itemTraitsParser;
	private final ItemCategoryCollection itemCategories;

	public ItemTypeParser(
			DynamicTileLoader tileLoader,
			ActorConditionTypeCollection actorConditionsTypes,
			ItemCategoryCollection itemCategories,
			TranslationLoader translationLoader) {
		this.tileLoader = tileLoader;
		this.translationLoader = translationLoader;
		this.itemTraitsParser = new ItemTraitsParser(actorConditionsTypes);
		this.itemCategories = itemCategories;
	}

	@Override
	public Pair<String, ItemType> parseObject(JSONObject o) throws JSONException {
		final String id = o.getString(JsonFieldNames.ItemType.itemTypeID);
		final String itemTypeName = translationLoader.translateItemTypeName(o.getString(JsonFieldNames.ItemType.name));
		final String description = translationLoader.translateItemTypeDescription(o.optString(JsonFieldNames.ItemType.description, null));
		final ItemTraits_OnEquip equipEffect = itemTraitsParser.parseItemTraits_OnEquip(o.optJSONObject(JsonFieldNames.ItemType.equipEffect));
		final ItemTraits_OnUse useEffect = itemTraitsParser.parseItemTraits_OnUse(o.optJSONObject(JsonFieldNames.ItemType.useEffect));
		final ItemTraits_OnUse hitEffect = itemTraitsParser.parseItemTraits_OnUse(o.optJSONObject(JsonFieldNames.ItemType.hitEffect));
		final ItemTraits_OnUse killEffect = itemTraitsParser.parseItemTraits_OnUse(o.optJSONObject(JsonFieldNames.ItemType.killEffect));
		final ItemTraits_OnHitReceived hitReceivedEffect = itemTraitsParser.parseItemTraits_OnHitReceived(o.optJSONObject(JsonFieldNames.ItemType.hitReceivedEffect));
		
		final int baseMarketCost = o.optInt(JsonFieldNames.ItemType.baseMarketCost);
		final boolean hasManualPrice = o.optInt(JsonFieldNames.ItemType.hasManualPrice, 0) > 0;
		final ItemType itemType = new ItemType(
				id
				, ResourceParserUtils.parseImageID(tileLoader, o.getString(JsonFieldNames.ItemType.iconID))
				, itemTypeName
				, description
				, itemCategories.getItemCategory(o.getString(JsonFieldNames.ItemType.category))
				, ItemType.DisplayType.fromString(o.optString(JsonFieldNames.ItemType.displaytype, null), ItemType.DisplayType.ordinary)
				, hasManualPrice
				, baseMarketCost
				, equipEffect
				, useEffect
				, hitEffect
				, killEffect
				, hitReceivedEffect
			);
		return new Pair<String, ItemType>(id, itemType);
	}
}
