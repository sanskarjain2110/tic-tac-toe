package com.strangeapp.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void user_click(View view) {
        ImageView img = (ImageView) view;
        TextView status = findViewById(R.id.status);
        int cell_pos = Integer.parseInt(img.getTag().toString());

        // check weather cell is empty or not
        if (cell_status[cell_pos] == 0) {
            if (turn != 0) {
                if (turn == 1) {
                    img.setImageResource(R.drawable.x);
                    cell_status[cell_pos] = 1;
                    turn = -1;
                    status.setText("O's Turn - Tap to play");
                    moves_left--;
                } else if (turn == -1) {
                    img.setImageResource(R.drawable.o);
                    cell_status[cell_pos] = -1;
                    turn = 1;
                    status.setText("X's Turn - Tap to play");
                    moves_left--;
                }

                win_condition(status);

            } else {
                Toast.makeText(MainActivity.this, "reset the game", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(MainActivity.this, "error", Toast.LENGTH_SHORT).show();
        }
    }

    public void win_condition(TextView status) {
        if (moves_left > 0) {
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
                    break;
                }
            }
        } else {
            status.setText("Draw - Tap to reset game");
            turn = 0;
        }
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

           TextView status = findViewById(R.id.status);
           status.setText("X's Turn - Tap to play");

       }
   }
}