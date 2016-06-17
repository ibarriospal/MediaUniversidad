package i.barriosp.mediauniversidad;

import android.nfc.Tag;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by nacho on 17/6/16.
 */
public class NewAsignaturaActivity extends AppCompatActivity {
    private static final String TAG;

    static {
        TAG = NewAsignaturaActivity.class.getName();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_layout);

    }

    public void save(View v){
        try {
            EditText asignatura = (EditText) findViewById(R.id.editTextAsignatura);
            EditText nota = (EditText) findViewById(R.id.editTextNota);
            String a = asignatura.getText().toString();
            Float n = Float.valueOf(nota.getText().toString());

            //save nueva en la DB
            DataBaseNotas db = new DataBaseNotas( getApplicationContext() );
            db.insertar(a, n);
            Log.d(NewAsignaturaActivity.TAG, "Asignatura " + a);
            Log.d(NewAsignaturaActivity.TAG, "Nota " + n);
            finish();
        }
        catch (Exception e){
            Toast.makeText(this, "Error al guardar", Toast.LENGTH_SHORT).show();
        }
    }

    public void cancel(View v){
        try {
            finish();
        }
        catch (Exception e){

        }
    }
}
