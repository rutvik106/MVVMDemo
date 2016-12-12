package viewmodel;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;

import adapters.RecyclerViewAdapter;

/**
 * Created by rutvik on 12/12/2016 at 9:00 AM.
 */

public abstract class RecyclerViewViewModel extends ViewModel
{


    RecyclerView.LayoutManager layoutManager;

    private Parcelable savedLayoutManagerState;


    protected abstract RecyclerViewAdapter getAdapter();

    protected abstract RecyclerView.LayoutManager createLayoutManager();


    protected RecyclerViewViewModel(@Nullable State savedInstanceState)
    {
        super(savedInstanceState);

        if (savedInstanceState instanceof RecyclerViewViewModelState)
        {
            savedLayoutManagerState =
                    ((RecyclerViewViewModelState) savedInstanceState).layoutManagerState;
        }

    }


    @Override
    public RecyclerViewViewModelState getInstanceState()
    {
        return new RecyclerViewViewModelState(this);
    }


    public final void setupRecyclerView(RecyclerView recyclerView)
    {
        layoutManager = createLayoutManager();
        if (savedLayoutManagerState != null)
        {
            layoutManager.onRestoreInstanceState(savedLayoutManagerState);
            savedLayoutManagerState = null;
        }
        recyclerView.setAdapter(getAdapter());
        recyclerView.setLayoutManager(layoutManager);
    }


    public static class RecyclerViewViewModelState extends State
    {

        private final Parcelable layoutManagerState;

        protected RecyclerViewViewModelState(RecyclerViewViewModel viewModel)
        {
            super(viewModel);
            layoutManagerState = viewModel.layoutManager.onSaveInstanceState();
        }

        public RecyclerViewViewModelState(Parcel in)
        {
            super(in);
            layoutManagerState = in.readParcelable(RecyclerView.LayoutManager.class.getClassLoader());
        }


        @Override
        public void writeToParcel(Parcel parcel, int flags)
        {
            super.writeToParcel(parcel, flags);
            parcel.writeParcelable(layoutManagerState, flags);
        }


        public static Creator<RecyclerViewViewModelState> CREATOR = new Creator<RecyclerViewViewModelState>()
        {
            @Override
            public RecyclerViewViewModelState createFromParcel(Parcel parcel)
            {
                return new RecyclerViewViewModelState(parcel);
            }

            @Override
            public RecyclerViewViewModelState[] newArray(int size)
            {
                return new RecyclerViewViewModelState[size];
            }
        };

    }


}
