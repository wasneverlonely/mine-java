package com.was.minejava;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.was.minejava.ui.list.ListActivity;
import com.was.minejava.ui.login.LoginActivity;
import com.was.minejava.ui.refresh.RefreshActivity;
import com.was.minejava.ui.tab.TabLayoutActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void clickLogin(View view) {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }

    public void clickList(View view) {
        Intent intent = new Intent(this, ListActivity.class);
        startActivity(intent);
    }

    public void clickRefresh(View view) {
        Intent intent = new Intent(this, RefreshActivity.class);
        startActivity(intent);
    }

    //
    public void clickTabLayout(View view) {
        Intent intent = new Intent(this, TabLayoutActivity.class);
        startActivity(intent);
    }

}