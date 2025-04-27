package com.example.reservy.ui.settings;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.reservy.R;
import com.example.reservy.utils.LocalHelper;

public class SettingsFragment extends Fragment {
    private Switch switchDarkMode;
    private Spinner spinnerLanguage;
    private SharedPreferences prefs;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_settings, container, false);

        prefs = requireContext()
                .getSharedPreferences("settings", getContext().MODE_PRIVATE);

        // Mode sombre
        switchDarkMode = view.findViewById(R.id.switchDarkMode);
        boolean dark = prefs.getBoolean("dark_mode", false);
        switchDarkMode.setChecked(dark);
        switchDarkMode.setOnCheckedChangeListener((CompoundButton btn, boolean isChecked) -> {
            prefs.edit().putBoolean("dark_mode", isChecked).apply();
            Toast.makeText(getContext(),
                    isChecked ? getString(R.string.dark_enabled) : getString(R.string.dark_disabled),
                    Toast.LENGTH_SHORT).show();
            requireActivity().recreate();
        });

        // Sélection de langue
        spinnerLanguage = view.findViewById(R.id.spinnerLanguage);
        ArrayAdapter<CharSequence> langAdapter = ArrayAdapter.createFromResource(
                getContext(),
                R.array.language_options,
                android.R.layout.simple_spinner_item
        );
        langAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerLanguage.setAdapter(langAdapter);

        // Pré-selection
        String currentLang = prefs.getString("Locale.Helper.Selected.Language", "en");
        int pos = currentLang.equals("fr") ? 1 : currentLang.equals("ar") ? 2 : 0;
        spinnerLanguage.setSelection(pos);

        spinnerLanguage.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override public void onItemSelected(AdapterView<?> parent, View v, int position, long id) {
                String code = position == 0 ? "en" : position == 1 ? "fr" : "ar";
                LocalHelper.setLocale(requireContext(), code);
                requireActivity().recreate();
            }
            @Override public void onNothingSelected(AdapterView<?> parent) {}
        });

        return view;
    }
}