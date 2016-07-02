package i.barriosp.mediauniversidad;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by nacho on 17/6/16.
 */
public class DataBaseNotas extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "notasDB.db";

    public DataBaseNotas(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public static final String TABLA_NOTAS = "notas";
    public static final String COLUMNA_ID = "_id";
    public static final String COLUMNA_ASIGNATURA = "asignatura";
    public static final String COLUMNA_NOTA = "nota";
    public static final String COLUMNA_ECT = "ect";
    public static final String COLUMNA_NXE = "producto";


    private static final String SQL_CREAR = "create table "
            + TABLA_NOTAS + "("
                + COLUMNA_ID + " integer primary key autoincrement, "
                + COLUMNA_ASIGNATURA + " text not null, "
                + COLUMNA_NOTA + " real not null, "
                + COLUMNA_ECT + " real not null, "
                + COLUMNA_NXE + " real not null);";


    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREAR);
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
    }


    public void insertar(Asignatura asignatura){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(COLUMNA_ASIGNATURA, asignatura.getNombre());
        values.put(COLUMNA_NOTA, asignatura.getNota());
        values.put(COLUMNA_ECT, asignatura.getEct());
        values.put(COLUMNA_NXE, asignatura.getNxe());

        db.insert(TABLA_NOTAS, null,values);
        db.close();
    }

    public List<Asignatura> obtener(){

        SQLiteDatabase db = this.getReadableDatabase();
        String[] projection = {COLUMNA_ID, COLUMNA_ASIGNATURA, COLUMNA_NOTA, COLUMNA_ECT, COLUMNA_NXE};

        Cursor cursor =
                db.query(TABLA_NOTAS,
                        projection,
                        //  " _id = ?",
                        //new String[] { String.valueOf(id) },
                        null,
                        null,
                        null,
                        null,
                        null,
                        null);

        List<Asignatura> aaa = new ArrayList<>();

        if (cursor != null) {
            cursor.moveToFirst();

            while (cursor.moveToNext()) {
                String nombre = cursor.getString(1);
                Float nota = Float.valueOf(cursor.getString(2));
                Float ect = Float.valueOf(cursor.getString(3));
                Double nxe = Double.parseDouble(cursor.getString(4));
                Asignatura a = new Asignatura(nombre, nota, ect, nxe);
                aaa.add(a);
            }
        }

        //System.out.println("Asignatura " + cursor.getString(1));
        //System.out.println("Nota " + cursor.getString(2));
        db.close();
        return aaa;
    }

    public void editar (Asignatura asignatura, int id){

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("asignatura",asignatura.getNombre());
        values.put("nota",asignatura.getNota());
        values.put("ect", asignatura.getEct());

        int i = db.update(TABLA_NOTAS,
                values,
                " _id = ?",
                new String[] { String.valueOf( id ) });
        db.close();
    }


    public boolean eliminar(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        try{
            db.delete(TABLA_NOTAS,
                    " _id = ?",
                    new String[] { String.valueOf (id ) });
            db.close();
            return true;

        }catch(Exception ex){
            return false;
        }
    }

    public float obtenerECT() {

        Float ect = new Float(0);
        SQLiteDatabase db = this.getReadableDatabase();
        String[] projection = {COLUMNA_ECT};

        Cursor cursor =
                db.query(TABLA_NOTAS,
                        projection,
                        //  " _id = ?",
                        //new String[] { String.valueOf(id) },
                        null,
                        null,
                        null,
                        null,
                        null,
                        null);

        if (cursor != null) {
            cursor.moveToFirst();

            while (cursor.moveToNext()) {
                ect = ect + Float.valueOf(cursor.getString(0));

            }
        }

        //System.out.println("Asignatura " + cursor.getString(1));
        //System.out.println("Nota " + cursor.getString(2));
        db.close();
        return ect;
    }

    public double obtenerNXE() {

        Double nxe = new Double(0);
        SQLiteDatabase db = this.getReadableDatabase();
        String[] projection = {COLUMNA_NXE};

        Cursor cursor =
                db.query(TABLA_NOTAS,
                        projection,
                        //  " _id = ?",
                        //new String[] { String.valueOf(id) },
                        null,
                        null,
                        null,
                        null,
                        null,
                        null);

        if (cursor != null) {
            cursor.moveToFirst();

            while (cursor.moveToNext()) {
                nxe = nxe + Double.parseDouble(cursor.getString(0));
            }
        }

        //System.out.println("Asignatura " + cursor.getString(1));
        //System.out.println("Nota " + cursor.getString(2));
        db.close();
        return nxe;
    }


}
