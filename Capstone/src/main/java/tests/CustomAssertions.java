package tests;

import org.testng.Assert;

public class CustomAssertions extends Assert {
    public static void isLabelEqual (String expectedText, String currentText) {
        String errorMsg = "Label " + currentText + " is not as expected. Expected was: " + expectedText;
        Assert.assertEquals(currentText, expectedText, errorMsg);
        System.out.println("Checking if current label " + currentText + " is equal to " +  expectedText );
    }

    public static void isNotEmpty (String currentText) {
        String errorMsg = "Label  is empty";
        Assert.assertNotEquals(currentText, null, errorMsg);
        System.out.println("Checking if current label is not empty" );
    }

    public static void isImageDisplayed (Boolean imageDisplayed) {
        String errorMsg = "Image of product was not displayed";
        Assert.assertTrue(imageDisplayed, errorMsg);
        System.out.println("Checking if current image is displayed" );
    }

}
