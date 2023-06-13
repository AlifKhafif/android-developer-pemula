package com.luckymahrus.finalsubmission.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.luckymahrus.finalsubmission.R;
import com.luckymahrus.finalsubmission.model.Project;

import java.util.ArrayList;

public class ListProjectAdapter extends RecyclerView.Adapter<ListProjectAdapter.ListViewHolder> {
    private ArrayList<Project> listProject;

    public ListProjectAdapter(ArrayList<Project> list) {
        this.listProject = list;
    }

    private OnItemClickCallback onItemClickCallback;
    public void setOnItemClickCallback(OnItemClickCallback onItemClickCallback)
    {
        this.onItemClickCallback = onItemClickCallback;
    }


    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_project_list, viewGroup, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ListViewHolder holder, int position) {
        Project Project = listProject.get(position);
        Glide.with(holder.itemView.getContext())
                .load(Project.getCompanyLogo())
                .apply(new RequestOptions().override(55, 55))
                .into(holder.ivCompanyLogo);
        holder.tvProjectName.setText(Project.getProjectName());
        holder.tvProjectUrl.setText(Project.getProjectUrl());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickCallback.onItemClicked(listProject.get(holder.getAdapterPosition()));
            }
        });
    }

    @Override
    public int getItemCount() {
        return listProject.size();
    }

    class ListViewHolder extends RecyclerView.ViewHolder {
        ImageView ivCompanyLogo;
        TextView tvProjectName, tvProjectUrl;

        ListViewHolder(View itemView) {
            super(itemView);
            ivCompanyLogo = itemView.findViewById(R.id.iv_company_logo);
            tvProjectName = itemView.findViewById(R.id.tv_project_name);
            tvProjectUrl = itemView.findViewById(R.id.tv_project_url);
        }
    }

    public interface OnItemClickCallback
    {
        void onItemClicked(Project data);
    }
}