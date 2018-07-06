package com.example.slikk.asdf;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class ReadKidFragment extends Fragment {

    ListView tvInfo;

    public ReadKidFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_read_kid, container, false);

        tvInfo = (ListView)view.findViewById(R.id.tv_info);

        List<Kid> kids = MainActivity.appDb.kidsDao().getKids();

        ArrayList<String> items = new ArrayList<>();


        for(Kid kid : kids){
            int id = kid.getId();
            String lname = kid.getLastname();
            String fname = kid.getFirstname();
            items.add(lname +" "+ fname);
//            info += "\n\nid: " + id + "\nlast name: " + lname + "\n first name: "+fname;

        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
          getActivity(),
          android.R.layout.simple_list_item_1,
          items
        );

        tvInfo.setAdapter(adapter);
        tvInfo.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, final int i, long l) {
                PopupMenu popup = new PopupMenu(getActivity(), tvInfo);
                popup.getMenuInflater().inflate(R.menu.popup_menu, popup.getMenu());

                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        Toast.makeText(getActivity(),""+menuItem.getTitle()+" "+i,Toast.LENGTH_SHORT).show();
                        return true;
                    }
                });

                popup.show();

            }
        });


        return view;
    }

}
