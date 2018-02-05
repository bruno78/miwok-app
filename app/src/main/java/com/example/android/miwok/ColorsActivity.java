package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ColorsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);


        ArrayList<Word>  colorVocabulary = new ArrayList<>();
        colorVocabulary.add(new Word("red", "weṭeṭṭi"));
        colorVocabulary.add(new Word("green","chokokki"));
        colorVocabulary.add(new Word("brown", "ṭakaakki"));
        colorVocabulary.add(new Word("gray", "ṭopoppi"));
        colorVocabulary.add(new Word("black", "kululli"));
        colorVocabulary.add(new Word("white", "kelelli"));
        colorVocabulary.add(new Word("dusty yellow", "ṭopiisә"));
        colorVocabulary.add(new Word("mustard yellow", "chiwiiṭә"));

        WordAdapter adapter = new WordAdapter(this, colorVocabulary);

        ListView colorListView = (ListView) findViewById(R.id.list);
        colorListView.setAdapter(adapter);


    }
}
