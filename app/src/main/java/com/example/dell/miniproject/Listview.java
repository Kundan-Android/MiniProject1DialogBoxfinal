package com.example.dell.miniproject;


import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SimpleCursorAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;


/**
 * A simple {@link Fragment} subclass.
 */
public class Listview extends Fragment {
    ListView listView;
    Cursor cursor;
    SimpleCursorAdapter simpleCursorAdapter;
    MyDataBase myDataBase;

    public Listview() {
        // Required empty public constructor
    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        myDataBase = new MyDataBase(getActivity());
        myDataBase.open();

    }

    @Override
    public void onDestroy() {
        myDataBase.close();
        super.onDestroy();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_listview, container, false);
        listView = (ListView) v.findViewById(R.id.listview1);
        cursor = myDataBase.queryDetails();
        simpleCursorAdapter = new SimpleCursorAdapter(getActivity(),
                            R.layout.row,
                            cursor,
                            new String[]{"no","name","mobile","mail","subject","date"},
                            new int[]{R.id.textView1,R.id.textView2,R.id.textView3,R.id.textView4,R.id.textView5,R.id.textView6});
        listView.setAdapter(simpleCursorAdapter);

        return v;
    }

}
