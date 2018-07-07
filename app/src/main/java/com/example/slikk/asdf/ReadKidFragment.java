package com.example.slikk.asdf;


import android.app.AlertDialog;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CursorAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;



/**
 * A simple {@link Fragment} subclass.
 */
public class ReadKidFragment extends Fragment {

    ListView tvInfo;

    public ReadKidFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_read_kid, container, false);

        tvInfo = (ListView) view.findViewById(R.id.tv_info);

        String[] columns = {
                "name",
                "points"
        };
        int[] resourceIds = {
                R.id.tv_row_name,
                R.id.tv_row_points
        };

        final Cursor cursor = MainActivity.appDb.kidsDao().getCursorAll();

        final CursorAdapter adapter = new SimpleCursorAdapter(
                getActivity(),
                R.layout.listview_kids_row,
                cursor,
                columns,
                resourceIds,
                0
        );
        tvInfo.setAdapter(adapter);
        tvInfo.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, final View v, final int pos, long l) {
                PopupMenu popup = new PopupMenu(getActivity(), v);
                popup.getMenuInflater().inflate(R.menu.popup_menu, popup.getMenu());

                Toast.makeText(getActivity(), "" + adapter.getItemId(pos), Toast.LENGTH_SHORT).show();

                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {

                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        final int id = (int) adapter.getItemId(pos);


                        switch (menuItem.getItemId()) {

                            case R.id.popup_del:

                                deletKid(id);

                                updateCursor(adapter);

                                Toast.makeText(getActivity(), "deleted", Toast.LENGTH_SHORT).show();

                                break;

                            case R.id.popup_update:
                                Toast.makeText(getActivity(), "soon update", Toast.LENGTH_SHORT).show();
                                break;

                            case R.id.popup_addpoint:

                                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                                View pointsD = getLayoutInflater().inflate(R.layout.dialog_points, container, false);
                                final EditText etPoints = pointsD.findViewById(R.id.et_add_point);
                                Button bnPoints = pointsD.findViewById(R.id.bn_add_point);

                                builder.setView(pointsD);
                                final AlertDialog dialog = builder.create();
                                dialog.show();

                                bnPoints.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {
                                        int points =Integer.parseInt(etPoints.getText().toString());

                                        MainActivity.appDb.kidsDao().updatePoint(points, id);

                                        Toast.makeText(getActivity(), "points updated", Toast.LENGTH_SHORT).show();
                                        updateCursor(adapter);
                                        dialog.hide();

                                    }
                                });

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

    private void updateCursor(CursorAdapter adapter) {
        Cursor newcursor = MainActivity.appDb.kidsDao().getCursorAll();
        adapter.changeCursor(newcursor);
        adapter.notifyDataSetChanged();
    }


    private void deletKid(int id) {

        Kid kid = new Kid();
        kid.setId(id);

        MainActivity.appDb.kidsDao().deleteKid(kid);

        Toast.makeText(getActivity(), "kid deleted", Toast.LENGTH_SHORT).show();
    }
}
