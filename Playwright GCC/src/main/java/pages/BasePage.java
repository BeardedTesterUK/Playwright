package pages;

import com.microsoft.playwright.Page;

public class BasePage {

    //Constructor
    private final Page page;
    public BasePage(Page page){
        this.page = page;
    }

    public String homeButton = "id=gccLogoTop";


    public void confirmTitle(String title){
        page.title().contains(title);
    }

    public void returnHome(){
        page.click(homeButton);
        confirmTitle("Homepage of Glasgow City Council - Glasgow City Council");
        System.out.println("RETURNING HOME");
    }
}
