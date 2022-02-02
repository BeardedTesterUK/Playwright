package pages;

import com.microsoft.playwright.*;

public class PaymentPage extends BasePage{
    private final Page page;
    public PaymentPage(Page page) {
        super(page);
        this.page = page;
    }

    public String councilTaxLink = "//button[text()='Council Tax']";
    public String rentPaymentButton = "//button[text()='Homeless Temporary Accommodation']";

    public void selectCouncilTaxPayment()  {
        page.click(councilTaxLink);
    }

    public void selectHomelessRent() {
        page.click(rentPaymentButton);
       // confirmTitle("Glasgow City Council - Data Entry");
    }
}
