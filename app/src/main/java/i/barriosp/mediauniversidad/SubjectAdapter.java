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
public class SubjectAdapter extends ArrayAdapter{

    private Activity context;
    private List data;
    private int id;

    public SubjectAdapter(Context context, int i, List<Subject> list) {
        super(context, i, list);
        this.id = i;
        this.context =  (Activity) context;
        this.data = list;
    }

    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = ((Activity)this.context).getLayoutInflater().inflate(this.id, parent, false);
        }

        Subject subject = (Subject) this.data.get(position);

        TextView nameTxtView = (TextView) convertView.findViewById(R.id.nameAdap);
        nameTxtView.setText(subject.getName());

        TextView markTxtView = (TextView) convertView.findViewById(R.id.notaAdap);
        markTxtView.setText("Calificación: " + Float.toString(subject.getMark()));

        TextView ectTxtView = (TextView) convertView.findViewById(R.id.ectAdap);
        ectTxtView.setText(Float.toString(subject.getEct()) + " ECTs");

        return convertView;
    }
}
