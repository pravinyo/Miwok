package com.is_great.pro.miwok;

/**
 * Created by Pravinyo on 12/29/2016.
 */

public class Word {
    private String mEnglishTranslation;
    private String mMiwokTranslation;
    private static final int NO_IMAGE_PROVIDED=-1;
    private int mImageId=NO_IMAGE_PROVIDED;
    private int mAudioResourceFile;

    public Word(String englishWord,String miwokWord,int AudioFile){
        mAudioResourceFile=AudioFile;
        mEnglishTranslation=englishWord;
        mMiwokTranslation=miwokWord;
    }

    public Word(String englishWord,String miwokWord,int imageId,int AudioFile){
        mEnglishTranslation=englishWord;
        mMiwokTranslation=miwokWord;
        mImageId=imageId;
        mAudioResourceFile=AudioFile;
    }

    public String getEnglishTranslation(){
        return mEnglishTranslation;
    }
    public String getMiwokTranslation(){
        return mMiwokTranslation;
    }
    public int getImageId(){
        return mImageId;
    }
    public boolean hasImage(){
        return mImageId!=NO_IMAGE_PROVIDED;
    }
    public int getAudioResourceFile(){
        return mAudioResourceFile;
    }

}
