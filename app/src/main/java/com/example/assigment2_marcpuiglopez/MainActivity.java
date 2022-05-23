package com.example.assigment2_marcpuiglopez;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
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
            setResult(RESULT_OK, intent);
            finish();
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_eje, menu);
        return super.onCreateOptionsMenu(menu);
    }

}