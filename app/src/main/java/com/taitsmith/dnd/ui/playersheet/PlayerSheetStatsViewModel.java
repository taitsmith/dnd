package com.taitsmith.dnd.ui.playersheet;

import android.app.Application;
import android.content.res.Resources;

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
    String[] setStatString(int[] stats) {
        Resources res = getApplication().getResources();
        String[] statNames = res.getStringArray(R.array.stats);
        String[] returnStrings = new String[6];

        for (int i = 0; i < statNames.length; i++) {
            int j = getResId(statNames[i], R.string.class);
            returnStrings[i] = String.format(res.getString(j), stats[i], Stats.getMod(stats[i]));
        }
        return returnStrings;
    }

    //thanks macarse on SO for this snippet
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