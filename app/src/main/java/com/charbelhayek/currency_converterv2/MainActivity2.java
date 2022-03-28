package com.charbelhayek.currency_converterv2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

public class MainActivity2 extends AppCompatActivity {
    EditText USD;
    EditText LBP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        USD= (EditText) findViewById(R.id.USD);
        LBP=(EditText) findViewById(R.id.LBP);
    }

}
    public void login(View v){
        String input_USD=USD.getText().toString();
        String input_LBP=LBP.getText().toString();

        if(input_USD.equals("") && input_LBP.equals("")){
            String message="Please put a number in one of the cases you did not put any!";
            Toast.makeText(getApplicationContext(),message,Toast.LENGTH_LONG).show();
        }
        else if(!input_USD.equals("") && !input_LBP.equals(""))
        {
            String message="Please put a number in one of the cases so we can convert";
            Toast.makeText(getApplicationContext(),message,Toast.LENGTH_LONG).show();
        }
        else if(!input_USD.equals("") && input_LBP.equals(""))
        {
            Double inp_USD = Double.parseDouble(input_USD);
            double result = inp_USD * 22000;
            Toast.makeText(getApplicationContext(), "the result is: " + result + " LBP", Toast.LENGTH_LONG).show();

        }
        else{
            Double inp_LBP=Double.parseDouble(input_LBP);
            double result=inp_LBP/22000;
            Toast.makeText(getApplicationContext(),"the result is: "+result+" USD",Toast.LENGTH_LONG).show();
        }

    }
}
}