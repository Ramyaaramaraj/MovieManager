package com.example.ramyaramaraj.movie.activities.Activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ramyaramaraj.movie.R;

public class LoginActivity extends AppCompatActivity{
    private TextInputEditText uname;
    private Button button;
    private TextView text1;
    public static final String PREFS_NAME = "LoginPrefs";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loginactivity);
        uname=(TextInputEditText)findViewById(R.id.usernametext);
        button =(Button)findViewById(R.id.submit);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(TextUtils.isEmpty(uname.getText()))
                {
                    //Enter valid user Name...
                   // Toast.makeText(getApplicationContext(), "UserName field Cannot be left Empty", Toast.LENGTH_SHORT).show();
                    uname.setError("This Field Cannot be left Empty");
                }
                else
                {
                    SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
                    if (settings.getString("logged", "").toString().equals("logged")) {
                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                        intent.putExtra("name",uname.getText().toString());
                        startActivity(intent);
                    }
                    else
                    {
                        SharedPreferences setting = getSharedPreferences(PREFS_NAME, 0);
                        SharedPreferences.Editor editor = setting.edit();
                        editor.putString("logged", "logged");
                        editor.commit();
                        Toast.makeText(getApplicationContext(), "Successfull Login", Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                        intent.putExtra("name",uname.getText().toString());
                        startActivity(intent);
                    }
                }
            }
        });
    }
}
