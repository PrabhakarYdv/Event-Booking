package com.prabhakar.eventbooking;

import android.content.Context;
import android.content.SharedPreferences;

public class PreferenceHelper {
    private static final String DATABASE_NAME = "com.xyz.eventDatabase";
private static SharedPreferences sharedPreferences;
    public static SharedPreferences getSharedPreferences(Context context) {
        if (sharedPreferences==null){
            sharedPreferences=context.getSharedPreferences(DATABASE_NAME, Context.MODE_PRIVATE);
        }
        return sharedPreferences;
    }

    public static void writeToPreference(String value, String key) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(key, value);
        editor.apply();
    }

    public static String getFromPreferences( String key) {
       return sharedPreferences.getString(key, "_ _ _ _ _ _");
    }
}
