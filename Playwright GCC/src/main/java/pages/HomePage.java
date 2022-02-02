package pages;

import com.microsoft.playwright.*;

public class HomePage extends BasePage{
    private final Page page;
    public HomePage(Page page) {
        super(page);
        this.page = page;
    }


    public String payBillLink = "//*[@id='actionButtonsGroup']/li[1]/a";

    public void selectPaymentLink(){
        page.click(payBillLink);
    }
}
