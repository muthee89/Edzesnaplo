package com.example.muthgergely.edzesnaplo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Calendar;

import static com.example.muthgergely.edzesnaplo.R.id.datum;
import static com.example.muthgergely.edzesnaplo.R.id.loves_elfogadhato;
import static com.example.muthgergely.edzesnaplo.R.id.loves_jo;
import static com.example.muthgergely.edzesnaplo.R.id.loves_rossz;
import static com.example.muthgergely.edzesnaplo.R.id.mentalis_allapot_elotte;

public class EdzesFelvetele extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edzes_felvetele);

        // beállítom az edzésnapló felvételkor a mai dátumot, ne kelljen kézzel kitölteni (Helyesen :)
        Calendar c = Calendar.getInstance();
        int ev = c.get(Calendar.YEAR);
        int honap = c.get(Calendar.MONTH)+1;
        int nap = c.get(Calendar.DAY_OF_MONTH);

        EditText mai_datum = (EditText) findViewById(datum);

        mai_datum.setText(ev+"."+honap+"."+nap+".");
        ((EditText)findViewById(loves_jo)).setText("0");
        ((EditText)findViewById(loves_rossz)).setText("0");
        ((EditText)findViewById(loves_elfogadhato)).setText("0");
    }

    private ArrayList<EdzesOBJ> list = new ArrayList<EdzesOBJ>();

    // Mentési gomb meghívásakor az alábbi funkció hívódik
    public void Mentes(View view)
    {
        Log.v("Edzesfelvétel","Mentés elkezdődik");
        //ArrayList<EdzesOBJ> mentes = new ArrayList<EdzesOBJ>();
        //EdzesOBJ edzes = new EdzesOBJ(datum,edzes_tip,verseny_tip,vesszo_szam,pontszam, loves_jo, loves_elfogadhato, loves_rossz, mentalis_feladat, mentalis_eredmeny, mentalis_allapot_elotte, mentalis_allapot_utana,fizikalis_allapot_elotte,fizikalis_allapot_utana,cel,elertem,jegyzetek,eszrevetel,feladat,edzoi_komment);


        // a kitöltött adatok átvétele egy edzés objektumba
        EdzesOBJ edzes = new EdzesOBJ();
        try {
            edzes.setdatum(((EditText)findViewById(R.id.datum)).getText().toString());
            edzes.setedzes_tip(((EditText)findViewById(R.id.edzes_tip)).getText().toString());
            edzes.setverseny_tip(((EditText)findViewById(R.id.verseny_tip)).getText().toString());
            edzes.setvesszo_szam(((EditText)findViewById(R.id.vesszo_szam)).getText().toString());
            edzes.setpontszam(((EditText)findViewById(R.id.pontszam)).getText().toString());
            edzes.setloves_jo(Double.parseDouble(((EditText)findViewById(loves_jo)).getText().toString()));
            edzes.setloves_elfogadhato(Double.parseDouble(((EditText)findViewById(loves_elfogadhato)).getText().toString()));
            edzes.setloves_rossz(Double.parseDouble(((EditText)findViewById(loves_rossz)).getText().toString()));
            edzes.setmentalis_feladat(((EditText)findViewById(R.id.mentalis_feladat)).getText().toString());
            edzes.setmentalis_eredmeny(((EditText)findViewById(R.id.mentalis_eredmeny)).getText().toString());
            edzes.setmentalis_allapot_elotte(((EditText)findViewById(mentalis_allapot_elotte)).getText().toString());
            edzes.setmentalis_allapot_utana(((EditText)findViewById(R.id.mentalis_allapot_utana)).getText().toString());
            edzes.setfizikalis_allapot_elotte(((EditText)findViewById(R.id.fizikalis_allapot_elotte)).getText().toString());
            edzes.setfizikalis_allapot_utana(((EditText)findViewById(R.id.fizikalis_allapot_utana)).getText().toString());
            edzes.setcel(((EditText)findViewById(R.id.cel)).getText().toString());
            edzes.setelertem(((EditText)findViewById(R.id.elertem)).getText().toString());
            edzes.setjegyzetek(((EditText)findViewById(R.id.jegyzetek)).getText().toString());
            edzes.seteszrevetel(((EditText)findViewById(R.id.eszrevetel)).getText().toString());
            edzes.setfeladat(((EditText)findViewById(R.id.feladat)).getText().toString());
            edzes.setedzoi_komment(((EditText)findViewById(R.id.edzoi_komment)).getText().toString());
        }
        catch (NumberFormatException e)
        {
            Log.v("Edzesfelvétel","Edzésfelvétel GetCause üzenet: "+e.getCause());
            Log.v("Edzesfelvétel","Edzésfelvétel GetMesssage üzenet: "+e.getMessage());
        }

        // fájlba írás

        // havi edzésnapló fájl előkészítése, feltöltése
        Calendar c = Calendar.getInstance();
        int ev = c.get(Calendar.YEAR);
        int honap = c.get(Calendar.MONTH)+1;

        String FILENAME = "edzésnapló_"+ev+"_"+honap;
        //tesztelő adat létrehozása - edzes2, hogy ne kelljen mindig kitölteni a naplót
        EdzesOBJ edzes2 = new EdzesOBJ("2017.01.05.", "lövés", "verseny típusa", "15", "150", 15, 25, 36,"mentálisan feladat","mentalis_eredmeny", "mentalis_allapot_elotte", "mentalis_allapot_utana","fizikalis_allapot_elotte", "fizikalis_allapot_utana", "cel", "elertem", "jegyzetek", "eszrevetel", "feladat", "edzoi_komment");
        /* A listázáshoz, adatok mentéséhez majd szükséges lista
        private ArrayList<Game> list = new ArrayList<Game>();
         */
        try {
            /* fájl írás próbálkozás
            Context context;
            File internalStorageDir = getFilesDir();
            File fajlnev = new File(internalStorageDir, FILENAME+".csv");
            FileOutputStream fos = context.openFileOutput(fajlnev, Context.MODE_PRIVATE);
            ObjectOutputStream os = new ObjectOutputStream(fos);
            os.writeObject(edzes);
            os.close();
            fos.close();*/

            File internalStorageDir = getFilesDir();
            File fajlnev = new File(internalStorageDir, FILENAME+".csv");
            //fos = new FileOutputStream(internalStorageDir);
            FileOutputStream fos = new FileOutputStream(fajlnev);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(edzes2);
            Log.v("Edzesfelvétel",edzes.getdatum());
            oos.flush();
            oos.close();

            fos.flush();
            fos.close();
        }
        catch (IOException e)
        {
            Log.v("Edzesfelvétel","GetCause fájl írása közben: "+e.getCause());
            Log.v("Edzesfelvétel","GetMesssage fájl írása közben: "+e.getMessage());
            e.printStackTrace();
        }/*
        catch (NotSerializableException ns)
        {
            Log.v("Edzesfelvétel","GetCause fájl írása: "+ns.getCause());
            Log.v("Edzesfelvétel","GetMesssage fájl írása: "+ns.getMessage());
            ns.printStackTrace();
        }*/

       /*FileOutputStream fos = openFileOutput(FILENAME, Context.MODE_APPEND);
        ObjectOutputStream os = new ObjectOutputStream(fos);
        os.writeObject(edzes);
        os.close();
        fos.close();

       /* Bundle extras = getIntent().getExtras();
        if (extras != null) {
        }
        MainActivity.adatok.add(edzes);
        mentes.clear();*/

    }

    /*public class Edzesobj{
        private String datum, edzes_tip, verseny_tip;
        private int vesszo_szam, pontszam;
        private double loves_jo, loves_elfogadhato, loves_rossz;
        private String mentalis_feladat, mentalis_eredmeny, mentalis_allapot_elotte, mentalis_allapot_utana;
        private String fizikalis_allapot_elotte, fizikalis_allapot_utana, cel, elertem;
        private String jegyzetek, eszrevetel, feladat, edzoi_komment;

        public String getdatum() {
            return datum;
        }
        public void setdatum(String datum) {
            this.datum = datum;
        }

        public String getedzes_tip() {
            return edzes_tip;
        }
        public void setedzes_tip(String edzes_tip) {
            this.edzes_tip = edzes_tip;
        }

        public String getverseny_tip() {
            return verseny_tip;
        }
        public void setverseny_tip(String verseny_tip) {
            this.verseny_tip = verseny_tip;
        }

        public int getvesszo_szam() {
            return vesszo_szam;
        }
        public void setvesszo_szam(int vesszo_szam) {
            this.vesszo_szam = vesszo_szam;
        }

        public int getpontszam() {
            return pontszam;
        }
        public void setpontszam(int pontszam) {
            this.pontszam = pontszam;
        }

        public double getloves_jo() {
            return loves_jo;
        }
        public void setloves_jo(double loves_jo) {
            this.loves_jo = loves_jo;
        }

        public double getloves_elfogadhato() {
            return loves_elfogadhato;
        }
        public void setloves_elfogadhato(double loves_elfogadhato) {
            this.loves_elfogadhato = loves_elfogadhato;
        }

        public double getloves_rossz() {
            return loves_rossz;
        }
        public void setloves_rossz(double loves_rossz) {
            this.loves_rossz = loves_rossz;
        }

        public String getmentalis_feladat() {
            return mentalis_feladat;
        }
        public void setmentalis_feladat(String mentalis_feladat) {
            this.mentalis_feladat = mentalis_feladat;
        }

        public String getmentalis_eredmeny() {
            return mentalis_eredmeny;
        }
        public void setmentalis_eredmeny(String mentalis_eredmeny) {
            this.mentalis_eredmeny = mentalis_eredmeny;
        }

        public String getmentalis_allapot_elotte() {
            return mentalis_allapot_elotte;
        }
        public void setmentalis_allapot_elotte(String mentalis_allapot_elotte) {
            this.mentalis_allapot_elotte = mentalis_allapot_elotte;
        }

        public String getmentalis_allapot_utana() {
            return mentalis_allapot_utana;
        }
        public void setmentalis_allapot_utana(String mentalis_allapot_utana) {
            this.mentalis_allapot_utana = mentalis_allapot_utana;
        }

        public String getfizikalis_allapot_elotte() {
            return fizikalis_allapot_elotte;
        }
        public void setfizikalis_allapot_elotte(String fizikalis_allapot_elotte) {
            this.fizikalis_allapot_elotte = fizikalis_allapot_elotte;
        }

        public String getfizikalis_allapot_utana() {
            return fizikalis_allapot_utana;
        }
        public void setfizikalis_allapot_utana(String fizikalis_allapot_utana) {
            this.fizikalis_allapot_utana = fizikalis_allapot_utana;
        }

        public String getcel() {
            return cel;
        }
        public void setcel(String cel) {
            this.cel = cel;
        }

        public String getelertem() {
            return elertem;
        }
        public void setelertem(String elertem) {
            this.elertem = elertem;
        }

        public String getjegyzetek() {
            return jegyzetek;
        }
        public void setjegyzetek(String jegyzetek) {
            this.jegyzetek = jegyzetek;
        }

        public String geteszrevetel() {
            return eszrevetel;
        }
        public void seteszrevetel(String eszrevetel) {
            this.eszrevetel = eszrevetel;
        }

        public String getfeladat() {
            return feladat;
        }
        public void setfeladat(String feladat) {
            this.feladat = feladat;
        }

        public String getedzoi_komment() {
            return edzoi_komment;
        }
        public void setedzoi_komment(String edzoi_komment) {
            this.edzoi_komment = edzoi_komment;
        }
    }
*/




}
