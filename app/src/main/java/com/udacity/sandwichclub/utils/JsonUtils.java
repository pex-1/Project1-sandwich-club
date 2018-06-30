package com.udacity.sandwichclub.utils;

import android.nfc.Tag;
import android.util.Log;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import static android.content.ContentValues.TAG;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) throws JSONException {
        String mainName;
        List<String> alsoKnownAs = new ArrayList<>();;
        String placeOfOrigin;
        String description;
        String image;
        List<String> ingredients = new ArrayList<>();;

        JSONObject rootObject = new JSONObject(json);
        JSONObject name = rootObject.getJSONObject("name");

        mainName = name.getString("mainName");
        placeOfOrigin = rootObject.getString("placeOfOrigin");
        description = rootObject.getString("description");
        image = rootObject.getString("image");

        JSONArray alsoKnownAsArray = name.getJSONArray("alsoKnownAs");
        for (int i = 0; i < alsoKnownAsArray.length(); i++) {
            alsoKnownAs.add(alsoKnownAsArray.getString(i));
        }

        JSONArray ingredientsArray = rootObject.getJSONArray("ingredients");
        for (int i = 0; i < ingredientsArray.length(); i++) {
            ingredients.add(ingredientsArray.getString(i));
        }

        return new Sandwich(mainName, alsoKnownAs, placeOfOrigin, description, image, ingredients);

    }
}
