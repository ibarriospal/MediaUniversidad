package i.barriosp.mediauniversidad;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

/**
 * Created by nacho on 17/6/16.
 */
public class NewAsignaturaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_layout);

        EditText asignatura = (EditText) findViewById(R.id.editTextAsignatura);
        EditText nota = (EditText) findViewById(R.id.editTextNota);
        Asignatura nueva = new Asignatura(asignatura.getText().toString(), Float.valueOf(nota.getText().toString()));

        //save nueva en la DB
    }
}
