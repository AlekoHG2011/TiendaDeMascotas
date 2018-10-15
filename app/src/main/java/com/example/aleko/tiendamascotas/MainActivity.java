package com.example.aleko.tiendamascotas;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);

    }

    // Creando el menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_opciones, menu);

        return true;
    }

    // Acciones que se realizan cuando se da click en cada opcion del menu
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

    public void Listado_pets(View view) {
        Intent intent = new Intent(MainActivity.this, ListadoMascotas.class);
        startActivity(intent);
        finish();
    }
}
