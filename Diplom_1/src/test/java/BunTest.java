import jdk.jfr.Description;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BunTest {
    private final String name;
    private final float price;

    public BunTest(String name, float price) {
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters(name = "Булочка. Тестовые данные: {0}; {1}")
    public static Object[][] getBuns() {
        return new Object[][]{
                {"black bun", 100},
                {"white bun", 200},
                {"red bun", 300},
        };
    }

    @Test
    @DisplayName("CheckNameBuns")
    @Description("Проверяем имя булочки")
    public void getNameBuns() {
        Bun bun = new Bun(name, price);
        assertEquals(name, bun.getName());
    }

    @Test
    @DisplayName("CheckPriceBuns")
    @Description("Проверяем стоимость булочки")
    public void getPriceBuns() {
        Bun bun = new Bun(name, price);
        assertEquals(price, bun.getPrice(), 0);
    }

}