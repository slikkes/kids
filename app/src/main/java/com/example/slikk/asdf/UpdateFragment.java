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
public class UpdateFragment extends Fragment {

    private EditText etId, etLname, etFname;
    private Button bnUpdate;

    public UpdateFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_update, container, false);

        etId = view.findViewById(R.id.et_id);
        etLname = view.findViewById(R.id.et_lastname);
        etFname = view.findViewById(R.id.et_firstname);

        bnUpdate = view.findViewById(R.id.bn_update_kid);
        bnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int id = Integer.parseInt(etId.getText().toString());
                String lname = etLname.getText().toString();
                String fname = etFname.getText().toString();

                Kid kid = new Kid();
                kid.setId(id);
                kid.setLastname(lname);
                kid.setFirstname(fname);

                MainActivity.appDb.kidsDao().updateKid(kid);

                Toast.makeText(getActivity(), "kid updated",Toast.LENGTH_SHORT).show();

                etId.setText("");
                etLname.setText("");
                etFname.setText("");
            }
        });


        return view;

    }

}
