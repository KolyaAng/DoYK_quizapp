package com.example.pro.doyk;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.pro.doyk.DbHelper.DbHelper;
import com.example.pro.doyk.LeaderBoard.Fundamentals.LeaderBoardAcSec1B;
import com.example.pro.doyk.LocalScoreBoard.LocalScoreBoard;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ActivityMyScore extends AppCompatActivity {

    Button catScore;
    Button leaderBoard;
    TextView yourScore;
    FirebaseAuth mAuth;
    DatabaseReference mUserRefDatabase;
    ChildEventListener mChildEventListener;
    DbHelper dbHelper = new DbHelper(this);
    private int catPhisMarks, catGeoMarks, catRelMarks, catHisMarks, catBioMarks, catCinMarks;
    private int catArtMarks, catLinMarks, catSpoMarks, catTecMarks, catLitMarks, catAllMarks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_score);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);

        getSupportActionBar().setCustomView(R.layout.ab_align);
        TextView tvTitle = findViewById(R.id.tvTitle);
        tvTitle.setText("Рейтинг");

//        getSupportActionBar().setHomeButtonEnabled(true);
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setAuthInstance();
        setDatabaseInstance();

        catPhisMarks = dbHelper.getScoreOSB("catPhysic","B");
        catGeoMarks = dbHelper.getScoreOSB("catGeography","B");
        catRelMarks = dbHelper.getScoreOSB("catReligion","B");
        catHisMarks = dbHelper.getScoreOSB("catHistory","B");
        catBioMarks = dbHelper.getScoreOSB("catBiology","B");
        catCinMarks = dbHelper.getScoreOSB("catCinema","B");
        catArtMarks = dbHelper.getScoreOSB("catArt","B");
        catLinMarks = dbHelper.getScoreOSB("catLing","B");
        catSpoMarks = dbHelper.getScoreOSB("catSport","B");
        catTecMarks = dbHelper.getScoreOSB("catTechnology","B");
        catLitMarks = dbHelper.getScoreOSB("catLiterature","B");
        catAllMarks = dbHelper.getScoreOSB("catAll","B");
        int totalScore = getTotalScore();


        String userId = mAuth.getCurrentUser().getUid();
        mUserRefDatabase.child("users").child(userId).child("catPhisMarks").setValue(catPhisMarks);
        mUserRefDatabase.child("users").child(userId).child("catGeoMarks").setValue(catGeoMarks);
        mUserRefDatabase.child("users").child(userId).child("catRelMarks").setValue(catRelMarks);
        mUserRefDatabase.child("users").child(userId).child("catHisMarks").setValue(catHisMarks);
        mUserRefDatabase.child("users").child(userId).child("catBioMarks").setValue(catBioMarks);
        mUserRefDatabase.child("users").child(userId).child("catCinMarks").setValue(catCinMarks);
        mUserRefDatabase.child("users").child(userId).child("catArtMarks").setValue(catArtMarks);
        mUserRefDatabase.child("users").child(userId).child("catLinMarks").setValue(catLinMarks);
        mUserRefDatabase.child("users").child(userId).child("catSpoMarks").setValue(catSpoMarks);
        mUserRefDatabase.child("users").child(userId).child("catTecMarks").setValue(catTecMarks);
        mUserRefDatabase.child("users").child(userId).child("catLitMarks").setValue(catLitMarks);
        mUserRefDatabase.child("users").child(userId).child("catAllMarks").setValue(catAllMarks);
        mUserRefDatabase.child("users").child(userId).child("totalScoreMarks").setValue(totalScore);

        catScore = findViewById(R.id.btnCatScore);
        leaderBoard = findViewById(R.id.btnLeaderb);
        yourScore = findViewById(R.id.tvYourS);

        yourScore.setText("Твій результат: " + String.valueOf(totalScore));

        catScore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(getApplicationContext(),LocalScoreBoard.class);
                startActivity(i);
                overridePendingTransition(android.R.anim.slide_in_left,android.R.anim.slide_out_right);
            }
        });

        leaderBoard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                int totalScore = dbHelper.getTotalScore();
//                String ts = String.valueOf(totalScore);
//
//                Toast toast = Toast.makeText(getApplicationContext(), ts, Toast.LENGTH_LONG);
//                toast.show();

                Intent i= new Intent(getApplicationContext(), LeaderBoardAcSec1B.class);
                startActivity(i);
                overridePendingTransition(android.R.anim.slide_in_left,android.R.anim.slide_out_right);
            }
        });


    }

    private void setAuthInstance() {
        mAuth = FirebaseAuth.getInstance();
    }

    private void setDatabaseInstance() {
        mUserRefDatabase = FirebaseDatabase.getInstance().getReference();
    }

    public int getTotalScore(){
         int tsc;
         tsc = (catPhisMarks + catAllMarks + catGeoMarks + catArtMarks + catBioMarks + catCinMarks + catHisMarks +
                 catLinMarks + catLitMarks + catRelMarks + catTecMarks + catSpoMarks);
                 return tsc;
    }




    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }
}
