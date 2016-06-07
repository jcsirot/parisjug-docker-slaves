package net.chelonix.parisjug;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * Created by jcsirot on 07/06/16.
 */
public class TestGoogle {
  private WebDriver driver;

  @Before
  public void setUp() throws Exception {
    DesiredCapabilities capabilities = DesiredCapabilities.firefox();
    capabilities.setCapability("version", "latest");
    capabilities.setCapability("name", "Testing Selenium");

    this.driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testSimple() throws Exception {
    this.driver.get("http://www.google.com");
    assertEquals("Google", this.driver.getTitle());
  }

  @After
  public void tearDown() throws Exception {
    this.driver.quit();
  }

}
