package com.charbelhayek.currency_converterv2;
/**********************************************
 * MainActivity2.java
 * @author Charbel Hayek, Samer Saber
 * This class represents the second page of the application
 * where the currency conversion from dollars to lira or vice versa
 * can be applied using the rate from 'lirarate.org'.
 * Other files include: MainActivity.java
 * Last modified on Thursday, 31 of April 2022
 ***********************************************/

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {
   EditText usd;
   EditText lbp;

   ImageView exchange;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        usd = (EditText) findViewById(R.id.USD);
        lbp = (EditText) findViewById(R.id.LBP);

        exchange = (ImageView) findViewById(R.id.exchange);
    }
    public void back(View v)
    {
    //This function will redirect to home page / MainActivity.java
        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
        startActivity(intent);
    }

    public void convert(View v)
    {
    //This function converts lira value to dollar value and vice versa
        String input_usd = usd.getText().toString();
        String input_lbp = lbp.getText().toString();

        exchange.animate().rotation(360).setDuration(2000);
        exchange.clearAnimation();

        if(input_usd.equals("") && input_lbp.equals(""))
        {
        //If user does not input value in either fields
            String message = "Please insert a value!";
            Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();
        }
        else if(!input_usd.equals("") && !input_lbp.equals(""))
        {
        //If user inputs value in both fields
            String message = "Please insert a number only in one of the fields and not both";
//          exchange.animate().rotation(360).setDuration(2000);
//          exchange.clearAnimation();
            Toast.makeText(getApplicationContext(),message,Toast.LENGTH_LONG).show();
        }
        else if(!input_usd.equals("") && input_lbp.equals(""))
        {
        //If user inputs value in lbp field only
            double inp_usd;
            inp_usd = 0.0;

            try
            {
                inp_usd = Double.parseDouble(input_usd);
            }catch(NumberFormatException e)
            {
                Toast.makeText(getApplicationContext(), "Please input a number value!", Toast.LENGTH_LONG).show();
                return;
            }

            double result = inp_usd * 22000;
//            exchange.animate().rotation(360).setDuration(2000);
//            exchange.clearAnimation();
            Toast.makeText(getApplicationContext(), "the result is: " + result + " LBP", Toast.LENGTH_LONG).show();
        }
        else
        {
        //If user inputs value in dollar field only
            double inp_lbp;
            inp_lbp = 0.0;

            try
            {
                inp_lbp = Double.parseDouble(input_lbp);
            }catch(NumberFormatException e)
            {
                Toast.makeText(getApplicationContext(), "Please input a number value!", Toast.LENGTH_LONG).show();
                return;
            }

            double result = inp_lbp / 22000;
//            exchange.animate().rotation(360).setDuration(2000);
//            exchange.clearAnimation();
            Toast.makeText(getApplicationContext(), "the result is: "+result+" USD", Toast.LENGTH_LONG).show();
        }
    }
}
