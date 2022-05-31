package com.techelevator.auctions.model;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.constraints.*;

public class Auction {

    private int id;
    private String title;
    private String description;
    private String user;
    @Positive(message = "The currentBid field should be greater than 0.")
    private double currentBid;

    public Auction() {
    }

    public Auction(String title, String description, String user, double currentBid) {
        this.title = title;
        this.description = description;
        this.user = user;
        this.currentBid = currentBid;
    }

    public Auction(int id, String title, String description, String user, double currentBid) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.user = user;
        this.currentBid = currentBid;
    }

    public int getId() {
        return id;
    }

    @NotBlank(message="The title field should not be blank.")
    public String getTitle() {
        return title;
    }

    @NotBlank(message="The description field should not be blank.")
    public String getDescription() {
        return description;
    }

    @NotBlank(message="The user field should not be blank.")
    public String getUser() {
        return user;
    }

    public double getCurrentBid() {
        return currentBid;
    }

    @Positive(message = "The currentBid field should be greater than 0.")
    public String currentBidToString() {
        return id + ": " + title + " | Current Bid: " + currentBid;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setCurrentBid(double currentBid) {
        this.currentBid = currentBid;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Auction{" + "id=" + id + ", title='" + title + '\'' + ", description='" + description + '\''
                + ", user='" + user + '\'' + ", currentBid=" + currentBid + '}';
    }
}
