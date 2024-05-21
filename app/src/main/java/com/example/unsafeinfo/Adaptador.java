package com.example.unsafeinfo;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adaptador extends RecyclerView.Adapter<Adaptador.NossoViewHolder>{
    private ArrayList<HazardousInfo> lista1 = new ArrayList<>();
    @NonNull
    @Override
    public Adaptador.NossoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.itens, parent, false);
        NossoViewHolder viewHolder = new NossoViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull NossoViewHolder holder, int position) {
        HazardousInfo hazardousInfo = lista1.get(position);
        holder.mTextViewPlataforma.setText(hazardousInfo.getPlataforma());
        holder.mTextViewUsuario.setText(hazardousInfo.getUsuario());
        holder.mTextViewSenha.setText(hazardousInfo.getSenha());
    }

    @Override
    public int getItemCount() {
        if(lista1 == null){
            return 0;
        }
        return lista1.size();
    }
    public class NossoViewHolder extends RecyclerView.ViewHolder{
        TextView mTextViewPlataforma, mTextViewUsuario, mTextViewSenha;
        public NossoViewHolder(@NonNull View itemView){
            super(itemView);

            mTextViewPlataforma = itemView.findViewById(R.id.textView4);
            mTextViewUsuario = itemView.findViewById(R.id.textView5);
            mTextViewSenha = itemView.findViewById(R.id.textView6);

        }
    }
    public void atualizarListagemCompleta(ArrayList<HazardousInfo> lista1){
        this.lista1 = lista1;
        notifyDataSetChanged();
    }
}


