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
    private TextInputEditText upassword;
    private Button button;
    private TextView move;
    public static final String PREFS_NAME = "LoginPrefs";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loginactivity);
        uname=(TextInputEditText)findViewById(R.id.usernametext);
        upassword=(TextInputEditText)findViewById(R.id.userpassword);
        button =(Button)findViewById(R.id.submit);
        SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
        if (settings.getString("logged", "").toString().equals("logged")) {
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            intent.putExtra("name",uname.getText().toString());
            startActivity(intent);
        }
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(TextUtils.isEmpty(uname.getText()))
                {
                    uname.setError("This Field Cannot be left Empty");
                }
                else
                {
                    SharedPreferences setting = getSharedPreferences(PREFS_NAME, 0);
                    SharedPreferences.Editor editor = setting.edit();
                    //editor.putString("logged", "logged");
                    String Login_name=setting.getString("Signup_Name","");
                    String Login_Password=setting.getString("Signup_Password",null);
                    editor.commit();

                    String Entered_name=uname.getText().toString();
                    String Entered_password=upassword.getText().toString();

                    if((Login_name.equals(Entered_name))&&(Login_Password.equals(Entered_password)))
                        {
                            //Toast.makeText(getApplicationContext(), "Successfull Login", Toast.LENGTH_LONG).show();
                            Intent intent = new Intent(LoginActivity.this, UserName.class);
                            intent.putExtra("name",uname.getText().toString());
                            startActivity(intent);
                        }
                        else
                        {
                           Toast.makeText(getApplicationContext(), "Incorrect Details..Try Again!!!!", Toast.LENGTH_LONG).show();
                        }

                    }
                }
        });
       move =(TextView) findViewById(R.id.signupnow);
        move.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Intent intents=new Intent(LoginActivity.this,SignupActivity.class);
               startActivity(intents);
            }
            }
        );
    }
}
