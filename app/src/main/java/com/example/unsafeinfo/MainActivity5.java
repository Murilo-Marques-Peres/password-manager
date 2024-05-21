package com.example.unsafeinfo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity5 extends AppCompatActivity {
    Button btnConfirmar;
    EditText campoSenha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        btnConfirmar = findViewById(R.id.buttonNovo2);
        campoSenha = findViewById(R.id.editTextTextPersonName5);

        btnConfirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String senha = campoSenha.getText().toString();
                SharedPreferences sharedPreferences =
                        getSharedPreferences(MainActivity2.ARQUIVO_MEUS_DADOS, Context.MODE_PRIVATE);
                String senhaConfirmacao = sharedPreferences.getString("senhaAplic", "padrao");

                if(senha.equals(senhaConfirmacao)){
                    Intent intent = new Intent(MainActivity5.this, MainActivity3.class);
                    startActivity(intent);
                }else{
                    campoSenha.setText("");
                    Toast.makeText(MainActivity5.this, "Senha Errada, Tente novamente!", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}