package com.example.assigment2_marcpuiglopez;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.example.assigment2_marcpuiglopez.domain.Player;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText nickname = findViewById(R.id.edit_nickname);

        Button confirmButton = findViewById(R.id.button_startgame);

        nickname.setHint(getIntent().getStringExtra("nickname"));

        confirmButton.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.class, GameClass.class);
            Player company = new Player(
                    nickname.getText().toString()
            );
            intent.putExtra("Edit", company);
            setResult(RESULT_OK, intent);
            finish();
        });
    }
}