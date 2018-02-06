package com.example.android.miwok;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;

import java.util.ArrayList;



public class WordAdapter extends ArrayAdapter<Word> {

    private int mColorBackground;

    /**
     * Created by brunogtavares on 2/4/18.
     *
     * This is our own custom constructor (it doesn't mirror a superclass constructor).
     * The context is used to inflate the layout file, and the list is the data we want
     * to populate into the lists
     *
     * @param context The current context. Used to inflate the layout file.
     * @param words A list of words objects to display in a list.
     * @param colorBackground The Resource reference for background color.
     */

    public WordAdapter(Context context, ArrayList<Word> words, int colorBackground) {
        super(context, 0, words);
        mColorBackground = colorBackground;
    }

    /**
     * Provide a view for an AdapterView (listView, GridView, etc.)
     *
     * @param position The position in the list of data that should be displayed in the list item view.
     * @param convertView The recycled view to populate.
     * @param parent The parent ViewGroup that is used for inflation.
     * @return the View for the position in the adapter view.
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // Check if the existing view is being reused, otherwise inflate the view.
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false
            );
        }

        // Get the view from the inner LinearLayout
        View textContainer = listItemView.findViewById(R.id.text_container);
        // Get the actual color that R.color.xxxx_catetory maps to
        int color = ContextCompat.getColor(getContext(), mColorBackground);
        // Set the background color
        textContainer.setBackgroundColor(color);

        // Get the {@link Word} object located at this position in the list
        Word currentWord = (Word) getItem(position);
        // Find the TextView in the list_item.xml layout with the ID miwok_text_view
        TextView miwokTextView = (TextView) listItemView.findViewById(R.id.miwok_text_view);
        // Get the version anme for the current Word object and
        // set this text on the same TextView.
        miwokTextView.setText(currentWord.getMiwokTranslation());
        TextView defaultTranlstationTextView = (TextView) listItemView.findViewById(R.id.default_text_view);
        defaultTranlstationTextView.setText(currentWord.getDefaultTranslation());

        ImageView imageImageView = (ImageView) listItemView.findViewById(R.id.iv_image);

        if(currentWord.hasImage()) {
            imageImageView.setImageResource(currentWord.getImageResourceId());
            imageImageView.setVisibility(View.VISIBLE);
        }
        else {
            imageImageView.setVisibility(View.GONE);
        }

        return listItemView;

    }

}
