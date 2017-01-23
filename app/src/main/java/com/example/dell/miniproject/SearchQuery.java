package com.example.dell.miniproject;


import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SimpleCursorAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class SearchQuery extends Fragment {

EditText editText1,editText2;
    Button go1,go2;

    public SearchQuery() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_search_query, container, false);
        editText1 = (EditText) v.findViewById(R.id.searcEditetext1);
        editText2 = (EditText) v.findViewById(R.id.searcEditetext2);
        go1 = (Button) v.findViewById(R.id.searcButton1);
        go2 = (Button) v.findViewById(R.id.searcButton2);
//        listView2 = (ListView) v.findViewById(R.id.listview2);
        go1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editText1.getText().toString();
                if (name.isEmpty()){
                    Toast.makeText(getActivity(), "enter", Toast.LENGTH_SHORT).show();
                }
                else {

                MainActivity mainActivity = (MainActivity) getActivity();
                mainActivity.passNameSearchingData(name);
                }



            }
        });
        go2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mobile = editText2.getText().toString();
                if (mobile.isEmpty()){
                    Toast.makeText(getActivity(), "enter", Toast.LENGTH_SHORT).show();
                }
                else {
                MainActivity mainActivity = (MainActivity) getActivity();
                mainActivity.passMobileSearchingData(mobile);
                }
            }
        });
        return v;
    }

}
