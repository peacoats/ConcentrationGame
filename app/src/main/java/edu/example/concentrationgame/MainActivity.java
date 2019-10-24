package edu.example.concentrationgame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private GameStrings gs;
    private ButtonHandler bh;
    private int currentButton = NONE;
    private int lastbutton = NONE;
    private static final int NONE = -1;
    private boolean buttonClicked = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bh = new ButtonHandler();
        gs = new GameStrings(this, bh);
        setContentView(gs);
    }

    private class ButtonHandler implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            Button clicked = (Button) view;
            String clickedTxt = (String) clicked.getText().toString();
            if (gs.isPlayButton(clicked)) {
                gs.shuffle();
                gs.enable();
            } else if (gs.isResetButton(clicked)) {
                for (int i = 0; i < 20; i++) {
                    gs.detext(i);
                    gs.disable();
                }
                gs.shuffle();
            } else {
                currentButton = gs.whichButton(clicked);
                gs.onoff(currentButton);
                gs.matchp1(currentButton);
                gs.matchp2(currentButton);
            }
        }
    }
}
