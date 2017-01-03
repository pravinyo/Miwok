package com.is_great.pro.miwok;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Pravinyo on 12/29/2016.
 */

public class WordAdapter extends ArrayAdapter<Word> {
    private int mListItemColor;

    public WordAdapter(Activity context, ArrayList<Word> words,int color) {
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews and an ImageView, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super(context, 0, words);
        mListItemColor=color;
    }
    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Get the {@link AndroidFlavor} object located at this position in the list
        Word currentWord = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID version_name
        TextView englishTextView = (TextView) listItemView.findViewById(R.id.english_text_view);
        // Get the version name from the current AndroidFlavor object and
        // set this text on the name TextView
        englishTextView.setText(currentWord.getEnglishTranslation());

        // Find the TextView in the list_item.xml layout with the ID version_number
        TextView miwokTextView = (TextView) listItemView.findViewById(R.id.miwok_text_view);
        // Get the version number from the current AndroidFlavor object and
        // set this text on the number TextView
        miwokTextView.setText(currentWord.getMiwokTranslation());

        //set color to list item
        View layout = listItemView.findViewById(R.id.text_container);
        int color = ContextCompat.getColor(getContext(),mListItemColor);
        layout.setBackgroundColor(color);


        //get Image
        ImageView image = (ImageView) listItemView.findViewById(R.id.image_image_view);
        if(currentWord.hasImage()){
            image.setImageResource(currentWord.getImageId());
            image.setVisibility(View.VISIBLE);
        }
        else{
            image.setVisibility(View.GONE);
        }
        // Return the whole list item layout (containing 2 TextViews and an ImageView)
        // so that it can be shown in the ListView
        return listItemView;
    }
}
