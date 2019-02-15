package proyect2.com.myapplication;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class FragmentA extends Fragment {

    private EditText texto_url;

    public FragmentA() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_a, container, false);

        texto_url = v.findViewById(R.id.url);

        Button btn_a_fragment_a = v.findViewById(R.id.btn_a_fragment_a);

        btn_a_fragment_a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //4. Mandar info al otro lado
                if(listener != null)  listener.onMessage("Hola desde el fragment A");
            }
        });
        return v;
    }

    //1. Interface
    public interface FragmentAActions{
        void onMessage(String msj);
    }
    //2. Crear el objeto
    FragmentAActions listener;

    //3. Crear metodo Set para el listener
    public void setListener(FragmentAActions listener){
        this.listener = listener;
    }

}
