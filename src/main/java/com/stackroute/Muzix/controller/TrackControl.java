package com.stackroute.Muzix.controller;
import com.stackroute.Muzix.exception.TrackNotFoundException;
import com.stackroute.Muzix.domain.Track;
import com.stackroute.Muzix.exception.TrackAlreadyExsistException;
import com.stackroute.Muzix.service.TrackService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/")
public class TrackControl {

    @Autowired
    private TrackService trackService;

    public TrackControl(TrackService trackService) {
        this.trackService = trackService;
    }

    public void setTrackService(TrackService trackService) {
        this.trackService = trackService;
    }

    @RequestMapping(value = "track", method = RequestMethod.POST)
    public ResponseEntity<Track> saveTrack(@RequestBody Track track) {
        ResponseEntity responseEntity;
        try {
            Track track1 = trackService.saveTrack(track);
            responseEntity = new ResponseEntity<String>("Successfully Added Track", HttpStatus.CREATED);


        } catch (TrackAlreadyExsistException e) {
            responseEntity = new ResponseEntity<String>(e.getMessage(), HttpStatus.CONFLICT);

            e.printStackTrace();
        }
        return responseEntity;
    }

        @RequestMapping(value = "track", method = RequestMethod.GET)
    public ResponseEntity<List<Track>> showAllTracks() {
        List<Track> track1 = trackService.showAllTrack();
        return new ResponseEntity<List<Track>>(track1, HttpStatus.OK);
    }

    @RequestMapping(value = "track", method = RequestMethod.PUT)
    public ResponseEntity<String> updateTrack(@RequestBody Track track) {
        ResponseEntity responseEntity;
        try {
            Track track1 = trackService.updateComment(track);
            return new ResponseEntity<String>("Successfully Updated", HttpStatus.OK);
        } catch (TrackNotFoundException ex) {
            responseEntity = new ResponseEntity<String>(ex.getMessage(), HttpStatus.CONFLICT);
            ex.printStackTrace();
        }
        return responseEntity;
    }

    @RequestMapping(value = "track", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteTrack(@RequestBody Track track) {
        ResponseEntity responseEntity;
        try {
            boolean answer = trackService.deleteTrack(track);
            return new ResponseEntity<String>("Successfully deleted", HttpStatus.OK);
        } catch (TrackNotFoundException ex) {
            responseEntity = new ResponseEntity<String>(ex.getMessage(), HttpStatus.CONFLICT);
            ex.printStackTrace();
        }
        return responseEntity;
    }

    @RequestMapping(value = "track/{trackName}", method = RequestMethod.GET)
    public ResponseEntity<List<Track>> getTrackByName(@PathVariable("trackName") String trackName) throws Exception {
        List<Track> track1 = trackService.getTrackByName(trackName);
        return new ResponseEntity<List<Track>>(track1, HttpStatus.OK);
    }

//    @Autowired
//    private Environment env;
//
//    @GetMapping("/property")
//    public String getPropertyValue(@RequestParam("key") String key) {
//        String returnValue = "No value";
//
//        String keyValue = env.getProperty(key);
//
//        if (keyValue != null && !keyValue.isEmpty()) {
//            returnValue = keyValue;
//        }
//        return returnValue;
//    }
//
//    @Value("${trackid}")
//    private String trackid;
//
//    @GetMapping("value")
//    public String getValue() {
//        return trackid;
//    }
//    @Value("${name}")
//    private String name;
//    @GetMapping("value1")
//    public String getValue1() {
//        return name;
//    }
//    @Value("${comments}")
//    private String comments;
//    @GetMapping("value2")
//    public String getValue2() {
//        return comments;
//    }
}
//
//
