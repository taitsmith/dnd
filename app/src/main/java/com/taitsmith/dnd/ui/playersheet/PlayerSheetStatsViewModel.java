package com.taitsmith.dnd.ui.playersheet;

import android.app.Application;
import android.content.res.Resources;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.taitsmith.dnd.R;
import com.taitsmith.dnd.objects.Player;
import com.taitsmith.dnd.utils.Stats;

import java.lang.reflect.Field;

public class PlayerSheetStatsViewModel extends AndroidViewModel {

    public PlayerSheetStatsViewModel(@NonNull Application application) {
        super(application);
    }

    void setStats(Player player) {
        int[] stats = Stats.randomStats();

        player.setStr(stats[0]);
        player.setDex(stats[1]);
        player.setCha(stats[2]);
        player.setIntel(stats[3]);
        player.setWis(stats[4]);
        player.setCha(stats[5]);
    }

    //TODO there's fur sure an easier way to do this
    //sets the string for the stat blocks
    String[] getStatStrings(int[] stats) {
        Resources res = getApplication().getResources();
        String[] statNames = res.getStringArray(R.array.stats);
        String[] returnStrings = new String[6];

        for (int i = 0; i < statNames.length; i++) {
            int j = getResId(statNames[i], R.string.class);
            returnStrings[i] = String.format(res.getString(j), stats[i], Stats.getMod(stats[i]));
        }
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