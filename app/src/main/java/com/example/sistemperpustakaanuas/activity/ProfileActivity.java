package com.example.sistemperpustakaanuas.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.sistemperpustakaanuas.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class ProfileActivity extends AppCompatActivity {
    private Button btnLogout;
    BottomNavigationView bottomNavigationView;
    FirebaseUser fbUser;
    TextView tvNamaUser, tvEmailUser;
    ImageView imgUser;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        imgUser = findViewById(R.id.imgUser);
        tvNamaUser = findViewById(R.id.namaUser);
        tvEmailUser = findViewById(R.id.emailUser);

        btnLogout = findViewById(R.id.btn_logout);
        bottomNavigationView = findViewById(R.id.bottom_nav_id);
        fbUser = FirebaseAuth.getInstance().getCurrentUser();

        if (fbUser != null){
            tvNamaUser.setText("Username:\n" +fbUser.getDisplayName());
            tvEmailUser.setText("Password:\n" +fbUser.getEmail());
        }
        imgUser.setImageResource(R.drawable.user);

        bottomNavigationView.setSelectedItemId(R.id.profil_menu);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.home_menu:
                        startActivity(new Intent(getApplicationContext(),HomeActivity.class));
                        finish();
                        break;
                    case R.id.profil_menu:
                        break;
                }
                return true;
            }
        });

        btnLogout.setOnClickListener(v -> {
            FirebaseAuth.getInstance().signOut();
            startActivity(new Intent(getApplicationContext(), LoginActivity.class));
            finish();
        });

    }
}
