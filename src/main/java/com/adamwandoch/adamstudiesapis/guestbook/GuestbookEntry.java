package com.adamwandoch.adamstudiesapis.guestbook;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;

/**
 * @author Adam Wandoch
 * Guestbook record entry entity class
 */

@Entity
public class GuestbookEntry {

    @Id
    @GeneratedValue
    private long id;
    private String name;
    private String content;

    public GuestbookEntry() {
    }

    public GuestbookEntry(long id, String name, String content) {
        this.id = id;
        this.name = name;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GuestbookEntry that = (GuestbookEntry) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(content, that.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, content);
    }

    @Override
    public String toString() {
        return "GuestbookEntry{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
