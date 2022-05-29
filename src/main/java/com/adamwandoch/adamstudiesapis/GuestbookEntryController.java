package com.adamwandoch.adamstudiesapis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Adam Wandoch
 */

@RestController
@CrossOrigin
public class GuestbookEntryController {

    public static final Logger LOG = LoggerFactory.getLogger(GuestbookEntryController.class);

    @Autowired
    private GuestbookEntryService guestbookEntryService;

    @GetMapping("/guestbook/v1/getall")
    public GuestbookEntryWrapper getAll() {
        return new GuestbookEntryWrapper(guestbookEntryService.getAllEntries());
    }

    @GetMapping("/addtest")
    public void addTest() {
        GuestbookEntry entry = new GuestbookEntry(0,"author", "content");
        guestbookEntryService.saveEntry(entry);
    }
}
