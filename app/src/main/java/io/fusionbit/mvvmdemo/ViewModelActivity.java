package io.fusionbit.mvvmdemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import viewmodel.ViewModel;

/**
 * Created by rutvik on 11/27/2016 at 7:59 PM.
 */

public abstract class ViewModelActivity extends AppCompatActivity
{

    private static final String EXTRA_VIEW_MODEL_STATE = "viewModelState";

    private ViewModel viewModel;


    @Nullable
    protected abstract ViewModel createViewModel(@Nullable ViewModel.State savedViewModelState);

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        ViewModel.State savedViewModelState = null;

        if (savedInstanceState != null)
        {
            savedViewModelState = savedInstanceState.getParcelable(EXTRA_VIEW_MODEL_STATE);
        }

        viewModel = createViewModel(savedViewModelState);

    }

    @Override
    protected void onStart()
    {
        super.onStart();
        if (viewModel != null)
        {
            viewModel.onStart();
        }
    }


    @Override
    protected void onSaveInstanceState(Bundle outState)
    {
        super.onSaveInstanceState(outState);
        if (viewModel != null)
        {
            outState.putParcelable(EXTRA_VIEW_MODEL_STATE, viewModel.getInstanceState());
        }
    }

    @Override
    protected void onStop()
    {
        super.onStop();
        if (viewModel != null)
        {
            viewModel.onStop();
        }
    }
}


