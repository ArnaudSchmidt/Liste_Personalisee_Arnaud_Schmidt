package com.example.schmi.customlist_arnaudschmidt;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import static com.example.schmi.customlist_arnaudschmidt.R.id.textView_choice;
import static com.example.schmi.customlist_arnaudschmidt.R.id.textView_nom;

public class ChoiceCode extends AppCompatActivity {

    String[] DETAIL = {"Sport collectif", "Sport Collectif", "Sport Individuel", "Sport Collectif"};

    private TextView detail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choice);

        detail =(TextView)findViewById(R.id.textView_choice);

        //récupération des données de l'intent
        Intent intent = getIntent();

        detail.setText(DETAIL[intent.getIntExtra("Posichoix", 0)]);

    }

}

