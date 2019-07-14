package com.example.kdvcalculate;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button btn;
    TextView txt;
    EditText edt1;
    EditText edt2;
    CheckBox cb1;
    CheckBox cb2;
    Integer isayi;
    Integer iyuzde;
    Double dsonuc;
    String sKDV;
    String sYuzde;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn=(Button) findViewById(R.id.lbtn);
        txt=(TextView) findViewById(R.id.ltxtv);
        edt1=(EditText) findViewById(R.id.ledtKDV);
        edt2=(EditText) findViewById(R.id.ledtyuzde);
        cb1=(CheckBox) findViewById(R.id.lcb8);
        cb2=(CheckBox) findViewById(R.id.lcb18);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sKDV =edt1.getText().toString();
                if(sKDV.trim().length()<1){
                    txt.setText("Please fill in the blanks");
                }
                else{
                    isayi=Integer.valueOf(sKDV);
                    txt.setText(isayi.toString());
                    if (cb1.isChecked()) {
                        edt2.setText("8");
                        iyuzde=(Integer) 8;
                    } else {
                        if (cb2.isChecked()) {
                            edt2.setText("18");
                            iyuzde=(Integer) 18;

                        }
                    }
                    try{
                        iyuzde=Integer.valueOf(edt2.getText().toString());
                    } catch (NumberFormatException matematikselHata){
                        iyuzde=0;
                    }
                    if (iyuzde>0){
                        dsonuc=(double) isayi*iyuzde/100;
                        txt.setText(dsonuc.toString());
                        txt.setTextSize(55);
                    } else {
                        txt.setText("Pleze enter correct format.");
                    }
                }
            }
        });
    }
}
