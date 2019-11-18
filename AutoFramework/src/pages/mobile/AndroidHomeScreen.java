package pages.mobile;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class AndroidHomeScreen {
    AppiumDriver<MobileElement> driver;

    @AndroidFindBy(id="com.aavn.devday.booklibrary:id/edt_search_book")
    AndroidElement txtSearch;

    public AndroidHomeScreen(AppiumDriver<MobileElement> driver)
    {
        this.driver = driver;
        //This initElements method will create  all WebElements
        PageFactory.initElements(new AppiumFieldDecorator(this.driver), this);
    }

    public AndroidElement getSearch() {
        return txtSearch;
    }


}
