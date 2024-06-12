package com.example.myapplication23.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication23.R;
import com.example.myapplication23.model.Chat;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class ChatAdapter extends RecyclerView.Adapter<ChatViewHolder> {

    private List<Chat> chatList = new ArrayList<>();
    public ChatAdapter(List<Chat> chatList) {
        this.chatList = chatList;
    }

    @NonNull
    @Override
    public ChatViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item, parent, false);
        ChatViewHolder chatViewHolder = new ChatViewHolder(view);
        return chatViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ChatViewHolder holder, int position) {
        Chat chat = chatList.get(position);
        holder.profileImage.setImageResource(chat.getSenderProfile());
        holder.messageText.setText(chat.getSenderMessage());
        holder.title.setText(chat.getSenderName());
        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "Name: "+chat.getSenderName(), Toast.LENGTH_SHORT).show();
            }});
    }

    @Override
    public int getItemCount() {
        return chatList.size();
    }
}


class ChatViewHolder extends RecyclerView.ViewHolder {

    public ImageView profileImage;
    public TextView messageText;
    public TextView title;
    public View view;
    public ChatViewHolder(@NonNull View itemView) {
        super(itemView);
        profileImage = itemView.findViewById(R.id.profileImage);
        messageText = itemView.findViewById(R.id.message);
        title = itemView.findViewById(R.id.title);
        view = itemView;
    }
}