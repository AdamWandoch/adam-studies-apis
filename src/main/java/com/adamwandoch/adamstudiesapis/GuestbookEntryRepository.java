package com.adamwandoch.adamstudiesapis;

import org.springframework.data.repository.CrudRepository;

/**
 * @author Adam Wandoch
 */

public interface GuestbookEntryRepository extends CrudRepository<GuestbookEntry, String> {
}
