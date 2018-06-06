package com.example.ramyaramaraj.movie.activities.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.ramyaramaraj.movie.R;

public class UserName extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nav_header_main);

        Intent intent = getIntent();
        String Name = intent.getStringExtra("name");
        TextView tv = (TextView) findViewById(R.id.usernamehead);
        tv.setText(Name);
        Intent intents=new Intent(UserName.this,MainActivity.class);
        startActivity(intents);
    }
}