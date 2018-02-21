package com.example.schmi.customlist_arnaudschmidt;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import static com.example.schmi.customlist_arnaudschmidt.R.id.textView_choice;
import static com.example.schmi.customlist_arnaudschmidt.R.id.textView_nom;

public class ChoiceCode extends AppCompatActivity {

    //tableau contenant le texte à afficher après le clic
    String[] DETAIL = {"La balle est grosse.", "Un sport de bonhommes.", "Pour avoir un seul gros bras.", "C'est comme du hand mais dans l'eau."};

    //déclaration de la textview dans laquelle sera mis le texte
    private TextView detail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choice);

        //association de l'élément de la vue avec le code
        detail =(TextView)findViewById(R.id.textView_choice);

        //récupération des données de l'intent
        Intent intent = getIntent();

        //modification de la valeur du texte en fonction de la donnée stockée dans l'intent
        detail.setText(DETAIL[intent.getIntExtra("Posichoix", 0)]);

    }

}

