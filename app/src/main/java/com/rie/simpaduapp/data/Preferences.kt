package com.rie.simpaduapp.data

import android.content.Context
import android.content.SharedPreferences

object Preferences {
    fun initPref(context: Context, name: String): SharedPreferences {
        return context.getSharedPreferences(name, Context.MODE_PRIVATE)
    }

    private const val KEY_IS_LOGGED_IN = "is_logged_in"


    fun saveAccessToken(accessToken: String, sharedPreferences: SharedPreferences) {
        val editor = sharedPreferences.edit()
        editor.putString("token", accessToken)
        editor.apply()
    }

    fun isLoggedIn(sharedPreferences: SharedPreferences): Boolean {
        return sharedPreferences.getBoolean(KEY_IS_LOGGED_IN, false)
    }
    fun setLoggedIn(sharedPreferences: SharedPreferences, isLoggedIn: Boolean) {
        val editor = sharedPreferences.edit()
        editor.putBoolean(KEY_IS_LOGGED_IN, isLoggedIn)
        editor.apply()
    }

    fun logout(sharedPreferences: SharedPreferences) {
        val editor = sharedPreferences.edit()
        editor.putBoolean(KEY_IS_LOGGED_IN, false)
        editor.remove("token")
        editor.apply()
    }
}
