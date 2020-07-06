package com.taitsmith.dnd;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;
import com.taitsmith.dnd.ui.playersheet.PlayerSheetCombatFragment;
import com.taitsmith.dnd.ui.playersheet.PlayerSheetStatsFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PlayerSheetActivity extends FragmentActivity {
   @BindView(R.id.spellcastingButton)
   MaterialButton spellcastingButton;
   @BindView(R.id.combatButton)
   MaterialButton combatButton;
   @BindView(R.id.skillsAbilitiesButton)
   MaterialButton skillsAbilitiesButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.player_sheet_activity);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, PlayerSheetStatsFragment.newInstance())
                    .commitNow();
        }
        ButterKnife.bind(this);
    }

    @OnClick(R.id.combatButton)
    void spellcastingFragment() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, PlayerSheetCombatFragment.newInstance())
                .commitNow();
    }

    @OnClick(R.id.skillsAbilitiesButton)
    void skillsFragment() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, PlayerSheetStatsFragment.newInstance())
                .commitNow();
    }
}
