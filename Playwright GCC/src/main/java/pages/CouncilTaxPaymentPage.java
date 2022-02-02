package pages;

import com.microsoft.playwright.Page;

public class CouncilTaxPaymentPage extends BasePage {
    private final Page page;

    public CouncilTaxPaymentPage(Page page){
        super(page);
        this.page = page;
    }

    public String refField = "id=FT_183";

    public void completePaymentForm(String refNumber) throws InterruptedException {
        page.fill(refField, refNumber);
        System.out.println("Council Tax Payment Made");
        Thread.sleep(5000);
    }
}
