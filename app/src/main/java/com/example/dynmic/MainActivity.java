package com.example.dynmic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<TextView> txtList =new  ArrayList<>();
    private LinearLayout parentLinearLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        parentLinearLayout =findViewById(R.id.views);

        findViewById(R.id.add).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addView(v);
            }
        });
        findViewById(R.id.valid).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate(v);
            }
        });

    }
   public void addView(View v){


       EditText text = new EditText(this);
       txtList.add(text);
       text.setHint("write someting");
       parentLinearLayout.addView(text);
    }
    public void validate(View v)
    {
        for(int i =0 ;i<txtList.size();i++){
            if(!txtList.get(i).getText().toString().isEmpty())
                txtList.get(i).setBackgroundColor(Color.BLUE);
            else{
                txtList.get(i).setError("invalid");
            }
        }
    }
}
