import static org.junit.jupiter.api.Assertions.assertEquals;

public class BonusServiceTest {

    @org.junit.jupiter.api.Test
    void shouldCalculateForRegisteredAndUnderLimit() {
        BonusService service = new BonusService();

        // подготавливаем данные:
        long amount = 1000;
        boolean registered = true;
        long expected = 30;

        // вызываем целевой метод:
        long actual = service.calculate(amount, registered);

        // производим проверку (сравниваем ожидаемый и фактический):
        assertEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    void shouldCalculateForRegisteredAndOverLimit() {
        BonusService service = new BonusService();

        // подготавливаем данные:
        long amount = 1_000_000;
        boolean registered = true;
        long expected = 500;

        // вызываем целевой метод:
        long actual = service.calculate(amount, registered);

        // производим проверку (сравниваем ожидаемый и фактический):
        assertEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    void shouldCalculateForMaxAmount() {
        BonusService service = new BonusService();

        long amount = Long.MAX_VALUE;
        boolean registered = true;
        long expected = 500;

        long actual = service.calculate(amount, registered);

        assertEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    void shouldCalculateForZeroAmount() {
        BonusService service = new BonusService();

        long amount = 0;
        boolean registered = true;
        long expected = 0;

        long actual = service.calculate(amount, registered);

        assertEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    void shouldCalculateForBoundaryAmount() {
        BonusService service = new BonusService();

        long amount = 500_000; // Лимит
        boolean registered = true;
        long expected = 500;

        long actual = service.calculate(amount, registered);

        assertEquals(expected, actual);
    }

     @org.junit.jupiter.api.Test
    void shouldCalculateForNotRegisteredAndUnderLimit() {
        BonusService service = new BonusService();

        long amount = 1000;
        boolean registered = false;
        long expected = 10; // для нерегистрированного пользователя

        long actual = service.calculate(amount, registered);

        assertEquals(expected, actual);
    }

     @org.junit.jupiter.api.Test
    void shouldCalculateForNotRegisteredAndOverLimit() {
        BonusService service = new BonusService();

        long amount = 1_000_000;
        boolean registered = false;
        long expected = 500; // для нерегистрированного пользователя

        long actual = service.calculate(amount, registered);

        assertEquals(expected, actual);
    }



}
