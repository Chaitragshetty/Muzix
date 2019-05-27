package com.stackroute.Muzix.config;

import com.stackroute.Muzix.domain.Track;
import com.stackroute.Muzix.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.jboss.logging.Logger;

//import java.util.logging.Logger;

@Component
@PropertySource("classpath:application.properties")
public class ApplicationListenerStartup implements ApplicationListener<ContextRefreshedEvent> {
    private static final Logger logs = Logger.getLogger(ApplicationListenerStartup.class);
    private TrackRepository trackRepository;

    @Autowired
    private Environment env;
    public ApplicationListenerStartup(TrackRepository trackRepository){
        this.trackRepository=trackRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent){
        logs.info("Inserting data on start");

       /* Track track1 = new Track(2,"Darkside","Singer : alan Walker");
        trackRepository.save(track1);
        Track track2 = new Track(3,"walkthroughfire","Singer : alanwalker");
        trackRepository.save(track2);*/
        Track track9 = new Track(Integer.parseInt(env.getProperty("trackid")),env.getProperty("name"),env.getProperty("comments"));
        trackRepository.save(track9);

        logs.info("data successfully inserted");
    }
}
