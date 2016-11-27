package viewmodel;

import android.databinding.BaseObservable;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.CallSuper;
import android.support.annotation.Nullable;

/**
 * Created by rutvik on 11/27/2016 at 7:47 PM.
 */

public abstract class ViewModel extends BaseObservable
{

    protected ViewModel(@Nullable State savedInstanceState)
    {

    }


    @CallSuper
    public void onStart()
    {

    }


    @CallSuper
    public void onStop()
    {

    }


    public State getInstanceState()
    {
        return new State(this);
    }


    public static class State implements Parcelable
    {

        protected State(ViewModel viewModel)
        {

        }

        public State(Parcel in)
        {

        }

        @Override
        public int describeContents()
        {
            return 0;
        }

        @CallSuper
        @Override
        public void writeToParcel(Parcel parcel, int i)
        {

        }


        public static Creator<State> CREATOR = new Creator<State>()
        {
            @Override
            public State createFromParcel(Parcel parcel)
            {
                return new State(parcel);
            }

            @Override
            public State[] newArray(int i)
            {
                return new State[i];
            }
        };

    }

}
