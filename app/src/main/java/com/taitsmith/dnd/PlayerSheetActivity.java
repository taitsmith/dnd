package com.taitsmith.dnd;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;
import android.util.Log;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.taitsmith.dnd.objects.Player;
import com.taitsmith.dnd.objects.Spell;
import com.taitsmith.dnd.ui.playersheet.PlayerSheetCombatFragment;
import com.taitsmith.dnd.ui.playersheet.PlayerSheetSpellsFragment;
import com.taitsmith.dnd.ui.playersheet.PlayerSheetStatsFragment;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import io.realm.Realm;
import io.realm.RealmConfiguration;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

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
    RealmConfiguration configuration;

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

         configuration = new RealmConfiguration.Builder()
                .deleteRealmIfMigrationNeeded()
                .build();

        realm = Realm.getInstance(configuration);

        //TODO random player, remove
        randomPlayer(this, realm);
        playerSheetPlayer = realm.where(Player.class)
                .equalTo("name", "Greg")
                .findFirst();

        testNet();
    }

    @OnClick(R.id.combatButton)
    void combatHpFragment() {
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

    @OnClick(R.id.spellcastingButton)
    void spellsFragment() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, PlayerSheetSpellsFragment.newInstance())
                .commitNow();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        realm.deleteAll();
        realm.close();
        unbinder.unbind();
    }


    //all just testing stuff for network and api calls
    //TODO move
    private void testNet() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                OkHttpClient client = new OkHttpClient();
                Realm realm1 = Realm.getInstance(configuration);
                Request request = new Request.Builder()
                        .url("https://www.dnd5eapi.co/api/spells/acid-arrow")
                        .build();

                try (Response response = client.newCall(request).execute()) {
                    realm1.beginTransaction();
                    Spell spell = realm1.createObjectFromJson(Spell.class, response.body().string());
                    Log.d("REALM JSON TEST", spell.getName());
                    realm1.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
