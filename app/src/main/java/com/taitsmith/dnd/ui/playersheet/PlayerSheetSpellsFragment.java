package com.taitsmith.dnd.ui.playersheet;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.taitsmith.dnd.R;

public class PlayerSheetSpellsFragment extends Fragment {

    private PlayerSheetSpellsViewModel mViewModel;

    public static PlayerSheetSpellsFragment newInstance() {
        return new PlayerSheetSpellsFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_player_sheet_spells, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(PlayerSheetSpellsViewModel.class);
        // TODO: Use the ViewModel
    }

}