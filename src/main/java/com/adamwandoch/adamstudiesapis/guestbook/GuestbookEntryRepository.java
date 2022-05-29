package com.adamwandoch.adamstudiesapis.guestbook;

import org.springframework.data.repository.CrudRepository;

/**
 * @author Adam Wandoch
 */

public interface GuestbookEntryRepository extends CrudRepository<GuestbookEntry, String> {
}
