package com.example.hw_recyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MainViewHolder> {

    public ArrayList <String> list;
    public ItemClickListener listener;

    public MainAdapter (ArrayList<String> list,ItemClickListener onItemClick) { // так как в
                            // MainActivity иниц.-ли массив ArrayList то здесь передали его
        this.listener=onItemClick;
        this.list = list;
    }

    @NonNull
    @Override
    public MainAdapter.MainViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_recyclerview,parent,false);
        return new MainViewHolder (view);  // инициализируем ячейку
    }

    @Override
    public void onBindViewHolder(@NonNull MainAdapter.MainViewHolder holder, int position) {
        holder.onBind(position); // для заполнения контента MainViewHolder
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MainViewHolder extends RecyclerView.ViewHolder{ // для заполнения ячейки
        TextView textView;

        public MainViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.textView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onItemClick(getAdapterPosition());
                }
            });
        }


        public void onBind(int position) { // заполнение данными ячейки (view)
            textView.setText(list.get(position));
        }
    }


    public interface ItemClickListener {
        void onItemClick (int adapterPosition);
    }
}
