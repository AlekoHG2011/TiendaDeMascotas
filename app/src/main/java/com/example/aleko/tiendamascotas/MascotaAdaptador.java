package com.example.aleko.tiendamascotas;

/**
 * Created by Aleko on 14/10/2018.
 */

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by aleko on 29/08/17.
 */
public class MascotaAdaptador extends RecyclerView.Adapter<MascotaAdaptador.MascotaViewHolder> {

    ArrayList<Mascota> mascotas;
    Activity activity;

    public MascotaAdaptador(ArrayList<Mascota> mascotas, Activity activity) {

        this.mascotas = mascotas;
        this.activity = activity;
    }

    @Override
    public MascotaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) { //inflar el layout y lo pasara al viewholder para que obtenga los views

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascotas, parent, false);
        return new MascotaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MascotaViewHolder mascotaViewHolder, int position) { // asocia cada elemento de la lista con cada view

        final Mascota mascota = mascotas.get(position);
        mascotaViewHolder.imgFoto.setImageResource(mascota.getFoto());
        mascotaViewHolder.tvNombreCV.setText(mascota.getNombre());
        mascotaViewHolder.tvEdadCV.setText(mascota.getEdad());

        mascotaViewHolder.imgFoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(activity, "Ver detalles de " + mascota.getNombre(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(activity, DetalleMascotas.class);
                intent.putExtra("Nombre", mascota.getNombre());
                intent.putExtra("Edad", mascota.getEdad());
                activity.startActivity(intent);
            }
        });

        mascotaViewHolder.btnLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(activity, "Diste Like a " + mascota.getNombre(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() { // Cantidad de elementos que contiene mi lista

        return mascotas.size();
    }

    public static class MascotaViewHolder extends RecyclerView.ViewHolder {

        private ImageView imgFoto;
        private TextView tvNombreCV;
        private TextView tvEdadCV;
        private ImageButton btnLike;


        public MascotaViewHolder(View itemView) {
            super(itemView);
            tvNombreCV = (TextView) itemView.findViewById(R.id.tvNombreCV);
            tvEdadCV = (TextView) itemView.findViewById(R.id.tvEdadCV);
            imgFoto = (ImageView) itemView.findViewById(R.id.imgFoto);
            btnLike = (ImageButton) itemView.findViewById(R.id.btnLike);
        }
    }
}
