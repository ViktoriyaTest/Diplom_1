import org.junit.Test;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

public class IngredientTypeTest {
    @Test
    public void chooseIngredientSauce() {
        assertEquals(IngredientType.valueOf("SAUCE"), IngredientType.SAUCE);
    }

    @Test
    public void chooseIngredientFilling() {
        assertEquals(IngredientType.valueOf("FILLING"), IngredientType.FILLING);
    }
}