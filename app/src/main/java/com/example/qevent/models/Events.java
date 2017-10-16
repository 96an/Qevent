package com.example.qevent.models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by am on 1/24/2017.
 */

public class Events implements Parcelable {

    public String title;
    public String date;
    public String month;
    public String body;

    public Events() {
    }

    protected Events(Parcel in) {
        title = in.readString();
        date = in.readString();
        month = in.readString();
        body = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeString(date);
        dest.writeString(month);
        dest.writeString(body);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Events> CREATOR = new Creator<Events>() {
        @Override
        public Events createFromParcel(Parcel in) {
            return new Events(in);
        }

        @Override
        public Events[] newArray(int size) {
            return new Events[size];
        }
    };
}
