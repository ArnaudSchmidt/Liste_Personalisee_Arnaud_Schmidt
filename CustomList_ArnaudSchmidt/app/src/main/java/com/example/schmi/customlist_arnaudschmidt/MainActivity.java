package com.example.schmi.customlist_arnaudschmidt;

import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import static com.example.schmi.customlist_arnaudschmidt.R.id.imageView;
import static com.example.schmi.customlist_arnaudschmidt.R.id.listview;

public class MainActivity extends AppCompatActivity {

    //tableau avec les images
    int[] IMAGES = {R.drawable.basket_icon, R.drawable.rugby_icon, R.drawable.tennis_icon, R.drawable.waterpolo_icon};

    //tableau avec les sports
    String[] NOMS = {"Basketball", "Rugby", "Tennis", "Water-Polo"};

    //tableau avec les types de sports
    String[] DESCRIPTIONS = {"Sport collectif", "Sport Collectif", "Sport Individuel", "Sport Collectif"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //associe l'objet dans la vue au code
        ListView listView=(ListView)findViewById(listview);

        //instance de la classe customeadapter qui servira à adapter la liste
        CustomAdapter customAdapter = new CustomAdapter();

        listView.setAdapter(customAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                //création de l'intent
                Intent userIntent = new Intent(MainActivity.this, ChoiceCode.class);

                //on ajoute à l'intent la position de l'item dans la liste sur lequel on a cliqué
                userIntent.putExtra("Posichoix", position);

                //mène à l'activité suivante
                startActivity(userIntent);

            }});

    }



    class CustomAdapter extends BaseAdapter{


        //retourne la longueur du tableau d'images pour savoir combien de fois répeter les fonctions/procédures
        @Override
        public int getCount() {
            return IMAGES.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        //modifie la vue selon les données prises dans les tableaux
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            convertView = getLayoutInflater().inflate(R.layout.customlayout,null);

            //associe chaque élément de la liste à un élément du customlayout
            ImageView imageview = (ImageView) convertView.findViewById(imageView);
            TextView textView_nom = (TextView) convertView.findViewById(R.id.textView_nom);
            TextView textView_description = (TextView) convertView.findViewById(R.id.textView_description);

            //transforme les éléments de la liste en fonction de la position de l'élément dans la liste
            imageview.setImageResource(IMAGES[position]);
            textView_nom.setText(NOMS[position]);
            textView_description.setText(DESCRIPTIONS[position]);

            return convertView;
        }
    }

}
