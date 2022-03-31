package com.charbelhayek.currency_converterv2;
/**********************************************
 * MainActivity2.java
 * @author Charbel Hayek, Samer Saber
 * This class represents the second page of the application
 * where the currency conversion from dollars to lira or vice versa
 * can be applied using the rate from 'lirarate.org'.
 * Other files include: MainActivity.java
 * Last modified on Thursday, 31 of April 2022
 */

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
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
        exchange = (ImageView)findViewById(R.id.exchange);
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
        String input_USD= usd.getText().toString();
        String input_LBP= lbp.getText().toString();
        exchange.animate().rotation(360).setDuration(2000);
        exchange.clearAnimation();

        if(input_USD.equals("") && input_LBP.equals("")){
            String message="Please put a number in one of the cases you did not put any!";

            Toast.makeText(getApplicationContext(),message,Toast.LENGTH_LONG).show();

        }
        else if(!input_USD.equals("") && !input_LBP.equals(""))
        {
            String message="Please put a number in one of the cases so we can convert";
//            exchange.animate().rotation(360).setDuration(2000);
//            exchange.clearAnimation();
            Toast.makeText(getApplicationContext(),message,Toast.LENGTH_LONG).show();
        }
        else if(!input_USD.equals("") && input_LBP.equals(""))
        {
            Double inp_USD = Double.parseDouble(input_USD);
            double result = inp_USD * 22000;
//            exchange.animate().rotation(360).setDuration(2000);
//            exchange.clearAnimation();
            Toast.makeText(getApplicationContext(), "the result is: " + result + " LBP", Toast.LENGTH_LONG).show();

        }
        else{
            Double inp_LBP=Double.parseDouble(input_LBP);
            double result=inp_LBP/22000;
//            exchange.animate().rotation(360).setDuration(2000);
//            exchange.clearAnimation();
            Toast.makeText(getApplicationContext(),"the result is: "+result+" USD",Toast.LENGTH_LONG).show();
        }

    }
}
