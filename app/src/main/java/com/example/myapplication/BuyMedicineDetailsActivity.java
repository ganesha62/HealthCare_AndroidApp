package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class BuyMedicineDetailsActivity extends AppCompatActivity {
    TextView tvPackageName, tvTotalCost;
    EditText edDetails;
    Button btnBack, btnAddCart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_medicine_details);

        tvPackageName = findViewById(R.id.textViewBMDpackageName);
        edDetails = findViewById(R.id.editTextBMDTextMultiLine);
        edDetails.setKeyListener(null);
        tvTotalCost = findViewById(R.id.textViewHAtTitle);
        btnBack = findViewById(R.id.buttonHADBack);
        btnAddCart = findViewById(R.id.buttonBMcartCheckout);

        Intent intent = getIntent();
        tvPackageName.setText(intent.getStringExtra("text1"));
        edDetails.setText(intent.getStringExtra("text2"));
        tvTotalCost.setText("total cost: " + intent.getStringExtra("text3") + "/-");

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(BuyMedicineDetailsActivity.this, BuyMedicineActivity.class));
            }
        });

        btnAddCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // TODO: Implement cart addition functionality here
                // You can use the following data:
                // String packageName = tvPackageName.getText().toString();
                // float price = Float.parseFloat(intent.getStringExtra("text3"));
                // ... (rest of the code)
                SharedPreferences sharedPreferences= getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
                String username= sharedPreferences.getString("username","").toString();
                String product=tvPackageName.getText().toString();
                float price=Float.parseFloat(intent.getStringExtra("text3").toString());
                Database db= new Database(getApplicationContext(),"healthcare",null,1);
                if(db.checkCart(username,product)==1){
                    Toast.makeText(getApplicationContext(),"product already added",Toast.LENGTH_SHORT).show();
                }else{
                    //db= new Database(getApplicationContext(),"healthcare", null, 1);
                    db.addCart(username,product,price,"medicine");
                    Toast.makeText(getApplicationContext(),"Record inserted into cart",Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(BuyMedicineDetailsActivity.this,BuyMedicineActivity.class));
                }
            }
        });
    }
}
