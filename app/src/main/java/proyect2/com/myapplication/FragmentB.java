package proyect2.com.myapplication;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


public class FragmentB extends Fragment implements View.OnClickListener {

    private EditText et_nombre_libreta;
    private EditText et_numero_libreta;
    private Button btn_libreta_agregar;
    private RecyclerView libreta;
    private AdapterTemplate adapterTemplate;

    public FragmentB() {
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

        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_a, container, false);
        et_nombre_libreta = v.findViewById(R.id.et_nombre_libreta);
        et_numero_libreta = v.findViewById(R.id.et_nombre_libreta);
        btn_libreta_agregar = v.findViewById(R.id.btn_libreta_agregar);
        libreta = v.findViewById(R.id.libreta);

        adapterTemplate = new AdapterTemplate();
        libreta.setHasFixedSize(true);

        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        libreta.setLayoutManager(manager);
        libreta.setAdapter(adapterTemplate);

        btn_libreta_agregar.setOnClickListener(this);

        return v;
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_libreta_agregar:
                Persona p = new Persona(et_nombre_libreta.getText().toString(), et_numero_libreta.getText().toString());
                adapterTemplate.agregarPersona(p);
                break;
        }
    }
}
