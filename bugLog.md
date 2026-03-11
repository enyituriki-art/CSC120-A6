## Bug 1
Brief description: Computer constructor ignores the memory parameter and always sets memory to 16.
Failed unit test: testConstructorSetsMemoryCorrectly()

## Bug 2
Brief description: Computer constructor ignores the price parameter and always sets price to 0. 
Failed unit test: testConstructorSetsPriceCorrectly()

## Bug 3
Brief description: setOS() ignores the argument and always sets operating system to "None"  
Failed unit test: testSetOSUpdatesOperatingSystem() 

## Bug 4
Brief description: toString() prints incorrect values because memory and price are wrong from constructor 
Failed unit test: testToStringContainsCorrectValues()

## Bug 5
Brief description: ResaleShop constructor incorrectly adds a computer to inventory so shops actually never start empty  
Failed unit test: testShopStartsEmpty()

## Bug 6
Brief description: buy() ignores the computer passed in and instead creates a new MacBook every time. 
Failed unit test: testBuyAddsCorrectComputer()

## Bug 7
Brief description: buy() does not check for duplicates and never throws the required RuntimeException
Failed unit test: testBuyDuplicateThrowsException()

## Bug 8
Brief description: sell() does not throw an exception when selling a computer not in inventory.  
Failed unit test: testSellThrowsIfNotInInventory()

## Bug 9
Brief description: refurbish() sets incorrect prices for year ranges (values do not match A2)
Failed unit test: testRefurbishUpdatesPriceCorrectly()

## Bug 10
Brief description: refurbish() fails to update OS correctly because it uses != for string comparison and calls broken setOS().
Failed unit test: testRefurbishUpdatesOSCorrectly()