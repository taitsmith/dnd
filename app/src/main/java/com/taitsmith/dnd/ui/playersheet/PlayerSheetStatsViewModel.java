package com.taitsmith.dnd.ui.playersheet;

import android.app.Application;
import android.content.res.Resources;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.taitsmith.dnd.R;

import java.lang.reflect.Field;

import static com.taitsmith.dnd.PlayerSheetActivity.playerSheetPlayer;
import static com.taitsmith.dnd.utils.Stats.getMod;

public class PlayerSheetStatsViewModel extends AndroidViewModel {

    public PlayerSheetStatsViewModel(@NonNull Application application) {
        super(application);
    }

    //sets the string for the stat blocks
    String[] getStatStrings() {
        String[] returnStrings = new String[6];
        Resources res = getApplication().getResources();

        returnStrings[0] = res.getString(R.string.strength, playerSheetPlayer.getStr(),
                getMod(playerSheetPlayer.getStr()));
        returnStrings[1] = res.getString(R.string.dexterity, playerSheetPlayer.getDex(),
                getMod(playerSheetPlayer.getDex()));
        returnStrings[2] = res.getString(R.string.constitution, playerSheetPlayer.getCon(),
                getMod(playerSheetPlayer.getCon()));
        returnStrings[3] = res.getString(R.string.intelligence, playerSheetPlayer.getIntel(),
                getMod(playerSheetPlayer.getIntel()));
        returnStrings[4] = res.getString(R.string.wisdom, playerSheetPlayer.getWis(),
                getMod(playerSheetPlayer.getWis()));
        returnStrings[5] = res.getString(R.string.charisma, playerSheetPlayer.getCha(),
                getMod(playerSheetPlayer.getCha()));

        return returnStrings;
    }

    String[] getSkillStrings() {
        Resources res = getApplication().getResources();
        String[] skills = res.getStringArray(R.array.skills);

        String[] returnString = new String[skills.length];

        for (int i = 0; i < skills.length; i++) {
            int j = getResId(skills[i], R.string.class);
            returnString[i] = res.getString(j);

            Log.d("SKILLS ", returnString[i]);
        }

        return returnString;
    }



    //thanks macarse on SO for this snippet
    //get R.string.foo as an int so we can can getString()
    //should be way easier than this right?
    private int getResId(String name, Class<?> c) {
        try {
            Field idField = c.getDeclaredField(name);
            return idField.getInt(idField);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }
}