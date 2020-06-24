package com.taitsmith.dnd;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;

import com.taitsmith.dnd.ui.playersheet.PlayerSheetStatsFragment;

public class PlayerSheetActivity extends FragmentActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.player_sheet_activity);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, PlayerSheetStatsFragment.newInstance())
                    .commitNow();
        }

    }
}
