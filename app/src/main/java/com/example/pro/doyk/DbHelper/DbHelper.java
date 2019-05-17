package com.example.pro.doyk.DbHelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.pro.doyk.Model.QuestionOS;

import java.util.ArrayList;
import java.util.List;

public class DbHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "Quiz.db";
    private static final String TABLE_QUEST = "questtable";
    private static final String KEY_ID = "id";
    private static final String KEY_QUES = "question";
    private static final String KEY_ANSWER = "answer"; //correct option
    private static final String KEY_OPTA= "opta"; //option a
    private static final String KEY_OPTB= "optb"; //option b
    private static final String KEY_OPTC= "optc"; //option c
    private static final String KEY_OPTD= "optd"; //option d
    private static final String KEY_CAT="category"; //category
    private static final String KEY_LEVEL="level";


    public static final String TABLE_SCORE="score";
    public static final String SCORE_KEY_ID="id";
    public static final String SCORE_KEY_SECTION="section";
    public static final String SCORE_KEY_LVL="level";
    public static final String SCORE_KEY_SCORE="score";

    private SQLiteDatabase dbase;

    public DbHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    public DbHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        dbase=db;

        String sql = "CREATE TABLE IF NOT EXISTS " + TABLE_QUEST + " ( "
                + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_QUES
                + " TEXT, " + KEY_ANSWER+ " TEXT, "+KEY_OPTA +" TEXT, "
                +KEY_OPTB +" TEXT, "+KEY_OPTC+" TEXT, "+KEY_OPTD+" TEXT, "+KEY_CAT+" TEXT, "+KEY_LEVEL+" TEXT)";
        db.execSQL(sql);
        addQuestionsOS();

        String sql4 = "CREATE TABLE IF NOT EXISTS "+ TABLE_SCORE+" ( "
                + SCORE_KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + SCORE_KEY_SECTION
                + " TEXT, " + SCORE_KEY_LVL+ " TEXT, "+ SCORE_KEY_SCORE+" INTEGER)";
        db.execSQL(sql4);
    }

    private void addQuestionsOS(){
        QuestionOS q1 = new QuestionOS("quest from Geo,B,1","ok","Normal","Differential","Incremental","ok","catGeography","B");
        this.addQuestionOS(q1);
        QuestionOS q2 = new QuestionOS("quest from Geo,B,2","ok","Normal","Differential","Incremental","ok","catGeography","B");
        this.addQuestionOS(q2);
        QuestionOS q3 = new QuestionOS("quest from Geo,B,3","ok","Normal","Differential","Incremental","ok","catGeography","B");
        this.addQuestionOS(q3);
        QuestionOS q4 = new QuestionOS("quest from Geo,B,4","ok","Normal","Differential","Incremental","ok","catGeography","B");
        this.addQuestionOS(q4);
        QuestionOS q5 = new QuestionOS("quest from Phy,B","ok","Normal","Differential","Incremental","ok","catPhysic","B");
        this.addQuestionOS(q5);
        QuestionOS q6 = new QuestionOS("quest from Phy,B","ok","Normal","Differential","Incremental","ok","catPhysic","B");
        this.addQuestionOS(q6);
        QuestionOS q7 = new QuestionOS("quest from Phy,B","ok","Normal","Differential","Incremental","ok","catPhysic","B");
        this.addQuestionOS(q7);
        QuestionOS q8 = new QuestionOS("quest from Phy,B","ok","Normal","Differential","Incremental","ok","catPhysic","B");
        this.addQuestionOS(q8);
        QuestionOS q9 = new QuestionOS("quest from Phy,B","ok","Normal","Differential","Incremental","ok","catPhysic","B");
        this.addQuestionOS(q9);
        QuestionOS q10 = new QuestionOS("quest from Rel,B","ok","Normal","Differential","Incremental","ok","catReligion","B");
        this.addQuestionOS(q10);
        QuestionOS q11 = new QuestionOS("quest from Rel,B","ok","Normal","Differential","Incremental","ok","catReligion","B");
        this.addQuestionOS(q11);
        QuestionOS q12 = new QuestionOS("quest from Rel,B","ok","Normal","Differential","Incremental","ok","catReligion","B");
        this.addQuestionOS(q12);
        QuestionOS q13 = new QuestionOS("quest from Rel,B","ok","Normal","Differential","Incremental","ok","catReligion","B");
        this.addQuestionOS(q13);
        QuestionOS q14 = new QuestionOS("quest from Rel,B","ok","Normal","Differential","Incremental","ok","catReligion","B");
        this.addQuestionOS(q14);
        QuestionOS q15 = new QuestionOS("quest from Geo,B,5","ok","Normal","Differential","Incremental","ok","catGeography","B");
        this.addQuestionOS(q15);
        QuestionOS q16 = new QuestionOS("quest from Art,B,1","ok","Normal","Differential","Incremental","ok","catArt","B");
        this.addQuestionOS(q16);

    }

    public void addQuestionOS(QuestionOS quest) {
        //SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_QUES, quest.getQUESTION());
        values.put(KEY_ANSWER, quest.getANSWER());
        values.put(KEY_OPTA, quest.getOPTA());
        values.put(KEY_OPTB, quest.getOPTB());
        values.put(KEY_OPTC, quest.getOPTC());
        values.put(KEY_OPTD, quest.getOPTD());
        values.put(KEY_CAT,quest.getCATEGORY());
        values.put(KEY_LEVEL, quest.getLEVEL());
        // Inserting Row
        dbase.insert(TABLE_QUEST, null, values);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


    public List<QuestionOS> getAllQuestions(String tname, String lname)
    {
        List<QuestionOS> quesList1= new ArrayList<QuestionOS>();

        String selectQuery1;
        if(tname.equals("catAll")){
            selectQuery1 = "SELECT  * FROM "+ TABLE_QUEST;
        }else
            {
        selectQuery1 = "SELECT  * FROM "+ TABLE_QUEST +" WHERE "+KEY_CAT+" = '"+tname+"' AND "+KEY_LEVEL+" = '"+lname+"'";}

        dbase=this.getReadableDatabase();
        Cursor cursor = dbase.rawQuery(selectQuery1, null);
        if (cursor.moveToFirst()) {
            do {
                QuestionOS quest1 = new QuestionOS();
                quest1.setID(cursor.getInt(0));
                quest1.setQUESTION(cursor.getString(1));
                quest1.setANSWER(cursor.getString(2));
                quest1.setOPTA(cursor.getString(3));
                quest1.setOPTB(cursor.getString(4));
                quest1.setOPTC(cursor.getString(5));
                quest1.setOPTD(cursor.getString(6));
                quesList1.add(quest1);
            } while (cursor.moveToNext());
        }
        return quesList1;
    }

    public boolean insertScore(int scoreOS, String tname, String cname){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(SCORE_KEY_SECTION.toString(),tname);
        contentValues.put(SCORE_KEY_LVL.toString(),cname);
        contentValues.put(SCORE_KEY_SCORE.toString(), scoreOS);
        long resultscore = db.insert(TABLE_SCORE, null, contentValues);
        if(resultscore == -1){
            return false;}
        else{
            return true;
            }
    }

    public int getScoreOSB(String catname, String lvlname) {
        Cursor c;
        SQLiteDatabase db = this.getWritableDatabase();
        String sqlSelectQuery="SELECT MAX(" + SCORE_KEY_SCORE + ") FROM " + TABLE_SCORE + " WHERE " + SCORE_KEY_SECTION + " = '"+catname+"' AND " + SCORE_KEY_LVL + " = " +"'"+lvlname+"'";
  //      "DELETE MIN(" + SCORE_KEY_SCORE + ") FROM " + TABLE_SCORE + " WHERE " + SCORE_KEY_SECTION + " = '"+catname+"' AND " + SCORE_KEY_LVL + " = " +"'"+lvlname+"'";

        c=db.rawQuery(sqlSelectQuery, null);
        c.moveToFirst();
        int x=c.getInt(0);
        Log.d("posol", String.valueOf(x));
        return x;
    }

//    public int getTotalScore(){
//        Cursor c;
//        SQLiteDatabase db = this.getWritableDatabase();
//        String sqlSelectQuery="SELECT SUM(" + SCORE_KEY_SCORE + ") FROM "+ TABLE_SCORE +"";
//        c=db.rawQuery(sqlSelectQuery, null);
//        c.moveToFirst();
//        int x=c.getInt(0);
//        Log.d("posol", String.valueOf(x));
//        return x;
//    }

}
