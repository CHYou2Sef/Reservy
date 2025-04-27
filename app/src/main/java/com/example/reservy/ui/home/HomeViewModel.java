package com.example.reservy.ui.home;

import com.example.reservy.models.Spectacle;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class HomeViewModel extends AndroidViewModel {
    public HomeViewModel(@NonNull Application application) {
        super(application);
    }
       /* private final SpectacleRepository spectacleRepository;
        private final MutableLiveData<FilterOptions> filterOptions = new MutableLiveData<>();
        private final MutableLiveData<String> sortOption = new MutableLiveData<>();
        private final MediatorLiveData<List<Spectacle>> spectacles = new MediatorLiveData<>();

        public HomeViewModel(@NonNull Application application) {
            super(application);
            spectacleRepository = new SpectacleRepository(application);

            // Initialize with default values
            filterOptions.setValue(new FilterOptions("", "", "", "", ""));
            sortOption.setValue("date_asc"); // Default sort

            // Get data from repository
            LiveData<List<Spectacle>> repoSpectacles = spectacleRepository.getAllSpectacles();

            // Add repository data as source
            spectacles.addSource(repoSpectacles, value -> {
                if (value != null) {
                    applyFilterAndSort(value, filterOptions.getValue(), sortOption.getValue());
                }
            });

            // Add filter options as source to react to filter changes
            spectacles.addSource(filterOptions, value -> {
                List<Spectacle> currentList = repoSpectacles.getValue();
                if (currentList != null) {
                    applyFilterAndSort(currentList, value, sortOption.getValue());
                }
            });

            // Add sort option as source to react to sort changes
            spectacles.addSource(sortOption, value -> {
                List<Spectacle> currentList = repoSpectacles.getValue();
                if (currentList != null) {
                    applyFilterAndSort(currentList, filterOptions.getValue(), value);
                }
            });
        }

        public LiveData<List<Spectacle>> getSpectacles() {
            return spectacles;
        }

        public void setFilter(String query, String date, String time, String lieu, String ville) {
            filterOptions.setValue(new FilterOptions(query, date, time, lieu, ville));
        }

        public void setSort(String sort) {
            sortOption.setValue(sort);
        }

        public void refreshSpectacles() {
            // This will trigger the repository to fetch fresh data
            spectacleRepository.getAllSpectacles();
        }

        public LiveData<List<Spectacle>> searchSpectacles(String query, String date, String time, String lieu, String ville) {
            return spectacleRepository.searchSpectacles(query, date, time, lieu, ville);
        }

        private void applyFilterAndSort(List<Spectacle> originalList, FilterOptions filters, String sort) {
            if (originalList == null) return;

            // Create working copy
            List<Spectacle> filteredList = new ArrayList<>(originalList);

            // Apply filters if needed
            if (filters != null && !filters.isEmpty()) {
                filteredList = applyFilters(filteredList, filters);
            }

            // Apply sorting
            if (sort != null) {
                sortList(filteredList, sort);
            }

            // Update the LiveData
            spectacles.setValue(filteredList);
        }

        private List<Spectacle> applyFilters(List<Spectacle> list, FilterOptions filters) {
            List<Spectacle> result = new ArrayList<>();

            for (Spectacle spectacle : list) {
                boolean matches = true;

                // Check title
                if (filters.getQuery() != null && !filters.getQuery().isEmpty()) {
                    if (!spectacle.getTitre().toLowerCase().contains(filters.getQuery().toLowerCase())) {
                        matches = false;
                    }
                }

                // Check date
                if (matches && filters.getDate() != null && !filters.getDate().isEmpty()) {
                    if (!spectacle.getDateS().equals(filters.getDate())) {
                        matches = false;
                    }
                }

                // Check time
                if (matches && filters.getTime() != null && !filters.getTime().isEmpty()) {
                    if (!spectacle.getH_DebutS().contains(filters.getTime())) {
                        matches = false;
                    }
                }

                // Check venue (lieu)
                if (matches && filters.getIdLieu() != null && !filters.getIdLieu().isEmpty()) {
                    if (spectacle.getIdLieu() == null ||
                            !spectacle.getNomLieu().toLowerCase().contains(filters.getIdLieu().toLowerCase())) {
                        matches = false;
                    }
                }

                // Check city (ville)
                if (matches && filters.getVille() != null && !filters.getVille().isEmpty()) {
                    if (spectacle.getLieu() == null ||
                            !spectacle.getLieu().getVille().toLowerCase().contains(filters.getVille().toLowerCase())) {
                        matches = false;
                    }
                }

                if (matches) {
                    result.add(spectacle);
                }
            }

            return result;
        }

        private void sortList(List<Spectacle> list, String sortOption) {
            switch (sortOption) {
                case "date_asc":
                    Collections.sort(list, Comparator.comparing(Spectacle::getDateS));
                    break;
                case "date_desc":
                    Collections.sort(list, Comparator.comparing(Spectacle::getDateS).reversed());
                    break;
                case "price_asc":
                    Collections.sort(list, Comparator.comparing(Spectacle::getPrice));
                    break;
                case "price_desc":
                    Collections.sort(list, Comparator.comparing(Spectacle::getPrice).reversed());
                    break;
                case "title_asc":
                    Collections.sort(list, Comparator.comparing(s -> s.getTitre().toLowerCase()));
                    break;
                case "title_desc":
                    Collections.sort(list, Comparator.comparing(s -> s.getTitre().toLowerCase()).reversed());
                    break;
            }
        }

        */
}