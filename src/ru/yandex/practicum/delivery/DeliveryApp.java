package ru.yandex.practicum.delivery;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DeliveryApp {

    private static final Scanner scanner = new Scanner(System.in);
    private static List<Parcel> allParcels = new ArrayList<>();
    private static List<Trackable> trackableParcels = new ArrayList<>();
    private static ParcelBox<StandardParcel> standardParcelBox = new ParcelBox<>(35000);
    private static ParcelBox<FragileParcel> fragileParcelBox = new ParcelBox<>(10000);
    private static ParcelBox<PerishableParcel> perishableParcelBox = new ParcelBox<>(20000);

    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            showMenu();
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    addParcel();
                    break;
                case 2:
                    sendParcels();
                    break;
                case 3:
                    calculateCosts();
                    break;
                case 4:
                    updateTrackableStatus();
                    break;
                case 5:
                    showParcelsOfBox();
                    break;
                case 0:
                    running = false;
                    break;
                default:
                    System.out.println("Неверный выбор.");
            }
            System.out.println("-".repeat(30));
        }
    }

    private static void showMenu() {
        System.out.println("Выберите действие:");
        System.out.println("1 — Добавить посылку");
        System.out.println("2 — Отправить все посылки");
        System.out.println("3 — Посчитать стоимость доставки");
        System.out.println("4 — Обновить статус для посылок с трекингом");
        System.out.println("5 — Показать содержимое коробки");
        System.out.println("0 — Завершить");
    }

    // реализуйте методы ниже
    private static int readTypeofParcels() {
        System.out.println("-".repeat(30));
        System.out.println("Выберите тип посылки:");
        System.out.println("1 — Стандартная");
        System.out.println("2 — Хрупкая");
        System.out.println("3 — Скоропортящаяся");

        return Integer.parseInt(scanner.nextLine());
    }

    private static String readDescription() {
        System.out.println("-".repeat(30));
        System.out.println("Введите описание посылки:");
        return scanner.nextLine();
    }

    private static int readWeight() {
        System.out.println("-".repeat(30));
        System.out.println("Введите вес посылки:");
        return Integer.parseInt(scanner.nextLine());
    }

    private static String readDeliveryAddress() {
        System.out.println("-".repeat(30));
        System.out.println("Введите адрес назначения посылки:");
        return scanner.nextLine();
    }

    private static int readSendDay() {
        System.out.println("-".repeat(30));
        System.out.println("Введите день месяца отправки посылки:");
        return Integer.parseInt(scanner.nextLine());
    }

    private static int readTimeToLive() {
        System.out.println("-".repeat(30));
        System.out.println("Введите сколько дней может храниться посылка:");
        return Integer.parseInt(scanner.nextLine());
    }

    private static String readNewLocation() {
        System.out.println("-".repeat(30));
        System.out.println("Введите новую информацию о местоположении:");
        return scanner.nextLine();
    }

    private static void addParcel() {
        // Подсказка: спросите тип посылки и необходимые поля, создайте объект и добавьте в allParcels
        int choice = readTypeofParcels();

        if (choice < 1 || choice > 3) {
            System.out.println("Выбран некорректный тип посылки");
            return;
        }

        String description = readDescription();
        int weight = readWeight();
        String deliveryAddress = readDeliveryAddress();
        int sendDay = readSendDay();

        switch (choice) {
            case 1:
                StandardParcel standardParcel = new StandardParcel(description, weight, deliveryAddress, sendDay);
                allParcels.add(standardParcel);
                standardParcelBox.addParcel(standardParcel);
                break;
            case 2:
                FragileParcel fragileParcel = new FragileParcel(description, weight, deliveryAddress, sendDay);
                allParcels.add(fragileParcel);
                trackableParcels.add(fragileParcel);
                fragileParcelBox.addParcel(fragileParcel);
                break;
            case 3:
                int timeToLive = readTimeToLive();
                PerishableParcel perishableParcel = new PerishableParcel(description, weight, deliveryAddress,
                                                                         sendDay, timeToLive);
                allParcels.add(perishableParcel);
                perishableParcelBox.addParcel(perishableParcel);
                break;
        }
    }

    private static void sendParcels() {
        // Пройти по allParcels, вызвать packageItem() и deliver()
        for (Parcel parcel : allParcels) {
            parcel.packageItem();
            parcel.deliver();
        }
    }

    private static void calculateCosts() {
        // Посчитать общую стоимость всех доставок и вывести на экран
        int totalCost = 0;
        for (Parcel parcel : allParcels) {
            totalCost += parcel.calculateDeliveryCost();
        }
        System.out.println("Общая стоимость всех доставок: " + totalCost);
    }

    private static void updateTrackableStatus() {
        String newLocation = readNewLocation();

        for (Trackable trackableParcel: trackableParcels) {
            trackableParcel.reportStatus(newLocation);
        }
    }

    private static void showParcelsOfBox() {
        int choice = readTypeofParcels();

        switch (choice) {
            case 1:
                standardParcelBox.getAllParcels();
                break;
            case 2:
                fragileParcelBox.getAllParcels();
                break;
            case 3:
                perishableParcelBox.getAllParcels();
                break;
            default:
                System.out.println("Введен неверный тип посылок");
        }
    }
}