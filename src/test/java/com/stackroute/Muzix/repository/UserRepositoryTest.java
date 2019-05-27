package com.stackroute.Muzix.repository;
import com.stackroute.Muzix.repository.TrackRepository;

import com.stackroute.Muzix.domain.Track;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    private TrackRepository trackRepository;
    private Track track;

    @Before
    public void setUp()
    {
        track = new Track();
        track.setTrackid(10);
        track.setName("John");
        track.setComments("df");


    }

    @After
    public void tearDown(){

        trackRepository.deleteAll();
    }


    @Test
    public void testSaveTrack(){
        trackRepository.save(track);
      Track fetchUser = trackRepository.findById(track.getTrackid()).get();
        Assert.assertEquals(10,fetchUser.getTrackid());

    }

    @Test
    public void testSaveTrackFailure(){
     Track testUser = new Track(1,"alan","ignore");
        trackRepository.save(track);
        Track fetchUser = trackRepository.findById(track.getTrackid()).get();
        Assert.assertNotSame(testUser,track);
    }

    @Test
    public void testshowAllTrack(){
      Track track = new Track(8,"sonu","new");
        Track track1 = new Track(45,"sheya","igigi");
        trackRepository.save(track);
        trackRepository.save(track1);
//
        List<Track> track2= (List<Track>) trackRepository.findAll();
        Assert.assertEquals("sonu",track2.get(0).getName());
////



    }


}
