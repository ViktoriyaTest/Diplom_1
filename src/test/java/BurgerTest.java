import jdk.jfr.Description;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(MockitoJUnitRunner.class) //Запустили класс с Mockito
public class BurgerTest {

    private final float price = 0;

    @Mock
    Bun bun;

    @Mock
    Ingredient ingredient1;
    Ingredient ingredient2;

    Burger burger = new Burger();

    @Test
    @DisplayName("setBunsTest")
    @Description("Проверяется метод Булочки")
    public void setBunsTest() {
        burger.setBuns(bun);
        assertEquals(bun, burger.bun);
    }

    @Test
    @DisplayName("addIngredientTest")
    @Description("Проверяется метод добавления ингредиента")
    public void addIngredientTest() {
        burger.addIngredient(ingredient1);
        assertTrue(burger.ingredients.contains(ingredient1));
    }

    @Test
    @DisplayName("removeIngredientTest")
    @Description("Проверяется метод удаления ингредиента")
    public void removeIngredientTest() {
        burger.addIngredient(ingredient1);
        burger.removeIngredient(0);
        Assert.assertFalse(burger.ingredients.contains(ingredient1));
    }

    @Test
    @DisplayName("moveIngredientTest")
    @Description("Проверяется метод перемещения ингредиента")
    public void moveIngredientTest() {
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        burger.moveIngredient(0, 1);
        Assert.assertEquals(ingredient1, burger.ingredients.get(1));
    }

    @Test
    @DisplayName("getPriceTest")
    @Description("Проверяется метод цены")
    public void getPriceTest() {
        burger.setBuns(bun);
        burger.addIngredient(ingredient1);
        assertEquals(price, burger.getPrice(), 0);
    }

    @Test
    @DisplayName("getReceiptTest")
    @Description("Проверяется метод получения чека")
    public void getReceiptTest() {
        burger.setBuns(bun);
        burger.addIngredient(ingredient1);

        Mockito.when(bun.getName()).thenReturn("white bun");
        Mockito.when(bun.getPrice()).thenReturn(200f);
        Mockito.when(ingredient1.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(ingredient1.getName()).thenReturn("chili sauce");
        Mockito.when(ingredient1.getPrice()).thenReturn(300f);

        String actualResult = burger.getReceipt();
        String expectedResult = String.format("(==== white bun ====)%n"
                + "= sauce chili sauce =%n"
                + "(==== white bun ====)%n"
                + "%n"
                + "Price: 700,000000%n");
        assertEquals(expectedResult, actualResult);
    }
}