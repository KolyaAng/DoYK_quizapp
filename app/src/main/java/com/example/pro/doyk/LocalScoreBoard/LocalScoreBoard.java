package com.example.pro.doyk.LocalScoreBoard;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.pro.doyk.DbHelper.DbHelper;
import com.example.pro.doyk.R;

public class LocalScoreBoard extends AppCompatActivity {

    DbHelper dbHelper = new DbHelper(this);
    TextView s1,s2,s3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scorelevel1);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);

        getSupportActionBar().setCustomView(R.layout.ab_align);
        TextView tvTitle = findViewById(R.id.tvTitle);
        tvTitle.setText("Рейтинг по категоріям");

//        getSupportActionBar().setHomeButtonEnabled(true);
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        int compFundaB,compFundaI,compFundaE;
        compFundaB=compFundaI=compFundaE=0;
        compFundaB=dbHelper.getScoreOSB("catPhysic","B");
        compFundaI=dbHelper.getScoreOSB("catGeography","B");
        compFundaE=dbHelper.getScoreOSB("catReligion","B");
        s1=(TextView)findViewById(R.id.st1);
        s2=(TextView)findViewById(R.id.st2);
        s3=(TextView)findViewById(R.id.st3);
        if(compFundaB<10)
        {
            s1.setText("0"+ compFundaB);
        }
        else
        {
            s1.setText(""+ compFundaB);
        }
        if(compFundaI<10)
        {
            s2.setText("0"+ compFundaI);
        }
        else
        {
            s2.setText(""+ compFundaI);
        }
        if(compFundaE<10)
        {
            s3.setText("0"+ compFundaE);
        }
        else
        {
            s3.setText(""+ compFundaE);
        }

    }

    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }
}
