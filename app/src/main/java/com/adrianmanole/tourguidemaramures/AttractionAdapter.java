package com.adrianmanole.tourguidemaramures;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * {@link AttractionAdapter} is an {@link ArrayAdapter} that can provide the layout
 * for each list item based on data resources
 */


public class AttractionAdapter extends ArrayAdapter<Attraction>{

    /** Resource ID for the background color for this list of attractions */

    private int mColorResourceId;

    /**
     * Create a new {@link AttractionAdapter} object.
     *
     * @param context is the current context.
     * @param attractions is the list of {@link Attraction}`s to be shown.
     * @param colorResourceId is the color resource ID for the background color for this list.
     */

    public AttractionAdapter (Context context, ArrayList<Attraction> attractions,
                              int colorResourceId){
        super(context, 0, attractions);
        mColorResourceId = colorResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if an existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.attraction_list_item, parent, false);
        }

        // Get the {@link Attraction} object located at this position in the list
        Attraction currentAttraction = getItem(position);

        // Find the ImageView in the attraction_list_item.xml layout with the id image
        ImageView attractionImageView = (ImageView) listItemView.findViewById(R.id.attraction_image);

        // Get the image resource id from the current Attraction object
        if (currentAttraction.hasImage()){
            // Set this image on the attraction ImageView
            attractionImageView.setImageResource(currentAttraction.getImageResourceId());

            // Make sure the view is visible
            attractionImageView.setVisibility(View.VISIBLE);
        } else {
            //Otherwise hide the ImageView (set visibility to GONE)
            attractionImageView.setVisibility(View.GONE);
        }

        // Find the TextView in the attraction_list_item.xml layout with the ID attraction_name
        TextView attractionNameTextView = (TextView) listItemView.findViewById(R.id.attraction_name);
        // Get the name of attraction from the current Attraction object
        // and set this text on the attractionName TextView
        attractionNameTextView.setText(currentAttraction.getAttractionName());

        // Find the TextView in the attraction_list_item.xml layout with the ID attraction_description
        TextView attractionDescriptionTextView = (TextView) listItemView.findViewById(R.id.attraction_description);
        // Get the description of attraction from the current Attraction object
        // and set this text on the attractionDescription TextView
        attractionDescriptionTextView.setText(currentAttraction.getAttractionDescription());

        // Set the theme color for the list item
        View textContainer = listItemView.findViewById(R.id.text_container);
        // Find the color that the resource ID maps to
        int color = ContextCompat.getColor(getContext(), mColorResourceId);
        // Set the background color of the text container View
        textContainer.setBackgroundColor(color);


        // Return the whole list item layout (containing 2 TextViews and 1 ImageView)
        // so that it can be shown in the ListView
        return listItemView;

    }
}