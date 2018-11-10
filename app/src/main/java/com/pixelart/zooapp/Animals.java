package com.pixelart.zooapp;

import android.os.Parcel;
import android.os.Parcelable;

public class Animals implements Parcelable {

    private int id;
    private String name;
    private String description;
    private String location;
    private String habitat;
    private String diet;
    private String size;
    private String weight;
    private String status;
    private String threats;
    private String category;

    public Animals() {
    }

    public Animals(String name, String description, String location, String habitat, String diet, String size, String weight, String status, String threats) {
        this.name = name;
        this.description = description;
        this.location = location;
        this.habitat = habitat;
        this.diet = diet;
        this.size = size;
        this.weight = weight;
        this.status = status;
        this.threats = threats;
    }

    public Animals(String name, String description, String location, String habitat, String diet, String size, String weight, String status, String threats, String category) {
        this.name = name;
        this.description = description;
        this.location = location;
        this.habitat = habitat;
        this.diet = diet;
        this.size = size;
        this.weight = weight;
        this.status = status;
        this.threats = threats;
        this.category = category;
    }

    public Animals(String name, String description, String location, String habitat, String diet, String size, String weight, String status, String threats, String category, int id) {
        this.name = name;
        this.description = description;
        this.location = location;
        this.habitat = habitat;
        this.diet = diet;
        this.size = size;
        this.weight = weight;
        this.status = status;
        this.threats = threats;
        this.category = category;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getHabitat() {
        return habitat;
    }

    public void setHabitat(String habitat) {
        this.habitat = habitat;
    }

    public String getDiet() {
        return diet;
    }

    public void setDiet(String diet) {
        this.diet = diet;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getThreats() {
        return threats;
    }

    public void setThreats(String threats) {
        this.threats = threats;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    protected Animals(Parcel in) {
        id = in.readInt();
        name = in.readString();
        description = in.readString();
        location = in.readString();
        habitat = in.readString();
        diet = in.readString();
        size = in.readString();
        weight = in.readString();
        status = in.readString();
        threats = in.readString();
        category = in.readString();
    }

    public static final Creator<Animals> CREATOR = new Creator<Animals>() {
        @Override
        public Animals createFromParcel(Parcel in) {
            return new Animals(in);
        }

        @Override
        public Animals[] newArray(int size) {
            return new Animals[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int flags) {
        parcel.writeInt(id);
        parcel.writeString(name);
        parcel.writeString(description);
        parcel.writeString(location);
        parcel.writeString(habitat);
        parcel.writeString(diet);
        parcel.writeString(size);
        parcel.writeString(weight);
        parcel.writeString(status);
        parcel.writeString(threats);
        parcel.writeString(category);
    }

    @Override
    public String toString() {
        return "Animals{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", location='" + location + '\'' +
                ", habitat='" + habitat + '\'' +
                ", diet='" + diet + '\'' +
                ", size='" + size + '\'' +
                ", weight='" + weight + '\'' +
                ", threats='" + status + '\'' +
                ", threats='" + threats + '\'' +
                ", category='" + category + '\'' +
                '}';
    }
}
