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
public class DeleteFragment extends Fragment {

    private Button bnDel;
    private EditText etId;

    public DeleteFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_delete, container, false);

        etId = view.findViewById(R.id.et_delete);
        bnDel = view.findViewById(R.id.bn_delete_kid);
        bnDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = Integer.parseInt(etId.getText().toString());

                Kid kid = new Kid();
                kid.setId(id);

                MainActivity.appDb.kidsDao().deleteKid(kid);

                Toast.makeText(getActivity(),"kid deleted", Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }

}
