package com.example.reservy.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.reservy.databinding.FragmentHomeBinding;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

/*
import com.example.reservy.adapters.JSONParser;
import com.example.reservy.R;
import com.example.reservy.adapters.SpectAdapter;
import com.example.reservy.db.connection;
import com.example.reservy.models.show_spectacle;
import com.example.reservy.ui.user.LoginActivity;
import com.google.firebase.auth.FirebaseAuth;
*/

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.lang.ref.WeakReference;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        return root;
    }
}
/*
public class HomeFragment extends Fragment implements SpectacleAdapter.OnSpectacleClickListener {

    private RecyclerView spectaclesRecyclerView;
    private TextView emptyView;
    private SwipeRefreshLayout swipeRefreshLayout;
    private SearchView searchView;
    private ChipGroup filterChipGroup;
    private FloatingActionButton fabFilter;

    private SpectacleAdapter spectacleAdapter;
    private List<Spectacle> spectacleList;
    private ApiHandler apiHandler;

    private String currentSearchQuery = "";
    private String currentDateFilter = "";
    private String currentLieuFilter = "";
    private String currentPrixFilter = "";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Initialize views
        spectaclesRecyclerView = view.findViewById(R.id.spectaclesRecyclerView);
        emptyView = view.findViewById(R.id.emptyView);
        swipeRefreshLayout = view.findViewById(R.id.swipeRefreshLayout);
        searchView = view.findViewById(R.id.searchView);
        filterChipGroup = view.findViewById(R.id.filterChipGroup);
        fabFilter = view.findViewById(R.id.fabFilter);

        // Initialize API handler
        apiHandler = new ApiHandler(getContext());

        // Setup RecyclerView
        spectacleList = new ArrayList<>();
        spectacleAdapter = new SpectacleAdapter(getContext(), spectacleList, this);
        spectaclesRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        spectaclesRecyclerView.setAdapter(spectacleAdapter);

        // Setup SwipeRefreshLayout
        swipeRefreshLayout.setOnRefreshListener(this::loadSpectacles);

        // Setup SearchView
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                currentSearchQuery = query;
                loadSpectacles();
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                if (newText.isEmpty() && !currentSearchQuery.isEmpty()) {
                    currentSearchQuery = "";
                    loadSpectacles();
                }
                return true;
            }
        });

        // Setup Filter FAB
        fabFilter.setOnClickListener(v -> {
            Intent intent = new Intent(getContext(), FilterActivity.class);
            intent.putExtra("dateFilter", currentDateFilter);
            intent.putExtra("lieuFilter", currentLieuFilter);
            intent.putExtra("prixFilter", currentPrixFilter);
            startActivityForResult(intent, 100);
        });

        // Setup Chip Group
        setupChipGroup();

        // Load spectacles
        loadSpectacles();
    }

    private void setupChipGroup() {
        Chip chipDate = filterChipGroup.findViewById(R.id.chipDate);
        Chip chipLieu = filterChipGroup.findViewById(R.id.chipLieu);
        Chip chipPrix = filterChipGroup.findViewById(R.id.chipPrix);

        chipDate.setOnClickListener(v -> {
            // Show date picker dialog
            // For simplicity, we'll just toggle the chip
            if (chipDate.isChecked()) {
                currentDateFilter = "asc";
            } else {
                currentDateFilter = "";
            }
            loadSpectacles();
        });

        chipLieu.setOnClickListener(v -> {
            // Show lieu filter dialog
            // For simplicity, we'll just toggle the chip
            if (chipLieu.isChecked()) {
                currentLieuFilter = "asc";
            } else {
                currentLieuFilter = "";
            }
            loadSpectacles();
        });

        chipPrix.setOnClickListener(v -> {
            // Show prix filter dialog
            // For simplicity, we'll just toggle the chip
            if (chipPrix.isChecked()) {
                currentPrixFilter = "asc";
            } else {
                currentPrixFilter = "";
            }
            loadSpectacles();
        });
    }

    private void loadSpectacles() {
        swipeRefreshLayout.setRefreshing(true);

        apiHandler.getSpectacles(currentSearchQuery, currentDateFilter, currentLieuFilter, currentPrixFilter, new ApiHandler.ApiResponseCallback() {
            @Override
            public void onSuccess(JSONObject response) {
                spectacleList.clear();
                try {
                    JSONArray spectaclesArray = response.getJSONArray("spectacles");
                    for (int i = 0; i < spectaclesArray.length(); i++) {
                        JSONObject spectacleObj = spectaclesArray.getJSONObject(i);
                        Spectacle spectacle = new Spectacle();
                        spectacle.setIdSpec(spectacleObj.getInt("idSpec"));
                        spectacle.setTitre(spectacleObj.getString("titre"));
                        spectacle.setDateS(spectacleObj.getString("dateS"));
                        spectacle.setH_DebutS(spectacleObj.getString("H_DebutS"));
                        spectacle.setDuree(spectacleObj.getString("duree"));
                        spectacle.setNbrSpectateur(spectacleObj.getInt("nbrSpectateur"));
                        spectacle.setDescription(spectacleObj.getString("description"));
                        spectacle.setSite_web(spectacleObj.getString("site_web"));
                        spectacle.setIdLieu(spectacleObj.getInt("idLieu"));
                        spectacle.setImg(spectacleObj.getString("img"));

                        // Add extra fields from joined tables if available
                        if (spectacleObj.has("nomLieu")) {
                            spectacle.setLieuName(spectacleObj.getString("nomLieu"));
                        }
                        if (spectacleObj.has("ville")) {
                            spectacle.setVille(spectacleObj.getString("ville"));
                        }

                        spectacleList.add(spectacle);
                    }

                    if (spectacleList.isEmpty()) {
                        emptyView.setVisibility(View.VISIBLE);
                        spectaclesRecyclerView.setVisibility(View.GONE);
                    } else {
                        emptyView.setVisibility(View.GONE);
                        spectaclesRecyclerView.setVisibility(View.VISIBLE);
                    }

                    spectacleAdapter.notifyDataSetChanged();
                } catch (JSONException e) {
                    e.printStackTrace();
                    Toast.makeText(getContext(), "Erreur de parsing JSON", Toast.LENGTH_SHORT).show();
                }

                swipeRefreshLayout.setRefreshing(false);
            }

            @Override
            public void onError(String errorMessage) {
                Toast.makeText(getContext(), errorMessage, Toast.LENGTH_SHORT).show();
                swipeRefreshLayout.setRefreshing(false);
            }
        });
    }

    @Override
    public void onSpectacleClick(Spectacle spectacle) {
        Intent intent = new Intent(getContext(), SpectacleDetailActivity.class);
        intent.putExtra("spectacle_id", spectacle.getIdSpec());
        startActivity(intent);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 100 && resultCode == -1 && data != null) {
            currentDateFilter = data.getStringExtra("dateFilter");
            currentLieuFilter = data.getStringExtra("lieuFilter");
            currentPrixFilter = data.getStringExtra("prixFilter");
            loadSpectacles();
        }
    }
}
*/
