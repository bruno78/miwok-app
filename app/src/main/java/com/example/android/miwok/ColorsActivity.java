package com.example.android.miwok;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ColorsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);


        ArrayList<Word>  colorVocabulary = new ArrayList<>();
        colorVocabulary.add(new Word("red", "weṭeṭṭi", R.drawable.color_red,
                                                                              R.raw.color_red));
        colorVocabulary.add(new Word("green","chokokki", R.drawable.color_green,
                                                                                R.raw.color_green));
        colorVocabulary.add(new Word("brown", "ṭakaakki", R.drawable.color_brown,
                                                                                 R.raw.color_brown));
        colorVocabulary.add(new Word("gray", "ṭopoppi", R.drawable.color_gray,
                                                                               R.raw.color_gray));
        colorVocabulary.add(new Word("black", "kululli", R.drawable.color_black,
                                                                                R.raw.color_black));
        colorVocabulary.add(new Word("white", "kelelli", R.drawable.color_white,
                                                                                R.raw.color_white));
        colorVocabulary.add(new Word("dusty yellow", "ṭopiisә", R.drawable.color_dusty_yellow,
                                                                                       R.raw.color_dusty_yellow));
        colorVocabulary.add(new Word("mustard yellow", "chiwiiṭә", R.drawable.color_mustard_yellow,
                                                                                          R.raw.color_mustard_yellow));

        WordAdapter adapter = new WordAdapter(this, colorVocabulary, R.color.category_colors);

        ListView colorListView = (ListView) findViewById(R.id.list);
        colorListView.setAdapter(adapter);

        colorListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Word word = (Word) parent.getItemAtPosition(position);
                MediaPlayer mediaPlayer = MediaPlayer.create(ColorsActivity.this, word.getAudioResourceId());
                mediaPlayer.start();

            }
        });


    }
}
