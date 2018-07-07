package com.example.slikk.asdf;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class AddKidFragment extends Fragment {


    private EditText name;
    private Button bnSave;

    public AddKidFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_add_kid, container, false);

        name = view.findViewById(R.id.et_name);
        bnSave = view.findViewById(R.id.bn_save);

        bnSave.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {

                String sname = name.getText().toString();

                Kid kid = new Kid();
                kid.setName(sname);

                MainActivity.appDb.kidsDao().addKid(kid);

                Toast.makeText(getActivity(),"kid added succesfully",Toast.LENGTH_SHORT).show();

                name.setText("");
            }
        });

        return view;
    }

}
