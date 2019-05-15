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
//    private static final String TABLE_QUEST1 = "catPhis";
//    private static final String TABLE_QUEST2 = "questHardware";
//    private static final String TABLE_QUEST3 = "questFinal";

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

//        String sql1 = "CREATE TABLE IF NOT EXISTS " + TABLE_QUEST1 + " ( "
//                + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_QUES
//                + " TEXT, " + KEY_ANSWER+ " TEXT, "+KEY_OPTA +" TEXT, "
//                +KEY_OPTB +" TEXT, "+KEY_OPTC+" TEXT, "+KEY_OPTD+" TEXT, "+KEY_CAT+" TEXT)";
//        db.execSQL(sql1);
//        addQuestionsCompFunda();
//
//        String sql2 = "CREATE TABLE IF NOT EXISTS " + TABLE_QUEST2 + " ( "
//                + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_QUES
//                + " TEXT, " + KEY_ANSWER+ " TEXT, "+KEY_OPTA +" TEXT, "
//                +KEY_OPTB +" TEXT, "+KEY_OPTC+" TEXT, "+KEY_OPTD+" TEXT, "+KEY_CAT+" TEXT)";
//        db.execSQL(sql2);
//        addQuestionsHardware();
//
//        String sql3 = "CREATE TABLE IF NOT EXISTS " + TABLE_QUEST3 + " ( "
//                + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_QUES
//                + " TEXT, " + KEY_ANSWER+ " TEXT, "+KEY_OPTA +" TEXT, "
//                +KEY_OPTB +" TEXT, "+KEY_OPTC+" TEXT, "+KEY_OPTD+" TEXT)";
//        db.execSQL(sql3);
//        addQuestionsRandom();

        String sql4 = "CREATE TABLE IF NOT EXISTS "+ TABLE_SCORE+" ( "
                + SCORE_KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + SCORE_KEY_SECTION
                + " TEXT, " + SCORE_KEY_LVL+ " TEXT, "+ SCORE_KEY_SCORE+" INTEGER)";
        db.execSQL(sql4);
    }

