package com.example.grocery_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btnAdd;
    private Button btnReset;
    private EditText txtProductName;
    private EditText txtPrice;
    private EditText txtStore;
    private EditText txtCalories;
    private double tax = 0.13;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAdd = findViewById(R.id.add_button);
        btnReset = findViewById(R.id.reset_button);
        txtProductName = findViewById(R.id.product_name_edittext);
        txtPrice = findViewById(R.id.price_edittext);
        txtStore = findViewById(R.id.store_edittext);
        txtCalories = findViewById(R.id.calories_edittext);

        View.OnClickListener btnAddClick = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GroceryApplication app = (GroceryApplication) getApplication();
                app.addProduct(txtProductName.getText().toString(), Double.parseDouble(txtPrice.getText().toString()), txtStore.getText().toString(), Integer.parseInt(txtCalories.getText().toString()), tax);
                Toast.makeText(getApplicationContext(), "Add button pressed", Toast.LENGTH_SHORT).show();
            }
        };
        btnAdd.setOnClickListener(btnAddClick);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.grocery_menu, menu);
        return true;
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