package com.example.pro.doyk;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

import java.util.Locale;

public class CategoryActivity extends AppCompatActivity {

    LinearLayout catPhis;
    LinearLayout catGeo;
    LinearLayout catRel;
    LinearLayout catAll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        setTitle("Вибери категорію");
        catPhis=(LinearLayout)findViewById(R.id.llcat1);
        catGeo=(LinearLayout)findViewById(R.id.llcat2);
        catRel=(LinearLayout)findViewById(R.id.llcat3);
        catAll=(LinearLayout)findViewById(R.id.llcat12);
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
                case R.id.llcat1:
                    catName = "catPhysic";
                    break;
                case R.id.llcat2:
                    catName = "catGeography";
                    break;
                case R.id.llcat3:
                    catName = "catReligion";
                    break;
                case R.id.llcat12:
                    catName = "";
                    break;
            }
            Intent i= new Intent(getApplicationContext(),Main2ActivitySec1.class);
            i.putExtra("category_name",catName);
            //доки нема етапів
            i.putExtra("level_name", "B");
            Log.d("CategoryName", catName);
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

