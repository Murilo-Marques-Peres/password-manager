package com.example.unsafeinfo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity3 extends AppCompatActivity {
    Button btnInserir;
    Button btnRemover;
    Button btnEditarSenha;
    EditText campoPlataforma;
    EditText campoUsuario;
    EditText campoSenha;
    EditText campoPlataformaRemover;
    EditText campoMudarSenha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        btnInserir = findViewById(R.id.button3);
        btnRemover = findViewById(R.id.button4);
        btnEditarSenha = findViewById(R.id.button5);
        campoPlataforma = findViewById(R.id.editTextTextPersonName);
        campoUsuario = findViewById(R.id.editTextTextPersonName2);
        campoSenha = findViewById(R.id.editTextTextPersonName3);
        campoPlataformaRemover = findViewById(R.id.editTextTextPersonName4);
        campoMudarSenha = findViewById(R.id.editTextTextPersonName6);

        btnEditarSenha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strMudarSenha = campoMudarSenha.getText().toString();
                mudarSenha(strMudarSenha);
            }
        });

        btnInserir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strPlataforma = campoPlataforma.getText().toString();
                String strUsuario = campoUsuario.getText().toString();
                String strSenha = campoSenha.getText().toString();

                adicionarInfo(strPlataforma, strUsuario, strSenha);
            }
        });

        btnRemover.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String plataforma = campoPlataformaRemover.getText().toString();
                excluirInfo(plataforma);
            }
        });
    }

    public void mudarSenha(String novaSenha){
        SharedPreferences sharedPreferences =
                getSharedPreferences(MainActivity2.ARQUIVO_MEUS_DADOS, Context.MODE_PRIVATE);
        sharedPreferences.edit().putString("senhaAplic", novaSenha).apply();
        Toast.makeText(MainActivity3.this, "Senha Mudada!", Toast.LENGTH_LONG).show();

    }
    public void adicionarInfo(String plataforma, String usuario, String senha){
        SharedPreferences sharedPreferences =
                getSharedPreferences(MainActivity2.ARQUIVO_MEUS_DADOS, Context.MODE_PRIVATE);
        int tamanhoRemedio = sharedPreferences.getInt("tamanhoRemedio", 0);
        String adressPlataforma = "plataforma" + tamanhoRemedio;
        String adressUsuario = "usuario" + tamanhoRemedio;
        String adressSenha = "senha" + tamanhoRemedio;
        sharedPreferences.edit().putString(adressPlataforma, plataforma).apply();
        sharedPreferences.edit().putString(adressUsuario, usuario).apply();
        sharedPreferences.edit().putString(adressSenha, senha).apply();


        tamanhoRemedio++;
        sharedPreferences.edit().putInt("tamanhoRemedio", tamanhoRemedio).apply();

        campoPlataforma.setText("");
        campoUsuario.setText("");
        campoSenha.setText("");

        Toast.makeText(MainActivity3.this, "Informações Salvas!", Toast.LENGTH_LONG).show();
    }
    public void excluirInfo(String plataforma){
        SharedPreferences sharedPreferences =
                getSharedPreferences(MainActivity2.ARQUIVO_MEUS_DADOS, Context.MODE_PRIVATE);
        int tamanhoRemedio = sharedPreferences.getInt("tamanhoRemedio", 0);
        for(int x = 0; x < tamanhoRemedio; x++){
            String adressPlataforma = "plataforma" + x;
            String adressUsuario = "usuario" + x;
            String adressSenha = "senha" + x;
            String nomePesquisado = sharedPreferences.getString(adressPlataforma, null);

            if(plataforma.equals(nomePesquisado)){
                sharedPreferences.edit().remove(adressPlataforma).apply();
                sharedPreferences.edit().remove(adressUsuario).apply();
                sharedPreferences.edit().remove(adressSenha).apply();

                Toast.makeText(MainActivity3.this, "Conjunto de Infos Removida!", Toast.LENGTH_LONG).show();
            }else{
                Toast.makeText(MainActivity3.this, "Conjunto de Infos Sem Match!", Toast.LENGTH_LONG).show();
            }
        }
        campoPlataformaRemover.setText("");
    }
}