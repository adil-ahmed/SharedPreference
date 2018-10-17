package com.teamflybd.sharedpreference;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText name,password;
    CheckBox rememberMe;
    Button submit;
    Boolean save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.name);
        password = findViewById(R.id.password);
        submit = findViewById(R.id.submit);
        rememberMe = findViewById(R.id.checkBox);

        SharedPreferences sharedPreferences = getSharedPreferences("loginRef",MODE_PRIVATE);
        final SharedPreferences.Editor editor = sharedPreferences.edit();

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nameText = name.getText().toString();
                String passwordText = password.getText().toString();
                if(nameText.equals("Adil") && passwordText.equals("Adil"))
                {
                    Toast.makeText(MainActivity.this, "Matched", Toast.LENGTH_SHORT).show();
                    if(rememberMe.isChecked())
                    {
                        editor.putBoolean("savelogin",true);
                        editor.putString("name",nameText);
                        editor.putString("pass",passwordText);
                        editor.commit();
                    }

                    Intent intent = new Intent(MainActivity.this,Main2Activity.class);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(MainActivity.this, "Wrong", Toast.LENGTH_SHORT).show();
                }
            }
        });

        save = sharedPreferences.getBoolean("savelogin",true);

        if(save == true)
        {
//            if name key and password key are blank then it will return null value.
            name.setText(sharedPreferences.getString("name",null));
            password.setText(sharedPreferences.getString("pass",null));
        }


    }
}
