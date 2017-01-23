package com.example.dell.miniproject;


import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.SimpleCursorAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import android.widget.DatePicker;

import java.util.Calendar;


/**
 * A simple {@link Fragment} subclass.
 */
public class CourseDeatils extends Fragment {
EditText editText1,editText2,editText3,editText4,editText5;
    EditText datetaxt;
    Button date,save,back;
    ListView listView;
    Cursor cursor;
    SimpleCursorAdapter simpleCursorAdapter;
    MyDataBase myDataBase;
    TextView textdate;

    public CourseDeatils() {
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
        View v = inflater.inflate(R.layout.fragment_course_deatils, container, false);
        editText1 = (EditText) v.findViewById(R.id.noEdittext);
        editText2 = (EditText) v.findViewById(R.id.nameEdittext);
        editText3 = (EditText) v.findViewById(R.id.mobileEdittext);
        editText4 = (EditText) v.findViewById(R.id.emailEdittext);
        editText5 = (EditText) v.findViewById(R.id.subEdittext);
         textdate = (TextView) v.findViewById(R.id.textviewDatepicked1);
        Bundle bundle = getArguments();
        if (bundle!=null)
        {
            String subject = bundle.getString("subject");
            editText5.setText("  "+""+subject);
           // Toast.makeText(getActivity(), ""+subject, Toast.LENGTH_SHORT).show();
        }
//        final  TextView etdate2 = (TextView) v.findViewById(R.id.textviewDatepicked2);
//        final  TextView etdate3 = (TextView) v.findViewById(R.id.textviewDatepicked3);

        date = (Button) v.findViewById(R.id.dateButton);
        back = (Button) v.findViewById(R.id.backButton);
        save = (Button) v.findViewById(R.id.saveButton);

        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onCreateDialog();


            }
        });

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String no = editText1.getText().toString();
                String name = editText2.getText().toString();
                String mobile = editText3.getText().toString();
                String mail = editText4.getText().toString();
                String subject = editText5.getText().toString();
                String date = textdate.getText().toString();
                if ((editText1.getText().toString().isEmpty())||(editText2.getText().toString().isEmpty())||(editText3.getText().toString().isEmpty())||(editText4.getText().toString().isEmpty())||(editText5.getText().toString().isEmpty()))
                {
                    Toast.makeText(getActivity(), "Please Enter All Details", Toast.LENGTH_SHORT).show();
                }
                else {
                    myDataBase.insertDeatils(no, name, mobile, mail, subject, date);
                    editText1.setText("");
                    editText2.setText("");
                    editText3.setText("");
                    editText4.setText("");
                    editText5.setText("");
                    editText1.requestFocus();
                    Toast.makeText(getActivity(), "saved in DataBase", Toast.LENGTH_SHORT).show();
                }

            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HomePageMenu homePageMenu = new HomePageMenu();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.replace(R.id.container1,homePageMenu);
                transaction.addToBackStack(null);
                transaction.commit();

            }
        });


        return  v;
    }
    public  Dialog onCreateDialog()
    {
        Dialog d = null;
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
         final int day = calendar.get(Calendar.DATE);
        DatePickerDialog datePickerDialog = new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                textdate.setText(year+"-"+(monthOfYear+1)+"-"+dayOfMonth);
            }
        },year,month,day);
        d = datePickerDialog;
        d.show();
        return d;
    }

}
