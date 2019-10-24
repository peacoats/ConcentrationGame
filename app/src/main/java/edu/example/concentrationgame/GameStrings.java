package edu.example.concentrationgame;

import android.content.Context;
import android.graphics.Point;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class GameStrings extends GridLayout {
    private Button[] button;
    private String[] list;
    private Button playButton;
    private Button resetButton;
    private static final int NONE = -1;
    private int p1score;
    private int p2score;
    private Random rgen;

    public GameStrings(AppCompatActivity context, OnClickListener ocl) {
        super(context);
        this.setColumnCount(4);
        this.setRowCount(7);
        list = new String[20];
        list[0] = "Luke Skywalker";
        list[1] = "Luke Skywalker";
        list[2] = "Leia Organa";
        list[3] = "Leia Organa";
        list[4] = "Darth Vader";
        list[5] = "Darth Vader";
        list[6] = "Han Solo";
        list[7] = "Han Solo";
        list[8] = "Chewbacca";
        list[9] = "Chewbacca";
        list[10] = "Yoda";
        list[11] = "Yoda";
        list[12] = "Obi Wan Kenobi";
        list[13] = "Obi Wan Kenobi";
        list[14] = "Jabba the Hutt";
        list[15] = "Jabba the Hutt";
        list[16] = "R2D2";
        list[17] = "R2D2";
        list[18] = "Boba Fett";
        list[19] = "Boba Fett";
        Point size = new Point();
        context.getWindowManager().getDefaultDisplay().getSize(size);
        int width = size.x / 4;
        button = new Button[20];
        for (int i = 0; i < 20; i++) {
            button[i] = new Button(context);
            button[i].setOnClickListener(ocl);
            button[i].setEnabled(false);
            this.addView(button[i], width, width);
        }
        playButton = new Button(context);
        playButton.setOnClickListener(ocl);
        playButton.setText("PLAY");
        this.addView(playButton, width, width);

        resetButton = new Button(context);
        resetButton.setOnClickListener(ocl);
        resetButton.setText("Reset");
        this.addView(resetButton, width, width);

        TextView blank1 = new TextView(context);
        blank1.setText("");
        this.addView(blank1, width, width);
        TextView blank2 = new TextView(context);
        blank2.setText("");
        this.addView(blank2, width, width);
        TextView p1tv = new TextView(context);
        p1tv.setText("Player 1");
        this.addView(p1tv, width, width);
        TextView p1numtv = new TextView(context);
        p1numtv.setText(p1score + "");
        this.addView(p1numtv, width, width);
        TextView p2tv = new TextView(context);
        p2tv.setText("Player 2");
        this.addView(p2tv, width, width);
        TextView p2numtv = new TextView(context);
        p2numtv.setText(p2score + "");
        this.addView(p2numtv, width, width);

    }

    public int matchp1(int buttonIndex) {
        if (button[buttonIndex].getText().equals(button[buttonIndex].getText())) {
            p1score = p1score + 1;
        }
        return p1score;
    }
    public int matchp2(int buttonIndex) {
        if (button[buttonIndex].getText().equals(button[buttonIndex].getText())) {
            p2score = p2score + 1;
        }
        return p2score;
    }

    public void enable() {
        for (int i = 0; i < 20; i++) {
            button[i].setEnabled(true);
        }
    }

    public void disable() {
        for (int i = 0; i < 20; i++) {
            button[i].setEnabled(false);
        }
    }

    public void shuffle() {
        rgen = new Random();
        int rand = rgen.nextInt(20);
        for (int i = 0; i < 19; i++) {
            String temp;
            temp = list[i];
            list[i] = list[rand];
            list[rand] = temp;
        }
    }

    public void text(int buttonIndex) {
        int n = 1;
        button[buttonIndex].setText(list[buttonIndex]);
    }

    public void detext(int buttonIndex) {
        int n = 0;
        button[buttonIndex].setText("");
    }

    public void onoff(int buttonIndex) {
        if (button[buttonIndex].getText().equals("")) {
            text(buttonIndex);
        } else {
            detext(buttonIndex);
        }
    }

    public boolean isPlayButton(Button b) {
        return b == playButton;
    }

    public boolean isResetButton(Button b) {
        return b == resetButton;
    }

    public int whichButton(Button b) {
        for (int index = 0; index < 20; index++) {
            if (b == button[index]) {
                return index;
            }
        }
        return NONE;
    }
}
