package com.example.pro.doyk;


import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.pro.doyk.DbHelper.DbHelper;
import com.example.pro.doyk.Model.UserModel;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.DecimalFormat;
import java.util.ArrayList;

import static com.example.pro.doyk.Adapter.Category.getCategoryImage;
import static com.example.pro.doyk.Adapter.Category.getCategoryMarks;

public class ResultActivity extends AppCompatActivity {

    FirebaseAuth mAuth;
    DatabaseReference mUserRefDatabase;

    int score=0;
    int fbScore = 0;
    DbHelper dbHelper = new DbHelper(this);

    Button btnWrongQstns;
    Button btnToScore;
    Button btnRepeat;
    LinearLayout imgL;

    public ArrayList<String> wrongQuests = new ArrayList<String>();
    public ArrayList<String> selectedAnswers = new ArrayList<String>();
    public ArrayList<String> actualAnswers = new ArrayList<String>();

    private ImageView img;
    private TextView tvPerc;
    String userName = "UserNameR";
    String levelName="",catName="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        img = (ImageView) findViewById(R.id.imageView);
        btnWrongQstns = (Button) findViewById(R.id.btnWrongQstns);
        btnToScore = (Button) findViewById(R.id.btnToScore);
        btnRepeat = (Button) findViewById(R.id.btnRepeat);
        btnRepeat.setEnabled(false);
        imgL = findViewById(R.id.imgL);

        Animation rotate = AnimationUtils.loadAnimation(this, R.anim.rotate_around_center_point);
        rotate.setRepeatCount(1);
        img.startAnimation(rotate);
        setAuthInstance();
        setDatabaseInstance();

        //get text view
        TextView txtCorrectAns = (TextView) findViewById(R.id.txtCorrectAns);
        //get score
        final Bundle b = getIntent().getExtras();
        if (b != null) {
            score = b.getInt("score");
            catName=b.getString("category_name");
            levelName=b.getString("level_name");
            dbHelper.insertScore(score,catName,levelName);
            }

        setFBScore();

        String imgName = getCategoryImage(catName);
        imgL.setBackgroundResource(getResources().getIdentifier(imgName, "drawable", getPackageName()));

            if(score > 9){
            txtCorrectAns.setText("Вітаю! Ти отримав маскимальний бал в цій категорії.");
        }
        else {
                String s;
                if((score == 0) || (score > 4)){s = " питань";} else {s = " питання";}
                txtCorrectAns.setText("Ти надав правильну відповідь на " + score + s +" з 10.");
                btnRepeat.setEnabled(true);
                btnRepeat.setVisibility(View.VISIBLE);
            }
        wrongQuests = getIntent().getStringArrayListExtra("wrongQuestions");
        selectedAnswers = getIntent().getStringArrayListExtra("selectedAnswer");
        actualAnswers = getIntent().getStringArrayListExtra("actualAnswer");

        double perc = score*10;
        DecimalFormat df = new DecimalFormat("##.###");
        tvPerc = (TextView) findViewById(R.id.tvPerc);
        tvPerc.setText(""+df.format(perc)+" %");

        btnWrongQstns.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intent = new Intent(ResultActivity.this, WrongQuestion.class);
//                //Bundle b = new Bundle();
//                intent.putStringArrayListExtra("wrongQuestions", wrongQuests);
//                intent.putStringArrayListExtra("selectedAnswer", selectedAnswers);
//                intent.putStringArrayListExtra("actualAnswer", actualAnswers);
//                startActivity(intent);
                finish();
            }
        });
        btnToScore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ResultActivity.this, ActivityMyScore.class);
                intent.putExtra("userName", userName);
                startActivity(intent);
                finish();
            }
        });
        btnRepeat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ResultActivity.this, QuestActivity.class);
                i.putExtra("category_name",catName);
                i.putExtra("level_name", "B");
                startActivity(i);
                finish();
            }
        });


    }

    public void setFBScore(){
        String catMark = getCategoryMarks(catName);
        fbScore = dbHelper.getScoreOSB(catName, levelName);
        String userId = mAuth.getCurrentUser().getUid();
        mUserRefDatabase.child("users").child(userId).child(catMark).setValue(fbScore);
    }

    private void setAuthInstance() {
        mAuth = FirebaseAuth.getInstance();
    }

    private void setDatabaseInstance() {
        mUserRefDatabase = FirebaseDatabase.getInstance().getReference();
    }

    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }
}
