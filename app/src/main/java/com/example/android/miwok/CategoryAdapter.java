package com.example.android.miwok;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by brunogtavares on 2/11/18.
 * {@link CategoryAdapter} is a {@link FragmentPagerAdapter} that can provide the layout for
 * each list item based on a data source which is a list of {@link Word} objects.
 */

public class CategoryAdapter extends FragmentPagerAdapter {

    private Context mContext;
    private static final int NUM_PAGES = 4;

    /**
     * Create a new {@link CategoryAdapter} object.
     *
     * @param fm is the fragment manager that will keep each fragment's state in the adapter
     *           across swipes.
     */
    public CategoryAdapter(Context context, FragmentManager fm){
        super(fm);
        mContext = context;
    }

    /**
     * @return the {@link Fragment} that should be displayed for the given page number.
     */
    @Override
    public Fragment getItem(int position) {

        if(position == 0) {
            return new NumbersFragment();
        }
        else if(position == 1) {
            return new FamilyFragment();
        }
        else if(position == 2) {
            return new ColorsFragment();
        }
        else {
            return new PhrasesFragment();
        }
    }

    /**
     * @return the total number of pages
     */
    @Override
    public int getCount() {
        return NUM_PAGES;
    }

    @Override
    public CharSequence getPageTitle(int position) {

        if(position == 0) {
            return mContext.getString(R.string.category_numbers);
        }
        else if(position == 1) {
            return mContext.getString(R.string.category_family);
        }
        else if(position == 2) {
            return mContext.getString(R.string.category_colors);
        }
        else {
            return mContext.getString(R.string.category_phrases);
        }
    }
}
