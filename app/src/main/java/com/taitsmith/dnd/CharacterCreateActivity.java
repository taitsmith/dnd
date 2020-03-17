package com.taitsmith.dnd;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.taitsmith.dnd.ui.charactercreate.CharacterCreateFragment;

public class CharacterCreateActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.character_create_activity);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, CharacterCreateFragment.newInstance())
                    .commitNow();
        }
    }
}
