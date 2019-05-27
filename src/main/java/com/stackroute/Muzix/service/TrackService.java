package com.stackroute.Muzix.service;

import com.stackroute.Muzix.domain.Track;
import com.stackroute.Muzix.exception.TrackAlreadyExsistException;
import com.stackroute.Muzix.exception.TrackNotFoundException;

import java.util.List;

public interface TrackService {
    public Track saveTrack(Track track) throws TrackAlreadyExsistException;
    public List<Track> showAllTrack();
    public Track updateComment(Track track) throws TrackNotFoundException;
    public boolean deleteTrack(Track track) throws TrackNotFoundException;
    public List<Track> getTrackByName(String Name) throws TrackNotFoundException;

}
