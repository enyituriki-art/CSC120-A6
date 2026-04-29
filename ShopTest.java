import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Unit tests for Computer and ResaleShop classes.
 * Each test is designed to reveal a specific bug in the starter code.
 */
public class ShopTest {

    // -------------------------
    // Computer Tests
    // -------------------------

    @Test
    public void testConstructorSetsMemoryCorrectly() {
        Computer c = new Computer("Test", "Intel", 500, 8, "Linux", 2020, 300);
        assertEquals(8, c.memory);
    }

    @Test
    public void testConstructorSetsPriceCorrectly() {
        Computer c = new Computer("Test", "Intel", 500, 8, "Linux", 2020, 300);
        assertEquals(300, c.price);
    }

    @Test
    public void testSetOSUpdatesOperatingSystem() {
        Computer c = new Computer("Test", "Intel", 500, 8, "Linux", 2020, 300);
        c.setOS("Windows");
        assertEquals("Windows", c.operatingSystem);
    }

    @Test
    public void testToStringContainsCorrectValues() {
        Computer c = new Computer("Test", "Intel", 500, 8, "Linux", 2020, 300);
        String s = c.toString();

        assertTrue(s.contains("Test"));
        assertTrue(s.contains("Intel"));
        assertTrue(s.contains("500"));
        assertTrue(s.contains("8"));
        assertTrue(s.contains("Linux"));
        assertTrue(s.contains("2020"));
        assertTrue(s.contains("300"));
    }

    // -------------------------
    // ResaleShop Tests
    // -------------------------

    @Test
    public void testShopStartsEmpty() {
        ResaleShop shop = new ResaleShop();
        assertEquals(0, shop.inventory.size()); 
        
    }

    @Test
    public void testBuyAddsCorrectComputer() {
        ResaleShop shop = new ResaleShop();
        Computer c = new Computer("Test", "Intel", 500, 8, "Linux", 2020, 300);

        shop.buy(c);

        assertTrue(shop.inventory.contains(c));
    }

    @Test
    public void testBuyDuplicateThrowsException() {
        ResaleShop shop = new ResaleShop();
        Computer c = new Computer("Test", "Intel", 500, 8, "Linux", 2020, 300);

        shop.buy(c);

        try {
            shop.buy(c);
            fail("Expected RuntimeException for duplicate buy");
        } catch (RuntimeException e) {
            // expected
        }
    }

    @Test
    public void testSellRemovesComputer() {
        ResaleShop shop = new ResaleShop();
        Computer c = new Computer("Test", "Intel", 500, 8, "Linux", 2020, 300);

        shop.buy(c);
        shop.sell(c);

        assertFalse(shop.inventory.contains(c));
    }

    @Test
    public void testSellThrowsIfNotInInventory() {
        ResaleShop shop = new ResaleShop();
        Computer c = new Computer("Test", "Intel", 500, 8, "Linux", 2020, 300);

        try {
            shop.sell(c);
            fail("Expected RuntimeException for invalid sell");
        } catch (RuntimeException e) {
            // expected
        }
    }

    @Test
    public void testRefurbishUpdatesPriceCorrectly() {
        ResaleShop shop = new ResaleShop();
        Computer c = new Computer("Test", "Intel", 500, 8, "Linux", 2015, 300);

        shop.buy(c);
        shop.refurbish(c, "Linux");

        assertEquals(550, c.price);
    }

    @Test
    public void testRefurbishUpdatesOSCorrectly() {
        ResaleShop shop = new ResaleShop();
        Computer c = new Computer("Test", "Intel", 500, 8, "Linux", 2020, 300);

        shop.buy(c);
        shop.refurbish(c, "Windows");

        assertEquals("Windows", c.operatingSystem);
    }

    @Test
    public void testRefurbishWithNoneDoesNotChangeOS() {
        ResaleShop shop = new ResaleShop();
        Computer c = new Computer("Test", "Intel", 500, 8, "Linux", 2020, 300);

        shop.buy(c);
        shop.refurbish(c, "None");

        assertEquals("Linux", c.operatingSystem);
    }

    @Test
    public void testPrintInventoryDoesNotCrash() {
        ResaleShop shop = new ResaleShop();
        Computer c = new Computer("Test", "Intel", 500, 8, "Linux", 2020, 300);

        shop.buy(c);

        shop.printInventory(); // should not throw exception
    }
}