package com.strangeapp.tictactoe;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Arrays;

public class Game extends AppCompatActivity {
    public static boolean game_key = true;

    public static int[] cell_status = { 0, 0, 0, 0, 0, 0, 0, 0, 0 };
    // O --> -1
    // empty --> 0
    // x --> 1

    final int[][] win_positions = {
            { 0, 1, 2 }, { 3, 4, 5 }, { 6, 7, 8 },
            { 0, 3, 6 }, { 1, 4, 7 }, { 2, 5, 8 },
            { 0, 4, 8 }, { 6, 4, 2 }
    };

    static int turn = 1;
    static int moves_left = 9;

    public void win_condition(TextView status) {
        if (moves_left >= 0) {
            for (int i = 0; i < 8; i++) {
                if (cell_status[win_positions[i][0]] != 0 &&
                        cell_status[win_positions[i][0]] == cell_status[win_positions[i][1]] &&
                        cell_status[win_positions[i][0]] == cell_status[win_positions[i][2]]) {

                    if (cell_status[win_positions[i][0]] == -1) {
                        status.setText("O wins - Tap to reset game");
                    } else {
                        status.setText("X wins - Tap to reset game");
                    }
                    turn = 0;
                    game_key = false;
                    break;
                }
            }

            if (moves_left==0&&game_key==true) {
                status.setText("Draw - Tap to reset game");
                turn = 0;
            }}
    }

    public void reset(View view) {
        if (turn == 0) {
            Arrays.fill(cell_status, 0);

            ((ImageView) findViewById(R.id.tap0)).setImageResource(0);
            ((ImageView) findViewById(R.id.tap1)).setImageResource(0);
            ((ImageView) findViewById(R.id.tap2)).setImageResource(0);
            ((ImageView) findViewById(R.id.tap3)).setImageResource(0);
            ((ImageView) findViewById(R.id.tap4)).setImageResource(0);
            ((ImageView) findViewById(R.id.tap5)).setImageResource(0);
            ((ImageView) findViewById(R.id.tap6)).setImageResource(0);
            ((ImageView) findViewById(R.id.tap7)).setImageResource(0);
            ((ImageView) findViewById(R.id.tap8)).setImageResource(0);

            turn = 1;
            moves_left = 9;
            game_key=true;

            TextView status = findViewById(R.id.status);
            status.setText("X's Turn - Tap to play");

        }
    }
}
