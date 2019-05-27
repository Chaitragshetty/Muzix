package com.stackroute.Muzix.service;
import com.stackroute.Muzix.domain.Track;
import com.stackroute.Muzix.exception.TrackAlreadyExsistException;
import com.stackroute.Muzix.exception.TrackNotFoundException;
import com.stackroute.Muzix.repository.TrackRepository;
import com.stackroute.Muzix.service.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.lang.model.element.Name;
import java.lang.Exception;

import java.util.List;
@Service

public class TrackServiceImp implements TrackService {
    @Autowired
    private TrackRepository trackRepository;

    public void setTrackRepository(TrackRepository trackRepository) {
        this.trackRepository = trackRepository;
    }

    public TrackServiceImp(TrackRepository trackRepository) {
        this.trackRepository = trackRepository;
    }

    private TrackServiceImp trackServiceImp;
    @Override
    public Track saveTrack(Track track) throws TrackAlreadyExsistException {
        if (trackRepository.existsById(track.getTrackid())) {
         throw  new TrackAlreadyExsistException("exception already exsist");

        }
        Track track1=trackRepository.save(track);
        if(track1==null)
        {
            throw  new TrackAlreadyExsistException("exception alredy exsist ");
        }
        return track1;
    }

    @Override
    public List<Track> showAllTrack() {
        List<Track>track1=(List<Track>) trackRepository.findAll();

        return track1;
    }


    @Override
    public Track updateComment(Track track) throws TrackNotFoundException {
        if (trackRepository.existsById(track.getTrackid()))
        {
            Track track1 = trackRepository.findById(track.getTrackid()).get();
            track1.setComments(track.getComments());
            trackRepository.save(track1);
            return track1;
        }
        else
        {
            throw new TrackNotFoundException("Track not found exception");

        }
//        return null;
    }


    @Override
    public boolean deleteTrack(Track track) throws TrackNotFoundException
    {
        if (trackRepository.existsById(track.getTrackid())){

        trackRepository.deleteById(track.getTrackid());
        return true;
    }

        else
        {
            throw new TrackNotFoundException("Track not found exception");
        }
        //return answer;
    }
//        return false;
    //        else
//        {
//            throw new TrackNotFoundException("Track not found exception");
//
//        }
        //return null;
//    }


    @Override
    public List<Track> getTrackByName(String Name) throws TrackNotFoundException {
        List<Track> listOfTracks = null;
        listOfTracks = trackRepository.getTrackByName(Name);
        if (listOfTracks.equals(null))
        {
            throw new TrackNotFoundException("Track not found exception");
        }
        return listOfTracks;

    }

}
