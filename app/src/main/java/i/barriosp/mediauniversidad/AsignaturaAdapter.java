package i.barriosp.mediauniversidad;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by nacho on 17/6/16.
 */
public class AsignaturaAdapter extends ArrayAdapter{

    private Activity context;
    private List data;
    private int id;

    public AsignaturaAdapter(Context context, int i, List<Asignatura> list) {
        super(context, i, list);
        this.id = i;
        this.context =  (Activity) context;
        this.data = list;
    }

    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = ((Activity)this.context).getLayoutInflater().inflate(this.id, parent, false);
        }

        Asignatura asignatura = (Asignatura) this.data.get(position);

        TextView name = (TextView) convertView.findViewById(R.id.nameAdap);
        name.setText(asignatura.getNombre());

        TextView nota = (TextView) convertView.findViewById(R.id.notaAdap);
        nota.setText("Calificación: " + Float.toString(asignatura.getNota()));

        TextView ect = (TextView) convertView.findViewById(R.id.ectAdap);
        ect.setText(Float.toString(asignatura.getEct()) + " ECTs");

        return convertView;
    }
}
