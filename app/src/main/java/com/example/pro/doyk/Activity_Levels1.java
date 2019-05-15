package com.example.pro.doyk;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

public class Activity_Levels1 extends AppCompatActivity {

    LinearLayout beginner;
    LinearLayout intermediate;
    LinearLayout expert;
    String catName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_levels1);
        setTitle("Comp Funda Levels");
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        beginner=(LinearLayout)findViewById(R.id.begin);
        intermediate=(LinearLayout)findViewById(R.id.inter);
        expert=(LinearLayout)findViewById(R.id.expert);
        //
        beginner.setOnClickListener(listener);
        intermediate.setOnClickListener(listener);
        expert.setOnClickListener(listener);
        //
        Intent iin = getIntent();
        Bundle b = iin.getExtras();
        if(b!=null){
            catName=(String)b.get("category_name");
            Log.d("Category Name",catName);
        }
        else
        {
            catName="";
        }

    }


    String levelName;
 //   String callActivity;


    View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
                switch(v.getId()){
                    case R.id.begin:
                        levelName = "B";
                        //callActivity = "Main2ActivitySec1.class";
                        break;
                    case R.id.inter:
                        levelName = "I";
                        break;
                    case R.id.expert:
                        levelName = "E";
                        break;
                }
            Intent i;
                i = new Intent(getApplicationContext(), Main2ActivitySec1.class);
            i.putExtra("category_name",catName);
                i.putExtra("level_name", levelName);
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
