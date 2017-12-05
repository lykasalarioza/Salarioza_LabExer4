package com.salarioza.lab_exer_dec05;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText et_paragraph;
    Button btn_save;
    Button btn_clear;
    Button btn_display;
    TextView tv_display;
    SharedPreferences pref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_paragraph = (EditText) findViewById(R.id.etparagraph);
        btn_save = (Button) findViewById(R.id.btnSave);
        btn_clear = (Button) findViewById(R.id.btnClear);
        btn_display = (Button) findViewById(R.id.btnDisplay);
        pref = getPreferences(Context.MODE_PRIVATE);
    }
    public void savetext (View view) {
        SharedPreferences.Editor editor = pref.edit();
        editor.putString("txtparagraph", et_paragraph.getText().toString());
        editor.commit();
        Toast.makeText(this, "Saved!", Toast.LENGTH_SHORT).show();
    }
    public void loadtext (View view) {
        String txt = pref.getString("txtparagraph", "");
        tv_display.setText(txt);
    }
    public void cleartext (View view) {
        tv_display.setText("");
    }
}
