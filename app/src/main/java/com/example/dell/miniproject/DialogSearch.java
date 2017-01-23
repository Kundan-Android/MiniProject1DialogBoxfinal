package com.example.dell.miniproject;


import android.app.Dialog;
import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SimpleCursorAdapter;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
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
public class DialogSearch extends DialogFragment {
    ListView listv2;
    Cursor cursor2;
    MyDataBase myDataBase;
    SimpleCursorAdapter simpleCursorAdapter;

    public DialogSearch() {
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

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Dialog dil = null;
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setIcon(R.mipmap.ic_launcher);
        builder.setTitle("Founded:");
        MainActivity mainActivity = (MainActivity) getActivity();
        Bundle b = getArguments();
        String name = b.getString("name");
        String mobile = b.getString("mobile");
        View v = getActivity().getLayoutInflater().inflate(R.layout.fragment_dialog_search,null);
        listv2 = (ListView) v.findViewById(R.id.listviewDialog);
        if(name!=null){
            cursor2 = myDataBase.queryDetailsname(name);
            // Toast.makeText(getActivity(), ""+cursor2, Toast.LENGTH_SHORT).show();

            if (cursor2.getCount()<=0){
                Toast.makeText(getActivity(), "Search Not Found", Toast.LENGTH_SHORT).show();}
            else {
                simpleCursorAdapter = new SimpleCursorAdapter(getActivity(),
                        R.layout.row,
                        cursor2,
                        new String[]{"no", "name", "mobile", "mail", "subject"},
                        new int[]{R.id.textView1, R.id.textView2, R.id.textView3, R.id.textView4, R.id.textView5});

                listv2.setAdapter(simpleCursorAdapter);
            }
            builder.setView(v);
            builder.setPositiveButton("OK",null);
        }
        else if (mobile!=null){
            cursor2 = myDataBase.queryDetailsMobile(mobile);
            if (cursor2.getCount()<=0){
                Toast.makeText(getActivity(), "search not Found", Toast.LENGTH_SHORT).show();}
            else {
                simpleCursorAdapter = new SimpleCursorAdapter(getActivity(),
                        R.layout.row,
                        cursor2,
                        new String[]{"no", "name", "mobile", "mail", "subject"},
                        new int[]{R.id.textView1, R.id.textView2, R.id.textView3, R.id.textView4, R.id.textView5});

                listv2.setAdapter(simpleCursorAdapter);
            }
            builder.setView(v);
        }
        dil = builder.create();
        return  dil;
    }

}
