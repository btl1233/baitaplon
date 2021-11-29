package com.example.baitaplon.cai_dat;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.baitaplon.R;

import java.util.List;

public class chon_anh extends RecyclerView.Adapter<chon_anh.chon_anh_viewholder> {
    List<String> list;
    Context context;
    private click click;

    public chon_anh(List<String> list, Context context, chon_anh.click click) {
        this.list = list;
        this.context = context;
        this.click = click;
    }

    @NonNull
    @Override
    public chon_anh_viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new chon_anh_viewholder(LayoutInflater.from(context).inflate(R.layout.item_hinh_anh,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull chon_anh_viewholder holder, @SuppressLint("RecyclerView") int position) {
        String hinh_anh=list.get(position);
        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                click.onVideoclick(position);
            }
        });
        Glide.with(context).load(hinh_anh).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    public class chon_anh_viewholder extends RecyclerView.ViewHolder{
        public ImageView imageView;
        public chon_anh_viewholder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.profile_image);
        }
    }
    public interface click{
         void onVideoclick(int postition);
    }
}
