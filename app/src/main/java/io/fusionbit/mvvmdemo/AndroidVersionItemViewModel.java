package io.fusionbit.mvvmdemo;

import android.databinding.Bindable;
import android.support.annotation.Nullable;

import models.AndroidVersion;

/**
 * Created by rutvik on 12/13/2016 at 8:18 AM.
 */

public class AndroidVersionItemViewModel extends ItemViewModel<AndroidVersion>
{

    private AndroidVersion androidVersion;

    @Override
    public void setItem(AndroidVersion item)
    {
        androidVersion = item;
        notifyChange();
    }

    public void onClick()
    {
        androidVersion.toggleSelected();
        notifyPropertyChanged(BR.selected);
    }

    @Bindable
    public String getVersion()
    {
        return androidVersion.getVersion();
    }

    @Bindable
    public String getCodeName()
    {
        return androidVersion.getCodeName();
    }

    @Bindable
    public boolean getSelected()
    {
        return androidVersion.isSelected();
    }


}
