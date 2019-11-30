package com.ithb.jeffry.tourdestinationcatalogue;

public class Location {
    private int position;
    private String name;
    private String shortDesc;
    private String currency;
    private String language;
    private String hotelPriceRange;
    private String flightDurationPrice;
    private String funFact;
    private String detail;
    private String photo;

    int getPosition() {
        return position;
    }

    void setPosition(int position) {
        this.position = position;
    }

    String getShortDesc() {
        return shortDesc;
    }

    void setShortDesc(String shortDesc) {
        this.shortDesc = shortDesc;
    }

    String getCurrency() {
        return currency;
    }

    void setCurrency(String currency) {
        this.currency = currency;
    }

    String getLanguage() {
        return language;
    }

    void setLanguage(String language) {
        this.language = language;
    }

    String getHotelPriceRange() {
        return hotelPriceRange;
    }

    void setHotelPriceRange(String hotelPriceRange) {
        this.hotelPriceRange = hotelPriceRange;
    }

    String getFlightDurationPrice() {
        return flightDurationPrice;
    }

    void setFlightDurationPrice(String flightDurationPrice) {
        this.flightDurationPrice = flightDurationPrice;
    }

    String getFunFact() {
        return funFact;
    }

    void setFunFact(String funFact) {
        this.funFact = funFact;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    String getDetail() {
        return detail;
    }

    void setDetail(String detail) {
        this.detail = detail;
    }

    String getPhoto() {
        return photo;
    }

    void setPhoto(String photo) {
        this.photo = photo;
    }
}
