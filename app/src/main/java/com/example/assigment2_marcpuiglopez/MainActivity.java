package com.example.assigment2_marcpuiglopez;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;


public class MainActivity extends AppCompatActivity {
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_icon, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.ranking) {
            Intent intent = new Intent(this, RankingClass.class);
            startActivity(intent);
        }
        return (super.onOptionsItemSelected(item));
    }

    public void onButtonStart(View view) {
        Intent intent = new Intent(this, GameClass.class);
        EditText editTextNickname = findViewById(R.id.edit_nickname);
        String nickname = editTextNickname.getText().toString();

        if (checkIfValidNickname(nickname)) {
            intent.putExtra(getString(R.string.nickname_hint), nickname);
            startActivity(intent);
        } else {
            Toast toast = Toast.makeText(this, getString(R.string.toast_invalid_nickname), Toast.LENGTH_SHORT);
            toast.show();
        }
    }

    private boolean checkIfValidNickname(String nickname) {
        if (nickname.equals(null) || nickname.isEmpty())
            return false;
        return true;
    }
}