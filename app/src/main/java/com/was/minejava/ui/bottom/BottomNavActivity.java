package com.was.minejava.ui.bottom;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;

import com.was.minejava.R;
import com.was.minejava.databinding.ActivityBottomNavBinding;

public class BottomNavActivity extends AppCompatActivity {


    ActivityBottomNavBinding bottomNavBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        bottomNavBinding = DataBindingUtil.setContentView(this, R.layout.activity_bottom_nav);


        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupWithNavController(bottomNavBinding.navView, navController);
    }
}