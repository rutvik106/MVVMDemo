package io.fusionbit.mvvmdemo;

import android.support.annotation.Nullable;

import viewmodel.ViewModel;

/**
 * Created by rutvik on 12/12/2016 at 8:44 AM.
 */

public abstract class ItemViewModel<ITEM_T> extends ViewModel
{
    protected ItemViewModel(@Nullable State savedInstanceState)
    {
        super(null);
    }

    public abstract void setItem(ITEM_T item);

}
