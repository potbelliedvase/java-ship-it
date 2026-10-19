package ru.yandex.practicum;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.yandex.practicum.delivery.FragileParcel;
import ru.yandex.practicum.delivery.PerishableParcel;
import ru.yandex.practicum.delivery.StandardParcel;

public class DeliveryCostTest {

    @Test
    public void costOfStandardParcelWithWeight1750ShouldBeEqual3500() {
        StandardParcel standardParcel = new StandardParcel(
                "Стопка журналов",
                1750,
                "г.Воронеж",
                5);

        Assertions.assertEquals(3500, standardParcel.calculateDeliveryCost());
    }

    @Test
    public void costOfFragileParcelWithWeight650ShouldBeEqual2600() {
        FragileParcel fragileParcel = new FragileParcel(
                "Зеркальце",
                650,
                "г.Санкт-Петербург",
                7);

        Assertions.assertEquals(2600, fragileParcel.calculateDeliveryCost());
    }

    @Test
    public void costOfPerishableParcelWithWeight4000ShouldBeEqual12000() {
        PerishableParcel perishableParcel = new PerishableParcel(
                "Пироги",
                4000,
                "г.Саратов",
                10,
                2);

        Assertions.assertEquals(12000, perishableParcel.calculateDeliveryCost());
    }

    @Test
    public void costOfStandardParcelWithWeight0ShouldBeEqual0() {
        StandardParcel standardParcel = new StandardParcel(
                "Стопка журналов",
                0,
                "г.Воронеж",
                5);

        Assertions.assertEquals(0, standardParcel.calculateDeliveryCost());
    }

    @Test
    public void costOfFragileParcelWithWeight0ShouldBeEqual0() {
        FragileParcel fragileParcel = new FragileParcel(
                "Зеркальце",
                0,
                "г.Санкт-Петербург",
                7);

        Assertions.assertEquals(0, fragileParcel.calculateDeliveryCost());
    }

    @Test
    public void costOfPerishableParcelWithWeight0ShouldBeEqual0() {
        PerishableParcel perishableParcel = new PerishableParcel(
                "Пироги",
                0,
                "г.Саратов",
                10,
                2);

        Assertions.assertEquals(0, perishableParcel.calculateDeliveryCost());
    }
}