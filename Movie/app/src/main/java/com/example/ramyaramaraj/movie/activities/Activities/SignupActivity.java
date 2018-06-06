package com.example.ramyaramaraj.movie.activities.Activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.ramyaramaraj.movie.R;

import org.json.JSONObject;

public class SignupActivity extends AppCompatActivity {
    public static final String PREFS_NAME = "LoginPrefs";
    private TextInputEditText Sign_Name,Sign_Email,Sign_Password,Sign_RetypePassword;
    private Button create;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);
        Sign_Name = (TextInputEditText) findViewById(R.id.Susername);
        Sign_Email = (TextInputEditText) findViewById(R.id.Semail);
        Sign_Password = (TextInputEditText) findViewById(R.id.Spassword);
        Sign_RetypePassword = (TextInputEditText) findViewById(R.id.SRepassword);
        create = (Button) findViewById(R.id.createaccount);
        create.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View view) {
                  if (TextUtils.isEmpty(Sign_Name.getText())) {
                      Sign_Name.setError("This Field Cannot be left Empty");
                  } else if (TextUtils.isEmpty(Sign_Email.getText())) {
                      Sign_Email.setError("This Field Cannot be left Empty");
                  } else if (TextUtils.isEmpty(Sign_Password.getText())) {
                      Sign_Password.setError("This Field Cannot be left Empty");
                  } else if (TextUtils.isEmpty(Sign_RetypePassword.getText())) {
                      Sign_RetypePassword.setError("This Field Cannot be left Empty");
                  }
                  String password = Sign_Password.getText().toString();
                  String confirm_password = Sign_RetypePassword.getText().toString();
                  String Name = Sign_Name.getText().toString();
                  String email = Sign_Email.getText().toString();
                 String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

                  JSONObject jsonObj = new JSONObject();
                  


                  if (email.matches(emailPattern)) {
                      if (password.equals(confirm_password)) {
                          Toast.makeText(getApplicationContext(), "Match", Toast.LENGTH_LONG).show();
                          //..........Shared preference................
                          SharedPreferences setting = getSharedPreferences(PREFS_NAME, 0);
                          SharedPreferences.Editor editor = setting.edit();
                          editor.putString("Signup_Name", Name);
                          editor.putString("Signup_Password", password);
                          editor.commit();
                          //.............Intent............................
                          Intent intent = new Intent(SignupActivity.this, LoginActivity.class);
                          startActivity(intent);
                      } else {
                          Toast.makeText(getApplicationContext(), " Password MisMatch", Toast.LENGTH_LONG).show();
                      }
                  } else {
                      Toast.makeText(getApplicationContext(), "Invalid Email Format", Toast.LENGTH_LONG).show();
                  }
              }
                                  }
        );
    }
}

