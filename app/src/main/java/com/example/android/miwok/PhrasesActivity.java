package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class PhrasesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        ArrayList<Word> phrasesVocabulary = new ArrayList();

        phrasesVocabulary.add(new Word("Where are you going?", "minto wuksus"));
        phrasesVocabulary.add(new Word("What is your name?", "tinnә oyaase'nә"));
        phrasesVocabulary.add(new Word("My name is...", "oyaaset..."));
        phrasesVocabulary.add(new Word("How are you feeling?", "michәksәs?"));
        phrasesVocabulary.add(new Word("I’m feeling good.", "kuchi achit"));
        phrasesVocabulary.add(new Word("Are you coming?", "әәnәs'aa?"));
        phrasesVocabulary.add(new Word("Yes, I’m coming.", "hәә’ әәnәm"));
        phrasesVocabulary.add(new Word("I’m coming.", "әәnәm"));
        phrasesVocabulary.add(new Word("Let’s go.", "yoowutis"));
        phrasesVocabulary.add(new Word("Come here.", "әnni'nem"));

        WordAdapter adapter = new WordAdapter(this, phrasesVocabulary);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(adapter);

    }
}
