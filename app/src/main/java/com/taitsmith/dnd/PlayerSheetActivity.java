package com.taitsmith.dnd;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.taitsmith.dnd.ui.playersheet.PlayerSheetFragment;

public class PlayerSheetActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.player_sheet_activity);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, PlayerSheetFragment.newInstance())
                    .commitNow();
        }
    }
}
