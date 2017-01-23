package com.example.dell.miniproject;


import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class Login extends Fragment {
    EditText editText1,editText2,editText3;
    Button login,reqPassword;


    public Login() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_login, container, false);
        editText1 = (EditText) v.findViewById(R.id.userTextview);
        editText2 = (EditText) v.findViewById(R.id.passwordtextview);
        editText3 = (EditText) v.findViewById(R.id.emailEdittext);
        login = (Button) v.findViewById(R.id.loginTextview);

        reqPassword = (Button) v.findViewById(R.id.reqButton);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sp = getActivity().getSharedPreferences("credit",0);
                String username = sp.getString("name",null);
                String password = sp.getString("password",null);
                String editName = editText1.getText().toString();
                String editpassword = editText2.getText().toString();
                if((editName.equals(username)) && (password.equals(editpassword)))
                 {
                    HomePageMenu homePageMenu = new HomePageMenu();
                    FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                    FragmentTransaction transaction = fragmentManager.beginTransaction();
                    transaction.replace(R.id.container1, homePageMenu);
                    transaction.commit();
                }
                else Toast.makeText(getActivity(), "Either User name or Password is Incorrect", Toast.LENGTH_SHORT).show();
            }
        });
        reqPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity mainActivity = (MainActivity) getActivity();

                mainActivity.requestmail();
            }
        });
        return v;
    }

}
