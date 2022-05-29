package com.adamwandoch.adamstudiesapis.guestbook;

import java.util.ArrayList;

/**
 * @author Adam Wandoch
 * Wrapper for returning records
 */

public class GuestbookEntryWrapper {

    private ArrayList<GuestbookEntry> listOfEntries;

    public GuestbookEntryWrapper() {
    }

    public GuestbookEntryWrapper(ArrayList<GuestbookEntry> listOfEntries) {
        this.listOfEntries = listOfEntries;
    }

    public ArrayList<GuestbookEntry> getListOfEntries() {
        return listOfEntries;
    }

    public void setListOfEntries(ArrayList<GuestbookEntry> listOfEntries) {
        this.listOfEntries = listOfEntries;
    }
}
