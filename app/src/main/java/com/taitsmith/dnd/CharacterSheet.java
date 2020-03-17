package com.taitsmith.dnd;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.taitsmith.dnd.ui.charactersheet.CharacterSheetFragment;

public class CharacterSheet extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.character_sheet_activity);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, CharacterSheetFragment.newInstance())
                    .commitNow();
        }
    }
}
