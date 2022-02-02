package tests;

import com.microsoft.playwright.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import pages.CouncilTaxPaymentPage;
import pages.HomePage;
import pages.PaymentPage;
import pages.RentPaymentPage;

public class BaseTest {


    static Playwright playwright;
    static Browser browser;
    static HomePage home;
    static PaymentPage payment;
    static CouncilTaxPaymentPage council;
    static RentPaymentPage rent;

    BrowserContext context;
    static Page page;

    @BeforeAll
    static void launchBrowser(){
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(1000));
//        home = new HomePage(page);
//        payment = new PaymentPage(page);
    }

   // @AfterAll
    //static void closeBrowser(){
        //playwright.close();
    //}

    @BeforeEach
    void createContextPage(){
        context = browser.newContext();
        page = context.newPage();
        page.navigate("https://www.glasgow.gov.uk/home");
    }

    @AfterEach
    void closeContext(){
        context.close();
    }
}
