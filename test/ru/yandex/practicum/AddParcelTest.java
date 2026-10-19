package ru.yandex.practicum;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.yandex.practicum.delivery.ParcelBox;
import ru.yandex.practicum.delivery.StandardParcel;

public class AddParcelTest {

    ParcelBox<StandardParcel> parcelBox;
    StandardParcel standardParcel;

    @Test
    public void parcelShouldBeAddWhenWeightLessMaxWeight() {
        parcelBox = new ParcelBox<>(10000);
        standardParcel = new StandardParcel(
                "Стопка журналов",
                5000,
                "г.Воронеж",
                5);
        parcelBox.addParcel(standardParcel);
        Assertions.assertEquals(1, parcelBox.getParcels().size());
    }

    @Test
    public void parcelShouldBeAddWhenWeightEqualsMaxWeight() {
        parcelBox = new ParcelBox<>(10000);
        standardParcel = new StandardParcel(
                "Стопка журналов",
                10000,
                "г.Воронеж",
                5);
        parcelBox.addParcel(standardParcel);
        Assertions.assertEquals(1, parcelBox.getParcels().size());
    }

    @Test
    public void parcelNotShouldBeAddWhenWeightMoreMaxWeight() {
        parcelBox = new ParcelBox<>(10000);
        standardParcel = new StandardParcel(
                "Стопка журналов",
                10001,
                "г.Воронеж",
                5);
        parcelBox.addParcel(standardParcel);
        Assertions.assertEquals(0, parcelBox.getParcels().size());
    }

    @Test
    public void fewParcelsShouldBeAddWhenWeightLessMaxWeight() {
        parcelBox = new ParcelBox<>(10000);
        standardParcel = new StandardParcel(
                "Стопка журналов",
                5000,
                "г.Воронеж",
                5);
        parcelBox.addParcel(standardParcel);

        standardParcel = new StandardParcel(
                "Стопка журналов",
                4999,
                "г.Воронеж",
                5);
        parcelBox.addParcel(standardParcel);

        Assertions.assertEquals(2, parcelBox.getParcels().size());
    }

    @Test
    public void fewParcelShouldBeAddWhenWeightEqualsMaxWeight() {
        parcelBox = new ParcelBox<>(10000);
        standardParcel = new StandardParcel(
                "Стопка журналов",
                5000,
                "г.Воронеж",
                5);
        parcelBox.addParcel(standardParcel);

        standardParcel = new StandardParcel(
                "Стопка журналов",
                5000,
                "г.Воронеж",
                5);
        parcelBox.addParcel(standardParcel);

        Assertions.assertEquals(2, parcelBox.getParcels().size());
    }

    @Test
    public void fewParcelsNotShouldBeAddWhenWeightMoreMaxWeight() {
        parcelBox = new ParcelBox<>(10000);
        standardParcel = new StandardParcel(
                "Стопка журналов",
                5000,
                "г.Воронеж",
                5);
        parcelBox.addParcel(standardParcel);

        standardParcel = new StandardParcel(
                "Стопка журналов",
                5001,
                "г.Воронеж",
                5);
        parcelBox.addParcel(standardParcel);

        Assertions.assertEquals(1, parcelBox.getParcels().size());
    }
}

//Предлагаем вам протестировать следующие функции:
//Вычисление стоимости посылки для каждого типа посылок.
//Работа метода isExpired — метод должен корректно вычислять, не испортилась ли посылка.
//Проверка добавления новой посылки в коробку. Если максимальный вес не превышен, посылка
//     должна добавляться, а если превышен — нет.

//Для каждой из функций проверьте один-два стандартных сценария для разных входных данных и один
//граничный. Используйте JUnit для реализации юнит-тестов.