package com.example.unsafeinfo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {
    RecyclerView rvListagem;
    private ArrayList<HazardousInfo> lista1;
    public static final String ARQUIVO_MEUS_DADOS = "MeusDados";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        lista1 = new ArrayList<>();

        SharedPreferences sharedPreferences =
                getSharedPreferences(ARQUIVO_MEUS_DADOS, Context.MODE_PRIVATE);
        int tamanhoRemedio = sharedPreferences.getInt("tamanhoRemedio", 0);

        for(int x = 0; x < tamanhoRemedio; x++){
            String adressPlataforma = "plataforma" + x;
            String adressUsuario = "usuario" + x;
            String adressSenha = "senha" + x;

            String plataforma = sharedPreferences.getString(adressPlataforma, null);
            String usuario = sharedPreferences.getString(adressUsuario, null);
            String senha = sharedPreferences.getString(adressSenha, null);

            if(plataforma != null){
                lista1.add(new HazardousInfo(plataforma, usuario, senha));
            }
        }

        rvListagem = findViewById(R.id.rvListagem);
        rvListagem.setHasFixedSize(true);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        rvListagem.setLayoutManager(layoutManager);

        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        rvListagem.addItemDecoration(itemDecoration);

        Adaptador adaptador = new Adaptador();
        rvListagem.setAdapter(adaptador);
        adaptador.atualizarListagemCompleta(lista1);
    }
}