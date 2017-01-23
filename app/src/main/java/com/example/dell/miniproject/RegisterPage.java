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
public class RegisterPage extends Fragment {
EditText editText1,editText2,editText3,editText4,editText5,editText6;
    Button register,login;

    public RegisterPage() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_register_page, container, false);
        editText1 = (EditText) v.findViewById(R.id.edit1);
        editText2 = (EditText) v.findViewById(R.id.edit2);
        editText3 = (EditText) v.findViewById(R.id.edit3);
        editText4 = (EditText) v.findViewById(R.id.edit4);
        editText5 = (EditText) v.findViewById(R.id.edit5);
        editText6 = (EditText) v.findViewById(R.id.edit6);
        register = (Button) v.findViewById(R.id.buttonregistry);
        login = (Button) v.findViewById(R.id.buttonlogin2);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Login login = new Login();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.add(R.id.container1,login);
                transaction.commit();


            }
        });
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ((editText1.getText().toString().isEmpty())||(editText2.getText().toString().isEmpty()||(editText3.getText().toString().isEmpty()))||(editText4.getText().toString().isEmpty())||(editText5.getText().toString().isEmpty()||(editText6.getText().toString().isEmpty())))

                {
                    Toast.makeText(getActivity(), "Please Fill All EditBox First", Toast.LENGTH_SHORT).show();
                }
                else {
                    SharedPreferences sharedPreferences = getActivity().getSharedPreferences("credit", 0);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("no.", editText1.getText().toString());
                    editor.putString("name", editText2.getText().toString());
                    editor.putString("mail", editText3.getText().toString());
                    editor.putString("password", editText4.getText().toString());
                    editor.putString("confirm", editText5.getText().toString());
                    editor.putString("hint", editText6.getText().toString());
                    editText1.setText("");
                    editText2.setText("");
                    editText3.setText("");
                    editText4.setText("");
                    editText5.setText("");
                    editText6.setText("");
                    Toast.makeText(getActivity(), "Your Data is Registered", Toast.LENGTH_SHORT).show();
                    editor.commit();
                }
            }
        });
        return v;
    }

}
