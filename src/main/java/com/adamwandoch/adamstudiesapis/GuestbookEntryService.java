package com.adamwandoch.adamstudiesapis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * @author Adam Wandoch
 */

@Service
public class GuestbookEntryService {

    @Autowired
    private GuestbookEntryRepository guestbookEntryRepository;

    public GuestbookEntryService() {
    }

    public ArrayList<GuestbookEntry> getAllEntries() {
        ArrayList<GuestbookEntry> entries = new ArrayList<>();
        guestbookEntryRepository.findAll().forEach(entries::add);
        return entries;
    }

    public void saveEntry(GuestbookEntry entry) {
        guestbookEntryRepository.save(entry);
    }

}
