package com.ithb.jeffry.tourdestinationcatalogue;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class CardViewLocationAdapter extends RecyclerView.Adapter<CardViewLocationAdapter.CardViewViewHolder> {
    private ArrayList<Location> listLocation;

    CardViewLocationAdapter(ArrayList<Location> list) {
        this.listLocation = list;
    }

    @NonNull
    @Override
    public CardViewViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cardview_location, parent, false);
        return new CardViewViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final CardViewViewHolder holder, int position) {
        Location location = listLocation.get(position);

        Glide.with(holder.itemView.getContext())
                .load(location.getPhoto())
                .apply(new RequestOptions().override(120, 120))
                .into(holder.imgPhoto);

        holder.tvName.setText(location.getName());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemClickCallback.onItemClicked((listLocation.get(holder.getAdapterPosition())));
            }
        });
    }

    @Override
    public int getItemCount() {
        return listLocation.size();
    }

    class CardViewViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;
        TextView tvName;

        CardViewViewHolder(View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.cardview_img_item_photo);
            tvName = itemView.findViewById(R.id.cardview_tv_item_name);
        }
    }

    private OnItemClickCallback onItemClickCallback;

    void setOnItemClickCallback(OnItemClickCallback onItemClickCallback){
        this.onItemClickCallback = onItemClickCallback;
    }
}
