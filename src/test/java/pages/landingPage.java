package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class landingPage {

    @FindBy(className = "header-search-button")
    public List<WebElement> txtSearch;

    @FindBy(id = "query-builder-test")
    WebElement searchBar;


//    @FindBy(xpath = "//a/span[text()='facebook/']")
    @FindBy(className = "search-match")
    public List<WebElement> searchResult;


    @FindBy(className = "octicon-mark-github")
    public List<WebElement> landingPageGit;
    @FindBy(xpath = "//a[contains(text(),'About')]")
    public WebElement about;

    public landingPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    public void doSearchByName(String searchName) throws InterruptedException {
        txtSearch.get(0).click();
        Thread.sleep(1000);
        searchBar.sendKeys(searchName);
        Thread.sleep(1000);
        searchBar.sendKeys(Keys.ARROW_DOWN);
        Thread.sleep(1000);
        searchBar.sendKeys(Keys.ENTER);
        Thread.sleep(1000);

    }

}
