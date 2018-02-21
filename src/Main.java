import tests.MainTest;

public class Main {
    public static void main(String[] args) throws Exception {
        MainTest mainTest = new MainTest();
        mainTest.setUp();
        //mainTest.testGetAllURL("funExamples");
        //mainTest.testGetFirstURL("funExamples");
        //mainTest.testLogin("config/User1");
       // mainTest.testEditAddressSlowed();
        //mainTest.testEditAddressRealtime();
        //mainTest.LogOut();
        //mainTest.testEbayAddtocart(); //add to cart from config
        //mainTest.SearchGeneric("Distributors", "Items");
        mainTest.testEbayAddtocart();
        mainTest.quit();
    }
}
