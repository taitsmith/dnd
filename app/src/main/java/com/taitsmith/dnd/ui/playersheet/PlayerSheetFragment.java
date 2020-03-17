package com.taitsmith.dnd.ui.playersheet;

import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.taitsmith.dnd.R;
import com.taitsmith.dnd.objects.Player;

public class PlayerSheetFragment extends Fragment {

    private PlayerSheetViewModel viewModel;
    private Player player;

    public static PlayerSheetFragment newInstance() {
        return new PlayerSheetFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.player_sheet_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        player = new Player();

        super.onViewCreated(view, savedInstanceState);
        viewModel = new ViewModelProvider(requireActivity()).get(PlayerSheetViewModel.class);
        viewModel.setStats(player);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        viewModel = ViewModelProviders.of(this).get(PlayerSheetViewModel.class);
        // TODO: Use the ViewModel
    }

}
