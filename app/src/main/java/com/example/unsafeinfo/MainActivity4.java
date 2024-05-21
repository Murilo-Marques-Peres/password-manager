package com.example.unsafeinfo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity4 extends AppCompatActivity {
    Button btnConfirmar;
    EditText campoSenha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        campoSenha = findViewById(R.id.editTextTextPassword);
        btnConfirmar = findViewById(R.id.buttonNovo);


        btnConfirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String senha = campoSenha.getText().toString();
                SharedPreferences sharedPreferences =
                        getSharedPreferences(MainActivity2.ARQUIVO_MEUS_DADOS, Context.MODE_PRIVATE);
                String senhaConfirmacao = sharedPreferences.getString("senhaAplic", "padrao");

                if(senha.equals(senhaConfirmacao)){
                    Intent intent = new Intent(MainActivity4.this, MainActivity2.class);
                    startActivity(intent);
                }else{
                    campoSenha.setText("");
                    Toast.makeText(MainActivity4.this, "Senha Errada, Tente novamente!", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}