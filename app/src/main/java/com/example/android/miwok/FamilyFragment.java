package com.example.android.miwok;


import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class FamilyFragment extends Fragment {

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
     * This event listener gets triggered when audio state changes
     */
    private AudioManager.OnAudioFocusChangeListener mAudioFocusChangeListener = new AudioManager.OnAudioFocusChangeListener() {
        @Override
        public void onAudioFocusChange(int audioFocus) {

            if(audioFocus == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT ||
                    audioFocus == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK) {

                mMediaPlayer.pause();
                mMediaPlayer.seekTo(0);
            }
            else if(audioFocus == AudioManager.AUDIOFOCUS_LOSS) {

                releaseMediaPlayer();
            }
            else if(audioFocus == AudioManager.AUDIOFOCUS_GAIN) {
                mMediaPlayer.start();
            }
        }
    };

    public FamilyFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.word_list, container, false);

        final ArrayList<Word> familyVocabulary = new ArrayList<>();

        familyVocabulary.add(new Word("father", "әpә", R.drawable.family_father,
                R.raw.family_father));
        // "әṭa"
        familyVocabulary.add(new Word("mother", "әta", R.drawable.family_mother,
                R.raw.family_mother));
        familyVocabulary.add(new Word("son", "angsi", R.drawable.family_son,
                R.raw.family_son));
        familyVocabulary.add(new Word("daughter", "tune", R.drawable.family_daughter,
                R.raw.family_daughter));
        familyVocabulary.add(new Word("older brother", "taachi", R.drawable.family_older_brother,
                R.raw.family_older_brother));
        familyVocabulary.add(new Word("younger brother", "chalitti", R.drawable.family_younger_brother,
                R.raw.family_younger_brother));
        // "teṭe"
        familyVocabulary.add(new Word("older sister", "tete", R.drawable.family_older_sister,
                R.raw.family_older_sister));
        familyVocabulary.add(new Word("younger sister", "kolliti", R.drawable.family_younger_sister,
                R.raw.family_younger_sister));
        familyVocabulary.add(new Word("grandmother", "ama", R.drawable.family_grandmother,
                R.raw.family_grandmother));
        familyVocabulary.add(new Word("grandfather", "paapa", R.drawable.family_grandfather,
                R.raw.family_grandfather));

        mAudioManager = (AudioManager) getActivity().getSystemService(Context.AUDIO_SERVICE);

        WordAdapter adapter = new WordAdapter(getActivity(), familyVocabulary, R.color.category_family);

        ListView listView = (ListView) rootView.findViewById(R.id.list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                releaseMediaPlayer();
                Word word = (Word) parent.getItemAtPosition(position);

                int result = mAudioManager.requestAudioFocus(mAudioFocusChangeListener, AudioManager.STREAM_MUSIC,
                        AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);

                if(result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
                    mMediaPlayer = MediaPlayer.create(getActivity(), word.getAudioResourceId());
                    mMediaPlayer.start();
                    mMediaPlayer.setOnCompletionListener(mCompletionListener);
                }

            }
        });

        return rootView;
    }

    @Override
    public void onStop() {
        super.onStop();

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

            // Abandon focus when playing is done
            mAudioManager.abandonAudioFocus(mAudioFocusChangeListener);
        }
    }

}
