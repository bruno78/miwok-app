package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class FamilyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        ArrayList<Word> familyVocabulary = new ArrayList<>();

        familyVocabulary.add(new Word("father", "әpә"));
        familyVocabulary.add(new Word("mother", "әṭa"));
        familyVocabulary.add(new Word("son", "angsi"));
        familyVocabulary.add(new Word("daughter", "tune"));
        familyVocabulary.add(new Word("older brother", "taachi"));
        familyVocabulary.add(new Word("younger brother", "chalitti"));
        familyVocabulary.add(new Word("older sister", "teṭe"));
        familyVocabulary.add(new Word("younger sister", "kolliti"));
        familyVocabulary.add(new Word("grandmother", "ama"));
        familyVocabulary.add(new Word("grandfather", "paapa"));


        WordAdapter adapter = new WordAdapter(this, familyVocabulary);

        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);
    }
}
