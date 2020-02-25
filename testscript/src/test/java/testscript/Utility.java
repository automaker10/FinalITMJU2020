package testscript;

import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static io.appium.java_client.touch.offset.PointOption.point;
import static java.time.Duration.ofMillis;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.interactions.internal.MouseAction.Button;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;

public class Utility {

	private AndroidDriver driver = null;

	public void apk_open(String namefile) throws MalformedURLException, InterruptedException {
		try {
			String apk = namefile;
			File app = new File(apk);
			DesiredCapabilities capabilities = DesiredCapabilities.android();
			capabilities.setCapability(CapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
			capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "8.1.0");
			capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Nexus 5X API 27");
			capabilities.setCapability(MobileCapabilityType.UDID, "emulator-5554");
			capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
			capabilities.setCapability(MobileCapabilityType.FULL_RESET, false);

			capabilities.setCapability("unicodeKeyboard", "true");

			driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			System.out.println("!!!! Driver is Launched.");

			Thread.sleep(4000);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	public void edit_input(String xPath, String fText) {
		driver.findElement(By.id(xPath)).sendKeys(fText);
	}

	public void edit_input_classname(String xPath, String fText) {
		List<AndroidElement> textFieldsList = driver.findElements(By.id(xPath));
		System.out.println(textFieldsList.size());
		AndroidElement search = textFieldsList.get(0);
		search.sendKeys(fText);
	}

	public void apk_close() {
		driver.quit();
	}

	public void edit_clear(String xPath) {
		driver.findElement(By.id(xPath)).clear();
	}

	public void button_click(String xPath) throws InterruptedException {
		driver.findElement(By.id(xPath)).click();
		Thread.sleep(4000);
	}

	public void button_list_click() {
		List<MobileElement> list = driver
				.findElements(By.xpath("stlpapp.finalproject.app.com.appstlp:id/ListRequestCenter"));
		System.out.println(list.get(4));
		for (MobileElement m : list) {
			System.out.println(m.getText());

		}
	}

	public void click_link(String fText) {
		driver.findElement(By.linkText(fText)).click();
	}

	public String textbox_getText(String xPath) {
		return driver.findElement(By.id(xPath)).getText();
	}

	public void checkbox_set(String fText) {
		String[] extract = fText.split(",");
		if (extract.length == 8) {
			List<MobileElement> checkBox = driver.findElements(By.className("android.widget.CheckBox"));
			for (int i = 0; i < extract.length; i++) {
				if (extract[i].equalsIgnoreCase("ON")) {
					checkBox.get(i).click();
				}if (extract[i].equalsIgnoreCase("on")) {
					checkBox.get(i).click();
				}
			}
		} else {
			throw new NoSuchElementException("Invalid CheckBox Selected");
		}
	}

	public void radio_select(String xPath, String fText) {

//		List<AndroidElement> list = driver.findElements(By.id(xPath));
//		for (int i = 0; i < list.size(); i++) {
//			System.out.println("======= :" + list.get(i).getText());
//
//			if (list.get(i).getText().toString().equals(fText)) {
//				list.get(i).click();
//			}
//		}

//		List<AndroidElement> list = driver.findElements(By.id(xPath));
//		for (AndroidElement ae : list) {
//			String word = ae.getText().toString();
//
//			if (word.equals(fText)) {
//				ae.click();
//			}
//		}
		
//		Select select = new Select(driver.findElement(By.xpath(xPath)));
//		List<WebElement> options = select.getOptions(); 
//
//		for (int i = 0; i < options.size(); i++) { 
//		if (options.get(i).getText().equals(fText)){ 
//			if (!options.get(i).isSelected())
//				options.get(i).click(); 
//		      return; 
//		    } 
//		  }
//		throw new NoSuchElementException("Invalid list Selected");

	}

//	public void list_select(String xPath, String fText) {
//		
//		Select select = new Select(driver.findElement(By.xpath(xPath)));
//		List<AndroidElement> options = select.getOptions();
//
//		for (int i = 0; i < options.size(); i++) {
//			if (options.get(i).getText().equals(fText)) {
//				if (!options.get(i).isSelected())
//					options.get(i).click();
//				return;
//			}
//		}
//		throw new NoSuchElementException("Invalid list Selected");
//	}

	public boolean dialog_click() {
		String text = "";
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alert = driver.switchTo().alert();
		text = alert.getText();
		alert.accept();
		String[] temp = text.split(":");

		if (temp[0].trim().equals("ข้อมูลผิดพลาด")) // แก้ไขเพิ่มเติม
			return false;
		else
			return true;
	}

	// Vertical Swipe by percentages
	public void verticalSwipeByPercentages(double startPercentage, double endPercentage, double anchorPercentage)
			throws InterruptedException {

		try {
			Dimension size = driver.manage().window().getSize();

			int anchor = (int) (size.width * anchorPercentage);
			int startPoint = (int) (size.getHeight() * startPercentage);
			int endPoint = (int) (size.getHeight() * endPercentage);

			new TouchAction(driver).press(point(anchor, startPoint)).waitAction(waitOptions(ofMillis(1000)))
					.moveTo(point(anchor, endPoint)).release().perform();
			Thread.sleep(4000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Tap by coordinates
	public void tapByCoordinates(int x, int y) throws InterruptedException {
		new TouchAction(driver).tap(point(x, y)).perform();
		Thread.sleep(4000);
	}

	// Double Tap by coordinates
	public void DoubleClick(String xPath) throws InterruptedException {
		TouchActions action = new TouchActions(driver);
		action.doubleTap(driver.findElement(By.id(xPath)));
		action.perform();
		Thread.sleep(4000);

	}

	// Swipe by elements
	public void swipeByElements(AndroidElement startElement, AndroidElement endElement) throws InterruptedException {
		int startX = startElement.getLocation().getX() + (startElement.getSize().getWidth() / 2);
		int startY = startElement.getLocation().getY() + (startElement.getSize().getHeight() / 2);

		int endX = endElement.getLocation().getX() + (endElement.getSize().getWidth() / 2);
		int endY = endElement.getLocation().getY() + (endElement.getSize().getHeight() / 2);

		new TouchAction(driver).press(point(startX, startY)).waitAction(waitOptions(ofMillis(1000)))
				.moveTo(point(endX, endY)).release().perform();

		Thread.sleep(4000);
	}

	public void datepicker(String xPath, String dayText) throws InterruptedException {
		driver.findElement(By.id(xPath)).click();

		String number = dayText.toString();
		String[] key = number.split("/");
		int day = Integer.parseInt(key[0]);
		int month = Integer.parseInt(key[1]);

		// อ่านค่าเดือน
		AndroidElement monthbtn = (AndroidElement) driver.findElement(By.id("android:id/prev"));
		if (month <= 12) {
			int result = 12 - month;
			try {
				for (int i = 1; i < result; i++) {
					monthbtn.click();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (month > 12) {
			int result = 10 + (12 - month);
			try {
				for (int i = 1; i < result; i++) {
					monthbtn.click();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("Pick Month Error !!");
		}

		driver.findElementByXPath("//android.view.View[@text='" + day + "']").click();

		driver.findElement(By.id("android:id/date_picker_header_year")).click();
		List<AndroidElement> list = driver.findElementsById("android:id/text1");
		MyMobileActions ma = new MyMobileActions(driver);

		String tyear = key[2];
		String lyear = "";
		String cyear = driver.findElementById("android:id/date_picker_header_year").getText();
		// อ่านค่าปีปัจจุบันที่แสดงในปฏิทิน เพื่อเปรียบเทียบว่าจะเลื่อนขึ้นหรือลง
		try {
			do {
				list = driver.findElementsById("android:id/text1");
				for (AndroidElement l : list) {
					lyear = l.getText();
					if (lyear.equals(tyear)) {
						l.click();
						break;
					}
				}
				try {
					if (tyear.compareTo(cyear) > 0) {
						ma.swipeByElements(list.get(list.size() - 1), list.get(0));
					} else {
						ma.swipeByElements(list.get(0), list.get(list.size() - 1));
					}
				} catch (Exception e) {
				}
			} while (!tyear.equals(lyear));
		} catch (Exception e) {

		}

		driver.findElement(By.id("android:id/button1")).click();

		Thread.sleep(3000);
	}

	public void saveScreen(String namefile,int index) {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(scrFile, new File(
					"D:\\work\\IT496 Project IN Information Technology (AJ.SAYAN)\\ScreenShot\\Error_TD_"+namefile+"_"+ index + ".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}