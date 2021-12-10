package com.example.listuserjava;

import android.os.Parcel;
import android.os.Parcelable;

public class Profile implements Parcelable {
    private String user;
    private String name;
    private String location;
    private String following, followers, company, repository;
    private int photo;


    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }

    public String getFollowing() {
        return following;
    }

    public void setFollowing(String following) {
        this.following = following;
    }

    public String getFollowers() {
        return followers;
    }

    public void setFollowers(String followers) {
        this.followers = followers;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getRepository() {
        return repository;
    }

    public void setRepository(String repository) {
        this.repository = repository;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.user);
        dest.writeString(this.name);
        dest.writeString(this.location);
        dest.writeInt(this.photo);
//        dest.writeString(this.photo);
        dest.writeString(this.followers);
        dest.writeString(this.company);
        dest.writeString(this.repository);
    }

    public Profile() {
    }

    private Profile(Parcel in) {
        this.user = in.readString();
        this.name = in.readString();
        this.location = in.readString();
        this.photo = in.readInt();
//        this.photo = in.readString();
        this.followers = in.readString();
        this.company = in.readString();
        this.repository = in.readString();
    }

    public static final Parcelable.Creator<Profile> CREATOR = new Parcelable.Creator<Profile>() {
        @Override
        public Profile createFromParcel(Parcel source) {
            return new Profile(source);
        }

        @Override
        public Profile[] newArray(int size) {
            return new Profile[size];
        }
    };
}
