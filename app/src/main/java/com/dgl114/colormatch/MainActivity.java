package com.dgl114.colormatch;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;


public class MainActivity extends AppCompatActivity {

    private final String GAME_STATE = "gameState";
    private LightsOutGame mGame;
    private Button[][] mButtons;
    private int mOnColor;
    private int mOffColor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mOnColor = ContextCompat.getColor(this, R.color.yellow);
        mOffColor = ContextCompat.getColor(this, R.color.black);

        mButtons = new Button[LightsOutGame.NUM_ROWS][LightsOutGame.NUM_COLS];

        GridLayout gridLayout = findViewById(R.id.light_grid);
        int childIndex = 0;
        for (int row = 0; row < LightsOutGame.NUM_ROWS; row++) {
            for (int col = 0; col < LightsOutGame.NUM_COLS; col++) {
                mButtons[row][col] = (Button) gridLayout.getChildAt(childIndex);
                childIndex++;
            }
        }

        mGame = new LightsOutGame();
        if (savedInstanceState == null) {
            startGame();
        }
        else {
            String gameState = savedInstanceState.getString(GAME_STATE);
            mGame.setState(gameState);
            setButtonColors();
        }
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(GAME_STATE, mGame.getState());
    }


    private void startGame() {
        mGame.newGame();
        setButtonColors();
    }

    public void onLightButtonClick(View view) {
        // Find the row and col selected
        boolean buttonFound = false;
        for (int row = 0; row < LightsOutGame.NUM_ROWS && !buttonFound; row++) {
            for (int col = 0; col < LightsOutGame.NUM_COLS && !buttonFound; col++) {
                if (view == mButtons[row][col]) {
                    mGame.selectLight(row, col);
                    buttonFound = true;
                }
            }
        }

        setButtonColors();

        // Congratulate the user if the game is over
        if (mGame.isGameOver()) {
            Toast.makeText(this, R.string.congrats, Toast.LENGTH_SHORT).show();
        }
    }

    private void setButtonColors() {

        // Set all buttons' background color
        for (int row = 0; row < LightsOutGame.NUM_ROWS; row++) {
            for (int col = 0; col < LightsOutGame.NUM_COLS; col++) {
                if (mGame.isLightOn(row, col)) {
                    mButtons[row][col].setBackgroundColor(mOnColor);
                } else {
                    mButtons[row][col].setBackgroundColor(mOffColor);
                }
            }
        }
    }

    public void onNewGameClick(View view) {
        startGame();
    }
}