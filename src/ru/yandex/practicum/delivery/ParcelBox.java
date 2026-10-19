package ru.yandex.practicum.delivery;

import java.util.ArrayList;

public class ParcelBox<T extends Parcel> {
    private ArrayList<T> parcels = new ArrayList<>();
    private final int maxWeight;
    private int currentWeight;

    public ParcelBox(int maxWeight) {
        this.maxWeight = maxWeight;
    }

    public void addParcel(T parcel) {
        if ((currentWeight + parcel.getWeight()) > maxWeight) {
            System.out.println("Данную посылку нельзя добавить в эту коробку: максимальный вес коробки будет превышен");
            return;
        }
        parcels.add(parcel);
        currentWeight += parcel.getWeight();
    }

    public void getAllParcels() {
        for (T parcel : parcels) {
            System.out.println(parcel.getDescription());
        }
    }

    public ArrayList<T> getParcels() {
        return parcels;
    }
}
