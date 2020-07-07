package com.taitsmith.dnd;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;

import com.google.android.material.button.MaterialButton;
import com.taitsmith.dnd.objects.Player;
import com.taitsmith.dnd.ui.playersheet.PlayerSheetCombatFragment;
import com.taitsmith.dnd.ui.playersheet.PlayerSheetStatsFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.exceptions.RealmMigrationNeededException;

import static com.taitsmith.dnd.utils.CreatePlayer.randomPlayer;

public class PlayerSheetActivity extends FragmentActivity {
   @BindView(R.id.spellcastingButton)
   MaterialButton spellcastingButton;
   @BindView(R.id.combatButton)
   MaterialButton combatButton;
   @BindView(R.id.skillsAbilitiesButton)
   MaterialButton skillsAbilitiesButton;

   public static Player playerSheetPlayer;

    Realm realm;
    Unbinder unbinder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.player_sheet_activity);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, PlayerSheetStatsFragment.newInstance())
                    .commitNow();
        }
        unbinder = ButterKnife.bind(this);

        RealmConfiguration configuration = new RealmConfiguration.Builder()
                .deleteRealmIfMigrationNeeded()
                .build();

        realm = Realm.getInstance(configuration);

        //TODO random player, remove
        randomPlayer(this, realm);
        playerSheetPlayer = realm.where(Player.class)
                .equalTo("name", "Greg")
                .findFirstAsync();
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

    @Override
    protected void onDestroy() {
        super.onDestroy();
        realm.deleteAll();
        realm.close();
        unbinder.unbind();
    }
}
