package io.fusionbit.mvvmdemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import viewmodel.ViewModel;

/**
 * Created by rutvik on 11/27/2016 at 8:39 PM.
 */

public abstract class ViewModelFragment extends Fragment
{

    private static final String EXTRA_VIEW_MODEL_STATE = "viewModelState";

    private ViewModel viewModel;

    @Nullable
    protected abstract ViewModel createViewModel(@Nullable ViewModel.State savedViewModelState);

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState)
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
    public void onStart()
    {
        super.onStart();
        if (viewModel != null)
        {
            viewModel.onStart();
        }
    }


    @Override
    public void onSaveInstanceState(Bundle outState)
    {
        super.onSaveInstanceState(outState);
        if (viewModel != null)
        {
            outState.putParcelable(EXTRA_VIEW_MODEL_STATE, viewModel.getInstanceState());
        }
    }


    @Override
    public void onStop()
    {
        super.onStop();
        if (viewModel != null)
        {
            viewModel.onStop();
        }
    }
}
