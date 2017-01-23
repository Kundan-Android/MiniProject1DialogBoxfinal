package com.example.dell.miniproject;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomePageMenu extends Fragment {
Button PhD,Mphil,view,search,student,faculty;


    public HomePageMenu() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=  inflater.inflate(R.layout.fragment_home_page_menu, container, false);
        PhD = (Button) v.findViewById(R.id.PhDbutton);
        Mphil = (Button) v.findViewById(R.id.MphilButton);
        view = (Button) v.findViewById(R.id.viewButton);
        search = (Button) v.findViewById(R.id.searchButton);
        student = (Button) v.findViewById(R.id.studentButton);
        faculty = (Button) v.findViewById(R.id.facultyButton);
        PhD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity mainActivity = (MainActivity) getActivity();
                String subject = "phd";
                mainActivity.chooseCourse(subject);


            }
        });
        Mphil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity mainActivity = (MainActivity) getActivity();
                String subject = "Mphil";
                mainActivity.chooseCourse(subject);
            }
        });
        student.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity mainActivity = (MainActivity) getActivity();
                String subject = "student";
                mainActivity.chooseCourse(subject);
            }
        });
        faculty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity mainActivity = (MainActivity) getActivity();
                String subject = "Faculty";
                mainActivity.chooseCourse(subject);

            }
        });
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               MainActivity mainActivity = (MainActivity) getActivity();
                mainActivity.listViewOpen();

            }
        });
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity mainActivity = (MainActivity) getActivity();
                mainActivity.searchopen();
            }
        });
        return v;
    }

}
