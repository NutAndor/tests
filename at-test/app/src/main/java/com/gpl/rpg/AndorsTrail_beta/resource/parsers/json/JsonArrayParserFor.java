package com.gpl.rpg.AndorsTrail_beta.resource.parsers.json;

import java.lang.reflect.Array;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;

public abstract class JsonArrayParserFor<T> extends JsonParserFor<T> {
	private final Class<T> classType;

	protected JsonArrayParserFor(Class<T> classType) {
		if (classType == null) throw new IllegalArgumentException("classType for parseArray must not be null");
		this.classType = classType;
	}

	public T[] parseArray(JSONArray array) throws JSONException {
		if (array == null) return null;
		final ArrayList<T> arrayList = new ArrayList<T>(array.length());
		parseRows(array, arrayList);
		if (arrayList.isEmpty()) return null;
		return arrayList.toArray(newArray(arrayList.size()));
	}

	@SuppressWarnings("unchecked")
	private T[] newArray(int size) {
		return (T[]) Array.newInstance(classType, size);
	}
}
