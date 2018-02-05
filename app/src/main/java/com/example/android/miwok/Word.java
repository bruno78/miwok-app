package com.example.android.miwok;

/**
 * {@link Word} represents a vocabulary word that the user wants to learn.
 * It contains a default translation and a Miwok tranlation for that word.
 */
public class Word {
    private String mMiwokTranslation;
    private String mDefaultTranslation;

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

}
