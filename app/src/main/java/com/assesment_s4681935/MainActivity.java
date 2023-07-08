package com.assesment_s4681935;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;



public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button addCarBtn, checkCarBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        addCarBtn= findViewById(R.id.addCarButton);
        checkCarBtn= findViewById(R.id.checkCarButton);

        addCarBtn.setOnClickListener(this);
        checkCarBtn.setOnClickListener(this);

    }

    @Override
    public void onClick(View view){
        int id= view.getId();
        if(id==R.id.addCarButton){
            goToAddCarPage();
        }
        if(id==R.id.checkCarButton){
            gotoCheckCarPage();
        }
    }
    private void goToAddCarPage(){
        Intent intent=new Intent(this, ActivityAddCar.class);
        startActivity(intent);
    }
    private void gotoCheckCarPage(){
        Intent intent=new Intent(this, ActivityCheckCar.class);
        startActivity(intent);
    }
}