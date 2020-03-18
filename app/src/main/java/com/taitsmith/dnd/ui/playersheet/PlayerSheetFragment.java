package com.taitsmith.dnd.ui.playersheet;

import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.taitsmith.dnd.R;
import com.taitsmith.dnd.objects.Player;
import com.taitsmith.dnd.utils.Stats;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class PlayerSheetFragment extends Fragment {

    @BindView(R.id.str_tv) TextView strTv;
    @BindView(R.id.dex_tv) TextView dexTv;
    @BindView(R.id.con_tv) TextView conTv;
    @BindView(R.id.int_tv) TextView intTv;
    @BindView(R.id.wis_tv) TextView wisTv;
    @BindView(R.id.cha_tv) TextView chaTv;

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

    @SuppressLint("ResourceType")
    private void updateStatViews() {
        String[] statStrings = viewModel.setStatString(Stats.randomStats());

        strTv.setText(statStrings[0]);
        dexTv.setText(statStrings[1]);
        conTv.setText(statStrings[2]);
        intTv.setText(statStrings[3]);
        wisTv.setText(statStrings[4]);
        chaTv.setText(statStrings[5]);

    }
}
