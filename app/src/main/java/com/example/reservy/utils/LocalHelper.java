package com.example.reservy.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.preference.PreferenceManager;

import java.util.Locale;

public class LocalHelper {


        private static final String SELECTED_LANGUAGE = "Locale.Helper.Selected.Language";

        public static Context onAttach(Context context) {
            String lang = getPersistedData(context, Locale.getDefault().getLanguage());
            return setLocale(context, lang);
        }

        public static Context setLocale(Context context, String language) {
            persist(context, language);
            Locale locale = new Locale(language);
            Locale.setDefault(locale);

            Configuration config = context.getResources().getConfiguration();
            config.setLocale(locale);
            return context.createConfigurationContext(config);
        }

        private static void persist(Context context, String language) {
            SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
            prefs.edit().putString(SELECTED_LANGUAGE, language).apply();
        }

        private static String getPersistedData(Context context, String defaultLanguage) {
            SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
            return prefs.getString(SELECTED_LANGUAGE, defaultLanguage);
        }
    }

