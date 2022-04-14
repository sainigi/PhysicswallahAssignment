package com.example.assignmentpw.adapter;



import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.assignmentpw.R;
import com.example.assignmentpw.model.Model;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {


    Model data[];

    public Adapter(Model[] data) {
        this.data = data;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_robby, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.userName.setText(data[position].getName());

//        StringBuilder subject = new StringBuilder();
//        StringBuilder qualif = new StringBuilder();

//        subject.append(data[position].getSubjects().get(0));
//        qualif.append(data[position].getQualification());

//        Log.d("Test", "onBindViewHolder: "+ data[position].getSubjects().toString());

        holder.subject.setText(data[position].getSubjects().toString().replaceAll("[]\\[]",""));
        holder.qualif.setText(data[position].getQualification().toString().replaceAll("[]\\[]",""));

        //for img
        Glide.with(holder.qualif.getContext()).load(data[position].getProfileImage()).into((ImageView) holder.imgs);


    }

    @Override
    public int getItemCount() {
        return data.length;
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        TextView userName,subject,qualif;
        View imgs;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            userName=itemView.findViewById(R.id.userName);
            subject=itemView.findViewById(R.id.subject);
            qualif=itemView.findViewById(R.id.qualif);
            imgs=itemView.findViewById(R.id.imgs);
        }
    }
}
