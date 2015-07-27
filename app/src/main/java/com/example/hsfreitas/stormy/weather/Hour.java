package com.example.hsfreitas.stormy.weather;

import android.os.Parcel;
import android.os.Parcelable;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by hsfreitas on 2015-07-15.
 */
public class Hour implements Parcelable{
    private long mTime;
    private String mIcon;
    private String mSummary;
    private double mTemperature;
    private String mTimezone;

    public Hour(){}

    public Hour(long time, String icon, String summary,
                double temperature, String timezone){
        mTime = time;
        mIcon = icon;
        mSummary = summary;
        mTemperature = temperature;
        mTimezone = timezone;
    }


    public long getTime() {
        return mTime;
    }

    public void setTime(long time) {
        mTime = time;
    }

    public String getIcon() {
        return mIcon;
    }

    public void setIcon(String icon) {
        mIcon = icon;
    }

    public String getSummary() {
        return mSummary;
    }

    public void setSummary(String summary) {
        mSummary = summary;
    }

    public int getTemperature() {
        return (int) Math.round(mTemperature);
    }

    public int getIconId(){
        return Forecast.getIconId(mIcon);
    }

    public void setTemperature(double temperature) {
        mTemperature = temperature;
    }


    public String getTimezone() {
        return mTimezone;
    }

    public void setTimezone(String timezone) {
        mTimezone = timezone;
    }

    public String getHour(){
        SimpleDateFormat formatter = new SimpleDateFormat("h a");
        Date date=  new Date(mTime * 1000);
        String timeString = formatter.format(date);
        return timeString;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(mTime);
        dest.writeString(mIcon);
        dest.writeString(mSummary);
        dest.writeDouble(mTemperature);
        dest.writeString(mTimezone);

    }

    private Hour(Parcel in){
        mTime = in.readLong();
        mIcon = in.readString();
        mSummary = in.readString();
        mTemperature = in.readDouble();
        mTimezone = in.readString();

    }

    public static final Creator<Hour> CREATOR = new Creator<Hour>() {
        @Override
        public Hour createFromParcel(Parcel source) {
            return new Hour(source);
        }

        @Override
        public Hour[] newArray(int size) {
            return new Hour[size];
        }
    };


}
