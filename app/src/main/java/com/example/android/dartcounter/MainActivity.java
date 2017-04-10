package com.example.android.dartcounter;

import android.support.v7.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int multiplier = 1;
    int currentScore = 0;
    int scorePlayer1 = 501;
    int scorePlayer2 = 501;
    boolean player1 = true;
    TextView scoreViewP1;
    TextView scoreViewP2;
    LinearLayout viewP1Bg;
    LinearLayout viewP2Bg;
    TextView currentScoreView;
    TextView currentMultiplierView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
    }

    private void findViews() {
        scoreViewP1 = (TextView) findViewById(R.id.scoreP1);
        scoreViewP2 = (TextView) findViewById(R.id.scoreP2);
        viewP1Bg = (LinearLayout) findViewById(R.id.player1_bg);
        viewP2Bg = (LinearLayout) findViewById(R.id.player2_bg);
        currentScoreView = (TextView) findViewById(R.id.current_score);
        currentMultiplierView = (TextView) findViewById(R.id.current_multiplier);
    }


    public void updateScore(View view){
        if (player1) {
            updatePlayer1();
        } else {
            updatePlayer2();
        }
    }

    private void updatePlayer1() {
        if (scorePlayer1 - multiplier * currentScore >= 0) {
            scorePlayer1 -= multiplier * currentScore;
        }
        currentScore = 0;
        multiplier = 1;
        scoreViewP1.setText("" + scorePlayer1);
        currentMultiplierView.setText("" + multiplier);
        currentScoreView.setText("" + currentScore);
    }

    private void updatePlayer2() {
        if (scorePlayer2 - multiplier * currentScore >= 0) {
            scorePlayer2 -= multiplier * currentScore;
        }
        currentScore = 0;
        multiplier = 1;
        scoreViewP2.setText("" + scorePlayer2);
        currentMultiplierView.setText("" + multiplier);
        currentScoreView.setText("" + currentScore);
    }

    public void changePlayer(View view) {
        player1 = !player1;
        if (player1) {
            viewP1Bg.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
            viewP2Bg.setBackgroundColor(getResources().getColor(R.color.white));
        } else {
            viewP1Bg.setBackgroundColor(getResources().getColor(R.color.white));
            viewP2Bg.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
        }
    }
    public void resetGame(View view){
        currentScore = 0;
        multiplier = 1;
        player1 = true;
        scorePlayer1 = 501;
        scorePlayer2 = 501;
        scoreViewP1.setText("" + scorePlayer1);
        scoreViewP2.setText("" + scorePlayer2);
        currentMultiplierView.setText("" + multiplier);
        currentScoreView.setText("" + currentScore);
        viewP1Bg.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
        viewP2Bg.setBackgroundColor(getResources().getColor(R.color.white));
    }

    public void setDouble(View view) {
        if (multiplier == 2) {
            multiplier = 1;
        } else{
            multiplier = 2;
        }
        currentMultiplierView.setText("" + multiplier);
    }

    public void setTriple(View view) {
        if (multiplier == 3) {
            multiplier = 1;
        } else{
            multiplier = 3;
        }
        currentMultiplierView.setText("" + multiplier);
    }

    public void setNumber(View view) {
        currentScore = Integer.parseInt(view.getTag().toString());
        currentScoreView.setText("" + currentScore);
    }
}
