import tests.MainTest;

public class Main {
    public static void main(String[] args) throws Exception {
        MainTest mainTest = new MainTest();
        mainTest.setUp();
        //mainTest.testGetAllURL("funExamples");
        //mainTest.testGetFirstURL("CrowdInput"); - if time?
        //mainTest.testLogin("config/User1"); //DO USER2 as well

        // EDIT CONFIG FILE


        //mainTest.testEditAddressRealtime();
        //mainTest.SearchGeneric("Distributors", "Items");
       // mainTest.testEbayAddtocart();



        mainTest.quit();
    }
}
