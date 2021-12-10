package com.example.listuserjava;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class ListUserAdapter extends RecyclerView.Adapter<ListUserAdapter.ListViewHolder> {
    private ArrayList<Profile> listUser;

    public ListUserAdapter(ArrayList<Profile> list) {
        this.listUser = list;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_row_user, viewGroup, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {
        Profile user = listUser.get(position);
        Glide.with(holder.itemView.getContext())
                .load(user.getPhoto()) // URL Gambar
                .circleCrop() // Mengubah image menjadi lingkaran
                .into(holder.imgPhoto);
        holder.tvUser.setText(user.getUser());
        holder.tvName.setText(user.getName());
        holder.tvLocation.setText(user.getLocation());

        //untuk menyimpan data ke menu berikutnya
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            ImageView imgPhoto;
            TextView tvName, tvUser, tvLocation;
            @Override
            public void onClick(View itemView) {
                Intent intent = new Intent(itemView.getContext(), DetailUserActivity.class);
                intent.putExtra("extra_user", user);
//                Bundle bundle = new Bundle(); ini
//                intent.putExtra("extra_user", user);
//                bundle.putString("nama", user.getName());
//                bundle.putString("username", user.getUser());
//                bundle.putInt("gambar", user.getPhoto());
//                bundle.putString("loca", user.getLocation());
//                bundle.putString("flwg", user.getFollowing());
//                bundle.putString("flws", user.getFollowers());
//                bundle.putString("com", user.getCompany());
//                bundle.putString("rep", user.getRepository());
//                intent.putExtras(bundle); ini
                itemView.getContext().startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return listUser.size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;
        TextView tvName, tvUser, tvLocation;

        public ListViewHolder(@NonNull View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.img_item_photo);
            tvUser = itemView.findViewById(R.id.tv_user);
            tvName = itemView.findViewById(R.id.tv_name);
            tvLocation = itemView.findViewById(R.id.tv_loc);
        }

    }

    private OnItemClickCallback onItemClickCallback;

    public void setOnItemClickCallback(OnItemClickCallback onItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback;
    }

    public interface OnItemClickCallback {
        void onItemClicked(Profile data);
    }


}
