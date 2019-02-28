package com.geekbrains.androidlesson;


import android.os.Parcel;
import android.os.Parcelable;

public class SecondActivityParams implements Parcelable {
    private final String name;
    private final Boolean hum;
    private final Boolean overc;
    private final Boolean speed;

    public SecondActivityParams(String name, Boolean hum, Boolean overc, Boolean speed) {
        this.name = name;
        this.hum = hum;
        this.overc = overc;
        this.speed = speed;
    }

    public String getName() {
        return name;
    }

    public Boolean getHum() {
        return hum;
    }

    public Boolean getOverc() {
        return overc;
    }

    public Boolean getSpeed() {
        return speed;
    }

    public SecondActivityParams(Parcel in) {
        String[] data = new String[4];
        in.readStringArray(data);
        name = data[0];
        hum = Boolean.parseBoolean(data[1]);
        overc = Boolean.parseBoolean(data[2]);
        speed = Boolean.parseBoolean(data[3]);
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeStringArray(new String[] { name, hum.toString(), overc.toString(), speed.toString() });
    }

    public static final Parcelable.Creator<SecondActivityParams> CREATOR = new Parcelable.Creator<SecondActivityParams>() {

        @Override
        public SecondActivityParams createFromParcel(Parcel source) {
            return new SecondActivityParams(source);
        }

        @Override
        public SecondActivityParams[] newArray(int size) {
            return new SecondActivityParams[size];
        }
    };

}
