package com.taitsmith.dnd.ui.playersheet;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.Snackbar;
import com.taitsmith.dnd.R;
import com.taitsmith.dnd.utils.SkillAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

import static com.taitsmith.dnd.PlayerSheetActivity.playerSheetPlayer;
import static com.taitsmith.dnd.utils.Stats.diceRoll;
import static com.taitsmith.dnd.utils.Stats.getMod;

public class PlayerSheetStatsFragment extends Fragment {

    @BindView(R.id.mainCharName) TextView nameTv;
    @BindView(R.id.level_class_textview) TextView levelClassTv;
    @BindView(R.id.str_tv) TextView strTv;
    @BindView(R.id.dex_tv) TextView dexTv;
    @BindView(R.id.con_tv) TextView conTv;
    @BindView(R.id.int_tv) TextView intTv;
    @BindView(R.id.wis_tv) TextView wisTv;
    @BindView(R.id.cha_tv) TextView chaTv;
    @BindView(R.id.skill_list)
    ListView skillListView;

    PlayerSheetStatsViewModel viewModel;
    private Unbinder unbinder;

    String[] skills;
    String[] statStrings;
    SkillAdapter adapter;

    public static PlayerSheetStatsFragment newInstance() {
        return new PlayerSheetStatsFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_player_sheet_skills_abilities, container, false);
        super.onViewCreated(view, savedInstanceState);

        unbinder = ButterKnife.bind(this, view);

        viewModel = new ViewModelProvider(requireActivity()).get(PlayerSheetStatsViewModel.class);
        statStrings = viewModel.getStatStrings();
        skills = viewModel.getSkillStrings();

        adapter = new SkillAdapter(getContext(), skills);

        skillListView.setAdapter(adapter);
        skillListView.setOnItemClickListener((adapterView, view1, i, l) -> {
            Toast.makeText(getContext(), skills[i], Toast.LENGTH_SHORT).show();
        });

        updateStatViews();
        nameTv.setText(playerSheetPlayer.getName());
        levelClassTv.setText(getString(R.string.level_class_alignment, playerSheetPlayer.getLevel(),
                playerSheetPlayer.getAlignment(), playerSheetPlayer.getClazz()));

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @SuppressLint("ResourceType")
    private void updateStatViews() {
        strTv.setText(statStrings[0]);
        dexTv.setText(statStrings[1]);
        conTv.setText(statStrings[2]);
        intTv.setText(statStrings[3]);
        wisTv.setText(statStrings[4]);
        chaTv.setText(statStrings[5]);
    }

    @OnClick(R.id.str_tv)
    public void strCheck() {
        showResult(diceRoll(20, 1,
                getMod(playerSheetPlayer.getStr())));
    }

    @OnClick(R.id.dex_tv)
    public void dexCheck(){
        showResult(diceRoll(20, 1,
                getMod(playerSheetPlayer.getDex())));
    }

    @OnClick(R.id.con_tv)
    public void conCheck() {
        showResult(diceRoll(20, 1,
                getMod(playerSheetPlayer.getCon())));
    }

    @OnClick(R.id.int_tv)
    public void intCheck() {
        showResult(diceRoll(20, 1,
                getMod(playerSheetPlayer.getIntel())));
    }

    @OnClick(R.id.wis_tv)
    public void wisCheck() {
        showResult(diceRoll(20, 1,
                getMod(playerSheetPlayer.getWis())));
    }

    @OnClick(R.id.cha_tv)
    public void chaCheck() {
        showResult(diceRoll(20, 1,
                getMod(playerSheetPlayer.getCha())));
    }


    //diceRoll() returns an array but we'll only show the user the result in a toast.
    //TODO more detailed logs that will show each die, modifier and total
    private void showResult(int[] result) {
        String s = String.format(getResources().getString(R.string.roll_result), result[result.length - 1]);
        Toast.makeText(getContext(), s, Toast.LENGTH_SHORT).show();



    }
}
