package com.example.recyclerviewemail;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import java.util.Random;

public class EmailAdapter extends RecyclerView.Adapter<EmailAdapter.ViewHolder> {
    private List<Email> emailList;
    private Context mContext;

    public EmailAdapter(Context mContext, List<Email> emailList) {
        this.emailList = emailList;
        this.mContext = mContext;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public TextView tvIcon,tvSender,tvSubject,tvContent,tvTime;
        public ImageView ivFav;

        public ViewHolder(View itemView) {
            super(itemView);

            tvSender = itemView.findViewById(R.id.email_sender);
            tvSubject = itemView.findViewById(R.id.email_subject);
            tvContent = itemView.findViewById(R.id.email_content);
            tvTime = itemView.findViewById(R.id.tv_time);
            tvIcon = itemView.findViewById(R.id.list_icon);
            ivFav = itemView.findViewById(R.id.img_fav);

        }
    }

    @Override
    public EmailAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.mail_list,parent,false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }
    @Override
    public void onBindViewHolder(final EmailAdapter.ViewHolder holder, int position) {

        Email email = emailList.get(position);
        holder.tvSender.setText(email.getSender());
        holder.tvSubject.setText(email.getSubject());
        holder.tvContent.setText(email.getContent());
        holder.tvTime.setText(email.getTime());
        holder.ivFav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (holder.ivFav.getColorFilter() != null){
                    holder.ivFav.clearColorFilter();
                }else {
                    holder.ivFav.setColorFilter(ContextCompat.getColor(mContext, R.color.colorStar));
                }
            }
        });

        Random random = new Random();
        int color = Color.argb(255, random.nextInt(256),random.nextInt(256), random.nextInt(256));
        ((GradientDrawable) holder.tvIcon.getBackground()).setColor(color);


        holder.tvIcon.setText(email.getSender().substring(0, 1));

    }

    @Override
    public int getItemCount() {
        return emailList.size();
    }


}
