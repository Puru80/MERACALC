package com.mainpage.meracalc;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.WordViewHolder>
{
    private final ArrayList<String> mList;
    private LayoutInflater mInflater;

    class WordViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {
        public final TextView wordItemView;
        final HistoryAdapter mAdapter;

        public WordViewHolder(View itemView, HistoryAdapter adapter)
        {
            super(itemView);
            wordItemView = itemView.findViewById(R.id.expression);
            this.mAdapter = adapter;
        }

        @Override
        public void onClick(View v)
        {
            String element = mList.get(getLayoutPosition());
            //Intent i = new Intent(Hsitory.get,MainActivity.class);
        }
    }

    public HistoryAdapter(Context context,
                           ArrayList<String> wordList)
    {
        mInflater = LayoutInflater.from(context);
        this.mList = wordList;
    }

    @NonNull
    @Override
    public WordViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View mItemView = mInflater.inflate(R.layout.wordlist_item,
                parent, false);
        return new WordViewHolder(mItemView, this);
    }

    @Override
    public void onBindViewHolder(WordViewHolder holder, int position)
    {
        String mCurrent = mList.get(position);
        holder.wordItemView.setText(mCurrent);
    }

    @Override
    public int getItemCount()
    {
        return mList.size();
    }
}
