package ru.netology.javaqadiplom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
public class CreditAccountTest {

    @Test
    public void shouldAddToPositiveBalance() {
        CreditAccount account = new CreditAccount(
                1_000,
                5_000,
                15
        );
        account.add(3_000);
        Assertions.assertEquals(4_000, account.getBalance());
        System.out.println("Тест №1");
        System.out.println(" Добавление новых средств к текущему балансу ");
    }
    @Test
    public void negativeInitialBalance(){
        Assertions.assertThrows(IllegalArgumentException.class, () ->{
            new CreditAccount(-1_000, 5_000,15);
        });
        System.out.println("Тест №2");
        System.out.println("Воспроизведение ошибки при отрицательном начальном балансе");
    }
    @Test
    public void negativeCreditLimit(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new CreditAccount(1_000,-5_000,15);
        });
        System.out.println("Тест №3");
        System.out.println("Воспроизведение ошибки при отрицательном кредитном лимите");
    }
    @Test
    public void negativeRate(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new CreditAccount(1_000,5_000,-15);
        });
        System.out.println("Тест №4");
        System.out.println("Воспроизведение ошибки при отрицательной процентной ставке");
    }
    @Test
    public void zeroRate(){
        CreditAccount account = new CreditAccount(
                1_000,
                5_000,
                0
        );
        Assertions.assertEquals(0, account.getRate());
        System.out.println("Тест №5");
        System.out.println("Нулевая ставка допустима, ошибка не должна воспроизводиться");
    }
    @Test
    public void shouldChangeIfAmountPositive(){
        CreditAccount account = new CreditAccount(
                1_000,
                5_000,
                15
        );
        account.pay(500);
        Assertions.assertEquals(500, account.getBalance());
        System.out.println("Тест №6");
        System.out.println("Покупка на N-ую сумму денег");
        System.out.println("Должно измениться, если сумма положительная");
    }
    @Test
    public void shouldZeroIfEqualBalance(){
        CreditAccount account = new CreditAccount(
                1_000,
                5_000,
                15
        );
        account.pay(1_000);
        Assertions.assertEquals(0,account.getBalance());
        System.out.println("Тест №7");
        System.out.println("Покупка на всю сумму денег на балансе");
        System.out.println("Должно быть равно нулю, если баланс равен покупке");
    }
    @Test
    public void shouldNegativeBalance(){
        CreditAccount account = new CreditAccount(
                1_000,
                5_000,
                15
        );
        account.pay(2_000);
        Assertions.assertEquals(-1_000, account.getBalance());
        System.out.println("Тест №8");
        System.out.println("Покупка на сумму денег превышающую баланс");
        System.out.println("Должен быть отрицательный баланс");
    }
    @Test
    public void ifAmountIsMoreThanCreditLimitPlusBalance(){
        CreditAccount account = new CreditAccount(
                1_000,
                5_000,
                15
        );
        account.pay(10_000);
        Assertions.assertEquals(1_000, account.getBalance());
        System.out.println("Тест №9");
        System.out.println("Покупка на сумму денег превышающую баланс и баланс");
        System.out.println("Если сумма превышает кредитный лимит и баланс, то покупка не совершается и текущий баланс не меняется");
    }
    @Test
    public void debtIfBalanceNegative(){
        CreditAccount account = new CreditAccount(
                1_000,
                5_000,
                15
        );
        account.pay(1_200);
        Assertions.assertEquals(-30, account.yearChange());
        System.out.println("Тест №10");
        System.out.println("Операция расчёта процентов на отрицательный баланс счёта");
        System.out.println("Долг должен начислиться");

    }
    @Test
    public void debtIfBalanceZero(){
        CreditAccount account = new CreditAccount(
                1_000,
                5_000,
                15
        );
        account.pay(1_000);
        Assertions.assertEquals(0, account.yearChange());
        System.out.println("Тест №11");
        System.out.println("Операция расчёта процентов на нулевой баланс счёта");
        System.out.println("Начисление процентов быть не должно");
    }
    @Test
    public void debtIfBalancePositive(){
        CreditAccount account = new CreditAccount(
                1_000,
                5_000,
                15
        );
        account.pay(500);
        Assertions.assertEquals(0, account.yearChange());
        System.out.println("Тест №12");
        System.out.println("Операция расчёта процентов на положительный баланс счёта");
        System.out.println("Начисление процентов быть не должно");
    }
}
