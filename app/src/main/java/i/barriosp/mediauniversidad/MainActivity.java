package i.barriosp.mediauniversidad;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void my_statics(View v) {
        try {
            Intent i = new Intent(this, MyStaticsActivity.class);
            this.startActivity(i);
        //lanzar el AsyncTask una vez que carga la DB

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
            MainActivity.this.startActivity(i);

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
