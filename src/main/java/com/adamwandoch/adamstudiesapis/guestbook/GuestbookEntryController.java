package com.adamwandoch.adamstudiesapis.guestbook;

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
        LOG.info("[GUESTBOOK : GETALL get endpoint requested]");
        return new GuestbookEntryWrapper(guestbookEntryService.getAllEntries());
    }

    @PostMapping("/guestbook/v1/save")
    public ResponseEntity saveEntry(@RequestBody GuestbookEntry entry) {
        LOG.info("[GUESTBOOK : SAVE post endpoint requested]");
        guestbookEntryService.saveEntry(entry);
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
