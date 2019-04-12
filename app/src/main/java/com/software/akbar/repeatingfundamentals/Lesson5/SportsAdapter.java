package com.software.akbar.repeatingfundamentals.Lesson5;

import android.content.Context;
import android.content.res.XmlResourceParser;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.software.akbar.repeatingfundamentals.R;

import java.util.ArrayList;

public class SportsAdapter extends RecyclerView.Adapter<SportsAdapter.Holder> {

    private ArrayList<Sport> mSports;
    private Context mContext;
    private OnSportClickListener mOnSportClickListener;

    interface  OnSportClickListener{
        void onSportClick(Sport sport);
    }

    public SportsAdapter(Context context, ArrayList<Sport> sports){
        this.mSports = sports;
        this.mContext = context;
    }

    public void setOnSportClickListener(OnSportClickListener onSportClickListener) {
        this.mOnSportClickListener = onSportClickListener;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.ex_5_2_recycler_layout, viewGroup, false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int i) {
        Sport currentSport = mSports.get(i);

        holder.bindTo(currentSport);
    }

    @Override
    public int getItemCount() {
        return mSports.size();
    }

    public class Holder extends RecyclerView.ViewHolder {

        ImageView sportImageView;
        TextView sportNameView;
        TextView sportNewsView;

        public Holder(@NonNull View itemView) {
            super(itemView);

            sportNameView = itemView.findViewById(R.id.sportNameView);
            sportNewsView = itemView.findViewById(R.id.sportNewsView);
            sportImageView = itemView.findViewById(R.id.sportImage);
        }

        public void bindTo(Sport currentSport) {
            sportNameView.setText(currentSport.getName());
            sportNewsView.setText(currentSport.getNews());
            sportImageView.setImageBitmap(currentSport.getImage());

            if(mOnSportClickListener == null) return;

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mOnSportClickListener.onSportClick(currentSport);
                }
            });
        }
    }
}
