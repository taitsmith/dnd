package com.taitsmith.dnd.ui.playersheet;

import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;
import com.taitsmith.dnd.R;
import com.taitsmith.dnd.objects.Player;
import com.taitsmith.dnd.utils.Stats;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

import static com.taitsmith.dnd.utils.Stats.diceRoll;
import static com.taitsmith.dnd.utils.Stats.getMod;

public class PlayerSheetFragment extends Fragment {

    @BindView(R.id.str_tv) TextView strTv;
    @BindView(R.id.dex_tv) TextView dexTv;
    @BindView(R.id.con_tv) TextView conTv;
    @BindView(R.id.int_tv) TextView intTv;
    @BindView(R.id.wis_tv) TextView wisTv;
    @BindView(R.id.cha_tv) TextView chaTv;

    //@BindView(R.id.charsheet_pager) ViewPager2 pager2;
    //@BindView(R.id.charsheet_tabs) TabLayout tabLayout;

    private PlayerSheetViewModel viewModel;
    private Player player;
    private Unbinder unbinder;

    public static PlayerSheetFragment newInstance() {
        return new PlayerSheetFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.player_sheet_fragment, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        player = new Player();

        super.onViewCreated(view, savedInstanceState);
        viewModel = new ViewModelProvider(requireActivity()).get(PlayerSheetViewModel.class);
        viewModel.setStats(player);
        updateStatViews();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        viewModel = ViewModelProviders.of(this).get(PlayerSheetViewModel.class);
        // TODO: Use the ViewModel

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    //method exists as is for dev purposes only, will be changed in the future to reflect actual use
    @SuppressLint("ResourceType")
    private void updateStatViews() {
        int[] playerStats = Stats.randomStats();
        String[] statStrings = viewModel.setStatString(playerStats);


        player.setStr(playerStats[0]);
        player.setDex(playerStats[1]);
        player.setCon(playerStats[2]);
        player.setIntel(playerStats[3]);
        player.setWis(playerStats[4]);
        player.setCha(playerStats[5]);

        //is it faster to do it this way or player.get$STAT?
        //TODO find out
        strTv.setText(statStrings[0]);
        dexTv.setText(statStrings[1]);
        conTv.setText(statStrings[2]);
        intTv.setText(statStrings[3]);
        wisTv.setText(statStrings[4]);
        chaTv.setText(statStrings[5]);
    }

    @OnClick(R.id.str_tv)
    public void strCheck() {
        showResult(diceRoll(20, 1, getMod(player.getStr())));
    }

    @OnClick(R.id.dex_tv)
    public void dexCheck(){
        showResult(diceRoll(20, 1, getMod(player.getDex())));
    }

    @OnClick(R.id.con_tv)
    public void conCheck() {
        showResult(diceRoll(20, 1, getMod(player.getCon())));
    }

    @OnClick(R.id.int_tv)
    public void intCheck() {
        showResult(diceRoll(20, 1, getMod(player.getIntel())));
    }

    @OnClick(R.id.wis_tv)
    public void wisCheck() {
        showResult(diceRoll(20, 1, getMod(player.getWis())));
    }

    @OnClick(R.id.cha_tv)
    public void chaCheck() {
        showResult(diceRoll(20, 1, getMod(player.getCha())));
    }


    //diceRoll() returns an array but we'll only show the user the result in a toast.
    //TODO more detailed logs that will show each die, modifier and total
    private void showResult(int[] result) {
        String s = String.format(getResources().getString(R.string.roll_result), result[result.length - 1]);
        Toast.makeText(viewModel.getApplication(), s, Toast.LENGTH_SHORT).show();
    }


}
