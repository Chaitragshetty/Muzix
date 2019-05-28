package com.stackroute.Muzix.repository;

//import org.springframework.data.jpa.repository.JpaRepository;
import com.stackroute.Muzix.domain.Track;
//import org.springframework.data.jpa.repository.Query;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TrackRepository extends MongoRepository<Track,Integer> {
//    @Query(value = "select * from track where name = ?1", nativeQuery = true)
//    public List<Track> getTrackByName(String trackName);


}
