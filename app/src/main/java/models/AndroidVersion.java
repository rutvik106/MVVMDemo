package models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by rutvik on 12/13/2016 at 8:29 AM.
 */

public class AndroidVersion implements Parcelable
{

    private final String codeName;
    private final String version;
    private boolean selected;

    public AndroidVersion(String codeName, String version)
    {
        this.codeName = codeName;
        this.version = version;
    }

    protected AndroidVersion(Parcel in)
    {
        codeName = in.readString();
        version = in.readString();
        selected = in.readInt() == 1;
    }

    @Override
    public int describeContents()
    {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeString(codeName);
        parcel.writeString(version);
        parcel.writeInt(selected ? 1 : 0);
    }

    public String getCodeName()
    {
        return codeName;
    }

    public String getVersion()
    {
        return version;
    }

    public boolean isSelected()
    {
        return selected;
    }

    public void toggleSelected()
    {
        selected = !selected;
    }


    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
        {
            return true;
        }

        if (obj == null || getClass() != obj.getClass())
        {
            return false;
        }

        AndroidVersion that = (AndroidVersion) obj;

        if (selected != that.selected)
        {
            return false;
        }

        if (codeName != null ? !codeName.equals(that.codeName) : that.codeName != null)
        {
            return false;
        } else
        {
            return !(version != null ? !version.equals(that.version) : that.version != null);
        }

    }

    @Override
    public int hashCode()
    {
        int result = codeName != null ? codeName.hashCode() : 0;

        result = 31 * result + (version != null ? version.hashCode() : 0);

        result = 31 * result + (selected ? 1 : 0);

        return result;
    }

    public static final Creator<AndroidVersion> CREATOR = new Creator<AndroidVersion>()
    {
        @Override
        public AndroidVersion createFromParcel(Parcel in)
        {
            return new AndroidVersion(in);
        }

        @Override
        public AndroidVersion[] newArray(int size)
        {
            return new AndroidVersion[size];
        }
    };

}
