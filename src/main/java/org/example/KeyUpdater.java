package org.example;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class KeyUpdater {
    public static void main(String[] args) throws JSONException {
        // Sample JSON String
        String jsonString = "{...}"; // Place your JSON string here
        JSONObject jsonobject = new JSONObject(jsonString);

        // Update keys
//        updateKey(jsonobject, "ruleControlVersion", "rule.control.version");

        // Print updated JSON
        System.out.println(jsonobject.toString(4)); // Pretty-print JSON
    }

//    public static void updateKey(JSONObject jsonobject, String oldKey, String newKey) {
//        // Check all keys in the JSONObject
//        for (String key : jsonobject.keys()) {
//            Object value = jsonobject.get(key);
//
//            // If the key matches the old key, replace it
//            if (key.equals(oldKey)) {
//                jsonobject.put(newKey, value);
//                jsonobject.remove(oldKey);
//            }
//
//            // If the value is another JSONObject, recurse
//            if (value instanceof JSONObject) {
//                updateKey((JSONObject) value, oldKey, newKey);
//            }
//
//            // If the value is a JSONArray, iterate through its elements
//            if (value instanceof JSONArray) {
//                JSONArray array = (JSONArray) value;
//                for (int i = 0; i < array.length(); i++) {
//                    Object arrayElement = array.get(i);
//                    if (arrayElement instanceof JSONObject) {
//                        updateKey((JSONObject) arrayElement, oldKey, newKey);
//                    }
//                }
//            }
//        }
//    }

}
