package com.example.pro.doyk.DbHelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.pro.doyk.Model.QuestionOS;

import org.json.JSONArray;
import org.json.JSONObject;

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
//        QuestionOS q1 = new QuestionOS("quest from Geo,B,1","ok","Normal","Differential","Incremental","ok","catGeography","B");
//        this.addQuestionOS(q1);
//        QuestionOS q2 = new QuestionOS("quest from Geo,B,2","ok","Normal","Differential","Incremental","ok","catGeography","B");
//        this.addQuestionOS(q2);
//        QuestionOS q3 = new QuestionOS("quest from Geo,B,3","ok","Normal","Differential","Incremental","ok","catGeography","B");
//        this.addQuestionOS(q3);
//        QuestionOS q4 = new QuestionOS("quest from Geo,B,4","ok","Normal","Differential","Incremental","ok","catGeography","B");
//        this.addQuestionOS(q4);
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
//        QuestionOS q10 = new QuestionOS("quest from Rel,B","ok","Normal","Differential","Incremental","ok","catReligion","B");
//        this.addQuestionOS(q10);
//        QuestionOS q11 = new QuestionOS("quest from Rel,B","ok","Normal","Differential","Incremental","ok","catReligion","B");
//        this.addQuestionOS(q11);
//        QuestionOS q12 = new QuestionOS("quest from Rel,B","ok","Normal","Differential","Incremental","ok","catReligion","B");
//        this.addQuestionOS(q12);
//        QuestionOS q13 = new QuestionOS("quest from Rel,B","ok","Normal","Differential","Incremental","ok","catReligion","B");
//        this.addQuestionOS(q13);
//        QuestionOS q14 = new QuestionOS("quest from Rel,B","ok","Normal","Differential","Incremental","ok","catReligion","B");
//        this.addQuestionOS(q14);
//        QuestionOS q15 = new QuestionOS("quest from Geo,B,5","ok","Normal","Differential","Incremental","ok","catGeography","B");
//        this.addQuestionOS(q15);
//        QuestionOS q16 = new QuestionOS("quest from Art,B,1","ok","Normal","Differential","Incremental","ok","catArt","B");
//        this.addQuestionOS(q16);
        QuestionOS q17 = new QuestionOS("Хто з перелічених князів охрестив Русь? ","Ярослав","Святослав","Володимир","Ігор","Володимир","catReligion","B");
        this.addQuestionOS(q17);
        QuestionOS q18 = new QuestionOS("Який духовний титул в православній церкві є найвищим? ","Митрополит","Єпископ","Архієписок","Патріарх","Патріарх","catReligion","B");
        this.addQuestionOS(q18);
        QuestionOS q19 = new QuestionOS("Хто із апостолів був братом Петра? ","Філіп","Андрій","Матвій","Симон Зилот","Андрій","catReligion","B");
        this.addQuestionOS(q19);
        QuestionOS q20 = new QuestionOS("Віра в предмети, що володіють різними надприродними силами? ","Тотемізм","Анемізм","Фетишизм","Шаманізм","Фетишизм","catReligion","B");
        this.addQuestionOS(q20);
        QuestionOS q21 = new QuestionOS("Як називаються люди, які намагаються звернути інших у свою релігію?","Набоби","Єретики","Місіонери","Релігісти","Місіонери","catReligion","B");
        this.addQuestionOS(q21);
        QuestionOS q22 = new QuestionOS("На якій горі жили, за переказами, грецькі боги? ","Парнас","Везувій","Олімп","Арарат","Олімп","catReligion","B");
        this.addQuestionOS(q22);
        QuestionOS q23 = new QuestionOS("Які з ангельських чинів є найвищими? ","Архангели","Престоли","Серафими","Херувими","Серафими","catReligion","B");
        this.addQuestionOS(q23);
        QuestionOS q24 = new QuestionOS("Яка богиня була матір’ю Ахілла? ","Афіна","Деметра","Артеміда","Фетіда","Фетіда","catReligion","B");
        this.addQuestionOS(q24);
        QuestionOS q25 = new QuestionOS("Яка тварина в Єгипті вважається священною? ","Верблюд","Крокодил","Кішка","Корова","Кішка","catReligion","B");
        this.addQuestionOS(q25);
        QuestionOS q26 = new QuestionOS("Як у грецькій міфології називали крилатих жінок, що викрадають дітей і людські душі? ","Силени","Гарпії","Грифони","Василіски","Гарпії","catReligion","B");
        this.addQuestionOS(q26);
        QuestionOS q27 = new QuestionOS("Найбільшою западиною Світового океану є? ","Філіпінський жолоб","Тонга","Маріанська","Кермадек","Маріанська","catGeography","B");
        this.addQuestionOS(q27);
        QuestionOS q28 = new QuestionOS("Назвіть материк, який перетинають всі меридіани Землі? ","Африка","Євразія","Австралія","Антарктида","Антарктида","catGeography","B");
        this.addQuestionOS(q28);
        QuestionOS q29 = new QuestionOS("Найбільш повноводна ріка на Землі? ","Амазонка","Ніл","Конго","Оріноко","Амазонка","catGeography","B");
        this.addQuestionOS(q29);
        QuestionOS q30 = new QuestionOS("Чисельність якого з народів найбільша у світі? ","Китайці","Американці","Індійці","Араби","Китайці","catGeography","B");
        this.addQuestionOS(q30);
        QuestionOS q31 = new QuestionOS("Як називається море без берегів? ","Середземне","Саргасове","Адріатичне","Охотське","Саргасове","catGeography","B");
        this.addQuestionOS(q31);
        QuestionOS q32 = new QuestionOS("Яким приладом вимірюють вологість повітря? ","Дозиметр","Гігрометр","Анемометр","Амперметр","Гігрометр","catGeography","B");
        this.addQuestionOS(q32);
        QuestionOS q33 = new QuestionOS("Яка держава Африки розташована на двох материках? ","Судан","Нігерія","Лівія","Єгипет","Єгипет","catGeography","B");
        this.addQuestionOS(q33);
        QuestionOS q34 = new QuestionOS("Найбільша в світі острівна держава? ","Індонезія","Шрі-Ланка","Японія","Куба","Індонезія","catGeography","B");
        this.addQuestionOS(q34);
        QuestionOS q35 = new QuestionOS("Де зустрічаються альпійські луки? ","В Карпатах","На кавказі","В усіх горах світу","В Альпах","В усіх горах світу","catGeography","B");
        this.addQuestionOS(q35);
        QuestionOS q36 = new QuestionOS("З якою країною Україна має найбільш протяжний сухопутний кордон? ","З Білоруссю","З Росією","З Польщею","З Румунією"," З Росією","catGeography","B");
        this.addQuestionOS(q36);
        QuestionOS q37 = new QuestionOS("Які вітри мають сезонний характер? ","Мусони","Бризи","Місцеві вітри","Фен","Мусони","catGeography","B");
        this.addQuestionOS(q37);
        QuestionOS q38 = new QuestionOS("Зображення якої тварини можна побачити на гербі Австралії? ","Кенгуру","Дінго","Ему","Коала","Коала","catGeography","B");
        this.addQuestionOS(q38);
        QuestionOS q39 = new QuestionOS("Найдовші гори в світі? ","Альпи","Уральські","Анди","Трансарктичні","Анди","catGeography","B");
        this.addQuestionOS(q39);
        QuestionOS q40 = new QuestionOS("Де знаходиться Мачу-Пікчу? ","Мексика","Бразилія","Перу","Чілі","Перу","catGeography","B");
        this.addQuestionOS(q40);
        QuestionOS q41 = new QuestionOS("Найбільша країна Європи за площею? ","Росія","Франція","Іспанія","Україна","Росія","catGeography","B");
        this.addQuestionOS(q41);
        QuestionOS q42 = new QuestionOS("Найдовша ріка в світі? ","Дніпро","Амазонка","Ніл","Міссісіпі","Амазонка","catGeography","B");
        this.addQuestionOS(q42);
        QuestionOS q43 = new QuestionOS("Скільки всього країн в світі? ","191","212","251","239","251","catGeography","B");
        this.addQuestionOS(q43);
        QuestionOS q44 = new QuestionOS("Яке з перерахованих міст є найбільш великим за чисельністю населення? ","Мадрид","Москва","Київ","Ріо-де-Жанейро","Ріо-де-Жанейро","catGeography","B");
        this.addQuestionOS(q44);
        QuestionOS q45 = new QuestionOS("Яка з перерахованих гірських систем найвища у Євразії? ","Альпи","Кавказ","Тибет","Алтай","Альпи","catGeography","B");
        this.addQuestionOS(q45);
        QuestionOS q46 = new QuestionOS("Який спортивний термін означає нарушення правил в ході гри? ","Фал","Фол","Фан","Фел","Фол","catSport","B");
        this.addQuestionOS(q46);
        QuestionOS q47 = new QuestionOS("В якій із цих ігр використовується мяч найбільшої величини? ","Футбол","Баскетбол","Волейбол","Водне поло","Баскетбол","catSport","B");
        this.addQuestionOS(q47);
        QuestionOS q48 = new QuestionOS("В якій із цих ігр на майданчику одночасно знаходиться найменша кількість гравців? ","Гандбол","Волейбол","Хокей","Баскетбол","Баскетбол","catSport","B");
        this.addQuestionOS(q48);
        QuestionOS q49 = new QuestionOS("Який із цих видів спорту Олімпійський? ","Армрестлінг","Боулінг","Керлінг","Регбі","Керлінг","catSport","B");
        this.addQuestionOS(q49);
        QuestionOS q50 = new QuestionOS("В якому із бігових видів його учасники долають найбільшу за протяжністю дистанцію?","Крос","Естафета","Марафон","Спринт","Марафон","catSport","B");
        this.addQuestionOS(q50);
        QuestionOS q51 = new QuestionOS("Куди потрапляє більярдна куля при попаданні?","У лунку","У лузу","В кільце","В кошик","У лузу","catSport","B");
        this.addQuestionOS(q51);
        QuestionOS q52 = new QuestionOS("Яка країна вважається батьківщиною сучасного хокею? ","Росія","США","Канада","Норвегія","Канада","catSport","B");
        this.addQuestionOS(q52);
        QuestionOS q53 = new QuestionOS("Коли відбулися перші Олімпійські ігри? ","у 776 до н.е.","у 12 н.е.","у 1720 році","у 897 до н.е.","у 776 до н.е.","catSport","B");
        this.addQuestionOS(q53);
        QuestionOS q54 = new QuestionOS("Хто з цих гравців є найкращим бомбардиром Ліги чемпіонів? "," Кріштіану Роналду","Ліонель Мессі","Златан Ібрагімович","Неймар","Кріштіану Роналду","catSport","B");
        this.addQuestionOS(q54);
        QuestionOS q55 = new QuestionOS("В якій країні пройшов перший Чемпіонат світу по футболу? ","Уругвай","Франція","Німеччина","Аргентина","Уругвай","catSport","B");
        this.addQuestionOS(q55);
        QuestionOS q56 = new QuestionOS("Назва «Сікстинська капела» походить від?","Папа Сікст IV","Свята Сікстина","Сікстинус, один із пагорбів Риму","Сіксти, шостого канонічного часу","Папа Сікст IV","cat catArt","B");
        this.addQuestionOS(q56);
        QuestionOS q57 = new QuestionOS("В якому місті знаходиться Ермітаж? ","Москва","Санкт-Петербург","Нижній Новгород","Мурманськ","Санкт-Петербург","catArt","B");
        this.addQuestionOS(q57);
        QuestionOS q58 = new QuestionOS("Найвідоміша картина світу?","Тайна Вечеря","Сіскстинська Мадонна","Мона Ліза","Крик","Мона Ліза","catArt","B");
        this.addQuestionOS(q58);
        QuestionOS q59 = new QuestionOS("Як називається робота художника, в якій він зобразив сам себе?","Автопортрет","Автобіографія","Авторитет","Регбі","Автопортрет","catArt","B");
        this.addQuestionOS(q59);
        QuestionOS q60 = new QuestionOS("Як називається дошка, на якій художник змішує фарби?","Піднос","Палітра","Планшет","Аркуш","Палітра","catArt","B");
        this.addQuestionOS(q60);
        QuestionOS q61 = new QuestionOS("Що може бути зображено на натюрморті? ","Вершник на коні","Море під час грози","Фрукти, ваза з квітами","Людина","Фрукти, ваза з квітами","catArt","B");
        this.addQuestionOS(q61);
        QuestionOS q62 = new QuestionOS("Хто написав знамениту картинку «Три богатирі»? ","Віктор Васнецов","Ілля Репін","Василь Сурков","Іван Шишкін","Віктор Васнецов","catArt","B");
        this.addQuestionOS(q62);
        QuestionOS q63 = new QuestionOS("Родоначальниками якого мистецства стали брати Люм’єр?","Фотографія","Кінематограф","Графічний дизайн","Малювання.","Кінематограф","catArt","B");
        this.addQuestionOS(q63);
        QuestionOS q64 = new QuestionOS("Де знаходиться знаменита статуя грішного ангела? "," В Парижі","В Мадриді","В Римі","В Лондоні","В Мадриді","catArt","B");
        this.addQuestionOS(q64);
        QuestionOS q65 = new QuestionOS("Як називається фотознімок, який вважають першим знімком в світі зі збережених?","Вид із вікна","Поїзд","Велика гора","Висота","Вид із вікна","catArt","B");
        this.addQuestionOS(q65);
        QuestionOS q66 = new QuestionOS("В якому році був створений перший ноутбук? ","1984","1974","1981","1971","1981","catHistory","B");
        this.addQuestionOS(q66);
        QuestionOS q67 = new QuestionOS("Як називається найстаріша династія в історії людства? ","Династія Чжоу","Династія Сун","Династія Ямато","Соломонівська династія","Династія Ямато","catHistory","B");
        this.addQuestionOS(q67);
        QuestionOS q68 = new QuestionOS("Яку територію займала цивілізація Майя? ","Азія","Північна Америка","Мезоамерика","Африка","Мезоамерика","catHistory","B");
        this.addQuestionOS(q68);
        QuestionOS q69 = new QuestionOS("В якому році вперше були застосовані танки? ","1918","1916","1939","1943","1916","catHistory","B");
        this.addQuestionOS(q69);
        QuestionOS q70 = new QuestionOS("За наказом якої імперії був побудований Тадж-Махал?","Імперія Мар’єв","Імперії Сасанідов","Монгольської","Могольської","Могольської","catHistory","B");
        this.addQuestionOS(q70);
        QuestionOS q71 = new QuestionOS("Кому Німеччина вперше об’явила війну в Першій Світовій війні? ","Бельгії","Росії","Сербії","Польщі","Сербії","catHistory","B");
        this.addQuestionOS(q71);
        QuestionOS q72 = new QuestionOS("В якому році Бразилія отримала незалежність від Португалії? ","1834","1822","1826","1824","1822","catHistory","B");
        this.addQuestionOS(q72);
        QuestionOS q73 = new QuestionOS("Хто вважається «батьком сучасної організованої злочинності» в США? ","Лікі Лучано","Карло Гамбіно","Франко Костелло","Аль Капоне","Лакі Лучано","catHistory","B");
        this.addQuestionOS(q73);
        QuestionOS q74 = new QuestionOS("У якому році Українська СРР стала складовою СРСР? ","1919","1920","1921","1922","1922","catHistory","B");
        this.addQuestionOS(q74);
        QuestionOS q75 = new QuestionOS("Яка революція призвела до повалення комуністичного режиму в Чехословакії в 1991? ","Бархатна революція","Жовтнева революція","Пражська весна","Культурна революція","Бархатна революція","catHistory","B");
        this.addQuestionOS(q75);
        QuestionOS q76 = new QuestionOS("Клітиною сполучної тканини є? ","Нейрон","Гаметоцит","Хондроцит","Міоцит","Хондроцит","catBiology","B");
        this.addQuestionOS(q76);
        QuestionOS q77 = new QuestionOS("Які бактерії є збудниками хвороб людини? ","Нітрифікуючі","Молочнокислі палички","Золотисті стафілококи","Денітрифікуючі","Золотисті стафілококи","catBiology","B");
        this.addQuestionOS(q77);
        QuestionOS q78 = new QuestionOS("Клітинне дихання відбувається у? ","Вакуолях","Хлоропластах","Мітохондріях","Комплекс Гольджі","Мітохондріях","catBiology","B");
        this.addQuestionOS(q78);
        QuestionOS q79 = new QuestionOS("Рослинна клітина відрізняється від бактеріальної наявністю? ","Рибосом","Клітинної стінки","Ядра","Цитоплазми","Ядра","catBiology","B");
        this.addQuestionOS(q79);
        QuestionOS q80 = new QuestionOS("Яка кістка входить до складу поясу верхніх кінцівок людини?","Променева","Плечова","Ліктьова","Лопатка","Лопатка","catBiology","B");
        this.addQuestionOS(q80);
        QuestionOS q81 = new QuestionOS("Пристосуванням птахів до польоту є? ","Задні кінцівки з пальцями","Грудна клітка","Пір’яний покрив","Легені","Пір’яний покрив","catBiology","B");
        this.addQuestionOS(q81);
        QuestionOS q82 = new QuestionOS("Пристосуванням земноводних до життя на суходолі є? ","Нирки","Повіки","Перетинки між пальцями","Бічна лінія","Повіки","catBiology","B");
        this.addQuestionOS(q82);
        QuestionOS q83 = new QuestionOS("Яка тканина розташована в зоні поділу кореня? ","Механічна","Покривна","Твірна","Провідна","Твірна","catBiology","B");
        this.addQuestionOS(q83);
        QuestionOS q84 = new QuestionOS("Рослинна клітина, на відміну від тваринної, має? ","Вакуолю з клітинним соком","Комплекс Гольджі","Ендоплазматичну сітку","Мітохондрії","Вакуолю з клітнним соком","catBiology","B");
        this.addQuestionOS(q84);
        QuestionOS q85 = new QuestionOS("Яка наука досліджує вимерлі організми? ","Палеонтологія","Морфологія","Еволюційне вчення","Археологія","Палеонтологія","catBiology","B");
        this.addQuestionOS(q85);
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

    public void deleteScore(){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DELETE FROM " + TABLE_SCORE);
    }

    public JSONArray getResults()
    {
        dbase=this.getReadableDatabase();
        String searchQuery = "SELECT  * FROM " + TABLE_QUEST;
        Cursor cursor = dbase.rawQuery(searchQuery, null );

        JSONArray resultSet = new JSONArray();

        cursor.moveToFirst();
        while (cursor.isAfterLast() == false) {

            int totalColumn = cursor.getColumnCount();
            JSONObject rowObject = new JSONObject();

            for( int i=0 ;  i< totalColumn ; i++ )
            {
                if( cursor.getColumnName(i) != null )
                {
                    try
                    {
                        if( cursor.getString(i) != null )
                        {
                            Log.d("TAG_NAME", cursor.getString(i) );
                            rowObject.put(cursor.getColumnName(i) ,  cursor.getString(i) );
                        }
                        else
                        {
                            rowObject.put( cursor.getColumnName(i) ,  "" );
                        }
                    }
                    catch( Exception e )
                    {
                        Log.d("TAG_NAME", e.getMessage()  );
                    }
                }
            }
            resultSet.put(rowObject);
            cursor.moveToNext();
        }
        cursor.close();
        Log.d("TAG_NAME", resultSet.toString() );
        return resultSet;
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
