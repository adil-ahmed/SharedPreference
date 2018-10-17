package com.teamflybd.sharedpreference;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        text = findViewById(R.id.text);
        SharedPreferences sp = getSharedPreferences("loginRef",MODE_PRIVATE);

        String name = sp.getString("name", "");

        text.setText(name);

    }
}
