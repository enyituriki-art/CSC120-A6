import static org.junit.Assert.*;
import org.junit.Test;
/**
 * Unit tests for the Computer and ResaleShop classes.
 * Each test checks for a specific bug in the provided starter code.
 */
public class ShopTest {

    // Tests for computer class

    @Test
    public void testConstructorSetsMemoryCorrectly() {
        Computer c = new Computer("Test", "Intel", 500, 8, "Linux", 2020, 300);
        assertEquals(8, c.memory);   // BUG: constructor hardcodes memory = 16
    }

    @Test
    public void testConstructorSetsPriceCorrectly() {
        Computer c = new Computer("Test", "Intel", 500, 8, "Linux", 2020, 300);
        assertEquals(300, c.price);  // BUG: constructor sets as price = 0
    }

    @Test
    public void testSetOSUpdatesOperatingSystem() {
        Computer c = new Computer("Test", "Intel", 500, 8, "Linux", 2020, 300);
        c.setOS("Windows");
        assertEquals("Windows", c.operatingSystem);  // BUG: setOS always sets OS to "None"
    }

    @Test
    public void testToStringContainsCorrectValues() {
        Computer c = new Computer("Test", "Intel", 500, 8, "Linux", 2020, 300);
        String s = c.toString();
        assertTrue(s.contains("Test"));
        assertTrue(s.contains("Intel"));
        assertTrue(s.contains("500"));
        assertTrue(s.contains("8"));     // BUG: memory is printed as 16
        assertTrue(s.contains("Linux"));
        assertTrue(s.contains("2020"));
        assertTrue(s.contains("300"));   // BUG: price is printed as 0
    }


    // Tests for resale shop

    @Test
    public void testShopStartsEmpty() {
        ResaleShop shop = new ResaleShop();
        assertEquals(0, shop.inventory.size());  // BUG: constructor adds a computer
    }

    @Test
    public void testBuyAddsCorrectComputer() {
        ResaleShop shop = new ResaleShop();
        Computer c = new Computer("Test", "Intel", 500, 8, "Linux", 2020, 300);
        shop.buy(c);
        assertTrue(shop.inventory.contains(c));  // BUG: buy() ignores argument and adds a new MacBook
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
        // BUG: buy() never checks duplicates, never throws
    }

    @Test
    public void testSellRemovesComputer() {
        ResaleShop shop = new ResaleShop();
        Computer c = new Computer("Test", "Intel", 500, 8, "Linux", 2020, 300);
        shop.buy(c);
        shop.sell(c);
        assertFalse(shop.inventory.contains(c));  // BUG: sell() might fail due to equals() missing
        But it does NOT throw an exception when selling something NOT in inventory
    }

    @Test
    public void testSellThrowsIfNotInInventory() {
        ResaleShop shop = new ResaleShop();
        Computer c = new Computer("Test", "Intel", 500, 8, "Linux", 2020, 300);
        try {
            shop.sell(c);
            fail("Expected RuntimeException for selling non-existent computer");
        } catch (RuntimeException e) {
            // expected
        }
        // BUG: sell() never throws
    }

    @Test
    public void testRefurbishUpdatesPriceCorrectly() {
        ResaleShop shop = new ResaleShop();
        Computer c = new Computer("Test", "Intel", 500, 8, "Linux", 2015, 300);
        shop.buy(c);
        shop.refurbish(c, "Linux");
        assertTrue(c.price < 300);  // BUG: refurbish sets wrong price ranges
    }

    @Test
    public void testRefurbishUpdatesOSCorrectly() {
        ResaleShop shop = new ResaleShop();
        Computer c = new Computer("Test", "Intel", 500, 8, "Linux", 2020, 300);
        shop.buy(c);
        shop.refurbish(c, "Windows");
        assertEquals("Windows", c.operatingSystem);  // BUG: setOS + string comparison both broken
    }

    @Test
    public void testPrintInventoryDoesNotCrash() {
        ResaleShop shop = new ResaleShop();
        Computer c = new Computer("Test", "Intel", 500, 8, "Linux", 2020, 300);
        shop.buy(c);
        try {
            shop.printInventory();
        } catch (Exception e) {
            fail("printInventory should not throw");
        }
        // BUG: for-loop uses <= and crashes
    }
}
