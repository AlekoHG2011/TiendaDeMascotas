package com.example.aleko.tiendamascotas;

/**
 * Created by Aleko on 14/10/2018.
 */

public class Mascota {

    private String nombre;
    private String edad;
    private int foto;
    private int avg;

    public Mascota(String nombre, String edad, int foto, int avg) {
        this.nombre = nombre;
        this.edad = edad;
        this.foto = foto;
        this.avg = avg;
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

    public int getAvg() {
        return avg;
    }

    public void setAvg(int avg) {
        this.avg = avg;
    }

    /*public int insertarVoto(String nombre) throws jsqlite.Exception{

        Integer idAux;
        String nombreAux;
        Integer edadAux;
        Integer votosAux = 0;

        try {

                String dbFile = "/mnt/sdcard/database/mascotas.sqlite";
                //listado = new ArrayList<TableInfo>();
                jsqlite.Database db = new jsqlite.Database();
                db.open(dbFile.toString(), jsqlite.Constants.SQLITE_OPEN_READONLY);
                String consulta = "SELECT mascota.id, mascota.nombre, mascota.edad, mascota.votos FROM mascota" +
                        " where mascota.nombre = " + nombre;
                Stmt stmt = db.prepare(consulta);
                while (stmt.step()) {
                    idAux  = Integer.valueOf(stmt.column_string(0));
                    nombreAux = stmt.column_string(1);
                    edadAux  = Integer.valueOf(stmt.column_string(2));
                    votosAux  = Integer.valueOf(stmt.column_string(3));
                }
                stmt.close();
                db.close();

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return votosAux;
    }*/


}