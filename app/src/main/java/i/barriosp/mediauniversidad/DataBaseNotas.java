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

    public static final String SUBJECT_TABLE = "notas";
    public static final String ID_ROW = "_id";
    public static final String SUBJECT_ROW = "subject";
    public static final String MARK_ROW = "mark";
    public static final String ECT_ROW = "ect";
    public static final String NXE_ROW = "product";


    private static final String SQL_CREATE = "create table "
            + SUBJECT_TABLE + "("
                + ID_ROW + " integer primary key autoincrement, "
                + SUBJECT_ROW + " text not null, "
                + MARK_ROW + " real not null, "
                + ECT_ROW + " real not null, "
                + NXE_ROW + " real not null);";


    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE);
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
    }

    public void insert(Subject subject){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(SUBJECT_ROW, subject.getName());
        values.put(MARK_ROW, subject.getMark());
        values.put(ECT_ROW, subject.getEct());
        values.put(NXE_ROW, subject.getNxe());

        db.insert(SUBJECT_TABLE, null,values);
        db.close();
    }

    public List<Subject> get(){

        SQLiteDatabase db = this.getReadableDatabase();
        String[] projection = {ID_ROW, SUBJECT_ROW, MARK_ROW, ECT_ROW, NXE_ROW};

        Cursor cursor =
                db.query(SUBJECT_TABLE,
                        projection,
                        //  " _id = ?",
                        //new String[] { String.valueOf(id) },
                        null,
                        null,
                        null,
                        null,
                        null,
                        null);

        List<Subject> data = new ArrayList<>();

        if (cursor != null) {
            cursor.moveToFirst();

            while (cursor.moveToNext()) {
                String name = cursor.getString(1);
                Float mark = Float.valueOf(cursor.getString(2));
                Float ect = Float.valueOf(cursor.getString(3));
                Double nxe = Double.parseDouble(cursor.getString(4));
                Subject subject = new Subject(name, mark, ect, nxe);
                data.add(subject);
            }
        }

        db.close();
        return data;
    }

    public void edit (Subject subject, int id){

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("asignatura", subject.getName());
        values.put("nota", subject.getMark());
        values.put("ect", subject.getEct());

        int i = db.update(SUBJECT_TABLE,
                values,
                " _id = ?",
                new String[] { String.valueOf( id ) });
        db.close();
    }

    public boolean delete(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        try{
            db.delete(SUBJECT_TABLE,
                    " _id = ?",
                    new String[] { String.valueOf (id ) });
            db.close();
            return true;

        }catch(Exception ex){
            return false;
        }
    }

    public float getECT() {

        Float ect = new Float(0);
        SQLiteDatabase db = this.getReadableDatabase();
        String[] projection = {ECT_ROW};

        Cursor cursor =
                db.query(SUBJECT_TABLE,
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

        db.close();
        return ect;
    }

    public double getNXE() {

        Double nxe = new Double(0);
        SQLiteDatabase db = this.getReadableDatabase();
        String[] projection = {NXE_ROW};

        Cursor cursor =
                db.query(SUBJECT_TABLE,
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

        db.close();
        return nxe;
    }
}
