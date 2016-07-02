package i.barriosp.mediauniversidad;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by nacho on 17/6/16.
 */
public class MyStaticsActivity extends AppCompatActivity{
    private static final int NUEVO = 0;
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
        List<Subject> data = db.get();
        Float credits = db.getECT();
        Double nxe = db.getNXE();
        Double average = (nxe/credits);
        ListView listView = (ListView) findViewById(R.id.listView);

        TextView mediaText = (TextView) findViewById(R.id.mediaText);
        String averageString = String.format( "%.2f", average );
        mediaText.setText(averageString);

        ArrayAdapter<Subject> adapter = new SubjectAdapter(this, R.layout.adapter_layout, data);
        listView.setAdapter(adapter);

        Button newSubject = (Button) findViewById(R.id.nuevaAsignatura);

        newSubject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MyStaticsActivity.this, NewAsignaturaActivity.class);
                startActivityForResult(i, NUEVO);
            }
        });
    }
}
