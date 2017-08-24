package com.example.gallusawa.w4d3database.m_UI;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.gallusawa.w4d3database.R;
import com.example.gallusawa.w4d3database.m_Model.Spacecraft;

import java.util.ArrayList;

/**
 * Created by gallusawa on 8/24/17.
 */

public class MyAdaptor extends RecyclerView.Adapter<MyViewHolder> {

    Context c;

    ArrayList<Spacecraft> spacecrafts;

    public MyAdaptor(Context c, ArrayList<Spacecraft> spacecrafts) {
        this.c = c;
        this.spacecrafts = spacecrafts;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(c).inflate(R.layout.model, parent, false);
        return  new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

       Spacecraft spacecraft = spacecrafts.get(position);

        holder.nameTxt.setText(spacecraft.getName());
        holder.propTxt.setText(spacecraft.getPropellant());
        holder.descTxt.setText(spacecraft.getDescription());

    }

    @Override
    public int getItemCount() {
        return spacecrafts.size();
    }
}
