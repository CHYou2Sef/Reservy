package com.example.reservy.ui.cart;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.reservy.R;
//import com.example.reservy.activities.PaymentActivity;
import com.example.reservy.ui.cart.CartAdapter;
import com.example.reservy.models.CartItem;
//import com.example.reservy.utils.CartManager;
//import com.example.reservy.utils.SessionManager;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class CartFragment extends Fragment implements CartAdapter.CartItemClickListener {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_cart, container, false);
    }

    @Override
    public void onDeleteClick(int position) {

    }
/*
    private RecyclerView cartRecyclerView;
    private TextView emptyCartView;
    private TextView subtotalValue;
    private TextView totalValue;
    private Button checkoutButton;

    private CartAdapter cartAdapter;
    private List<CartItem> cartItems;
 //   private CartManager cartManager;
   // private SessionManager sessionManager;



    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Initialize views
        cartRecyclerView = view.findViewById(R.id.cartRecyclerView);
        emptyCartView = view.findViewById(R.id.emptyCartView);
        subtotalValue = view.findViewById(R.id.subtotalValue);
        totalValue = view.findViewById(R.id.totalValue);
        checkoutButton = view.findViewById(R.id.checkoutButton);

        // Initialize managers
       // cartManager = CartManager.getInstance(getContext());
       // sessionManager = SessionManager.getInstance(getContext());

        // Setup RecyclerView
        cartItems = new ArrayList<>();
        cartAdapter = new CartAdapter(getContext(), cartItems, this);
        cartRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        cartRecyclerView.setAdapter(cartAdapter);

        // Setup checkout button
        checkoutButton.setOnClickListener(v -> {
            if (sessionManager.isLoggedIn()) {
                if (!cartItems.isEmpty()) {
                    proceedToCheckout();
                } else {
                    Toast.makeText(getContext(), "Votre panier est vide", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(getContext(), "Veuillez vous connecter pour continuer", Toast.LENGTH_SHORT).show();
                // Redirect to login activity
                // Intent intent = new Intent(getContext(), LoginActivity.class);
                // startActivity(intent);
            }
        });

        // Load cart items
        loadCartItems();


    }

    @Override
    public void onResume() {
        super.onResume();
        // Reload cart items when fragment is resumed
        loadCartItems();
    }


    private void loadCartItems() {
        cartItems.clear();
        cartItems.addAll(cartManager.getCartItems());

        if (cartItems.isEmpty()) {
            emptyCartView.setVisibility(View.VISIBLE);
            cartRecyclerView.setVisibility(View.GONE);
            checkoutButton.setEnabled(false);
        } else {
            emptyCartView.setVisibility(View.GONE);
            cartRecyclerView.setVisibility(View.VISIBLE);
            checkoutButton.setEnabled(true);
        }

        // Update prices
        updatePrices();

        cartAdapter.notifyDataSetChanged();
    }

    private void updatePrices() {
        double subtotal = 0;
        for (CartItem item : cartItems) {
            subtotal += item.getPrice() * item.getQuantity();
        }

        // Format currency
        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(Locale.getDefault());
        currencyFormat.setCurrency(java.util.Currency.getInstance("TND"));

        subtotalValue.setText(currencyFormat.format(subtotal));
        totalValue.setText(currencyFormat.format(subtotal)); // Add tax or delivery fees if needed
    }

    private void proceedToCheckout() {
        Intent intent = new Intent(getContext(), PaymentActivity.class);
        startActivity(intent);
    }

    @Override
    public void onDeleteClick(int position) {
        CartItem itemToRemove = cartItems.get(position);
        cartManager.removeFromCart(itemToRemove.getSpectacleId());
        cartItems.remove(position);
        cartAdapter.notifyItemRemoved(position);

        if (cartItems.isEmpty()) {
            emptyCartView.setVisibility(View.VISIBLE);
            cartRecyclerView.setVisibility(View.GONE);
            checkoutButton.setEnabled(false);
        }

        updatePrices();
        Toast.makeText(getContext(), "Article supprimé du panier", Toast.LENGTH_SHORT).show();
    }
*/

}
