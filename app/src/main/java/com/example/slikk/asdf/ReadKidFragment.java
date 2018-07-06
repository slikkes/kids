package com.example.slikk.asdf;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class ReadKidFragment extends Fragment {

    TextView tvInfo;

    public ReadKidFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_read_kid, container, false);

        tvInfo = view.findViewById(R.id.tv_info);

        List<Kid> kids = MainActivity.appDb.kidsDao().getKids();

        String info = "";

        for(Kid kid : kids){
            int id = kid.getId();
            String lname = kid.getLastname();
            String fname = kid.getFirstname();

//            info += "\n\nid: " + id + "\nlast name: " + lname + "\n first name: "+fname;

        }

        tvInfo.setText(info);
        return view;
    }

}
