package com.example.sanpinch.ui.script;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sanpinch.R;
import com.example.sanpinch.data.PlayerCard;
import com.example.sanpinch.data.Script;
import com.example.sanpinch.ui.playercard.PlayerCard_rcViewAdapter;
import com.example.sanpinch.ui.playercard.onPlayerCardSelectedListener;

import java.util.List;

public class Script_rcViewAdapter extends RecyclerView.Adapter<Script_rcViewAdapter.mViewHolder> {

    private final onScriptSelectedListener mListener;
    private final List<Script> mValues;

    public Script_rcViewAdapter(List<Script> scripts, onScriptSelectedListener listener) {
        mListener = listener;
        mValues = scripts;
    }

    @NonNull
    @Override
    public mViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.script_item_layout, parent, false);


        return new Script_rcViewAdapter.mViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final mViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.update();
        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mListener.onScriptSelected(holder.mItem, R.integer.displayScriptDetail);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public static class mViewHolder extends RecyclerView.ViewHolder {

        public final View mView;
        public final TextView scriptName;
        public final TextView scriptTime;
        public Script mItem;

        public mViewHolder(@NonNull View itemView) {
            super(itemView);
            mView = itemView;
            scriptName = mView.findViewById(R.id.script_item_name);
            scriptTime = mView.findViewById(R.id.script_item_time);

        }

        public void update() {
            scriptName.setText(mItem.name);
            scriptTime.setText(mView.getContext().getResources().getString(R.string.time_estimate_format)
                    + mItem.TimeEstimate);
        }
    }
}
