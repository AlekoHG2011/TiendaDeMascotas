package com.example.aleko.tiendamascotas;

/**
 * Created by Aleko on 14/10/2018.
 */

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class ActivityAyuda extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ayuda);

        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);   /// Activando navegacion hacia atras
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
}
