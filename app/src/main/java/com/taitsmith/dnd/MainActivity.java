package com.taitsmith.dnd;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import com.taitsmith.dnd.ui.main.MainFragment;
import com.taitsmith.dnd.ui.main.MainViewModel;

public class MainActivity extends AppCompatActivity {
    MainViewModel viewModel;

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
    }
}
