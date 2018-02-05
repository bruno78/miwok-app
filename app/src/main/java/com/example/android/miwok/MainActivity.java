/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.miwok;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private TextView mNumbersTextView;
    private TextView mFamilyTextView;
    private TextView mColorsActivtyTextView;
    private TextView mPhrasesActivityTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set the content of the activity to use the activity_main.xml layout file
        setContentView(R.layout.activity_main);

        // Attaching the layout to the activity
        mNumbersTextView = (TextView) findViewById(R.id.numbers);
        mFamilyTextView = (TextView) findViewById(R.id.family);
        mColorsActivtyTextView = (TextView) findViewById(R.id.colors);
        mPhrasesActivityTextView = (TextView) findViewById(R.id.phrases);


        // Set the onClick listener to Number TextView
        mNumbersTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent numbersIntent = new Intent(MainActivity.this, NumbersActivity.class);
                startActivity(numbersIntent);
            }
        });

        // Set the onClick listener to Family TextView
        mFamilyTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent familyIntent = new Intent( MainActivity.this, FamilyActivity.class);
                startActivity(familyIntent);
            }
        });

        // Set the onClick listener to Color textView
        mColorsActivtyTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent colorIntent = new Intent(MainActivity.this, ColorsActivity.class);
                startActivity(colorIntent);
            }
        });

        // Set the onClick listener to Phrases textView
        mPhrasesActivityTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent phrasesIntent = new Intent(MainActivity.this, PhrasesActivity.class);
                startActivity(phrasesIntent);
            }
        });


    }
}
