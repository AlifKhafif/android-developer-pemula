package com.digitalsoftware.livdev.rempahasli;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class CardRempahAdapter extends RecyclerView.Adapter<CardRempahAdapter.ListViewHolder> {

    Context c;
    private ArrayList<Rempah> listRempah;

    public CardRempahAdapter(ArrayList<Rempah> list, Context c) {
        this.listRempah = list;
        this.c = c;
    }

    private OnItemClickCallback onItemClickCallback;

    public void setOnItemClickCallback(OnItemClickCallback onItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_row_rempah, viewGroup, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ListViewHolder holder, int position) {
        Rempah rempah = listRempah.get(position);

        final String images = rempah.getPhoto();
        final String title = rempah.getName();
        final String isi = rempah.getFrom();

        //BIND
        holder.imgPhoto.setImageURI(Uri.parse(images));
        holder.tvName.setText(title);
        holder.tvFrom.setText(isi);

        Glide.with(holder.itemView.getContext())
                .load(rempah.getPhoto())
                .apply(new RequestOptions().override(55, 55))
                .into(holder.imgPhoto);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDetail(images,title,isi);
            }
        });

    }
    private void openDetail(String... details) {
        Intent i = new Intent(c, DetailM.class);
        i.putExtra("IMAGES_KEY", details[0]);
        i.putExtra("TITLE_KEY", details[1]);
        i.putExtra("ISI_KEY", details[2]);
        c.startActivity(i);

    }

    @Override
    public int getItemCount() {
        return listRempah.size();
    }

    class ListViewHolder extends RecyclerView.ViewHolder {

        ImageView imgPhoto;
        TextView tvName, tvFrom;

        ListViewHolder(View itemView) {
            super(itemView);

            imgPhoto = itemView.findViewById(R.id.img_item_photo);
            tvName = itemView.findViewById(R.id.tv_item_name);
            tvFrom = itemView.findViewById(R.id.tv_item_from);
        }
    }

    public interface OnItemClickCallback {
        void onItemClicked(Rempah data);
    }
}
