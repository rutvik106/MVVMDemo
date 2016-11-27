package viewmodel;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.Nullable;

import io.fusionbit.mvvmdemo.ActivityHome;

/**
 * Created by rutvik on 11/27/2016 at 8:46 PM.
 */

public class InitialViewModel extends ViewModel
{
    public InitialViewModel(@Nullable State savedInstanceState)
    {
        super(savedInstanceState);
    }

    public void onHomeButtonClick(Activity activity)
    {
        activity.startActivity(new Intent(activity, ActivityHome.class));
    }

}
