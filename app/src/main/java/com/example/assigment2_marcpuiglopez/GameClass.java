package com.example.assigment2_marcpuiglopez;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.assigment2_marcpuiglopez.domain.User;
import com.example.assigment2_marcpuiglopez.domain.UserAdapter;
import com.example.assigment2_marcpuiglopez.domain.UserViewModel;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class GameClass extends AppCompatActivity {

    String url = "https://palabras-aleatorias-public-api.herokuapp.com/random";

    TextView textViewWord;
    EditText editTextLetter;
    EditText editTextGuess;

    User user;
    String word;
    String solution;
    int intents;

    RequestQueue queue;

    private ArrayList<User> dataSet;
    private UserAdapter todoAdapter;
    UserViewModel viewModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_class);

        String nickname = getIntent().getStringExtra("nickname");
        user = new User(nickname);

        queue = Volley.newRequestQueue(getApplicationContext());
        textViewWord = findViewById(R.id.word);
        editTextLetter = findViewById(R.id.letter);
        editTextGuess = findViewById(R.id.guess);

        intents = 0;

        viewModel = new ViewModelProvider(this).get(UserViewModel.class);

        getWord(url);
    }

    private void getWord(String url) {

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONObject body = response.getJSONObject("body");
                            word = body.getString("Word");
                            Log.v("TEST", "intents: " + intents + " word: " + word);
                            Log.v("TEST", "length: " + word.length() + " score: " + getScore());
                            setSolution();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.v("TEST", error.getMessage());
            }
        });
        queue.add(jsonObjectRequest);
    }

    public void setSolution() {
        solution = "";

        for (int i = 0; i < word.length(); i++) {
            solution += "_";
        }
        textViewWord.setText(solution);
    }

    public void onButtonTry(View view) {
        String letter = editTextLetter.getText().toString();

        if (checkIfLetter(letter)) {
            buttonTryPlaceLetter(letter.charAt(0));
            intents++;
            checkIfComplete(solution);
            Log.v("TEST", "intents: " + intents + "word: " + word);
            Log.v("TEST", "length: " + word.length() + "score: " + getScore());
        } else {
            Toast toast = Toast.makeText(this, "Incorrect input", Toast.LENGTH_LONG);
            toast.show();
        }
        editTextLetter.setText("");
    }

    private boolean checkIfLetter(String input) {
        Log.v("TryButton", "Letter: " + input);

        if (input.equals(null))
            return false;
        else if (input.length() != 1)
            return false;
        else if (!input.matches("[A-Z]*[a-z]")) {
            return false;
        }
        return true;
    }

    private void buttonTryPlaceLetter(char input) {
        char[] changeSolution;

        for (int i = 0; i < word.length(); i ++) {
            if (word.charAt(i) == input) {
                changeSolution = solution.toCharArray();
                changeSolution[i] = input;
                solution = String.valueOf(changeSolution);
            }
        }
        textViewWord.setText(solution);
    }

    public void onButtonGuess(View view) {
        String guess = editTextGuess.getText().toString();

        if (!checkIfComplete(guess)) {
            Toast toast = Toast.makeText(this, "You Lost, game finished", Toast.LENGTH_LONG);
            toast.show();
            endGame(false);
            finish();
        } else {
            textViewWord.setText(guess);
        }
        editTextGuess.setText("");
    }

    private boolean checkIfComplete(String possibleSolution) {
        if (possibleSolution.equals(word)) {
            Toast toast = Toast.makeText(this, "VICTORY", Toast.LENGTH_LONG);
            endGame(true);
            toast.show();
            return true;
        }
        return false;
    }

    private void endGame(boolean win) {
        if (win)
            user.setScore(getScore());
        else
            user.setScore(0);

        viewModel.insert(user);
        finish();
    }

    private int getScore() {
        double score;
        score = word.length() - intents;
        score /= word.length();
        score *= 10;
        return (int)score;
    }
}
