package com.example.pro.doyk;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Locale;

public class CategoryActivity extends AppCompatActivity {

    TextView tvTitle;

    LinearLayout catPhis;
    LinearLayout catGeo;
    LinearLayout catRel;
    LinearLayout catHis;
    LinearLayout catBio;
    LinearLayout catCin;
    LinearLayout catArt;
    LinearLayout catLin;
    LinearLayout catSpo;
    LinearLayout catTec;
    LinearLayout catLit;
    LinearLayout catAll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);

        getSupportActionBar().setCustomView(R.layout.ab_align);
        tvTitle = findViewById(R.id.tvTitle);
        tvTitle.setText("Вибери категорію");
 //       setTitle("Вибери категорію");
        catPhis=(LinearLayout)findViewById(R.id.llcat1);
        catGeo=(LinearLayout)findViewById(R.id.llcat2);
        catRel=(LinearLayout)findViewById(R.id.llcat3);
        catHis=(LinearLayout)findViewById(R.id.llcat4);
        catBio=(LinearLayout)findViewById(R.id.llcat5);
        catCin=(LinearLayout)findViewById(R.id.llcat6);
        catArt=(LinearLayout)findViewById(R.id.llcat7);
        catLin=(LinearLayout)findViewById(R.id.llcat8);
        catSpo=(LinearLayout)findViewById(R.id.llcat9);
        catTec=(LinearLayout)findViewById(R.id.llcat10);
        catLit=(LinearLayout)findViewById(R.id.llcat11);
        catAll=(LinearLayout)findViewById(R.id.llcat12);

        catPhis.setOnClickListener(listener);
        catGeo.setOnClickListener(listener);
        catRel.setOnClickListener(listener);
        catHis.setOnClickListener(listener);
        catBio.setOnClickListener(listener);
        catCin.setOnClickListener(listener);
        catArt.setOnClickListener(listener);
        catLin.setOnClickListener(listener);
        catSpo.setOnClickListener(listener);
        catTec.setOnClickListener(listener);
        catLit.setOnClickListener(listener);
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
                case R.id.llcat4:
                    catName = "catHistory";
                    break;
                case R.id.llcat5:
                    catName = "catBiology";
                    break;
                case R.id.llcat6:
                    catName = "catCinema";
                    break;
                case R.id.llcat7:
                    catName = "catArt";
                    break;
                case R.id.llcat8:
                    catName = "catLing";
                    break;
                case R.id.llcat9:
                    catName = "catSport";
                    break;
                case R.id.llcat10:
                    catName = "catTechnology";
                    break;
                case R.id.llcat11:
                    catName = "catLiterature";
                    break;
                case R.id.llcat12:
                    catName = "catAll";
                    break;
            }
            //Intent i= new Intent(getApplicationContext(),Main2ActivitySec1.class);
            Intent i= new Intent(getApplicationContext(),QuestActivity.class);
            i.putExtra("category_name",catName);
            //level_name = B доки нема етапів
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

