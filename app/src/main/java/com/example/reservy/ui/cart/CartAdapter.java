package com.example.reservy.ui.cart;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

//import com.bumptech.glide.Glide;
import com.example.reservy.R;
import com.example.reservy.models.CartItem;
//import com.example.reservy.utils.Constants;

import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.CartViewHolder> {

    private final Context context;
    private final List<CartItem> cartItems;
    private final CartItemClickListener listener;

    public interface CartItemClickListener {
        void onDeleteClick(int position);
    }

    public CartAdapter(Context context, List<CartItem> cartItems, CartItemClickListener listener) {
        this.context = context;
        this.cartItems = cartItems;
        this.listener = listener;
    }

    @NonNull
    @Override
    public CartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_cart, parent, false);
        return new CartViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CartViewHolder holder, int position) {
        CartItem cartItem = cartItems.get(position);

        holder.titleTextView.setText(cartItem.getTitre());

        // Format date and time
        SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        SimpleDateFormat outputFormat = new SimpleDateFormat("dd MMMM yyyy", Locale.getDefault());

      /*
        try {
            Date date = inputFormat.parse(cartItem.getDate());
            if (date != null) {
                holder.dateTextView.setText(String.format("%s - %s", outputFormat.format(date), cartItem.getTime()));
            } else {
                holder.dateTextView.setText(String.format("%s - %s", cartItem.getDate(), cartItem.getTime()));
            }
        } catch (ParseException e) {
            holder.dateTextView.setText(String.format("%s - %s", cartItem.getDate(), cartItem.getTime()));
        }

        // Set quantity
        holder.quantityTextView.setText(String.format("Quantité: %d", cartItem.getQuantity()));

        // Format and set price
        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(Locale.getDefault());
        currencyFormat.setCurrency(java.util.Currency.getInstance("TND"));
        holder.priceTextView.setText(currencyFormat.format(cartItem.getPrice() * cartItem.getQuantity()));

        // Load image
        if (cartItem.getImageUrl() != null && !cartItem.getImageUrl().isEmpty()) {
            Glide.with(context)
                    .load(Constants.BASE_URL + "images/" + cartItem.getImageUrl())
                    .placeholder(R.drawable.placeholder_image)
                    .error(R.drawable.error_image)
                    .into(holder.imageView);
        } else {
            holder.imageView.setImageResource(R.drawable.placeholder_image);
        }
*/
        // Set delete click listener
        holder.deleteButton.setOnClickListener(v -> {
            if (listener != null) {
                listener.onDeleteClick(holder.getAdapterPosition());
            }
        });
    }

    @Override
    public int getItemCount() {
        return cartItems.size();
    }

    static class CartViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView titleTextView;
        TextView dateTextView;
        TextView quantityTextView;
        TextView priceTextView;
        ImageButton deleteButton;

        public CartViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.cartItemImageView);
            titleTextView = itemView.findViewById(R.id.cartItemTitle);
            dateTextView = itemView.findViewById(R.id.cartItemDate);
            quantityTextView = itemView.findViewById(R.id.cartItemQuantity);
            priceTextView = itemView.findViewById(R.id.cartItemPrice);
            deleteButton = itemView.findViewById(R.id.deleteItemButton);
        }
    }
}
