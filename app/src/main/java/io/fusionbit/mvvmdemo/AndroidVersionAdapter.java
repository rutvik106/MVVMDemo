package io.fusionbit.mvvmdemo;

import android.databinding.ViewDataBinding;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import adapters.RecyclerViewAdapter;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.fusionbit.mvvmdemo.databinding.ItemAndroidVersionBinding;
import models.AndroidVersion;

/**
 * Created by rutvik on 12/13/2016 at 9:04 AM.
 */

public class AndroidVersionAdapter extends RecyclerViewAdapter<AndroidVersion, AndroidVersionItemViewModel>
{

    @Override
    public AndroidVersionViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_android_version, parent, false);

        AndroidVersionItemViewModel viewModel = new AndroidVersionItemViewModel();

        ItemAndroidVersionBinding binding = ItemAndroidVersionBinding.bind(view);
        binding.setViewModel(viewModel);

        return new AndroidVersionViewHolder(view, binding, viewModel);
    }


    public void setItems(ArrayList<AndroidVersion> newItems)
    {
        items.clear();
        items.addAll(newItems);
        notifyDataSetChanged();
    }


    public ArrayList<AndroidVersion> getItems()
    {
        return items;
    }


    static class AndroidVersionViewHolder
            extends ItemViewHolder<AndroidVersion, AndroidVersionItemViewModel>
    {

        public AndroidVersionViewHolder(View itemView, ViewDataBinding binding,
                                        AndroidVersionItemViewModel viewModel)
        {
            super(itemView, binding, viewModel);
            ButterKnife.bind(this, itemView);
        }


        @OnClick(R.id.versionItem)
        void onClickVersionItem()
        {
            viewModel.onClick();
        }


    }


}
