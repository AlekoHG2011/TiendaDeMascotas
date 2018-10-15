package com.example.aleko.tiendamascotas;

/**
 * Created by Aleko on 14/10/2018.
 */

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class DetalleMascotas extends AppCompatActivity {


    TextView tvNombre;
    TextView tvEdad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_mascotas);

        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);   /// Activando navegacion hacia atras

        Bundle parametros = getIntent().getExtras();
        String nombre = parametros.getString("Nombre");
        String edad = parametros.getString("Edad");

        tvNombre = (TextView) findViewById(R.id.tvNombre);
        tvEdad = (TextView) findViewById(R.id.tvEdad);

        tvNombre.setText(nombre);
        tvEdad.setText(edad);
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

            case R.id.mRefresh:
                Toast.makeText(this, "Refresh", Toast.LENGTH_SHORT).show();
        }

        return super.onOptionsItemSelected(item);
    }


}