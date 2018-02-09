package com.example.android.miwok;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class PhrasesActivity extends AppCompatActivity {

    private static final int NO_IMAGE = -1;
    private MediaPlayer mMediaPlayer;
    private AudioManager mAudioManager;

    /**
     * This event listener gets triggered when audio file finishes playing.
     */
    private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mp) {
            releaseMediaPlayer();
        }
    };

    /**
     * This event listener gets triggered when the audio changes
     */
    AudioManager.OnAudioFocusChangeListener mAudioFocusChangeListener = new AudioManager.OnAudioFocusChangeListener() {
        @Override
        public void onAudioFocusChange(int focusChange) {
            if (focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT ||
                    focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK) {
                mMediaPlayer.pause();
                mMediaPlayer.seekTo(0);
            }
            else if (focusChange == AudioManager.AUDIOFOCUS_LOSS) {
                releaseMediaPlayer();
            }
            else if (focusChange == AudioManager.AUDIOFOCUS_GAIN) {
                mMediaPlayer.start();
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        final ArrayList<Word> phrasesVocabulary = new ArrayList();

        phrasesVocabulary.add(new Word("Where are you going?", "minto wuksus", NO_IMAGE,
                R.raw.phrase_where_are_you_going));
        phrasesVocabulary.add(new Word("What is your name?", "tinnә oyaase'nә", NO_IMAGE,
                R.raw.phrase_what_is_your_name));
        phrasesVocabulary.add(new Word("My name is...", "oyaaset...", NO_IMAGE,
                R.raw.phrase_my_name_is));
        phrasesVocabulary.add(new Word("How are you feeling?", "michәksәs?", NO_IMAGE,
                R.raw.phrase_how_are_you_feeling));
        phrasesVocabulary.add(new Word("I’m feeling good.", "kuchi achit", NO_IMAGE,
                R.raw.phrase_im_feeling_good));
        phrasesVocabulary.add(new Word("Are you coming?", "әәnәs'aa?", NO_IMAGE,
                R.raw.phrase_are_you_coming));
        phrasesVocabulary.add(new Word("Yes, I’m coming.", "hәә’ әәnәm", NO_IMAGE,
                R.raw.phrase_yes_im_coming));
        phrasesVocabulary.add(new Word("I’m coming.", "әәnәm", NO_IMAGE,
                R.raw.phrase_im_coming));
        phrasesVocabulary.add(new Word("Let’s go.", "yoowutis", NO_IMAGE,
                R.raw.phrase_lets_go));
        phrasesVocabulary.add(new Word("Come here.", "әnni'nem", NO_IMAGE,
                R.raw.phrase_come_here));
        // Creates audio Manager object
        mAudioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);

        // Creates the adapter for the recycler view,
        // The third argument sets the color background for the Activity
        WordAdapter adapter = new WordAdapter(this, phrasesVocabulary, R.color.category_phrases);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                releaseMediaPlayer();
                Word word = (Word) parent.getItemAtPosition(position);

                int result = mAudioManager.requestAudioFocus(mAudioFocusChangeListener,
                        AudioManager.STREAM_MUSIC,
                        AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);

                if(result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
                    mMediaPlayer = MediaPlayer.create(PhrasesActivity.this, word.getAudioResourceId());
                    mMediaPlayer.start();
                    mMediaPlayer.setOnCompletionListener(mCompletionListener);
                }

            }
        });
    }

    @Override
    protected void onStop() {
        super.onStop();

        // Make sure the audio stop playing when the user leaves the app
        releaseMediaPlayer();
    }

    /**
     * This helper method prevents multiple plays on multiple clicks.
     */
    private void releaseMediaPlayer() {
        if (mMediaPlayer != null) {
            mMediaPlayer.stop();
            mMediaPlayer.release();
            mMediaPlayer = null;

            // Abandon Audio Focus when the playback is done!
            mAudioManager.abandonAudioFocus(mAudioFocusChangeListener);
        }
    }
}
