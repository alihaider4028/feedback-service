package com.event.feedbackservice;

import com.event.feedbackservice.Repository.*;
import com.event.feedbackservice.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class FeedbackServiceApplication implements CommandLineRunner {
    @Autowired
    private EventRepository eventRepository;
    @Autowired
    private TagRepository tagRepository;
    @Autowired
    private EventTypeRepository eventTypeRepository;
    @Autowired
    private LocationRepository locationRepository;
    @Autowired

    private AttendeeRepository attendeeRepository;

    @Autowired
    private AttendanceRecordRepository attendanceRecordRepository;
    @Autowired

    private BookmarkRepository bookmarkRepository;


    public FeedbackServiceApplication() {
    }

    public static void main(String[] args) {
        SpringApplication.run(FeedbackServiceApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        generateDummyData();
    }

    private void generateDummyData() {
        // Generate the dummy data here
        // You can reuse the code from the previous example
        Tag tag1 = new Tag(1, "jazz");
        Tag tag2 = new Tag(2, "Songs");
        Tag tag3 = new Tag(3, "music fes");
        this.tagRepository.save(tag1);
        this.tagRepository.save(tag2);
        this.tagRepository.save(tag3);
        List<Tag> tags = Arrays.asList(tag1, tag2, tag3);
        Location location = new Location(5, "usa", "newyork", 42.77888f, 67.3323f);
        this.locationRepository.save(location);
        EventType eventType = new EventType(1, "music");
        this.eventTypeRepository.save(eventType);


        Event event1 = new Event();
        event1.setCapacity(150);
        event1.setDate(new Date());
        event1.setDescription("Join us for a fantastic evening of live jazz music, delicious food, and dancing.");
        event1.setLocationId(location);
        event1.setOrganizerId(102);
        event1.setTitle("Jazz Night Extravaganza");
        event1.setTypeId(eventType);
        event1.setTags(tags);


        Event event2 = new Event();
        event2.setCapacity(200);
        event2.setDate(new Date());
        event2.setDescription("An amazing night of rock music and great vibes.");
        event2.setLocationId(location);
        event2.setOrganizerId(103);
        event2.setTitle("Rock Fest");
        event2.setTypeId(eventType);
        event2.setTags(tags);
        this.eventRepository.save(event1);
        this.eventRepository.save(event2);
        Bookmark bookmark = new Bookmark();
        bookmark.setEvent(event1);
        this.bookmarkRepository.save(bookmark);
        List<Bookmark> bookmarks = new ArrayList<>();
        bookmarks.add(bookmark);
        Attendee attendee = new Attendee();
        attendee.setBookmarks(bookmarks);
        this.attendeeRepository.save(attendee);
        Attendee attendee1= new Attendee();
        attendee1.setBookmarks(bookmarks);

        AttendanceRecord attendanceRecord = new AttendanceRecord();
        attendanceRecord.setAttendeeId(attendee);
        attendanceRecord.setEventId(event1);

        this.attendanceRecordRepository.save(attendanceRecord);

        // Save the dummy data to the database or perform any other operations
    }

}
