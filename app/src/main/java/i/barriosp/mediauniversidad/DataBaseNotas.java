package i.barriosp.mediauniversidad;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


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

    private static final String SQL_CREAR = "create table "
            + TABLA_NOTAS + "("
            + COLUMNA_ID + " integer primary key autoincrement, "
            + COLUMNA_ASIGNATURA + " text not null"
            + COLUMNA_NOTA + " real not null);";


    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREAR);
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
    }


    public void insertar(String asignatura, float nota){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(COLUMNA_ASIGNATURA, asignatura);
        values.put(COLUMNA_NOTA, nota);

        db.insert(TABLA_NOTAS, null,values);
        db.close();
    }

    public void obtener(int id){

        SQLiteDatabase db = this.getReadableDatabase();
        String[] projection = {COLUMNA_ID, COLUMNA_ASIGNATURA, COLUMNA_NOTA};

        Cursor cursor =
                db.query(TABLA_NOTAS,
                        projection,
                        " _id = ?",
                        new String[] { String.valueOf(id) },
                        null,
                        null,
                        null,
                        null);


        if (cursor != null)
            cursor.moveToFirst();


        System.out.println("Asignatura " + cursor.getString(1));
        System.out.println("Nota " + cursor.getString(2));
        db.close();

    }

    public void editar (String asignatura, float nota, int id){

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("asignatura",asignatura);
        values.put("nota",nota);

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

}
