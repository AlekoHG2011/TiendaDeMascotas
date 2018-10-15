package com.example.aleko.tiendamascotas;

/**
 * Created by Aleko on 14/10/2018.
 */

public class Mascota {

    private String nombre;
    private String edad;
    private int foto;

    public Mascota(String nombre, String edad, int foto) {
        this.nombre = nombre;
        this.edad = edad;
        this.foto = foto;
    }

    public String getNombre() {

        return nombre;
    }

    public void setNombre(String nombre) {

        this.nombre = nombre;
    }

    public String getEdad() {

        return edad;
    }

    public void setEdad(String edad) {

        this.edad = edad;
    }

    public int getFoto() {

        return foto;
    }

    public void setFoto(int foto) {

        this.foto = foto;
    }
}