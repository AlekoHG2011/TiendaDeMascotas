package com.example.aleko.tiendamascotas;

/**
 * Created by Aleko on 14/10/2018.
 */

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class MascotasFavoritas extends AppCompatActivity {

    ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;
    public MascotaAdaptador adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mascotas_favoritas);

        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);   /// Activando navegacion hacia atras

        this.setTitle("Mascotas Favoritas");

        FloatingActionButton moveTop = (FloatingActionButton) findViewById(R.id.top);
        listaMascotas = (RecyclerView) findViewById(R.id.rvMascotas);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        //GridLayoutManager glm = new GridLayoutManager(this, 2);

        moveTop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listaMascotas.smoothScrollToPosition(0);
            }
        });

        listaMascotas.setLayoutManager(llm);
        inicializarlistaMascotas();
        inicializarAdaptador();


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_opciones, menu);

        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {

            case R.id.mAyuda:
                Intent intent = new Intent(this, ActivityAyuda.class);
                startActivity(intent);
                break;

            case R.id.mConfiguracion:
                Intent intent1 = new Intent(this, ActivityConfiguracion.class);
                startActivity(intent1);
                break;

            case R.id.mFavoritos:
                Intent intentFav = new Intent(this, MascotasFavoritas.class);
                startActivity(intentFav);
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    public void inicializarAdaptador() {
        //MascotaAdaptador adaptador = new MascotaAdaptador(mascotas);
        adaptador = new MascotaAdaptador(mascotas, this);
        listaMascotas.setAdapter(adaptador);

    }

    public void inicializarlistaMascotas() {

        mascotas = new ArrayList<Mascota>();

        mascotas.add(new Mascota("Titi", "12 meses", R.drawable.d4, 0));
        mascotas.add(new Mascota("Peggy", "18 meses", R.drawable.c1, 0));
        mascotas.add(new Mascota("Yoyo", "1 mes", R.drawable.rabbit, 0));
        mascotas.add(new Mascota("Maximus", "2 años", R.drawable.d7, 0));
        mascotas.add(new Mascota("Odoo", "12 meses", R.drawable.cooker, 0));
    }

}
