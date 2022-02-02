package tests;


import org.junit.jupiter.api.Test;
import pages.CouncilTaxPaymentPage;
import pages.HomePage;
import pages.PaymentPage;
import pages.RentPaymentPage;

public class CouncilTests extends BaseTest{

    public String payBillLink = "//*[@id='actionButtonsGroup']/li[1]/a";
    public String councilTaxLink = "//button[text()='Council Tax']";
    public String refField = "id=FT_183";

    @Test
    public void payACouncilTaxBill() throws InterruptedException {
        home = new HomePage(page);
        home.selectPaymentLink();
        payment = new PaymentPage(page);
        payment.selectCouncilTaxPayment();
        council = new CouncilTaxPaymentPage(page);
        council.completePaymentForm("12345");
    }

    @Test
    public void payCouncilTaxBillFromCouncilTaxPage(){

    }

    @Test
    public void payAHousingBenefitBill() {

    }

    @Test
    public void payRentBill() {
        home = new HomePage(page);
        home.selectPaymentLink();
        payment = new PaymentPage(page);
        payment.selectHomelessRent();
        rent = new RentPaymentPage(page);
        rent.completePaymentForm("12345678",
                "John Smith",
                "1 Address Street",
                "AB1 2CD",
                "10",
                "50");
        rent.confirmPayment();
        rent.returnHome();
    }

    @Test
    public void mandatoryFieldErrorMessage() {
        home = new HomePage(page);
        home.selectPaymentLink();
        payment = new PaymentPage(page);
        payment.selectHomelessRent();
        rent = new RentPaymentPage(page);
        rent.confirmErrorMessages("Please enter a valid reference number",
                "This must not be left blank",
                "Please enter your house name or number and street name",
                "Please enter a valid postcode",
                "Please enter an amount");
        rent.returnHome();
    }
}