//    private void addQuestionsCompFunda() {
//
//        QuestionCompFunda q245= new QuestionCompFunda("1 Byte = ?","8 bits","4 bits","2 bits","1 bit","8 bits","E");
//        this.addQuestionCompFunda(q245);
//        QuestionCompFunda q246= new QuestionCompFunda("Which of the following is an OOP Principle","Structured Programming","Procedural Programming","Inheritance","Linking","Inheritance","E");
//        this.addQuestionCompFunda(q246);
//        QuestionCompFunda q247= new QuestionCompFunda("Which command divides the surface of the blank disk into sectors and assign a unique address to each one","Ver","Format","Fat","Check Disk","Format","E");
//        this.addQuestionCompFunda(q247);
//        QuestionCompFunda q248= new QuestionCompFunda("Every computer connected to an intranet or extranet must have a distinct","firewall","Proxy Server","Domain Name","IP address","IP address","E");
//        this.addQuestionCompFunda(q248);
//        QuestionCompFunda q249= new QuestionCompFunda("Firewalls are used to protect against","Unauthorized Attacks","Viruses","Fire Attacks","Data Driven Attacks","Unauthorized Attacks","E");
//        this.addQuestionCompFunda(q249);
//        QuestionCompFunda q250= new QuestionCompFunda("The first Digital Computer introduced, was named as ","UNIVAC","EDSAC","ENIAC","MARK-1","MARK-1","E");
//        this.addQuestionCompFunda(q250);
//
//    }
//
//    public void addQuestionCompFunda(QuestionCompFunda quest) {
//        //SQLiteDatabase db = this.getWritableDatabase();
//        ContentValues values = new ContentValues();
//        values.put(KEY_QUES, quest.getQUESTION1());
//        values.put(KEY_ANSWER, quest.getANSWER1());
//        values.put(KEY_OPTA, quest.getOPTA1());
//        values.put(KEY_OPTB, quest.getOPTB1());
//        values.put(KEY_OPTC, quest.getOPTC1());
//        values.put(KEY_OPTD, quest.getOPTD1());
//        values.put(KEY_CAT,quest.getCATEGORY1());
//        // Inserting Row
//        dbase.insert(TABLE_QUEST1, null, values);
//    }

    private void addQuestionsOS(){
        QuestionOS q1 = new QuestionOS("quest from Geo,B","ok","Normal","Differential","Incremental","ok","catGeography","B");
        this.addQuestionOS(q1);
        QuestionOS q2 = new QuestionOS("quest from Geo,B","ok","Normal","Differential","Incremental","ok","catGeography","B");
        this.addQuestionOS(q2);
        QuestionOS q3 = new QuestionOS("quest from Geo,B","ok","Normal","Differential","Incremental","ok","catGeography","B");
        this.addQuestionOS(q3);
        QuestionOS q4 = new QuestionOS("quest from Geo,B","ok","Normal","Differential","Incremental","ok","catGeography","B");
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
        QuestionOS q15 = new QuestionOS("quest from Geo,B","ok","Normal","Differential","Incremental","ok","catGeography","B");
        this.addQuestionOS(q15);

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

//    private void addQuestionsHardware() {
//        QuestionHardWare q143= new QuestionHardWare("During boot-up, the memory test:","Is a superfluous step that should be ignored","Checks and verifies that contiguous memory is installed","Is an operational error","Displays what memory is installed, but nothing else","Checks and verifies that contiguous memory is installed","I");
//        this.addQuestionHardware(q143);
//        QuestionHardWare q144= new QuestionHardWare("What do you need to check serial and parallel port?","Port adapter","Logic probe","Loopback plug","All of the above","Loopback plug","I");
//        this.addQuestionHardware(q144);
//        QuestionHardWare q145= new QuestionHardWare("To test for AC ripple on a PC power supply, you would set the volt/ohm meter for:","DC","AC","Ohm","Farad","AC","I");
//        this.addQuestionHardware(q145);
//        QuestionHardWare q146= new QuestionHardWare("On the 16-bit ISA bus, IRQ2 is elevated to which higher level interrupt?","9","11","13","15","9","I");
//        this.addQuestionHardware(q146);
//        QuestionHardWare q147= new QuestionHardWare("What is a common language that computers use to talk with one another on a network","client","adapter","protocol","OS","protocol","I");
//        this.addQuestionHardware(q147);
//        QuestionHardWare q148= new QuestionHardWare("A COM port is a _____ port.","parallel","serial","static","multi","serial","I");
//        this.addQuestionHardware(q148);
//        QuestionHardWare q149= new QuestionHardWare("Modems use transmission.","synchronous","asynchronous","timed interval","ata","asynchronous","I");
//        this.addQuestionHardware(q149);
//        QuestionHardWare q150= new QuestionHardWare("The DC voltage on most circuit boards is:","-12 V","0 V","+5 V","+12 V","+5 V","I");
//        this.addQuestionHardware(q150);
//    }
//
//    public void addQuestionHardware(QuestionHardWare quest) {
//        //SQLiteDatabase db = this.getWritableDatabase();
//        ContentValues values = new ContentValues();
//        values.put(KEY_QUES, quest.getQUESTION2());
//        values.put(KEY_ANSWER, quest.getANSWER2());
//        values.put(KEY_OPTA, quest.getOPTA2());
//        values.put(KEY_OPTB, quest.getOPTB2());
//        values.put(KEY_OPTC, quest.getOPTC2());
//        values.put(KEY_OPTD, quest.getOPTD2());
//        values.put(KEY_CAT,quest.getCATEGORY2());
//        // Inserting Row
//        dbase.insert(TABLE_QUEST2, null, values);
//    }
//
//    private void addQuestionsRandom() {
//        QuestionRandom q105 = new QuestionRandom("One of the things that separates a TERMINAL from a PC is that the terminal does not have a what ?","Keyboard","Monitor","Power Cord","CPU","CPU");
//        this.addQuestionRandom(q105);
//        QuestionRandom q106 = new QuestionRandom("Data is stored on diskette in what form ?","Ink","Laser Bubble","Magnetism","Circuits","Magnetism");
//        QuestionRandom q296 = new QuestionRandom("The function(s) of the Storage Assignment is (are)","to assign storage to all variables referenced in the source program.","to assign storage to all temporary locations that are necessary for intermediate results","to assign storage to literals, and to ensure that the storage is allocate and appropriate locations are initialized.","all of the above","all of the above");
//        this.addQuestionRandom(q296);
//        QuestionRandom q297 = new QuestionRandom("A Processor","is a device that performs a sequence of operations specified by instructions in memory.","is the device where information is stored","is a sequence of instructions","is typically characterized by interactive processing and time of the CPU's time to allow quick response to each user","is a device that performs a sequence of operations specified by instructions in memory");
//        this.addQuestionRandom(q297);
//        QuestionRandom q298 = new QuestionRandom("With MS-DOS which command will divide the surface of the blank floppy disk into sectors and assign a unique address to each one?","FORMAT command","FAT command","VER command","CHKDSK command","FORMAT command");
//        this.addQuestionRandom(q298);
//        QuestionRandom q299 = new QuestionRandom("Multiprogramming","is a method of memory allocation by which the program is subdivided into equal portions, or pages and core is subdivided into equal portions or blocks.","consists of those addresses that may be generated by a processor during execution of a computation","is a method of allocating processor time.","allows multiple programs to reside in separate areas of core at the time","allows multiple programs to reside in separate areas of core at the time");
//        this.addQuestionRandom(q299);
//        QuestionRandom q300 = new QuestionRandom("A translator which reads an entire programme written in a high level language and converts it into machine language code is:","assembler","translator","compiler","system software","compiler");
//        this.addQuestionRandom(q300);
//
//    }
//
//
//    public void addQuestionRandom(QuestionRandom quest) {
//        ContentValues values = new ContentValues();
//        values.put(KEY_QUES, quest.getQUESTION3());
//        values.put(KEY_ANSWER, quest.getANSWER3());
//        values.put(KEY_OPTA, quest.getOPTA3());
//        values.put(KEY_OPTB, quest.getOPTB3());
//        values.put(KEY_OPTC, quest.getOPTC3());
//        values.put(KEY_OPTD, quest.getOPTD3());
//        // Inserting Row
//        dbase.insert(TABLE_QUEST3, null, values);
//    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

//    public List<QuestionCompFunda> getAllQuestions1(String tname, String lname)
//    {
//        List<QuestionCompFunda> quesList1= new ArrayList<QuestionCompFunda>();
//        String selectQuery1 = "SELECT  * FROM " + tname+" WHERE "+KEY_CAT+" = '"+lname+"'";
//        dbase=this.getReadableDatabase();
//        Cursor cursor = dbase.rawQuery(selectQuery1, null);
//        // looping through all rows and adding to list
//        if (cursor.moveToFirst()) {
//            do {
//                QuestionCompFunda quest1 = new QuestionCompFunda();
//                quest1.setID1(cursor.getInt(0));
//                quest1.setQUESTION1(cursor.getString(1));
//                quest1.setANSWER1(cursor.getString(2));
//                quest1.setOPTA1(cursor.getString(3));
//                quest1.setOPTB1(cursor.getString(4));
//                quest1.setOPTC1(cursor.getString(5));
//                quest1.setOPTD1(cursor.getString(6));
//                quesList1.add(quest1);
//            } while (cursor.moveToNext());
//        }
//        // return quest list
//        return quesList1;
//    }

    public List<QuestionOS> getAllQuestions(String tname, String lname)
    {
        List<QuestionOS> quesList1= new ArrayList<QuestionOS>();
        String selectQuery1 = "SELECT  * FROM "+ TABLE_QUEST +" WHERE "+KEY_CAT+" = '"+tname+"' AND "+KEY_LEVEL+" = '"+lname+"'";
        //AND "+KEY_LEVEL+" = '"+lname+"'
        dbase=this.getReadableDatabase();
        Cursor cursor = dbase.rawQuery(selectQuery1, null);
        // looping through all rows and adding to list
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
        // return quest list
        return quesList1;
    }

//    public List<QuestionHardWare> getAllQuestions2(String tname, String lname)
//    {
//        List<QuestionHardWare> quesList1= new ArrayList<QuestionHardWare>();
//        String selectQuery1 = "SELECT  * FROM " + tname+" WHERE "+KEY_CAT+" = '"+lname+"'";
//        dbase=this.getReadableDatabase();
//        Cursor cursor = dbase.rawQuery(selectQuery1, null);
//        // looping through all rows and adding to list
//        if (cursor.moveToFirst()) {
//            do {
//                QuestionHardWare quest1 = new QuestionHardWare();
//                quest1.setID2(cursor.getInt(0));
//                quest1.setQUESTION2(cursor.getString(1));
//                quest1.setANSWER2(cursor.getString(2));
//                quest1.setOPTA2(cursor.getString(3));
//                quest1.setOPTB2(cursor.getString(4));
//                quest1.setOPTC2(cursor.getString(5));
//                quest1.setOPTD2(cursor.getString(6));
//                quesList1.add(quest1);
//            } while (cursor.moveToNext());
//        }
//        // return quest list
//        return quesList1;
//    }
//
//    public List<QuestionRandom> getAllQuestions3(String tname)
//    {
//        List<QuestionRandom> quesList1= new ArrayList<QuestionRandom>();
//        String selectQuery1 = "SELECT  * FROM " + tname ;
//        dbase=this.getReadableDatabase();
//        Cursor cursor = dbase.rawQuery(selectQuery1, null);
//        // looping through all rows and adding to list
//        if (cursor.moveToFirst()) {
//            do {
//                QuestionRandom quest1 = new QuestionRandom();
//                quest1.setID3(cursor.getInt(0));
//                quest1.setQUESTION3(cursor.getString(1));
//                quest1.setANSWER3(cursor.getString(2));
//                quest1.setOPTA3(cursor.getString(3));
//                quest1.setOPTB3(cursor.getString(4));
//                quest1.setOPTC3(cursor.getString(5));
//                quest1.setOPTD3(cursor.getString(6));
//                quesList1.add(quest1);
//            } while (cursor.moveToNext());
//        }
//        // return quest list
//        return quesList1;
//    }



//    public boolean insertScoreCompFunda(int scoreCompFunda,String tname, String cname) {
//        SQLiteDatabase db = this.getWritableDatabase();
//
//        ContentValues contentValues = new ContentValues();
//        contentValues.put(SCORE_KEY_SECTION.toString(),tname);
//        contentValues.put(SCORE_KEY_CAT.toString(),cname);
//        contentValues.put(SCORE_KEY_SCORE.toString(), scoreCompFunda);
//        long resultscore = db.insert(TABLE_SCORE, null, contentValues);
//        if(resultscore == -1)
//            return false;
//        else
//            return true;
//    }

    public boolean insertScore(int scoreOS, String tname, String cname){
        SQLiteDatabase db = this.getWritableDatabase();
        Log.d("uyebav", "nahuy");

        ContentValues contentValues = new ContentValues();
        contentValues.put(SCORE_KEY_SECTION.toString(),tname);
        contentValues.put(SCORE_KEY_LVL.toString(),cname);
        contentValues.put(SCORE_KEY_SCORE.toString(), scoreOS);
        long resultscore = db.insert(TABLE_SCORE, null, contentValues);
        if(resultscore == -1){
            Log.d("posol", "nahuy");
            return false;}
        else{
            Log.d("posol", "ne posol");
            return true;
            }
    }

//    public boolean insertScoreHardware(int scoreHardware, String tname, String cname) {
//        SQLiteDatabase db = this.getWritableDatabase();
//
//        ContentValues contentValues = new ContentValues();
//        contentValues.put(SCORE_KEY_SECTION.toString(),tname);
//        contentValues.put(SCORE_KEY_CAT.toString(),cname);
//        contentValues.put(SCORE_KEY_SCORE.toString(), scoreHardware);
//        long resultscore = db.insert(TABLE_SCORE, null, contentValues);
//        if(resultscore == -1)
//            return false;
//        else
//            return true;
//    }
//
//    public boolean insertScoreFinal(int scoreRandom, String tname){
//        SQLiteDatabase db = this.getWritableDatabase();
//        String cname=null;
//        ContentValues contentValues = new ContentValues();
//        contentValues.put(SCORE_KEY_SECTION.toString(),tname);
//        contentValues.put(SCORE_KEY_CAT.toString(),cname);
//        contentValues.put(SCORE_KEY_SCORE.toString(), scoreRandom);
//        long resultscore = db.insert(TABLE_SCORE, null, contentValues);
//        if(resultscore == -1)
//            return false;
//        else
//            return true;
//    }

//    public int getScoreCompFundaB() {
//        Cursor c;
//        SQLiteDatabase db = this.getWritableDatabase();
//        String sqlSelectQuery="SELECT MAX(" + SCORE_KEY_SCORE + ") FROM " + TABLE_SCORE + " WHERE "+ SCORE_KEY_SECTION + " = '"+ TABLE_QUEST1 +"' AND "+ SCORE_KEY_CAT + " = " +"'B'";
//        c=db.rawQuery(sqlSelectQuery, null);
//        c.moveToFirst();
//        int x=c.getInt(0);
//        return x;
//    }
//
//    public int getScoreCompFundaI() {
//        Cursor c;
//        SQLiteDatabase db = this.getWritableDatabase();
//        String sqlSelectQuery="SELECT MAX(" + SCORE_KEY_SCORE + ") FROM " + TABLE_SCORE + " WHERE "+ SCORE_KEY_SECTION + " = '"+ TABLE_QUEST1 +"' AND "+ SCORE_KEY_CAT + " = " +"'I'";
//        c=db.rawQuery(sqlSelectQuery, null);
//        c.moveToFirst();
//        int x=c.getInt(0);
//        return x;
//    }
//
//    public int getScoreCompFundaE() {
//        Cursor c;
//        SQLiteDatabase db = this.getWritableDatabase();
//        String sqlSelectQuery="SELECT MAX(" + SCORE_KEY_SCORE + ") FROM " + TABLE_SCORE + " WHERE "+ SCORE_KEY_SECTION + " = '"+ TABLE_QUEST1 +"' AND "+ SCORE_KEY_CAT + " = " +"'E'";
//        c=db.rawQuery(sqlSelectQuery, null);
//        c.moveToFirst();
//        int x=c.getInt(0);
//        return x;
//    }

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

    public int getTotalScore(){
        Cursor c;
        SQLiteDatabase db = this.getWritableDatabase();
        String sqlSelectQuery="SELECT SUM(" + SCORE_KEY_SCORE + ") FROM "+ TABLE_SCORE +"";
        c=db.rawQuery(sqlSelectQuery, null);
        c.moveToFirst();
        int x=c.getInt(0);
        Log.d("posol", String.valueOf(x));
        return x;
    }


//    public int getScoreOSI() {
//        Cursor c;
//        SQLiteDatabase db = this.getWritableDatabase();
//        String sqlSelectQuery="SELECT MAX(" + SCORE_KEY_SCORE + ") FROM " + TABLE_SCORE + " WHERE "+ SCORE_KEY_SECTION + " = 'catGeography' AND "+ SCORE_KEY_LVL + " = " +"'I'";
//        c=db.rawQuery(sqlSelectQuery, null);
//        c.moveToFirst();
//        int x=c.getInt(0);
//        return x;
//    }
//
//    public int getScoreOSE() {
//        Cursor c;
//        SQLiteDatabase db = this.getWritableDatabase();
//        String sqlSelectQuery="SELECT MAX(" + SCORE_KEY_SCORE + ") FROM " + TABLE_SCORE + " WHERE "+ SCORE_KEY_SECTION + " = 'catReligion' AND "+ SCORE_KEY_LVL + " = " +"'E'";
//        c=db.rawQuery(sqlSelectQuery, null);
//        c.moveToFirst();
//        int x=c.getInt(0);
//        return x;
//    }

//    public int getScoreHardwareB() {
//        Cursor c;
//        SQLiteDatabase db = this.getWritableDatabase();
//        String sqlSelectQuery="SELECT MAX(" + SCORE_KEY_SCORE + ") FROM " + TABLE_SCORE + " WHERE "+ SCORE_KEY_SECTION + " = '"+ TABLE_QUEST2 +"' AND "+ SCORE_KEY_CAT + " = " +"'B'";
//        c=db.rawQuery(sqlSelectQuery, null);
//        c.moveToFirst();
//        int x=c.getInt(0);
//        return x;
//    }
//
//    public int getScoreHardwareI() {
//        Cursor c;
//        SQLiteDatabase db = this.getWritableDatabase();
//        String sqlSelectQuery="SELECT MAX(" + SCORE_KEY_SCORE + ") FROM " + TABLE_SCORE + " WHERE "+ SCORE_KEY_SECTION + " = '"+ TABLE_QUEST2 +"' AND "+ SCORE_KEY_CAT + " = " +"'I'";
//        c=db.rawQuery(sqlSelectQuery, null);
//        c.moveToFirst();
//        int x=c.getInt(0);
//        return x;
//    }
//
//    public int getScoreHardwareE() {
//        Cursor c;
//        SQLiteDatabase db = this.getWritableDatabase();
//        String sqlSelectQuery="SELECT MAX(" + SCORE_KEY_SCORE + ") FROM " + TABLE_SCORE + " WHERE "+ SCORE_KEY_SECTION + " = '"+ TABLE_QUEST2 +"' AND "+ SCORE_KEY_CAT + " = " +"'E'";
//        c=db.rawQuery(sqlSelectQuery, null);
//        c.moveToFirst();
//        int x=c.getInt(0);
//        return x;
//    }
//
//    public int getScoreRandom() {
//        Cursor c;
//        SQLiteDatabase db = this.getWritableDatabase();
//        String sqlSelectQuery="SELECT MAX(" + SCORE_KEY_SCORE + ") FROM " + TABLE_SCORE + " WHERE "+ SCORE_KEY_SECTION + " = '"+ TABLE_QUEST3+"'";
//        c=db.rawQuery(sqlSelectQuery, null);
//        c.moveToFirst();
//        int x=c.getInt(0);
//        return x;
//    }


}
