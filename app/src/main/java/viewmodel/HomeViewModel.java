package viewmodel;

import android.content.Context;
import android.databinding.Bindable;
import android.os.Parcel;
import android.support.annotation.Nullable;

import io.fusionbit.mvvmdemo.BR;

/**
 * Created by rutvik on 11/27/2016 at 9:15 PM.
 */

public class HomeViewModel extends ViewModel
{

    private final Context context;

    int clicks;

    public HomeViewModel(Context context, @Nullable State savedInstanceState)
    {
        super(savedInstanceState);
        this.context = context;

        if (savedInstanceState instanceof HomeViewState)
        {
            clicks = ((HomeViewState) savedInstanceState).clicks;
        }
    }


    @Override
    public State getInstanceState()
    {
        return new HomeViewState(this);
    }


    @Bindable
    public String getClickCounts()
    {
        return "Clicks: " + clicks;
    }

    public void onCountButtonPress()
    {
        clicks++;
        notifyPropertyChanged(BR.clickCounts);
    }

    private static class HomeViewState extends State
    {

        private final int clicks;

        protected HomeViewState(HomeViewModel viewModel)
        {
            super(viewModel);
            clicks = viewModel.clicks;
        }

        public HomeViewState(Parcel in)
        {
            super(in);
            clicks = in.readInt();
        }

        @Override
        public void writeToParcel(Parcel parcel, int i)
        {
            super.writeToParcel(parcel, i);
            parcel.writeInt(clicks);
        }

        public static Creator<HomeViewState> CREATOR = new Creator<HomeViewState>()
        {
            @Override
            public HomeViewState createFromParcel(Parcel parcel)
            {
                return new HomeViewState(parcel);
            }

            @Override
            public HomeViewState[] newArray(int i)
            {
                return new HomeViewState[i];
            }
        };

    }

}
