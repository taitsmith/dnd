package com.taitsmith.dnd.ui.playercreate;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.taitsmith.dnd.R;

public class CharacterCreateFragment extends Fragment {

    private CharacterCreateViewModel mViewModel;

    public static CharacterCreateFragment newInstance() {
        return new CharacterCreateFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.player_create_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(CharacterCreateViewModel.class);
        // TODO: Use the ViewModel
    }

}
