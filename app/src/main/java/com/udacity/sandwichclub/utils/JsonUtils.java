package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) {
        try {
            JSONObject masterJSONObject = new JSONObject(json);
            JSONObject name = masterJSONObject.getJSONObject("name");
            String placeOfOrigin = masterJSONObject.optString("placeOfOrigin");
            String description = masterJSONObject.optString("description");
            String imageURL = masterJSONObject.optString("image");
            JSONArray ingredients = masterJSONObject.getJSONArray("ingredients");
            List<String> ingredients_list = JSONArrayToList(ingredients);
            JSONArray akas = name.getJSONArray("alsoKnownAs");
            List<String> alias = JSONArrayToList(akas);
            return new Sandwich(name.optString("mainName"),alias,
                    placeOfOrigin,description,
                    imageURL,ingredients_list);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }
    private static List<String> JSONArrayToList(JSONArray jsonArray){
        List<String>resultList = new ArrayList<>();
        for(int i=0;i<jsonArray.length();i++){
            resultList.add(jsonArray.optString(i));

        }
        return resultList;
    }
}
