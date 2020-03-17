package com.taitsmith.dnd;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import com.taitsmith.dnd.ui.main.MainFragment;
import com.taitsmith.dnd.ui.main.MainViewModel;
import com.taitsmith.dnd.utils.Stats;

public class MainActivity extends AppCompatActivity {
    MainViewModel viewModel;

    int[] stats;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        viewModel = new ViewModelProvider(this).get(MainViewModel.class);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, MainFragment.newInstance())
                    .commitNow();
        }
        stats = Stats.randomStats();
    }
}
