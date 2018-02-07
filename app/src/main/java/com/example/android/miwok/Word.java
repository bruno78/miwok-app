package com.example.android.miwok;

/**
 * {@link Word} represents a vocabulary word that the user wants to learn.
 * It contains a default translation and a Miwok tranlation for that word.
 */
public class Word {
    private String mMiwokTranslation;
    private String mDefaultTranslation;
    private int mImageResourceId = NO_IMAGE;
    private static final int NO_IMAGE = -1;
    private int mAudioResourceId;

    /**
     * This constructor accepts two parameters, first is the Miwok word and second is the translation
     * @param miwokWord to be translated
     * @param defaultWord is the translation of the Miwok word
     */
    public Word(String defaultWord, String miwokWord) {
        mMiwokTranslation = miwokWord;
        mDefaultTranslation = defaultWord;
    }

    /**
     * This constructor accepts three parameters, first is the Miwok word, second is the translation
     * and third is Image Resource Id to locate image.
     * @param miwokWord to be translated
     * @param defaultWord is the translation of the Miwok word
     * @param vImageResourceId is the id resource of the image
     */
    public Word(String defaultWord, String miwokWord, int vImageResourceId) {
        mMiwokTranslation = miwokWord;
        mDefaultTranslation = defaultWord;
        mImageResourceId = vImageResourceId;
    }

    /**
     * This constructor accepts three parameters, first is the Miwok word, second is the translation
     * and third is Image Resource Id to locate image.
     * @param miwokWord to be translated
     * @param defaultWord is the translation of the Miwok word
     * @param vImageResourceId is the id resource of the image
     * @param vAudioResourceId is the id resource for the audio
     */
    public Word(String defaultWord, String miwokWord, int vImageResourceId, int vAudioResourceId) {
        mMiwokTranslation = miwokWord;
        mDefaultTranslation = defaultWord;
        mImageResourceId = vImageResourceId;
        mAudioResourceId = vAudioResourceId;
    }



    /**
     * Get the default translation of the word.
     */
    public String getDefaultTranslation(){
        return mDefaultTranslation;
    }

    /**
     * Get the Miwok translation of the word.
     */
    public String getMiwokTranslation(){
        return mMiwokTranslation;
    }

    /**
     * Get the id for the image resource location
     */
    public int getImageResourceId() { return mImageResourceId; }

    /**
     * Get the id for the audio resource location
     */
    public int getAudioResourceId() { return mAudioResourceId; }

    /**
     * Test the condition whether Word object has image or not
     */
    public boolean hasImage() { return mImageResourceId != NO_IMAGE; }

}
