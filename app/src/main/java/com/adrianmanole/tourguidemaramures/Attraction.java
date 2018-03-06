package com.adrianmanole.tourguidemaramures;

/**
 * {@link Attraction} is a tourist attraction that user wants to see.
 * It contains the resource ID, name of attraction, short description and and image if available
 */

public class Attraction {

    /**
     * String resource ID for the name of the attraction
     */
    private int mAttractionName;

    /**
     * String resource ID for the short description of the attraction
     */
    private int mAttractionDescription;

    /**
     * Image of the attraction - drawable resource ID
     */
    private int mImageResourceId = NO_IMAGE_PROVIDED;

    private static final int NO_IMAGE_PROVIDED = -1;

    /**
     *  Create a new Attraction object.
     *
     *  @param attractionName is the name of the touristic attraction
     *  @param attractionDescription is a short description of the attraction
     *  @param imageResourceId is the drawable resource ID for the image associated with the attraction
     *
     */

    public Attraction (int attractionName, int attractionDescription, int imageResourceId){
        mAttractionName = attractionName;
        mAttractionDescription = attractionDescription;
        mImageResourceId = imageResourceId;
    }

    /**
     * Get name of attraction
     */

    public int getAttractionName(){
        return mAttractionName;
    }

    /**
     * Get description of attraction
     */

    public int getAttractionDescription(){
        return mAttractionDescription;
    }

    /**
     * Get image from drawable
     */
    public int getImageResourceId(){
        return mImageResourceId;
    }

    /**
     * Returns whether or not there is an image for this attraction
     */

    public boolean hasImage(){
        return mImageResourceId != NO_IMAGE_PROVIDED;
    }

}