package Test12;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CalculatorTest 
{
	 private static RemoteWebDriver CalculatorSession = null;
	    private static WebElement CalculatorResult = null;

@BeforeClass
	public static void setUp()
	
	{
	
	try 
	{
		
		DesiredCapabilities ds = new DesiredCapabilities();
		Capabilities.setCapability("app", "Microsoft.WindowsCalculator_8wekyb3d8bbwe!App");
        Capabilities.setCapability("platformName", "Windows");
        Capabilities.setCapability("deviceName", "WindowsPC");
        CalculatorSession = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        CalculatorSession.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        CalculatorSession.findElementByXPath("//Button[starts-with(@Name, \"Menu\")]").click();
        CalculatorSession.findElementByXPath("//ListItem[@Name=\"Standard Calculator\"]").click();

        CalculatorSession.findElementByName("Clear").click();
        CalculatorSession.findElementByName("Seven").click();
        CalculatorResult = CalculatorSession.findElementByName("Display is  7 ");
        Assert.assertNotNull(CalculatorResult);

	  }catch(Exception e){
          e.printStackTrace();
      }
	finally 
	{
      }
  }
public void clear()
{
	CalculatorSession.findElementByName("claer").click();
	Assert.assertEquals("Display is  0 ", CalculatorResult.getText());
	
	
}
@AfterClass

public void TearDown()
{
	 CalculatorResult = null;
     if (CalculatorSession != null) {
         CalculatorSession.quit();
}
     CalculatorSession = null;
}

@Test

public void Addition()
{

	 CalculatorSession.findElementByName("One").click();
     CalculatorSession.findElementByName("Plus").click();
     CalculatorSession.findElementByName("Seven").click();
     CalculatorSession.findElementByName("Equals").click();
     Assert.assertEquals("Display is  8 ", CalculatorResult.getText());	
	
}
@Test

public void Combination()
{

    CalculatorSession.findElementByName("Seven").click();
    CalculatorSession.findElementByName("Multiply by").click();
    CalculatorSession.findElementByName("Nine").click();
    CalculatorSession.findElementByName("Plus").click();
    CalculatorSession.findElementByName("One").click();
    CalculatorSession.findElementByName("Equals").click();
    CalculatorSession.findElementByName("Divide by").click();
    CalculatorSession.findElementByName("Eight").click();
    CalculatorSession.findElementByName("Equals").click();
    Assert.assertEquals("Display is  8 ", CalculatorResult.getText());
}

@Test

public void Division()

{
	
	 CalculatorSession.findElementByName("Eight").click();
     CalculatorSession.findElementByName("Eight").click();
     CalculatorSession.findElementByName("Divide by").click();
     CalculatorSession.findElementByName("One").click();
     CalculatorSession.findElementByName("One").click();
     CalculatorSession.findElementByName("Equals").click();
     Assert.assertEquals("Display is  8 ", CalculatorResult.getText());
}
@Test

public void Multification()
{

	  CalculatorSession.findElementByName("Nine").click();
      CalculatorSession.findElementByName("Multiply by").click();
      CalculatorSession.findElementByName("Nine").click();
      CalculatorSession.findElementByName("Equals").click();
      Assert.assertEquals("Display is  81 ", CalculatorResult.getText());
	}

@Test
public void Subtraction()
{
    CalculatorSession.findElementByName("Nine").click();
    CalculatorSession.findElementByName("Minus").click();
    CalculatorSession.findElementByName("One").click();
    CalculatorSession.findElementByName("Equals").click();
    Assert.assertEquals("Display is  8 ", CalculatorResult.getText());
}
}

