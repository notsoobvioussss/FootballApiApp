package com.timur.ewa.app.presentation.utils

import android.content.Context
import androidx.appcompat.app.AppCompatDelegate

object ThemeManager {

    private const val THEME_PREF = "theme_pref"
    private const val THEME_KEY = "theme_key"

    const val LIGHT_THEME = "light"
    const val DARK_THEME = "dark"

    fun applyTheme(theme: String) {
        when (theme) {
            LIGHT_THEME -> AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            DARK_THEME -> AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        }
    }

    fun saveTheme(context: Context, theme: String) {
        val preferences = context.getSharedPreferences(THEME_PREF, Context.MODE_PRIVATE)
        preferences.edit().putString(THEME_KEY, theme).apply()
    }

    fun loadTheme(context: Context): String {
        val preferences = context.getSharedPreferences(THEME_PREF, Context.MODE_PRIVATE)
        return preferences.getString(THEME_KEY, LIGHT_THEME) ?: LIGHT_THEME
    }
}
