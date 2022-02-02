package pages;

import com.microsoft.playwright.Page;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.*;

public class RentPaymentPage extends BasePage{
    private final Page page;
    public RentPaymentPage(Page page) {
        super(page);
        this.page = page;
    }

    public String referenceNumberField = "id=FT_136";
    public String nameField = "id=FT_137";
    public String firstAddressLineField = "id=FT_138";
    public String postcodeField = "id=PCI_24";
    public String amountFieldPounds = "id=ATI_23";
    public String amountFiledPence = "id=ATIPence_23";
    public String continueButton = "id=continue";
    public String referenceNumberError = "div[class='aip_error_style aip_common_control_style'] label[for='FT_136']";


    public void completePaymentForm(String ref, String name, String address, String postcode, String pounds, String pence) {
        page.fill(referenceNumberField, ref);
        page.fill(nameField,name);
        page.fill(firstAddressLineField, address);
        page.fill(postcodeField, postcode);
        page.fill(amountFieldPounds, pounds);
        page.fill(amountFiledPence, pence);
    }

    public void confirmPayment(){
        System.out.println("CLICK CONTINUE PAYMENT");
    }

    public void confirmErrorMessages(String ref, String name, String address, String postcode, String amount) {
        page.click(continueButton);
        assertThat(page.locator(referenceNumberError)).containsText("Please enter a valid reference number");
    }
}
