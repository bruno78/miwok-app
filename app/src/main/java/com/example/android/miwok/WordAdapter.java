package com.example.android.miwok;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;



public class WordAdapter extends ArrayAdapter<Word> {

    /**
     * Created by brunogtavares on 2/4/18.
     *
     * This is our own custom constructor (it doesn't mirror a superclass constructor).
     * The context is used to inflate the layout file, and the list is the data we want
     * to populate into the lists
     *
     * @param context The current context. Used to inflate the layout file.
     * @param words A list of words objects to display in a list.
     */

    public WordAdapter(Context context, ArrayList<Word> words) {
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super(context, 0, words);
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
        // Get the {@link Word} object located at this position in the list
        Word currentWord = (Word) getItem(position);
        // Find the TextView in the list_item.xml layout with the ID miwok_text_view
        TextView miworkTextView = (TextView) listItemView.findViewById(R.id.miwok_text_view);
        // Get the version anme for the current Word object and
        // set this text on the same TextView.
        miworkTextView.setText(currentWord.getMiwokTranslation());
        TextView defaultTranlstationTextView = (TextView) listItemView.findViewById(R.id.default_text_view);
        defaultTranlstationTextView.setText(currentWord.getDefaultTranslation());

        return listItemView;




    }
}
