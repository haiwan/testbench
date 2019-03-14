package junit.com.vaadin.testbench.tests.testUI.elements;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import com.vaadin.testbench.TestBenchElement;
import com.vaadin.testbench.addons.junit5.extensions.unittest.VaadinTest;
import com.vaadin.testbench.tests.testUI.ElementQueryView;
import junit.com.vaadin.testbench.tests.testUI.GenericTestPageObject;

@VaadinTest
public class ElementScreenCompareTest {

  /**
   * Height of the screenshots we want to capture
   */
  public static final int SCREENSHOT_HEIGHT = 850;

  /**
   * Width of the screenshots we want to capture
   */
  public static final int SCREENSHOT_WIDTH = 1500;

  private void openTestURL(GenericTestPageObject po) {
    po.loadPage(ElementQueryView.ROUTE);
  }


//    @Override
//    public List<DesiredCapabilities> getBrowserConfiguration() {
//        List<DesiredCapabilities> browsers = new ArrayList<>(
//                super.getBrowserConfiguration());
//        // Resize viewport does not work in Safari
//        browsers.remove(BrowserUtil.safari());
//        return browsers;
//    }


  @BeforeEach
  void setUp(GenericTestPageObject po) {
    po.getCommandExecutor().resizeViewPortTo(SCREENSHOT_WIDTH , SCREENSHOT_HEIGHT);
  }

  @VaadinTest
  public void elementCompareScreen(GenericTestPageObject po) throws Exception {
    openTestURL(po);
    TestBenchElement button4 = po.$(NativeButtonElement.class).get(4);

    Assertions.assertTrue(button4.compareScreen("button4"));
    TestBenchElement layout = button4.findElement(By.xpath("../.."));
    Assertions.assertTrue(layout.compareScreen("layout"));
  }

}