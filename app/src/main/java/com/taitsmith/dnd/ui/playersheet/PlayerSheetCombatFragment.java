package com.taitsmith.dnd.ui.playersheet;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;
import com.taitsmith.dnd.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

import static com.taitsmith.dnd.PlayerSheetActivity.playerSheetPlayer;

public class PlayerSheetCombatFragment extends Fragment {
    @BindView(R.id.ac_tv)
    TextView acTextView;
    @BindView(R.id.hp_tv)
    TextView hpTextView;
    @BindView(R.id.initiative_tv)
    TextView initiativeTextView;
    @BindView(R.id.temp_hp_tv)
    TextView tempHpTextView;
    @BindView(R.id.speed_tv)
    TextView speedTextView;
    @BindView(R.id.hit_dice_tv)
    TextView hitDiceTextView;

    private Unbinder unbinder;
    private PlayerSheetCombatViewModel viewModel;

    public static PlayerSheetCombatFragment newInstance() {
        return new PlayerSheetCombatFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_player_sheet_combat, container, false);

        unbinder = ButterKnife.bind(this, view);

        super.onViewCreated(view, savedInstanceState);

        viewModel = new ViewModelProvider(requireActivity()).get(PlayerSheetCombatViewModel.class);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setUI();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }

    public void setUI() {
        acTextView.setText(getString(R.string.armor_class, playerSheetPlayer.getArmorClass()));
        hpTextView.setText(getString(R.string.hp_max_current, playerSheetPlayer.getHpCurrent(),
                playerSheetPlayer.getHpMax()));
        initiativeTextView.setText(getString(R.string.initiative, playerSheetPlayer.getInitiative()));
        tempHpTextView.setText(getString(R.string.hp_temp, playerSheetPlayer.getHpTemp()));
        speedTextView.setText(getString(R.string.speed, playerSheetPlayer.getSpeed()));
        hitDiceTextView.setText(getString(R.string.hit_dice, playerSheetPlayer.getLevel(),
                playerSheetPlayer.getHitDice()));
    }
}