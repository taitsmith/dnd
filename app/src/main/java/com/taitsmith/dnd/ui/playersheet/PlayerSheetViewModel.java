package com.taitsmith.dnd.ui.playersheet;

import android.widget.TextView;

import androidx.lifecycle.ViewModel;

import com.taitsmith.dnd.objects.Player;
import com.taitsmith.dnd.utils.Stats;

import java.util.List;

public class PlayerSheetViewModel extends ViewModel {
    private List<TextView> statViews;

    public void setStats(Player player) {
        int[] stats = Stats.randomStats();

        player.setStr(stats[0]);
        player.setDex(stats[1]);
        player.setCha(stats[2]);
        player.setIntel(stats[3]);
        player.setWis(stats[4]);
        player.setCha(stats[5]);
    }

}
