package io.fusionbit.mvvmdemo;

import android.os.Bundle;
import android.support.annotation.Nullable;

import butterknife.ButterKnife;
import butterknife.OnClick;
import viewmodel.InitialViewModel;
import viewmodel.ViewModel;

public class ActivityInitial extends ViewModelActivity
{

    private InitialViewModel initialViewModel;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_initial);

        ButterKnife.bind(this);
    }

    @Nullable
    @Override
    protected ViewModel createViewModel(@Nullable ViewModel.State savedViewModelState)
    {
        initialViewModel = new InitialViewModel(savedViewModelState);
        return initialViewModel;
    }

    @OnClick(R.id.btn_openHome)
    void startHomeActivity()
    {
        initialViewModel.onHomeButtonClick(this);
    }

}
