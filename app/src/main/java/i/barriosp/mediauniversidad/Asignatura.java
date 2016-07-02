package i.barriosp.mediauniversidad;

/**
 * Created by nacho on 17/6/16.
 */

public class Asignatura {

    private String nombre;
    private float nota;
    private float ect;
    private double nxe;


    public Asignatura(String name, float n, float ect, double nxe){
        this.nombre = name;
        this.nota = n;
        this.ect = ect;
        this.nxe = nxe;
    }

    public String getNombre(){
        return this.nombre;
    }

    public float getNota(){
        return this.nota;
    }

    public float getEct(){
        return this.ect;
    }

    public double getNxe(){
        return this.nxe;
    }


    public void setNombre(String nuevo){
        this.nombre = nuevo;
    }

    public void setNota(float nuevo){
        this.nota = nuevo;
    }

    public void setEct(float nuevo){
        this.ect = ect;
    }
}
