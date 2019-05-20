package com.example.pro.doyk.Scores;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.pro.doyk.DbHelper.DbHelper;
import com.example.pro.doyk.R;

public class LocalScoreBoard extends AppCompatActivity {

    DbHelper dbHelper = new DbHelper(this);
    TextView s1,s2,s3, s4, s5, s6, s7, s8, s9, s10, s11, s12;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_local_score_board);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);

        getSupportActionBar().setCustomView(R.layout.ab_align);
        TextView tvTitle = findViewById(R.id.tvTitle);
        tvTitle.setText("Рейтинг по категоріям");


        int phys, geo, rel, his, bio, cin, art, lin, spo, tec, lit, all;


        phys = dbHelper.getScoreOSB("catPhysic","B");
        geo = dbHelper.getScoreOSB("catGeography","B");
        rel = dbHelper.getScoreOSB("catReligion","B");
        his = dbHelper.getScoreOSB("catHistory","B");
        bio = dbHelper.getScoreOSB("catBiology","B");
        cin = dbHelper.getScoreOSB("catCinema","B");
        art = dbHelper.getScoreOSB("catArt","B");
        lin = dbHelper.getScoreOSB("catLing","B");
        spo = dbHelper.getScoreOSB("catSport","B");
        tec = dbHelper.getScoreOSB("catTechnology","B");
        lit = dbHelper.getScoreOSB("catLiterature","B");
        all = dbHelper.getScoreOSB("catAll","B");

        s1=(TextView)findViewById(R.id.st1);
        s2=(TextView)findViewById(R.id.st2);
        s3=(TextView)findViewById(R.id.st3);
        s4=(TextView)findViewById(R.id.st4);
        s5=(TextView)findViewById(R.id.st5);
        s6=(TextView)findViewById(R.id.st6);
        s7=(TextView)findViewById(R.id.st7);
        s8=(TextView)findViewById(R.id.st8);
        s9=(TextView)findViewById(R.id.st9);
        s10=(TextView)findViewById(R.id.st10);
        s11=(TextView)findViewById(R.id.st11);
        s12=(TextView)findViewById(R.id.st12);

        if(phys<10) { s1.setText("0"+ phys + "/10");} else { s1.setText(""+ phys+ "/10");}
        if(geo<10) { s2.setText("0"+ geo+ "/10");} else { s2.setText(""+ geo+ "/10");}
        if(rel<10) { s3.setText("0"+ rel+ "/10");} else { s3.setText(""+ rel+ "/10");}
        if(his<10) { s4.setText("0"+ his+ "/10");} else { s4.setText(""+ his+ "/10");}
        if(bio<10) { s5.setText("0"+ bio+ "/10");} else { s5.setText(""+ bio+ "/10");}
        if(cin<10) { s6.setText("0"+ cin+ "/10");} else { s6.setText(""+ cin+ "/10");}
        if(art<10) { s7.setText("0"+ art+ "/10");} else { s7.setText(""+ art+ "/10");}
        if(lin<10) { s8.setText("0"+ lin+ "/10");} else { s8.setText(""+ lin+ "/10");}
        if(spo<10) { s9.setText("0"+ spo+ "/10");} else { s9.setText(""+ spo+ "/10");}
        if(tec<10) { s10.setText("0"+ tec+ "/10");} else { s10.setText(""+ tec+ "/10");}
        if(lit<10) { s11.setText("0"+ lit+ "/10");} else { s11.setText(""+ lit+ "/10");}
        if(all<10) { s12.setText("0"+ all+ "/10");} else { s12.setText(""+ all+ "/10");}

    }

    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }
}
