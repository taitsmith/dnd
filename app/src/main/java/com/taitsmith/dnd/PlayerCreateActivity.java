package com.taitsmith.dnd;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.taitsmith.dnd.ui.playercreate.PlayerCreateFragment;

public class PlayerCreateActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.player_create_activity);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, PlayerCreateFragment.newInstance())
                    .commitNow();
        }
    }
}
