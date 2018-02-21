import tests.MainTest;

public class Main {
    public static void main(String[] args) throws Exception {
        MainTest mainTest = new MainTest();
        mainTest.setUp();
        //mainTest.testGetAllURL("funExamples");
        //mainTest.testGetFirstURL("CrowdInput"); //7 secnds make shorter
        //mainTest.testLogin("config/User2");
       // mainTest.testEditAddressSlowed();
        //mainTest.testEditAddressRealtime(); //talk about how we can change passwords/other use details
         //add to cart from config
        //mainTest.SearchGeneric("Distributors", "Items"); //we can change items if we want? - get user input //can be expanded if time
        mainTest.testEbayAddtocart(); //- PAyment details so we cant add to card atm, so we just doing it indiv purchases
        mainTest.quit();
    }
}
