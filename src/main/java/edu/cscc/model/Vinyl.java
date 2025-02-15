package edu.cscc.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.validation.constraints.*;

/**
 * @author David Geier
 * @version November 11th, 2024
 */

@Entity
public class Vinyl {

    @Id
    @GeneratedValue(generator = "STORE_SEQ", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "STORE_SEQ", allocationSize = 1)
    private long id;

    // Attributes
    @NotBlank(message = "Title is a required field")
    @Size(max = 50, message = "Title must not exceed 50 characters")
    private String title;
    @NotBlank(message = "Artist is a required field")
    @Size(max = 40, message = "Artist must not exceed 40 characters")
    private String artist;
    @NotBlank(message = "Label is a required field")
    @Size(max = 40, message = "Label must not exceed 40 characters")
    private String label;
    @Min(value = 1930, message = "Record must have been produced after 1930")
    private String yearOfRelease;
    @Min(value = 1, message = "Number of tracks must be 1 or more")
    @Max(value = 20, message = "Number of tracks must be 20 or less")
    @NotNull(message = "Number of Tracks must not be left blank")
    private Integer numberOfTracks;
    private Integer recordSize;
    private boolean damaged;

    // Default constructor
    public Vinyl() {
    }

    // Getters
    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public String getLabel() {
        return label;
    }

    public String getYearOfRelease() {
        return yearOfRelease;
    }

    public Integer getNumberOfTracks() {
        return numberOfTracks;
    }

    public Integer getRecordSize() {
        return recordSize;
    }

    public boolean isDamaged() {
        return damaged;
    }

    // Setters

    public void setId(long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public void setYearOfRelease(String yearOfRelease) {
        this.yearOfRelease = yearOfRelease;
    }

    public void setNumberOfTracks(Integer numberOfTracks) {
        this.numberOfTracks = numberOfTracks;
    }

    public void setRecordSize(Integer recordSize) {
        this.recordSize = recordSize;
    }

    public void setDamaged(boolean damaged) {
        this.damaged = damaged;
    }
}