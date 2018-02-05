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

        familyVocabulary.add(new Word("father", "әpә", R.drawable.family_father));
        familyVocabulary.add(new Word("mother", "әṭa", R.drawable.family_mother));
        familyVocabulary.add(new Word("son", "angsi", R.drawable.family_son));
        familyVocabulary.add(new Word("daughter", "tune", R.drawable.family_daughter));
        familyVocabulary.add(new Word("older brother", "taachi", R.drawable.family_older_brother));
        familyVocabulary.add(new Word("younger brother", "chalitti", R.drawable.family_younger_brother));
        familyVocabulary.add(new Word("older sister", "teṭe", R.drawable.family_older_sister));
        familyVocabulary.add(new Word("younger sister", "kolliti", R.drawable.family_younger_sister));
        familyVocabulary.add(new Word("grandmother", "ama", R.drawable.family_grandmother));
        familyVocabulary.add(new Word("grandfather", "paapa", R.drawable.family_grandfather));


        WordAdapter adapter = new WordAdapter(this, familyVocabulary);

        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);
    }
}
