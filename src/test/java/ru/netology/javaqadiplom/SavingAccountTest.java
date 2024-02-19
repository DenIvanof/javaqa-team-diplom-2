package ru.netology.javaqadiplom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SavingAccountTest {

    @Test
    public void shouldAddLessThanMaxBalance() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        account.add(3_000);

        Assertions.assertEquals(2_000 + 3_000, account.getBalance());
    }


    @Test
    public void shouldNotPayMoreThanBalance() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        Assertions.assertFalse(account.pay(3_000));
        Assertions.assertEquals(2_000, account.getBalance());
    }

    @Test
    public void shouldPayEqMinBalance() {
        SavingAccount account = new SavingAccount(
                5_000,
                1_000,
                10_000,
                5
        );

        boolean result = account.pay(4_000);

        Assertions.assertTrue(result);
        Assertions.assertEquals(1000, account.getBalance());
    }

    @Test
    public void shouldAddEqualsMaxBalance() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );
        account.add(8_000);

        Assertions.assertEquals(2_000 + 8_000, account.getBalance());
    }

    @Test
    public void shouldMinBalanceMoreMaxBalance() { // исключение, когда минимальный баланс выше максимального

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new SavingAccount(2_000, 10_000, 8_000, 5);
        });
    }

    @Test
    public void shouldMinBalanceNegative() {

        Assertions.assertThrows(IllegalArgumentException.class, () -> { // исключение, когда минимальный баланс отрицательный
            new SavingAccount(2_000, -1_000, 10_000, 5);
        });
    }

    @Test
    public void shouldMaxBalanceNegative() {

        Assertions.assertThrows(IllegalArgumentException.class, () -> { // исключение, когда максимальный баланс отрицательный
            new SavingAccount(2_000, 1_000, -10_000, 5);
        });
    }

    @Test
    public void shouldInitialBalanceNegative() {

        Assertions.assertThrows(IllegalArgumentException.class, () -> { // исключение, когда начальный баланс отрицательный
            new SavingAccount(-2_000, 1_000, 10_000, 5);
        });
    }

    @Test
    public void TestYearChangeZeroInitialBalance() { // исключение, если начальный баланс равен 0

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new SavingAccount(0_000, 2_000, 10_000, 5);
        });
    }

}








