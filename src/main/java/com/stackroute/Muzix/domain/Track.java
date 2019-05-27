package com.stackroute.Muzix.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
@Data //Using lombok to handle the getter setters
@NoArgsConstructor //Creates a zero argument constructor
@AllArgsConstructor //Creates an all argument constructor
@Builder
public class Track {
    @Id
    int trackid;
    String name;
    String comments;

    /*public Track() {
    }

    public Track(int trackid, String name, String comments) {
        this.trackid = trackid;
        this.name = name;
        this.comments = comments;
    }

    @Override
    public String toString() {
        return "Track{" +
                "trackid=" + trackid +
                ", name='" + name + '\'' +
                ", comments='" + comments + '\'' +
                '}';
    }

    public int getTrackid() {
        return trackid;
    }

    public void setTrackid(int trackid) {
        this.trackid = trackid;
    }*/
}
