package ru.yandex.practicum;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.yandex.practicum.delivery.PerishableParcel;

public class IsExpiredTest {

    PerishableParcel perishableParcel = new PerishableParcel(
            "Пироги",
            4000,
            "г.Саратов",
            10,
            2);

    @Test
    public void shouldBeExpiredWhenCurrentDayBiggerThanSumOfSendDayAndTtl() {
        Assertions.assertTrue(perishableParcel.isExpired(13));
    }

    @Test
    public void shouldBeNotExpiredWhenCurrentDayEqualsSumOfSendDayAndTtl() {
        Assertions.assertFalse(perishableParcel.isExpired(12));
    }

    @Test
    public void shouldBeNotExpiredWhenCurrentDayLessThanSumOfSendDayAndTtl() {
        Assertions.assertFalse(perishableParcel.isExpired(11));
    }
}