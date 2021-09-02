package pagesAdvanced;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AndroidFindBy;

import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.support.FindBy;

import java.util.List;


public class SwipeableBasicScreen extends BaseScreenADV{

    public SwipeableBasicScreen(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@resource-id='com.h6ah4i.android.example.advrecyclerview:id/container']")
    List<MobileElement> list;

    @AndroidFindBy(xpath="//*[@resource-id='android:id/button1']")
    MobileElement okButtonOnTheMessage;


    public SwipeableBasicScreen pinItem(int i) {
        logger.info("Method 'pinItem' starts");
        MobileElement element = list.get(i+1);
        toTheLeft(element);
        logger.info("Method 'pinItem' is done");
        return this;
    }

    public SwipeableBasicScreen removeItem(int i) {
        logger.info("Method 'removeItem' starts");
        MobileElement element = list.get(i+1);
        toTheRight(element);
        logger.info("Method 'removeItem' is done");
        return this;
    }

    public SwipeableBasicScreen pinAndUnpinItem(int i) {
        logger.info("Method 'pinAndUnpinItem' starts");
        pinItem(i);

        int index = i+1;
        String xpathItemPinned = "//*[@resource-id='com.h6ah4i.android.example.advrecyclerview:id/recycler_view']//*[@class='android.widget.FrameLayout'][" + index +"]";
        MobileElement element = driver.findElement(By.xpath(xpathItemPinned));
        toTheRight(element);
        logger.info("Method 'pinAndUnpinItem' is done");
        return this;
    }

    public void toTheLeft(MobileElement el) {
        Rectangle rect = el.getRect();
        int xFrom = (int)(rect.getX() + rect.getWidth() * 0.8);
        int yFrom = rect.getY() + rect.getHeight() / 2;
        int xTo = rect.getX() + rect.getWidth() / 4;

        TouchAction<?> touchAction = new TouchAction<>(driver);
        touchAction.longPress(PointOption.point(xFrom, yFrom))
                .moveTo(PointOption.point(xTo, yFrom))
                .release()
                .perform();

        okButtonOnTheMessage.click();

        logger.info("Swipe to the left is done");

    }

    public void toTheRight(MobileElement el) {
        Rectangle rect = el.getRect();
        int xFrom = rect.getX() + rect.getWidth() / 4;
        int yFrom = rect.getY() + rect.getHeight() / 2;
        int xTo = (int) (rect.getX() + rect.getWidth() * 0.8);

        TouchAction<?> touchAction = new TouchAction<>(driver);
        touchAction.longPress(PointOption.point(xFrom, yFrom))
                .moveTo(PointOption.point(xTo, yFrom))
                .release()
                .perform();

        logger.info("Swipe to the right is done");

    }

//************* additional method ***************
    public SwipeableBasicScreen swipeAndDragDown(int i, int method) {
        logger.info("Method 'pinItemDragDown' starts");

        int difference = i - 8;
        int index = 0;
        MobileElement element = list.get(0);

        if (difference < 0) {
            index = i + 1;
            element = list.get(index);
        }
        if (difference >= 0 && difference < 8) {
            dragDown(1);
            index = difference + 1;
            element = list.get(index);
        }
        if (difference >= 8 && difference < 16) {
            dragDown(2);
            index = (difference - 8) + 1;
            element = list.get(index);
        }
        if (difference >= 16 && difference < 24) {
            dragDown(3);
            index = (difference - 16) + 1;
            element = list.get(index);
        }
        if (difference >= 24 && difference < 32) {
            dragDown(4);
            index = (difference - 24) + 1;
            element = list.get(index);
        }
        if (difference >= 32 && difference < 40) {
            dragDown(5);
            index = (difference - 32) + 1;
            element = list.get(index);
        }
        if (difference >= 40) {
            dragDown(6);
            index = (difference - 36) + 1;
            element = list.get(index);
        }
        switch (method) {
            case 1:
                toTheLeft(element);
                break;
            case 2:
                toTheRight(element);
                break;
            case 3:
                pinAndUnpinItem(element, index);
                break;
        }
        logger.info("Method 'pinItemDragDown' is done");
        return this;
    }

    public void dragDown(int count) {

        for( int j = count; j != 0; j--) {
            MobileElement element = list.get(8);
            Rectangle rect = element.getRect();
            int xFrom = (int) (rect.getX() + rect.getWidth() * 0.5);
            int yFrom = (int) (rect.getY() - rect.getHeight() * 0.2);
            int yTo = 0;

            TouchAction<?> touchAction = new TouchAction<>(driver);
            touchAction.longPress(PointOption.point(xFrom, yFrom))
                    .moveTo(PointOption.point(xFrom,yTo))
                    .release()
                    .perform();
        }

        logger.info("Drag down is done");
    }

    public SwipeableBasicScreen pinAndUnpinItem(MobileElement el, int i) {
        logger.info("Method 'pinAndUnpinItem' starts");
        toTheLeft(el);

        String xpathItemPinned = "//*[@resource-id='com.h6ah4i.android.example.advrecyclerview:id/recycler_view']//*[@class='android.widget.FrameLayout'][" + i +"]";
        MobileElement element = driver.findElement(By.xpath(xpathItemPinned));
        toTheRight(element);
        logger.info("Method 'pinAndUnpinItem' is done");
        return this;
    }

}
