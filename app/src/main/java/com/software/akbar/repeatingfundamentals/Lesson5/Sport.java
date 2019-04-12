package com.software.akbar.repeatingfundamentals.Lesson5;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.DisplayMetrics;


public class Sport {
    private String mName;
    private String mNews;
    private Bitmap mImage;

    public Sport(Context context, String name, String news, int imgResource){
        this.mName = name;
        this.mNews = news;

        this.mImage = this.drawableToBitmap(context.getResources(), imgResource);
    }

    private Bitmap drawableToBitmap(Resources contextResources, int resId) {

        Bitmap bitmap = BitmapFactory.decodeResource(contextResources, resId);

        bitmap = this.resizeBitmap(bitmap, getDisplayWidth(contextResources));

        return bitmap;
    }

    private int getDisplayWidth(Resources resources) {

        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        return displayMetrics.widthPixels;
    }

    private Bitmap resizeBitmap(Bitmap bitmap, int width) {

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

    public Bitmap getImage() {
        return mImage;
    }
}
