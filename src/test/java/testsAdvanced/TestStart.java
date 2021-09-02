package testsAdvanced;

import config.ConfigAdvanced;
import org.testng.annotations.Test;
import pagesAdvanced.DragScreen;

public class TestStart extends ConfigAdvanced {
    @Test
    public void dragDownTest() {
        new DragScreen(driver)
                .selectDraggableBasic()
                .dragDown();
    }

    @Test
    public void dragDownCountTest() {
        new DragScreen(driver)
                .selectDraggableBasic()
                .dragDown(4);
    }

    @Test
    public void dragDownWindowTest() {
        new DragScreen(driver)
                .selectDraggableBasic()
                .dragDownWindow();
    }


    @Test
    public void swipeTestPinItem()  {
        new DragScreen(driver)
                .selectSwipe()
                .selectSwipeBasic()
                .pinItem(0);
    }

    @Test
    public void swipeTestPinUnpin()  {
        new DragScreen(driver)
                .selectSwipe()
                .selectSwipeBasic()
                .pinAndUnpinItem(5);
    }

    @Test
    public void swipeTestRemove()  {
        new DragScreen(driver)
                .selectSwipe()
                .selectSwipeBasic()
                .removeItem(7);

    }
//************ additional test ***********
    @Test
    public void swipeDragDownTest() {
        new DragScreen(driver)
                .selectSwipe()
                .selectSwipeBasic()
                .pinItemDragDown(48);
    }
}
