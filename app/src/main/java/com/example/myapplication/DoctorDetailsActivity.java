package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class DoctorDetailsActivity extends AppCompatActivity {

    private String[][] doctor_details1=
            {
                    {"Doctor Name : Jisoo", "Hospital Address : Chennai", "Exp : 5yrs", "Mobile No : 1234567890", "600"},
                    {"Doctor Name : SRK", "Hospital Address : Delhi", "Exp : 10yrs", "Mobile No : 1234566890", "1200"},
                    {"Doctor Name : Ganesha", "Hospital Address : Mumbai", "Exp : 7yrs", "Mobile No : 1244567890", "800"},
                    {"Doctor Name : John", "Hospital Address : Bangalore", "Exp : 3yrs", "Mobile No : 1234567790", "400"},
                    {"Doctor Name : Jerry", "Hospital Address : Kolkata", "Exp : 6yrs", "Mobile No : 1234567899", "600"}
            };
    private String[][] doctor_details2=
            {
                    {"Doctor Name : Jennie", "Hospital Address : Chennai", "Exp : 5yrs", "Mobile No : 1234567890", "600"},
                    {"Doctor Name : Akshay Kumar", "Hospital Address : Delhi", "Exp : 10yrs", "Mobile No : 1234566890", "1200"},
                    {"Doctor Name : Ram", "Hospital Address : Mumbai", "Exp : 7yrs", "Mobile No : 1244567890", "800"},
                    {"Doctor Name : Sophie", "Hospital Address : Bangalore", "Exp : 3yrs", "Mobile No : 1234567790", "400"},
                    {"Doctor Name : Tom", "Hospital Address : Kolkata", "Exp : 6yrs", "Mobile No : 1234567899", "600"}
            };
    private String[][] doctor_details3=
            {
                    {"Doctor Name : Lisa", "Hospital Address : Chennai", "Exp : 5yrs", "Mobile No : 1234567890", "600"},
                    {"Doctor Name : GGR", "Hospital Address : Delhi", "Exp : 10yrs", "Mobile No : 1234566890", "1200"},
                    {"Doctor Name : Bruce", "Hospital Address : Mumbai", "Exp : 7yrs", "Mobile No : 1244567890", "800"},
                    {"Doctor Name : Wayne", "Hospital Address : Bangalore", "Exp : 3yrs", "Mobile No : 1234567790", "400"},
                    {"Doctor Name : Clark", "Hospital Address : Kolkata", "Exp : 6yrs", "Mobile No : 1234567899", "600"}
            };
    private String[][] doctor_details4=
            {
                    {"Doctor Name : Rose", "Hospital Address : Chennai", "Exp : 5yrs", "Mobile No : 1234567890", "600"},
                    {"Doctor Name : Diana", "Hospital Address : Delhi", "Exp : 10yrs", "Mobile No : 1234566890", "1200"},
                    {"Doctor Name : Ganesha", "Hospital Address : Mumbai", "Exp : 7yrs", "Mobile No : 1244567890", "800"},
                    {"Doctor Name : John", "Hospital Address : Bangalore", "Exp : 3yrs", "Mobile No : 1234567790", "400"},
                    {"Doctor Name : Robert", "Hospital Address : Kolkata", "Exp : 6yrs", "Mobile No : 1234567899", "600"}
            };
    private String[][] doctor_details5=
            {
                    {"Doctor Name : Carol", "Hospital Address : Chennai", "Exp : 5yrs", "Mobile No : 1234567890", "600"},
                    {"Doctor Name : Shawn", "Hospital Address : Delhi", "Exp : 10yrs", "Mobile No : 1234566890", "1200"},
                    {"Doctor Name : Max", "Hospital Address : Mumbai", "Exp : 7yrs", "Mobile No : 1244567890", "800"},
                    {"Doctor Name : Tom", "Hospital Address : Bangalore", "Exp : 3yrs", "Mobile No : 1234567790", "400"},
                    {"Doctor Name : Jerry", "Hospital Address : Kolkata", "Exp : 6yrs", "Mobile No : 1234567899", "600"}
            };
    TextView tv;
    String [][] doctor_details={};
    ArrayList list;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_details);

        tv= findViewById(R.id.textViewDDTTitle);
        btn= findViewById(R.id.buttonAddToCart);
        Intent it= getIntent();
        String title= it.getStringExtra("title");
        tv.setText(title);

        if(title.compareTo("Family Physicians")==0)
            doctor_details=doctor_details1;
        else if(title.compareTo("Dieticians")==0)
            doctor_details=doctor_details2;
        else if(title.compareTo("Dentists")==0)
            doctor_details=doctor_details3;
        else if(title.compareTo("Surgeons")==0)
            doctor_details=doctor_details4;
        else
            doctor_details=doctor_details5;

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DoctorDetailsActivity.this,FindDoctorActivity.class));
            }
        });

        list= new ArrayList();
        for(int i=0;i<doctor_details.length;i++){
            HashMap<String, String> item = new HashMap<String, String>();
            item.put("line1", doctor_details[i][0]);
            item.put("line2", doctor_details[i][1]);
            item.put("line3", doctor_details[i][2]);
            item.put("line4", doctor_details[i][3]);
            item.put("line5", "Cons Fees"+doctor_details[i][4]+"/-");
            list.add(item);
        }
        SimpleAdapter sa = new SimpleAdapter(this, list, R.layout.multi_lines, new String[]{"line1", "line2", "line3", "line4", "line5"},
                new int[]{R.id.line_a, R.id.line_b, R.id.line_c, R.id.line_d, R.id.line_e});
        ListView lst= findViewById(R.id.listViewHA);
        lst.setAdapter(sa);

        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent it= new Intent(DoctorDetailsActivity.this,BookAppointmentActivity.class);
                it.putExtra("text1",title);
                it.putExtra("text2",doctor_details[i][0]);
                it.putExtra("text3",doctor_details[i][1]);
                it.putExtra("text4",doctor_details[i][2]);
                it.putExtra("text5",doctor_details[i][3]);
                startActivity(it);
            }
        });
    }
}