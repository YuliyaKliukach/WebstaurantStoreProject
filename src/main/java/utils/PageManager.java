package utils;

import pages.HomePage;

public class PageManager {
    public static HomePage homePage;

    public static void initializePageObjects(){
        homePage=new HomePage();
    }
}
