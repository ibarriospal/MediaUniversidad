package i.barriosp.mediauniversidad;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.EditText;

import java.util.List;


/**
 * Created by nacho on 17/6/16.
 */
public class MyStaticsActivity extends AppCompatActivity{
    private static final int NUEVO = 0;
    private Asignatura entry;
    private static final String TAG;

    static {
        TAG = NewAsignaturaActivity.class.getName();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.statics_layout);

        //vista adaptada
        DataBaseNotas db = new DataBaseNotas(getApplicationContext());
        List<Asignatura> aaa = db.obtener();
        Float creditos = db.obtenerECT();
        Double nxe = db.obtenerNXE();
        Double media = (double) nxe/creditos;
        ListView listView = (ListView) findViewById(R.id.listView);

        TextView mediaText = (TextView) findViewById(R.id.mediaText);
        mediaText.setText(media.toString());

        ArrayAdapter<Asignatura> a = new AsignaturaAdapter(this, R.layout.adapter_layout, aaa);
        listView.setAdapter(a);

        Button nueva = (Button) findViewById(R.id.nuevaAsignatura);

        nueva.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MyStaticsActivity.this, NewAsignaturaActivity.class);
                startActivityForResult(i, NUEVO);
            }
        });
    }

}
