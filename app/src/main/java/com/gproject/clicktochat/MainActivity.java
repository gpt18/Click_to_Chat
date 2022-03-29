package com.gproject.clicktochat;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

    Button submit;
    EditText input;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        submit = findViewById(R.id.btn_open);
        input = findViewById(R.id.txt_phone);



        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String number =  input.getText().toString();
                String wp_url = "https://wa.me/+91"+number+"?text=Hi";

                if(number.length()==0){
                    Toast.makeText(MainActivity.this, "Please enter phone number.", Toast.LENGTH_SHORT).show();
                }
                if(number.length()<10){
                    Toast.makeText(MainActivity.this, "Enter 10 digit number.", Toast.LENGTH_SHORT).show();
                }
                else{
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse(wp_url));
                    startActivity(intent);
                }
            }
        });

    }

}