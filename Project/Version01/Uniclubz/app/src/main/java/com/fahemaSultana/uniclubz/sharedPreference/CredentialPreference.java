package com.fahemaSultana.uniclubz.sharedPreference;

import android.content.Context;
import android.content.SharedPreferences;

import com.fahemaSultana.uniclubz.MyApplication;
import com.fahemaSultana.uniclubz.dataModel.UserEntity;
import com.google.gson.Gson;

public class CredentialPreference {

    private static CredentialPreference credentialPreference;
    private static SharedPreferences sharedPreferences;
    private static SharedPreferences.Editor editor;

    private CredentialPreference() {
        sharedPreferences = MyApplication.getAppContext().getSharedPreferences("credential_preference", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        editor.apply();
    }

    public static CredentialPreference getInstance() {
        if (credentialPreference == null)
            credentialPreference = new CredentialPreference();
        return credentialPreference;
    }

    public void setUserId(String uid) {
        editor.putString("user_id", uid);
        editor.apply();
    }

    public String getUserId() {
        return sharedPreferences.getString("user_id", "");
    }

    public void setUserDetails(UserEntity userEntity) {
        editor.putString("user_details", new Gson().toJson(userEntity));
        editor.apply();
    }

    public UserEntity getUserDetails() {
        String userDetailsJson = sharedPreferences.getString("user_details", "");
        return new Gson().fromJson(userDetailsJson, UserEntity.class);
    }

}
