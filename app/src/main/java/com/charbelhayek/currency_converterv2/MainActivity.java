package com.charbelhayek.currency_converterv2;
/***********************************************
 * MainActivity.java
 * @author Charbel Hayek, Samer Saber
 * This class represents the home page of the application.
 * Other files include: MainActivitiy2.java
 * Last modified on Thursday, 31 of April 2022
 ***********************************************/

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void goToNextPage(View v){
        Intent intent=new Intent(getApplicationContext(),MainActivity2.class);// i am calling the next page
        startActivity(intent);
    }
}