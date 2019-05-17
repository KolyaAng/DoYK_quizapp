package com.example.pro.doyk;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.pro.doyk.DbHelper.DbHelper;
import com.example.pro.doyk.Model.QuestionOS;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import static com.example.pro.doyk.Adapter.Category.getCategoryTitle;

public class Main2ActivitySec1 extends AppCompatActivity {
    List<QuestionOS> quesList;
    public int score=0;
    int ctr1=1;
    QuestionOS currentQ1;
    TextView txtQuestion;
    RadioGroup grp;
    RadioButton rda, rdb, rdc, rdd;
    Button butNext;
    Random random = new Random();
    ArrayList<Integer> list = new ArrayList<Integer>();
    TextView textViewTime;
    public ArrayList<String> wrongQuestList = new ArrayList<String>();
    public ArrayList<String> selectedAnswer = new ArrayList<String>();
    public ArrayList<String> actualAnswer = new ArrayList<String>();
    int number;
    String catName="",levelName="";
    TextView qstnNo;
    boolean timerFlag;
    ///
///
    final CounterClass timer = new CounterClass(31000, 1000);

    public void nextQuest(){
        timer.start();
        if (timerFlag){
                RadioButton answer = (RadioButton) findViewById(grp.getCheckedRadioButtonId());
                if (currentQ1.getANSWER().equals(answer.getText())) {
                    score++;
                }
                else
                {
                    wrongQuestList.add(number, currentQ1.getQUESTION());
                    selectedAnswer.add(number, answer.getText().toString());
                    actualAnswer.add(number, currentQ1.getANSWER());
                    number++;
                }
        }else
        {
            wrongQuestList.add(number, currentQ1.getQUESTION());
            selectedAnswer.add(number, "Час питання вийшов.");
            actualAnswer.add(number, currentQ1.getANSWER());
            number++;
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        grp.clearCheck();
        if (ctr1 < quesList.size()) {
            currentQ1 = quesList.get(list.get(ctr1));
            setQuestionView();
        } else {
            timer.cancel();
            showResult();
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2_sec1);
        qstnNo = (TextView)findViewById(R.id.qstnNo);
        
        Intent iin=getIntent();
        Bundle b=iin.getExtras();

        if(b!=null){
            catName=(String)b.get("category_name");
            levelName=(String)b.get("level_name");
            Log.d("CategoryName",catName);
            Log.d("LevelName",levelName);
        }
        String catTitle = getCategoryTitle(catName);
        setTitle(catTitle);
        number=0;
        DbHelper db= new DbHelper(this);
        textViewTime = (TextView)findViewById(R.id.textViewTime);
       // final CounterClass timer = new CounterClass(1800000, 1000);
        timer.start();
        quesList = db.getAllQuestions(catName,levelName);
        for(int i = 0; i < quesList.size(); i++){
            while(true){
                int next = random.nextInt(quesList.size());
                if(!list.contains(next))
                {
                    list.add(next);
                    break;
                }
            }
        }
        currentQ1= quesList.get(list.get(0));
        txtQuestion =(TextView)findViewById(R.id.textView1);
        rda =(RadioButton)findViewById(R.id.radio0);
        rdb =(RadioButton)findViewById(R.id.radio1);
        rdc =(RadioButton)findViewById(R.id.radio2);
        rdd =(RadioButton)findViewById(R.id.radio3);
        butNext =(Button)findViewById(R.id.button1);
        setQuestionView();
        grp = (RadioGroup) findViewById(R.id.radioGroup1);
        grp.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if(i== R.id.radio0 || i == R.id.radio1 || i==R.id.radio2 || i == R.id.radio3){

                    timerFlag = true;
                    nextQuest();
                }
            }
        });

    }


    public class CounterClass extends CountDownTimer {
        public CounterClass(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onTick(long millisUntilFinished) {
            long millis = millisUntilFinished;
            String hms = String.format("%02d:%02d",
                    TimeUnit.MILLISECONDS.toMinutes(millis) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(millis)),
                    TimeUnit.MILLISECONDS.toSeconds(millis) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millis)));
            textViewTime.setText(hms);
        }

        @Override
        public void onFinish() {
            timerFlag = false;
            nextQuest();
        }
    }

    public void showResult(){
        Intent intent = new Intent(Main2ActivitySec1.this, ResultActivity.class);
        Bundle b = new Bundle();
        b.putInt("score", score);//Your score
        b.putString("category_name",catName);//Your table name
        b.putString("level_name",levelName);//Your category name
        intent.putStringArrayListExtra("wrongQuestions", wrongQuestList);
        intent.putStringArrayListExtra("selectedAnswer", selectedAnswer);
        intent.putStringArrayListExtra("actualAnswer", actualAnswer);
        intent.putExtras(b); //Put your score to your next Intent
        startActivity(intent);
        finish();
    }

    private void setQuestionView(){
        txtQuestion.setText(currentQ1.getQUESTION());
        rda.setText(currentQ1.getOPTA());
        rdb.setText(currentQ1.getOPTB());
        rdc.setText(currentQ1.getOPTC());
        rdd.setText(currentQ1.getOPTD());
        if(ctr1<10)
            qstnNo.setText("0" + ctr1 + "/10");
        else
            qstnNo.setText("" + ctr1+ "/10");
        ctr1++;
    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(R.string.exit_fr_quest)
                .setCancelable(false)
                .setPositiveButton("Так", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        timer.cancel();
                        finish();
                    }
                })
                .setNegativeButton("Ні", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });

        AlertDialog alert = builder.create();
        alert.show();
    }
}
