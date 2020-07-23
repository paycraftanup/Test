
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class CalculatorTest {

	static AppiumDriver<MobileElement> driver;

	public static void main(String[] args) {
		try {
			openCalculator();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getStackTrace());
			e.printStackTrace();
		}
	}

	public static void openCalculator() throws Exception {
		
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("deviceName", "Redmi");
		cap.setCapability("platformName", "Android");
		cap.setCapability("udid", "c24c6a607d04");
		cap.setCapability("platformVersion", "7.1.2");
		cap.setCapability("autoAcceptAlerts", true);
		cap.setCapability("appPackage", "com.miui.calculator");
		cap.setCapability("appActivity", "com.miui.calculator.cal.CalculatorActivity");
		cap.setCapability("autoGrantPermissions", true);
		
		URL url = new URL("http://127.0.0.1:4723/wd/hub");
		
		driver = new AppiumDriver<MobileElement>(url, cap);
		
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.alertIsPresent());
		driver.switchTo().alert().accept();
		
		System.out.println("Application Started...");
		
		MobileElement one = driver.findElement(By.id("com.miui.calculator:id/btn_1_s"));
		MobileElement plus = driver.findElement(By.id("com.miui.calculator:id/btn_plus_s"));
		MobileElement five = driver.findElement(By.id("com.miui.calculator:id/btn_5_s"));
		MobileElement equals = driver.findElement(By.id("com.miui.calculator:id/btn_equal_s"));
		MobileElement result = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout[2]/com.miui.support.view.ViewPager/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout"));
		
		one.click();
		plus.click();
		five.click();
		equals.click();
		
		String sum = result.getText();
		System.out.println("Result is "+sum);

	}
}
