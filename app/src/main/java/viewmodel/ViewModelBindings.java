package viewmodel;

import android.databinding.BindingAdapter;
import android.support.v7.widget.RecyclerView;

/**
 * Created by rutvik on 12/12/2016 at 9:13 AM.
 */

public class ViewModelBindings
{

    @BindingAdapter("recyclerViewViewModel")
    public static void setRecyclerViewViewModel(RecyclerView recyclerView,
                                                RecyclerViewViewModel viewModel)
    {
        viewModel.setupRecyclerView(recyclerView);
    }

}
