package com.fer.aula15_recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    ItemAdapter adapter;
    ItemData[] dados;
    boolean escuro = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recycler);

        int modoAtual = getResources().getConfiguration().uiMode & Configuration.UI_MODE_NIGHT_MASK;
        switch (modoAtual) {
            case Configuration.UI_MODE_NIGHT_NO:
                // Modo Escuro Não Ativo
                escuro = false;
                break;
            case Configuration.UI_MODE_NIGHT_YES:
                // Modo Escuro Ativo
                TextView textView = findViewById(R.id.titulo);
                textView.setTextColor(Color.WHITE);
                escuro = true;
                break;
        }

        dados = new ItemData[]{
          new ItemData("Bart","Genética não é uma desculpa!",R.drawable.bart),
          new ItemData("Homer", "Se alguma coisa está difícil de ser feita, é porque não é para ser feita!",R.drawable.homer),
          new ItemData("Marge","Há vezes em que temos que nos afastar para contemplar uma obra de arte!",R.drawable.marge),
          new ItemData("Lisa","É mais fácil ser amiga de muitas pessoas on-line do que de uma pessoa ao vivo.",R.drawable.lisa),
          new ItemData("Maggie","Chip chip.",R.drawable.maggie),
          new ItemData("Krusty","Por que coisas de palhaço sempre acontecem com palhaços?",R.drawable.krusty),
          new ItemData("Milhouse","Começamos como Romeo e Julieta, mas acabou em tragédia.",R.drawable.milhouse),
          new ItemData("Montgomery Burns","Eu nunca peço desculpas. Me desculpe, mas eu sou assim.",R.drawable.burns),
        };

        adapter = new ItemAdapter( MainActivity.this, dados, escuro);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }
}