package com.strangeapp.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import android.widget.ImageView;
import android.widget.Toast;

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
        int cell_pos = Integer.parseInt(img.getTag().toString());

        // check weather cell is empty or not
        if (cell_status[cell_pos] == 0) {
            if (turn != 0) {
                if (turn == 1) {
                    img.setImageResource(R.drawable.x);
                    cell_status[cell_pos] = 1;
                    turn = -1;
                    moves_left--;
                } else if (turn == -1) {
                    img.setImageResource(R.drawable.o);
                    cell_status[cell_pos] = -1;
                    turn = 1;
                    moves_left--;
                }

                win_condition();

            } else {
                Toast.makeText(MainActivity.this, "reset the game", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(MainActivity.this, "error", Toast.LENGTH_SHORT).show();
        }
    }

    public void win_condition() {
        if (moves_left > 0) {
            for (int i = 0; i < 8; i++) {
                if (cell_status[win_positions[i][0]] != 0 &&
                        cell_status[win_positions[i][0]] == cell_status[win_positions[i][1]] &&
                        cell_status[win_positions[i][0]] == cell_status[win_positions[i][0]]) {
                    Toast.makeText(MainActivity.this, "win", Toast.LENGTH_SHORT).show();
                    turn = 0;
                    break;
                }
            }
        } else {
            Toast.makeText(MainActivity.this, "it's draw", Toast.LENGTH_SHORT).show();

        }

    }
}