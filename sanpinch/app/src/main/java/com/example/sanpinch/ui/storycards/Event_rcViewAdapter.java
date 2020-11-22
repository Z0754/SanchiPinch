package com.example.sanpinch.ui.storycards;

import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sanpinch.R;
import com.example.sanpinch.data.AbilityCheck;

import java.util.List;
import java.util.Random;

public class Event_rcViewAdapter extends RecyclerView.Adapter<Event_rcViewAdapter.mViewHolder> {

    List<AbilityCheck> mValues;

    public Event_rcViewAdapter(List<AbilityCheck> abilityChecks) {
        mValues = abilityChecks;
    }

    @NonNull
    @Override
    public mViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.event_item_layout, parent, false);

        return new mViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull mViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.update();
    }


    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public static class mViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public final View mView;
        private final TextView event_ability;
        public AbilityCheck mItem;
        public final TextView event_desc;
        public final TextView event_diff;
        public final TextView event_result;
        public final Button roll_button;

        private final static int UPDATE_UI = 0;
        private final Handler myHandler = new Handler() {
            public void handleMessage(Message msg) {
                final int what = msg.what;
                switch(what) {
                    case UPDATE_UI: updateResult(); break;
                }
            }
        };

        public mViewHolder(@NonNull View itemView) {
            super(itemView);
            mView = itemView;
            event_desc = mView.findViewById(R.id.eventDescription);
            event_ability = mView.findViewById(R.id.eventAbilities);
            event_result = mView.findViewById(R.id.eventResult);
            event_diff = mView.findViewById(R.id.eventDifficulty);
            roll_button = mView.findViewById(R.id.RollDice_Button);




            roll_button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                        mItem.result = new Random().nextInt(99);
                        if (mItem.result > mItem.difficulty) {
                            mItem.state = R.integer.passCheck;
                        } else {
                            mItem.state = R.integer.failCheck;
                        }
                        myHandler.sendEmptyMessage(UPDATE_UI);

                }


            });


        }

        public void update() {
            event_desc.setText(mItem.desc);
            event_ability.setText("Available Ability: " + mItem.ability);
            event_diff.setText("Pass: " + mItem.difficulty);


            if (mItem.state == R.integer.passCheck) {
                event_result.setText(mItem.result + " Pass!");
            } else if (mItem.state == R.integer.failCheck) {
                event_result.setText(mItem.result + " Fail!");
            } else {
                event_result.setText("");
            }
        }

        public void updateResult(){
            if (mItem.state == R.integer.passCheck) {
                event_result.setText(mItem.result + " Pass!");
            } else if (mItem.state == R.integer.failCheck) {
                event_result.setText(mItem.result + " Fail!");
            } else {
                event_result.setText("");
            }
        }
    }
}