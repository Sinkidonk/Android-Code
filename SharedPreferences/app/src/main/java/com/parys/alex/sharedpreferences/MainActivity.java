package com.parys.alex.sharedpreferences;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import android.widget.Toast;
import android.view.View.OnClickListener;


public class MainActivity extends AppCompatActivity {
    private SharedPreferences prefs;
    private EditText editText;
    private SeekBar seekBar;
    private Button btn;

    private final static String FONT_SIZE_KEY = "fontsize";
    private final static String TEXT_VALUE_KEY = "textvalue";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shared_preferences);

        final EditText editText = findViewById(R.id.EditText01);
        Button btn = findViewById(R.id.btnSave);
        SeekBar seekBar = findViewById(R.id.SeekBar01);

        btn.setOnClickListener(new OnClickListener(){
            @Override
            public void onClick(View v) {
                //---get the SharedPreferences object---
                prefs = getPreferences(MODE_PRIVATE);

                SharedPreferences.Editor editor = prefs.edit();

                //---save the values in the EditText view to preferences---
                editor.putFloat(FONT_SIZE_KEY, editText.getTextSize());
                editor.putString(TEXT_VALUE_KEY, editText.getText().toString());

                //---saves the values---
                editor.commit();

                //---display file saved message---
                Toast.makeText(getBaseContext(),
                        "Font size saved successfully!",
                        Toast.LENGTH_SHORT).show();


            }
        });
        prefs = getPreferences(MODE_PRIVATE);
        float fontSize = prefs.getFloat(FONT_SIZE_KEY, 12);
        seekBar.setProgress((int) fontSize);
        editText.setText(prefs.getString(TEXT_VALUE_KEY, ""));
        editText.setTextSize(seekBar.getProgress());
        seekBar.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {						}

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress,
                                          boolean fromUser) {
                //---change the font size of the EditText---
                editText.setTextSize(progress);
            }
        });
    }

    public void save(View view){
        //---get the SharedPreferences object---
        prefs = getPreferences(MODE_PRIVATE);

        SharedPreferences.Editor editor = prefs.edit();

        //---save the values in the EditText view to preferences---
        editor.putFloat(FONT_SIZE_KEY, editText.getTextSize());
        editor.putString(TEXT_VALUE_KEY, editText.getText().toString());

        //---saves the values---
        editor.commit();

        //---display file saved message---
        Toast.makeText(getBaseContext(),
                "Font size saved successfully!",
                Toast.LENGTH_SHORT).show();

        prefs = getPreferences(MODE_PRIVATE);
        float fontSize = prefs.getFloat(FONT_SIZE_KEY, 12);
        seekBar.setProgress((int) fontSize);
        editText.setText(prefs.getString(TEXT_VALUE_KEY, ""));
        editText.setTextSize(seekBar.getProgress());
    }




}
