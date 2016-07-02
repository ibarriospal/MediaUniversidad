package i.barriosp.mediauniversidad;

/**
 * Created by nacho on 17/6/16.
 */

public class Subject {

    private String name;
    private float mark;
    private float ect;
    private double nxe;

    public Subject(String name, float mark, float ect, double nxe){
        this.name = name;
        this.mark = mark;
        this.ect = ect;
        this.nxe = nxe;
    }

    public String getName(){
        return this.name;
    }

    public float getMark(){
        return this.mark;
    }

    public float getEct(){
        return this.ect;
    }

    public double getNxe(){
        return this.nxe;
    }

    public void setName(String newName){ this.name = newName; }

    public void setNota(float newMark){
        this.mark = newMark;
    }

    public void setEct(float newEct){ this.ect = newEct; }
}
