package pagesAdvanced;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;


public class SwipeScreen extends BaseScreenADV{
    public SwipeScreen(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    @AndroidFindBy(xpath="//*[@resource-id='com.h6ah4i.android.example.advrecyclerview:id/button'][2]")
    MobileElement swipeBasic;

    public SwipeableBasicScreen selectSwipeBasic(){
        if(swipeBasic.isEnabled())
        {
            swipeBasic.click();
            logger.info("selectSwipeBasic method is done");
        }
        return new SwipeableBasicScreen(driver);
    }
}
