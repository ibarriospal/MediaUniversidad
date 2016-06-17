package i.barriosp.mediauniversidad;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;


/**
 * Created by nacho on 17/6/16.
 */
public class MyStaticsActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.statics_layout);

        //vista adaptada
    }

    public void newAsignatura(Void v) {
        try {
            Intent i = new Intent(this, NewAsignaturaActivity.class);
            this.startActivity(i);

        } catch (Exception e) {
            Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show();
        }
    }

}
