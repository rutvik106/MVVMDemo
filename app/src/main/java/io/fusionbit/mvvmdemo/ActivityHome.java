package io.fusionbit.mvvmdemo;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;

import butterknife.ButterKnife;
import butterknife.OnClick;
import io.fusionbit.mvvmdemo.databinding.ActivityHomeBinding;
import viewmodel.HomeViewModel;
import viewmodel.ViewModel;

public class ActivityHome extends ViewModelActivity
{

    private HomeViewModel homeViewModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        ActivityHomeBinding binding =
                DataBindingUtil.setContentView(this, R.layout.activity_home);

        binding.setViewModel(homeViewModel);

        ButterKnife.bind(this);

    }

    @Nullable
    @Override
    protected ViewModel createViewModel(@Nullable ViewModel.State savedViewModelState)
    {
        homeViewModel = new HomeViewModel(this, savedViewModelState);
        return homeViewModel;
    }


    @OnClick(R.id.btn_count)
    void onCountButtonClicked()
    {
        homeViewModel.onCountButtonPress();
    }

}
