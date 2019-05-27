package com.stackroute.Muzix.config;
//
//package com.stackroute.Muzix.seetdata;

import com.stackroute.Muzix.domain.Track;
import com.stackroute.Muzix.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.jboss.logging.Logger;

@Component
@PropertySource("classpath:application.properties")
public class PropertiesWithJavaConfig implements ApplicationListener<ContextRefreshedEvent> {
    private static final Logger logs = Logger.getLogger(PropertiesWithJavaConfig.class);
    private TrackRepository trackRepository;

    @Autowired
    public PropertiesWithJavaConfig(TrackRepository trackRepository){
        this.trackRepository=trackRepository;
    }

    @Value("${trackid}")
    private int trackid;

    @Value("${name}")
    private String name;

    @Value("${comments}")
    private String comments;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent){
        logs.info("Inserting data on start");

        Track track1 = new Track(trackid,name,comments);
        trackRepository.save(track1);

        logs.info("data successfully inserted");
    }
}

