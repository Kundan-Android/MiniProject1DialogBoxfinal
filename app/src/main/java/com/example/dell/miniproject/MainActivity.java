package com.example.dell.miniproject;

import android.content.SharedPreferences;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LoginPage fragmentlogin = new LoginPage();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.add(R.id.container1,fragmentlogin);
        transaction.commit();

    }
    public void listViewOpen()
    {
        Listview listview = new Listview();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.container1,listview);
        transaction.addToBackStack(null);
        transaction.commit();
    }
    public void searchopen()
    {
        SearchQuery searchQuery = new SearchQuery();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.container1,searchQuery);
        transaction.addToBackStack(null);
        transaction.commit();

    }
    public void requestmail()
    {
        EmailComposer emailComposer = new EmailComposer();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.add(R.id.container1,emailComposer);
        transaction.addToBackStack(null);
        transaction.commit();
    }
    public void chooseCourse(String subject)
    {
        CourseDeatils courseDeatils = new CourseDeatils();
        Bundle b = new Bundle();
        switch (subject)
        {
            case "phd": b.putString("subject",subject);
                        courseDeatils.setArguments(b);
                          break;
            case "Mphil": b.putString("subject",subject);
                         courseDeatils.setArguments(b);
                         break;
            case "student": b.putString("subject",subject);
                             courseDeatils.setArguments(b);
                          break;
            case "Faculty": b.putString("subject",subject);
                             courseDeatils.setArguments(b);
                         break;
        }


        FragmentManager fragmentManager = getSupportFragmentManager();

        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.container1,courseDeatils);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    public void passNameSearchingData(String name)
    {
        DialogSearch dialogSearch = new DialogSearch();
        Bundle b = new Bundle();
        b.putString("name",name);
        dialogSearch.setArguments(b);
        dialogSearch.show(getSupportFragmentManager(),null);


    }

    public void passMobileSearchingData(String mobile)
    {
        DialogSearch dialogSearch = new DialogSearch();
        Bundle b = new Bundle();
        b.putString("mobile",mobile);
        dialogSearch.setArguments(b);
        dialogSearch.show(getSupportFragmentManager(),null);


    }
    public void registerFisrt()
    {
        RegisterPage registerPage = new RegisterPage();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.container1,registerPage);
        transaction.addToBackStack(null);
        transaction.commit();
    }
    public void loginFisrt()
    {
        Login login = new Login();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.container1,login);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}
