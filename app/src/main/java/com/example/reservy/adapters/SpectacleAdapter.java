package com.example.reservy.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide; // Or Picasso

import com.example.reservy.models.Spectacle;
import com.example.reservy.utils.DateTimeUtils;
//import com.example.reservy.utils.Constants; // Example util
import com.example.reservy.R;


import java.util.ArrayList;
import java.util.List;



public class SpectacleAdapter extends RecyclerView.Adapter<SpectacleAdapter.SpectacleViewHolder> {

    private List<Spectacle> spectacles = new ArrayList<>();
    private final OnSpectacleClickListener listener;
    private final Context context; // Needed for Glide

    public interface OnSpectacleClickListener {
        void onSpectacleClick(Spectacle spectacle);
    }

    public SpectacleAdapter(Context context, OnSpectacleClickListener listener) {
        this.context = context;
        this.listener = listener;
    }

    public void setSpectacles(List<Spectacle> newSpectacles) {
        this.spectacles.clear();
        if (newSpectacles != null) {
            this.spectacles.addAll(newSpectacles);
        }
        notifyDataSetChanged(); // Consider DiffUtil for better performance
    }

    @NonNull
    @Override
    public SpectacleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_spectacle, parent, false);
        return new SpectacleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SpectacleViewHolder holder, int position) {
        Spectacle currentSpectacle = spectacles.get(position);
        holder.bind(currentSpectacle, listener, context);
    }

    @Override
    public int getItemCount() {
        return spectacles.size();
    }

    static class SpectacleViewHolder extends RecyclerView.ViewHolder {
        ImageView imageViewSpectacle;
        TextView textViewTitle;
        TextView textViewLocation;
        TextView textViewDate;
        TextView textViewTime;

        public SpectacleViewHolder(@NonNull View itemView) {
            super(itemView);
            imageViewSpectacle = itemView.findViewById(R.id.spectacleImageView);
            textViewTitle = itemView.findViewById(R.id.titleTextView);
            textViewTime = itemView.findViewById(R.id.timeTextView);
            textViewDate = itemView.findViewById(R.id.dateTextView);
            textViewLocation = itemView.findViewById(R.id.locationTextView);
        }

        public void bind(final Spectacle spectacle, final OnSpectacleClickListener listener, Context context) {
            textViewTitle.setText(spectacle.getTitre());
            textViewLocation.setText(String.format("%s (%s)", spectacle.getNomLieu(), spectacle.getVille()));

            // Format Date/Time using a Util class
            String formattedDateTime = DateTimeUtils.formatSpectacleDateTime(spectacle.getDateS(), spectacle.getH_DebutS());
            textViewDate.setText(formattedDateTime);


            // Load image using Glide/Picasso
            String imageUrl = spectacle.getImg(); // Get URL from model
            if (imageUrl != null && !imageUrl.isEmpty()) {
                Glide.with(context)
                        .load(imageUrl)
                        .placeholder(R.drawable.placeholder_image) // Add a placeholder drawable
                        .error(R.drawable.error_image) // Add an error drawable
                        .centerCrop() // Or fitCenter() depending on layout needs
                        .into(imageViewSpectacle);
            } else {
                // Set placeholder if no image URL
                imageViewSpectacle.setImageResource(R.drawable.placeholder_image);
            }


            itemView.setOnClickListener(v -> listener.onSpectacleClick(spectacle));
        }
    }
}