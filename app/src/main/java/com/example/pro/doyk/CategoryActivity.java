package com.example.pro.doyk;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;

public class CategoryActivity extends AppCompatActivity {

    LinearLayout catPhis;
    LinearLayout catGeo;
    LinearLayout catRel;
    LinearLayout catAll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        setTitle("Category");
        catPhis=(LinearLayout)findViewById(R.id.fundamentals);
        catGeo=(LinearLayout)findViewById(R.id.operating);
        catRel=(LinearLayout)findViewById(R.id.hardware);
        catAll=(LinearLayout)findViewById(R.id.finale);
        //sc=(LinearLayout)findViewById(R.id.score);
        catPhis.setOnClickListener(listener);
        catGeo.setOnClickListener(listener);
        catRel.setOnClickListener(listener);
        catAll.setOnClickListener(listener);
    }

    String catName;

    View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch(v.getId()){
                case R.id.fundamentals:
                    catName = "catPhysic";
                    break;
                case R.id.operating:
                    catName = "catGeography";
                    break;
                case R.id.hardware:
                    catName = "catReligion";
                    break;
                case R.id.finale:
                    catName = "catAll";
                    break;
            }
            Intent i= new Intent(getApplicationContext(),Activity_Levels1.class);
            i.putExtra("category_name",catName);
            startActivity(i);
            overridePendingTransition(android.R.anim.slide_in_left,android.R.anim.slide_out_right);
        }

    };

    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }
}

