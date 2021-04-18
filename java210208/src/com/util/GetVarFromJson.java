package com.util;

import java.io.FileNotFoundException;
import java.io.FileReader;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class GetVarFromJson {
	private static GetVarFromJson gvfj = null;
	GetVarFromJson() {}
	public static GetVarFromJson getInstance() {
		if (gvfj == null) {
			gvfj = new GetVarFromJson();
		}
		return gvfj;
	}
	public String getVar(String path, String key) {
		String var = null;
		try {
			JsonObject jsonobj = new JsonObject();
			JsonElement element = JsonParser.parseReader(new FileReader(path));
			jsonobj = element.getAsJsonObject();
			var = jsonobj.get(key).getAsString();
		} catch (FileNotFoundException e) {
			System.out.println("file not found");
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return var;
	}
}
