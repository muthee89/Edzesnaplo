package com.example.muthgergely.edzesnaplo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    // megnyitja az edzés felvétele lapot és azt a képernyőre "helyezi"
    public void openEdzesFelvetel(View view) {
        Intent i = new Intent(this, EdzesFelvetele.class);
       // i.putExtra("adatom",adatok);
        startActivity(i);
    }

    // Ha listázni akarom a már meglévő fájlokat, sorolja fel - KÉSŐBBI useful template
    /*
    <ListView xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:id="@+id/list"
    android:orientation="vertical"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:paddingBottom="@dimen/activity_vertical_margin"
    android:paddingLeft="@dimen/activity_horizontal_margin"
    android:paddingRight="@dimen/activity_horizontal_margin"
    android:paddingTop="@dimen/activity_vertical_margin"
tools:context="com.example.android.miwok.NumbersActivity"/>
     */
    /* import android.widget.ListView;
    import android.widget.ArrayAdapter;
    ArrayList<EdzesOBJ> elemek = new ArrayList<EdzesOBJ>();
    ArrayAdapter<EdzesOBJ> elemek= new ArrayAdapter<EdzesOBJ>(this, android.R.layout.simple_list_item_1,words);
    ListView listView = (ListView) findViewById(R.id.list);
    listView.setAdapter(itemsAdapter);
     */
}
