package com.strangeapp.tictactoe;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;

public class PVP extends Game {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pvp);
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
                Toast.makeText(PVP.this, "reset the game", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(PVP.this, "error", Toast.LENGTH_SHORT).show();
        }
    }
}