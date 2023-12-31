package com.assesment_s4681935;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
public class ActivityCheckCar extends AppCompatActivity implements View.OnClickListener{

    Button checkPriceButton,backButton;
    EditText checkBrand,checkModel,checkPrice;
    DBHelper DBHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkcar);

        checkPriceButton = findViewById(R.id.checkPriceButton);
        backButton=findViewById(R.id.backButton);

        checkBrand = findViewById(R.id.checkBrand);
        checkModel = findViewById(R.id.checkModel);
        checkPrice = findViewById(R.id.checkPrice);


        checkPriceButton.setOnClickListener(this);
        backButton.setOnClickListener(this);
        DBHelper = new DBHelper(this);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        if(id == R.id.backButton)
        {
            gotoHomePage();
        }
        if(id == R.id.checkPriceButton) {
            viewPrice();
        }
    }

    private void viewPrice() {
        String brand = checkBrand.getText().toString().trim();
        String model = checkModel.getText().toString().trim();

        if(brand.isEmpty() || model.isEmpty()) {
            Toast.makeText(this, "Please enter brand name and model name!", Toast.LENGTH_SHORT).show();
            return;
        }

        int price = DBHelper.getPrice(brand, model);

        if(price == -1) {
            Toast.makeText(this, "Car not found. Please try again!", Toast.LENGTH_SHORT).show();
            checkPrice.setText("");
        }
        else {
            checkPrice.setText(String.valueOf(price));
        }
    }
    private void gotoHomePage()
    {
       Intent intent=new Intent(this,MainActivity.class);
       startActivity(intent);
    }
}