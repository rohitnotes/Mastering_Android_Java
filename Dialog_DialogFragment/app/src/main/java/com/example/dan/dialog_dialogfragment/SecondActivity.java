package com.example.dan.dialog_dialogfragment;

import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        FragmentTest fragmentTest = new FragmentTest();
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.container_second_activity, fragmentTest, "FragmentTest").commit();
    }
}
