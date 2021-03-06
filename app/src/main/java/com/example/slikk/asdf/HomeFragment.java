package com.example.slikk.asdf;


import android.os.Bundle;
import android.support.v4.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupMenu;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment implements View.OnClickListener {

    private Button bnAdd, bnRead;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        bnAdd = view.findViewById(R.id.bn_add);
        bnAdd.setOnClickListener(this);
        bnRead = view.findViewById(R.id.bn_show);
        bnRead.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bn_add:
                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container, new AddKidFragment()).addToBackStack(null).commit();
                break;
            case R.id.bn_show:
                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container, new ReadKidFragment()).addToBackStack(null).commit();
                break;
        }
    }
}
