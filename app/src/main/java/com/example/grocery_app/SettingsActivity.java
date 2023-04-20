package com.example.grocery_app;

import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class SettingsActivity extends AppCompatActivity {

    private Button btnResetList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        btnResetList = findViewById(R.id.reset_list_button);

        View.OnClickListener btnResetListClick = new View.OnClickListener(){
            @Override
            public void onClick(View v){
                GroceryApplication app = (GroceryApplication) getApplication();
                app.deleteAllProducts();
            }
        };
        btnResetList.setOnClickListener(btnResetListClick);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch(item.getItemId()){
            case R.id.grocery_list:
                startActivity(new Intent(getApplicationContext(), Grocery_List_Activity.class));
                break;
            case R.id.settings:
                startActivity(new Intent(getApplicationContext(), SettingsActivity.class));
                break;
            default:
                break;
        }
        return true;
    }
}
