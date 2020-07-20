package com.example.dynmic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    HashMap<Integer,TextView> txtList =new HashMap<>();
    private LinearLayout parentLinearLayout;
    int count= 0;
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

        LinearLayout ll =  new LinearLayout(this);
        ll.setOrientation(LinearLayout.HORIZONTAL);
       EditText text = new EditText(this);

       txtList.put(count,text); //add view in hash map with key , which is id of remove button

       text.setHint("write something");
       ll.addView(text);

       Button btn = new Button(this);

       btn.setId(++count);// here set id for button

       btn.setText("Remove");

       btn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               LinearLayout linearParent =  (LinearLayout) v.getParent().getParent();
               LinearLayout linearChild = (LinearLayout) v.getParent();
               linearParent.removeView(linearChild);

               txtList.remove(v.getId());// remove the hash map data using view id

               Toast.makeText(getApplicationContext(),"Array size:"+Integer.toString(txtList.size()),Toast.LENGTH_LONG).show();
           }
       });
       ll.addView(btn);
       parentLinearLayout.addView(ll);
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
