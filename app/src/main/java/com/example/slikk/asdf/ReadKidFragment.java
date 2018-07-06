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

        tvInfo = (ListView) view.findViewById(R.id.tv_info);

        List<Kid> kids = MainActivity.appDb.kidsDao().getKids();

        ArrayList<String> items = new ArrayList<>();


        for (Kid kid : kids) {
            int id = kid.getId();
            String lname = kid.getLastname();
            String fname = kid.getFirstname();
            items.add(lname + " " + fname);
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
            public void onItemClick(AdapterView<?> adapterView, final View v, final int i, long l) {
                PopupMenu popup = new PopupMenu(getActivity(), v);
                popup.getMenuInflater().inflate(R.menu.popup_menu, popup.getMenu());

                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {

                        switch (menuItem.getItemId()) {
                            case R.id.popup_del:
                                deletKid(i+1);
                                break;
                            case R.id.popup_addpoint:
                                Toast.makeText(getActivity(), "soon add point", Toast.LENGTH_SHORT).show();
                                break;
                            case R.id.popup_update:
                                Toast.makeText(getActivity(), "soon update", Toast.LENGTH_SHORT).show();
                                break;
                            default:
                                Toast.makeText(getActivity(), "" + menuItem.getItemId(), Toast.LENGTH_SHORT).show();
                                break;

                        }
                        return true;
                    }
                });

                popup.show();

            }
        });


        return view;
    }


    private void deletKid(int id) {

        Kid kid = new Kid();
        kid.setId(id);

        MainActivity.appDb.kidsDao().deleteKid(kid);

        Toast.makeText(getActivity(), "kid deleted", Toast.LENGTH_SHORT).show();
    }
}
