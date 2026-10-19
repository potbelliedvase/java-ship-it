package ru.yandex.practicum.delivery;

public class PerishableParcel extends Parcel {

    private static final int PRICE = 3;
    private int timeToLive;

    public PerishableParcel(String description, int weight, String deliveryAddress, int sendDay, int timeToLive) {
        super(description, weight, deliveryAddress, sendDay);
        this.timeToLive = timeToLive;
    }

    @Override
    public int getPrice() {
        return PRICE;
    }

    public int getTimeToLive() {
        return timeToLive;
    }

    public boolean isExpired(int currentDay) {
        return !((getSendDay() + getTimeToLive()) >= currentDay);
    }
}
