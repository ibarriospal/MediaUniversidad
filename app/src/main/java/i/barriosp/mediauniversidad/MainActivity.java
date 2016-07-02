package i.barriosp.mediauniversidad;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

   private List<Asignatura> aaa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void my_statics(View v) {
        try {
            //lanzar el AsyncTask una vez que carga la DB
            new MyStaticsTask().execute();

        } catch (Exception e) {
            Toast.makeText(MainActivity.this, "Error al cargar Mis Datos", Toast.LENGTH_SHORT).show();
        }
    }


    public void options(View v) {
            Toast.makeText(MainActivity.this, "Proximamente", Toast.LENGTH_SHORT).show();
    }


    public void about(View v) {
        try {
            Intent i = new Intent(MainActivity.this, AboutUsActivity.class);
            this.startActivity(i);

        } catch (Exception e) {
            Toast.makeText(MainActivity.this, "Error al cargar About Us", Toast.LENGTH_SHORT).show();
        }
    }


    private class MyStaticsTask  extends AsyncTask<String, Void, Void> {
        private MyStaticsTask() {
        }

        @Override
        protected void onPreExecute() {
            ProgressBar progressBar = (ProgressBar) findViewById(R.id.progressBar);
            progressBar.setVisibility(View.VISIBLE);
        }

        protected Void doInBackground(String... strings) {
            try {
                //carga la DB
                DataBaseNotas db = new DataBaseNotas( getApplicationContext() );
                List<Asignatura> aaa = db.obtener();

            }catch(Exception e){
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void v) {
            super.onPostExecute(v);
            ProgressBar progressBar = (ProgressBar) findViewById(R.id.progressBar);
            progressBar.setVisibility(View.INVISIBLE);
            Intent i = new Intent(MainActivity.this, MyStaticsActivity.class);
            MainActivity.this.startActivity(i);
        }
    }

}
