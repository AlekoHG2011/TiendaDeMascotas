package com.example.aleko.tiendamascotas;

/**
 * Created by Aleko on 14/10/2018.
 */

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;

public class ListadoMascotas extends AppCompatActivity {


    ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;
    public MascotaAdaptador adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listado_mascotas);

        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);   /// Activando navegacion hacia atras

        listaMascotas = (RecyclerView) findViewById(R.id.rvMascotas);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        //GridLayoutManager glm = new GridLayoutManager(this, 2);

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
                Intent intentAyuda = new Intent(this, ActivityAyuda.class);
                startActivity(intentAyuda);
                break;

            case R.id.mConfiguracion:
                Intent intentConfig = new Intent(this, ActivityConfiguracion.class);
                startActivity(intentConfig);
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

        mascotas.add(new Mascota("Tito", "3 meses", R.drawable.c6));
        mascotas.add(new Mascota("Rupe", "5 meses", R.drawable.d2));
        mascotas.add(new Mascota("Chucho", "10 meses", R.drawable.d3));
        mascotas.add(new Mascota("Titi", "12 meses", R.drawable.d4));
        mascotas.add(new Mascota("Peggy", "18 meses", R.drawable.c1));
        mascotas.add(new Mascota("Fruti", "8 meses", R.drawable.d5));
        mascotas.add(new Mascota("Yoyo", "1 mes", R.drawable.rabbit));
        mascotas.add(new Mascota("Fredd", "5 meses", R.drawable.dancercat));
        mascotas.add(new Mascota("Maximus", "2 años", R.drawable.d7));
        mascotas.add(new Mascota("Sisi", "2 meses", R.drawable.vacunar_gatos));
        mascotas.add(new Mascota("Odoo", "12 meses", R.drawable.cooker));
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if (keyCode == KeyEvent.KEYCODE_BACK) {
            Intent intent = new Intent(ListadoMascotas.this, MainActivity.class);
            startActivity(intent);
        }
        return super.onKeyDown(keyCode, event);
    }
}
