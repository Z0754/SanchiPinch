package com.example.sanpinch.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sanpinch.R;
import com.example.sanpinch.data.PlayerCard;

import java.util.List;

public class PlayerCard_rcViewAdapter extends RecyclerView.Adapter<PlayerCard_rcViewAdapter.mViewHolder> {

    private List<PlayerCard> mValues;
    private int count;
    public PlayerCard_rcViewAdapter(List<PlayerCard> playerCards) {
        mValues = playerCards;
        count = playerCards.size();
    }

    @NonNull
    @Override
    public mViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.pc_item_layout, parent, false);


        return new mViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull mViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.update();
    }

    @Override
    public int getItemCount() {
        return count;
    }


    public static class mViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public final View mView;
        public final TextView pcName;
        public final TextView pcJob;
        public final TextView pcAge;
        public final TextView pcHP;
        public final TextView pcMP;
        public final TextView pcSan;
        public PlayerCard mItem;

        public mViewHolder(@NonNull View itemView) {
            super(itemView);
            mView = itemView;
            pcName = mView.findViewById(R.id.pcitem_name_tv);
            pcJob = mView.findViewById(R.id.pcitem_job_tv);
            pcAge = mView.findViewById(R.id.pcitem_age_tv);
            pcHP = mView.findViewById(R.id.pcitem_hp_tv);
            pcMP = mView.findViewById(R.id.pcitem_mp_tv);
            pcSan = mView.findViewById(R.id.pcitem_san_tv);
        }

        /**
         * update all fields in the view holder
         */
        public void update() {
            pcName.setText(mItem.name);
            pcJob.append(mItem.job);
            pcAge.append(""+mItem.age);

            pcHP.setText(mView.getContext().getResources().getString(
                    R.string.hp_format, mItem.HP, mItem.HP_max));
            pcMP.setText(mView.getContext().getResources().getString(
                    R.string.mp_format, mItem.MP, mItem.MP_max));
            pcSan.setText(mView.getContext().getResources().getString(
                    R.string.san_format, mItem.SAN, mItem.SAN_MAX));
        }
    }
}
