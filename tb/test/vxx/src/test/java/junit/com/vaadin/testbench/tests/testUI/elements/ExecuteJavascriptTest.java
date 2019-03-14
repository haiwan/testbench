package junit.com.vaadin.testbench.tests.testUI.elements;

import org.junit.jupiter.api.Assertions;
import com.vaadin.testbench.TestBenchElement;
import com.vaadin.testbench.addons.junit5.extensions.unittest.VaadinTest;
import com.vaadin.testbench.tests.testUI.ElementQueryView;
import junit.com.vaadin.testbench.tests.testUI.GenericTestPageObject;

@VaadinTest
public class ExecuteJavascriptTest {

  private void openTestURL(GenericTestPageObject po) {
    po.loadPage(ElementQueryView.ROUTE);
  }

  @VaadinTest
  public void getProperty(GenericTestPageObject po) throws Exception {
    openTestURL(po);

    TestBenchElement button = po.$(NativeButtonElement.class).first();
    Long offsetTop = button.getPropertyDouble("offsetTop").longValue();
    Assertions.assertEquals(Long.valueOf(0) , offsetTop);
  }
}