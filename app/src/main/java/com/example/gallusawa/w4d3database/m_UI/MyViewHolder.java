package com.example.gallusawa.w4d3database.m_UI;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.gallusawa.w4d3database.R;

/**
 * Created by gallusawa on 8/24/17.
 */

public class MyViewHolder extends RecyclerView.ViewHolder {

    TextView  nameTxt, propTxt, descTxt;


    public MyViewHolder(View itemView) {
        super(itemView);


        TextView nameTxt = (TextView) itemView.findViewById(R.id.nameTxt);
        TextView propTxt = (TextView) itemView.findViewById(R.id.nameTxt2);
        TextView descTxt = (TextView) itemView.findViewById(R.id.nameTxt3);

    }
}
