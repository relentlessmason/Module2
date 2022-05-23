package com.techelevator.auctions.services;

import org.springframework.web.client.RestTemplate;

import com.techelevator.auctions.model.Auction;

public class AuctionService {

    public static final String API_BASE_URL = "http://localhost:3000/auctions/";
    private RestTemplate restTemplate = new RestTemplate();


    public Auction[] getAllAuctions() {
        // call api here
        //Use the RestTemplate to request all auctions and save them into an array of Auctions.
               // Replace the current return statement to return the array of Auctions.
        return restTemplate.getForObject(API_BASE_URL, Auction[].class);
    }

    public Auction getAuction(int id) {
        // call api here
        //Use RestTemplate to request a specific auction by ID.
        //Return the single Auction.
        return restTemplate.getForObject(API_BASE_URL+id, Auction.class);
    }

    public Auction[] getAuctionsMatchingTitle(String title) {
        // call api here
        //Use RestTemplate to request all auctions which match the title parameter and save them into an array of Auctions.
        //The API URL requires a query string with the key named title_like and the value of the title parameter.
        // This requests the server to search for auctions that have a title containing the value in the title parameter.
        //Replace the current return statement to return the array of Auctions.
        String searchTitle = "?title_like=" + title;
        return restTemplate.getForObject(API_BASE_URL + searchTitle, Auction[].class);
    }

    public Auction[] getAuctionsAtOrBelowPrice(double price) {
        // call api here
        //Use RestTemplate to request all auctions which are less than or equal to
        // the price parameter and save them into an array of Auctions.
        //The API URL requires a query string with the key named currentBid_lte
        // and the value of the price parameter. This requests the server to search for
        // auctions that have a price less than or equal to the value in the price parameter.
        //Replace the current return statement to return the array of Auctions.
        String currentBid = "?currentBid_lte=" + price;
        return restTemplate.getForObject(API_BASE_URL + currentBid, Auction[].class );
    
    }

}
