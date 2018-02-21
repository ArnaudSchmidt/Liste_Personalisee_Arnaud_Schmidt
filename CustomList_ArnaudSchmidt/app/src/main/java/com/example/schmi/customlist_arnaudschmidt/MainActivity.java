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

    int[] IMAGES = {R.drawable.basket_icon, R.drawable.rugby_icon, R.drawable.tennis_icon, R.drawable.waterpolo_icon};

    String[] NOMS = {"Basketball", "Rugby", "Tennis", "Water-Polo"};

    String[] DESCRIPTIONS = {"Sport collectif", "Sport Collectif", "Sport Individuel", "Sport Collectif"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView=(ListView)findViewById(listview);

        CustomAdapter customAdapter = new CustomAdapter();

        listView.setAdapter(customAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                //création de l'intent
                Intent userIntent = new Intent(MainActivity.this, ChoiceCode.class);

                userIntent.putExtra("Posichoix", position);

                //mène à l'activité suivante
                startActivity(userIntent);

            }});

    }



    class CustomAdapter extends BaseAdapter{


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

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            convertView = getLayoutInflater().inflate(R.layout.customlayout,null);

            ImageView imageview = (ImageView) convertView.findViewById(imageView);
            TextView textView_nom = (TextView) convertView.findViewById(R.id.textView_nom);
            TextView textView_description = (TextView) convertView.findViewById(R.id.textView_description);

            imageview.setImageResource(IMAGES[position]);
            textView_nom.setText(NOMS[position]);
            textView_description.setText(DESCRIPTIONS[position]);

            return convertView;
        }
    }

}
