package com.software.akbar.repeatingfundamentals.Lesson4;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.software.akbar.repeatingfundamentals.R;

import java.text.StringCharacterIterator;
import java.util.ArrayList;

public class WordsRecyclerAdapter extends RecyclerView.Adapter<WordsRecyclerAdapter.Holder> {

    private ArrayList<String> mWords;

    public WordsRecyclerAdapter(ArrayList<String> words){
        this.mWords = words;
    }

    public void insertItem(String word) {

        int lastItem = getItemCount();
        mWords.add(word);
        notifyItemInserted(lastItem);
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View group = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.exercise_4_4_recycler_item, viewGroup, false);

        return new Holder(group);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int i) {

        String currentWord = mWords.get(i);

        holder.bind(currentWord);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String clicked = currentWord.concat(" Clicked!!! ");
                mWords.set(i, clicked);
                notifyItemChanged(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mWords.size();
    }

    public class Holder extends RecyclerView.ViewHolder {
        TextView mWordView;

        public Holder(@NonNull View itemView) {
            super(itemView);

            mWordView = itemView.findViewById(R.id.recyclerTextView);
        }

        public void bind(String currentWord) {
            this.mWordView.setText(currentWord);
        }
    }
}
