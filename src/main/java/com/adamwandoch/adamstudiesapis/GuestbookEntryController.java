package com.adamwandoch.adamstudiesapis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/save")
    public ResponseEntity saveEntry(@RequestBody GuestbookEntry entry) {
        System.out.println(entry);
        guestbookEntryService.saveEntry(entry);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/addtest")
    public void addTest() {
        GuestbookEntry entry = new GuestbookEntry(0,"author", "content");
        guestbookEntryService.saveEntry(entry);
    }
}
