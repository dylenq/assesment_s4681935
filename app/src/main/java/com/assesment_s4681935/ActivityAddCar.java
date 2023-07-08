package com.assesment_s4681935;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class ActivityAddCar extends AppCompatActivity implements View.OnClickListener{

    Button addCarButton2, backButton;
    EditText addBrand,addModel,addPrice;
    DBHelper dbHelper;
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addcar);

        dbHelper=new DBHelper(this);

        addCarButton2= findViewById(R.id.addCarButton2);
        backButton=findViewById(R.id.backButton);
        addBrand=findViewById(R.id.addBrand);
        addModel=findViewById(R.id.addModel);
        addPrice=findViewById(R.id.addPrice);

        addCarButton2.setOnClickListener(this);
        backButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view){
        int id=view.getId();
        if(id==R.id.addCarButton2){
            insertData();
        }
        if(id==R.id.backButton){
            goToHomePage();
        }
    }

    private void insertData(){
        String brand =addBrand.getText().toString();
        String model =addModel.getText().toString();
        String price =addPrice.getText().toString();

        boolean isInserted=dbHelper.insertData(brand,model, Integer.parseInt(price));
        if(isInserted){
            Toast.makeText(ActivityAddCar.this,"Data Inserted successfully!", Toast.LENGTH_LONG).show();
        }

        else{
            Toast.makeText(ActivityAddCar.this,"Please insert the relevant data",Toast.LENGTH_LONG).show();
        }
    }

    private void goToHomePage(){
        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}