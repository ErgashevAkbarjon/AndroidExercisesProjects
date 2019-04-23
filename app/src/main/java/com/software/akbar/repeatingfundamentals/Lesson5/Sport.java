package com.software.akbar.repeatingfundamentals.Lesson5;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.DisplayMetrics;


public class Sport {
    private String mName;
    private String mNews;
    private int mImageRes;

    public Sport(Context context, String name, String news, int imgResource){
        this.mName = name;
        this.mNews = news;

        this.mImageRes = imgResource;
    }

    public static Bitmap drawableToBitmap(Resources contextResources, int resId) {

        Bitmap bitmap = BitmapFactory.decodeResource(contextResources, resId);

        bitmap = resizeBitmap(bitmap, getDisplayWidth(contextResources));

        return bitmap;
    }

    private static int getDisplayWidth(Resources resources) {

        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        return displayMetrics.widthPixels;
    }

    private static Bitmap resizeBitmap(Bitmap bitmap, int width) {

        float factor = width / (float) bitmap.getWidth();

        int newHeight = (int)(bitmap.getHeight() * factor);

        return Bitmap.createScaledBitmap(bitmap, width, newHeight, true);
    }

    public String getName() {
        return mName;
    }

    public String getNews() {
        return mNews;
    }

    public int getImage() {
        return this.mImageRes;
    }
}
