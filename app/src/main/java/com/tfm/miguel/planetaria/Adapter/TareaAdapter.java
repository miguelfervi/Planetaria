package com.tfm.miguel.planetaria.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tfm.miguel.planetaria.R;

import java.util.List;

/**
 * Created by miguelfernandezvillegas on 29/6/17.
 */

public class TareaAdapter extends RecyclerView.Adapter<TareaAdapter.ViewHolder> {

    //cambiar por objeto tarea que se creará
    private List<String> names;
    private int layout;
    private OnItemClickListener listener;

    public TareaAdapter(List<String> names, int layout, OnItemClickListener listener){
        this.names = names;
        this.layout = layout;
        this.listener = listener;
    }


    @Override
    public TareaAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(layout, parent, false);
        ViewHolder vh = new ViewHolder(v);


        return vh;
    }

    @Override
    public void onBindViewHolder(TareaAdapter.ViewHolder holder, int position) {
        holder.bind(names.get(position),listener);
    }

    @Override
    public int getItemCount() {
        return names.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder{

        public TextView name;

        public ViewHolder(View itemHolder){
            super(itemHolder);
            this.name = (TextView) itemView.findViewById(R.id.textView);
        }
        // objeto  donde se usa name
        public void bind(final String name, final OnItemClickListener listener){
            this.name.setText(name);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(name,getAdapterPosition());
                }
            });
        }


    }

    public interface OnItemClickListener{
        void onItemClick(String name, int position);
    }
}
