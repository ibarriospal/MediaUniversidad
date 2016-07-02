package i.barriosp.mediauniversidad;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
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

        Button botonSave = (Button) findViewById(R.id.botonSave);
        Button botonCancel = (Button) findViewById(R.id.botonCancel);


        botonSave.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // Si el EditText no está vacío recogemos el resultado.
                // Guardamos el texto del EditText en un String.

                EditText nombre = (EditText) findViewById(R.id.editTextAsignatura);
                EditText nota = (EditText) findViewById(R.id.editTextNota);
                EditText ect = (EditText) findViewById(R.id.editTextEct);

                Float n;
                Float e;
                Double nxe;

                try {
                    n = Float.valueOf(nota.getText().toString());
                    e = Float.valueOf(ect.getText().toString());
                    nxe = (double) (n*e);

                    String a = nombre.getText().toString();

                    if (n > 10 || n < 0 || n.isNaN() || n == null || n.toString() == "" || nxe == null || nxe.toString() == "") {
                        Toast.makeText(NewAsignaturaActivity.this, "Introduce nota válida [0-10]", Toast.LENGTH_SHORT).show();
                    } else if (a.equals(null) || a.isEmpty()) {
                        Toast.makeText(NewAsignaturaActivity.this, "Introduce nombre de la asignatura", Toast.LENGTH_SHORT).show();
                    } else if (e < 0 || e == 0 || e.isNaN() || e == null || e.toString() == "") {
                        Toast.makeText(NewAsignaturaActivity.this, "Introduce créditos válidos", Toast.LENGTH_SHORT).show();
                    } else {
                        //save nueva en la DB
                        Asignatura asignatura = new Asignatura(a, n, e, nxe);
                        DataBaseNotas db = new DataBaseNotas(getApplicationContext());
                        db.insertar(asignatura);
                        finish();

                        Toast.makeText(NewAsignaturaActivity.this, "Nota guardada", Toast.LENGTH_SHORT).show();

                        // Finalizamos la Activity para volver a la anterior
                        finish();
                    }
                } catch (NumberFormatException ex) {
                    Toast.makeText(NewAsignaturaActivity.this, "Introduce datos de la asignatura válidos", Toast.LENGTH_SHORT).show();
                }
            }
        });


        // Definimos el listener que ejecutará el método onClick del botón cancelar.
        botonCancel.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent i = getIntent();

                Toast.makeText(NewAsignaturaActivity.this, "Cancelar", Toast.LENGTH_SHORT).show();

                // Finalizamos la Activity para volver a la anterior
                finish();
            }
        });
    }

}