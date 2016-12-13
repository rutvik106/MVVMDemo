package io.fusionbit.mvvmdemo;

import viewmodel.ViewModel;

/**
 * Created by rutvik on 12/12/2016 at 8:44 AM.
 */

public abstract class ItemViewModel<ITEM_T> extends ViewModel
{
    public ItemViewModel()
    {
        super(null);
    }

    public abstract void setItem(ITEM_T item);

}
