package testscript;

import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static io.appium.java_client.touch.offset.PointOption.point;
import static java.time.Duration.ofMillis;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.tools.ant.taskdefs.WaitFor;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.android.AndroidKeyMetastate;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class Keyword {

	private AndroidDriver driver = null;

	public Keyword() {
		driver = StartUp.myDriver;
	}

	// open app
	public void open_app(String namefile) throws InterruptedException, MalformedURLException {

		String app = namefile;
		File apps = new File(namefile);

		DesiredCapabilities capabilities = DesiredCapabilities.android();
		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);

		capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "8.1.0");
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Nexus 5X API 27");
		capabilities.setCapability(MobileCapabilityType.UDID, "emulator-5554");

		capabilities.setCapability(MobileCapabilityType.APP, apps.getAbsolutePath());
		capabilities.setCapability(MobileCapabilityType.FULL_RESET, false);

		// unicodeKeyboard
		capabilities.setCapability("unicodeKeyboard", "true");

		driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	// button click
	public void button_click(String xPath) throws InterruptedException {
		driver.findElement(By.id(xPath)).click();
		Thread.sleep(4000);
	}

	// button click process
	public void button_click_process(String xPath) throws InterruptedException {
		driver.findElement(By.id(xPath)).click();
		saveScreen();
		Thread.sleep(4000);

	}

	// edit text
	public void edit_input(String xPath, String fText) {
		driver.findElement(By.id(xPath)).clear();
		driver.findElement(By.id(xPath)).sendKeys(fText);
	}

	// clear text
	public void clear_input(String xPath, String fText) {
		driver.findElement(By.id(xPath)).clear();
	}

	// close app
	public void close_app() throws InterruptedException {
		driver.quit();
	}

	// edit input more request
	public void edit_input_classname(String xPath, String fText) {
		List<AndroidElement> textFieldsList = driver.findElements(By.id(xPath));
		System.out.println(textFieldsList.size());
		AndroidElement search = textFieldsList.get(0);
		search.sendKeys(fText);
	}

	// tap by coordinates
	public void tapByCoordinates(int x, int y) throws InterruptedException {
		new TouchAction(driver).tap(point(x, y)).perform();
	}

	// vertical swipe by percentages
	public void verticalSwipeByPercentages(double startPercentage, double endPercentage, double anchorPercentage)
			throws InterruptedException {

		try {
			Dimension size = driver.manage().window().getSize();

			int anchor = (int) (size.width * anchorPercentage);
			int startPoint = (int) (size.getHeight() * startPercentage);
			int endPoint = (int) (size.getHeight() * endPercentage);

			new TouchAction(driver).press(point(anchor, startPoint)).waitAction(waitOptions(ofMillis(1000)))
					.moveTo(point(anchor, endPoint)).release().perform();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// get text
	public void get_Text(String xPath) {
		// String s = driver.findElement(By.id(xPath)).getText();
		String s = driver.findElement(By.xpath(xPath)).getText();
		System.out.println(s);
	}

	// date
	public void datepicker(String xPath, String text) throws ParseException {
		try {
			if (!text.equals(null))
				;

			driver.findElement(By.id(xPath)).click();

			String[] vdate = text.split("/");

			int d = Integer.parseInt(vdate[0]);
			int m = Integer.parseInt(vdate[1]);
			int y = Integer.parseInt(vdate[2]);

			// Year
			driver.findElement(By.id("android:id/date_picker_header_year")).click();
			List<AndroidElement> list = driver.findElements(By.id("android:id/text1"));

			MyMobileActions ma = new MyMobileActions(driver);
			String tyear = y + "";
			String lyear = "";
			String cyear = driver.findElementById("android:id/date_picker_header_year").getText();
			do {
				list = (List<AndroidElement>) driver.findElementsById("android:id/text1");
				for (MobileElement l : list) {
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

			// Day and Month
			SimpleDateFormat sdf = new SimpleDateFormat("MMM", Locale.getDefault());
			Calendar calendar = Calendar.getInstance();
			calendar.set(y, m - 1, d);

			// System.out.println("Date : " + sdf.format(calendar.getTime()));

			String head = "";

			String[] arrayOfString = { "//android.view.View[@text='", d + "", "']" };
			String result = "";
			for (String each : arrayOfString) {
				result += each;
			}

			do {
				head = driver.findElement(By.id("android:id/date_picker_header_date")).getText();
				Boolean b = head.contains(sdf.format(calendar.getTime()));

				if (b == true) {
					driver.findElement(By.xpath(result)).click();
					break;
				} else {
					driver.findElement(By.id("android:id/prev")).click();
					driver.findElement(By.xpath(result)).click();
				}
			} while (!head.equals(sdf.format(calendar.getTime())));

			driver.findElement(By.id("android:id/button1")).click();

		} catch (Exception e) {
			e.getMessage();
			// driver.findElement(By.id("android:id/button1")).click();
		}

	}

	// check error
	public void checkError(String xlsxResult, String xError) {
		try {
			if (StartUp.vError.equalsIgnoreCase("No Error")) { // No Error
				try {
					if (!xError.equals("Fail")) {
						if (xlsxResult.equals("หน้าจอแสดงข้อมูลผู้ใช้งาน")) {
							StartUp.vError = "No Error";// + xError
							StartUp.vResult = "Pass";
							saveScreenResult(StartUp.tcname, StartUp.tdname);
						} else if (xlsxResult.equals("บันทึกข้อมูลสำเร็จ")) {
							StartUp.vError = "No Error";// + xError
							StartUp.vResult = "Pass";
							saveScreenResult(StartUp.tcname, StartUp.tdname);
						} else if (xlsxResult.equals("เข้าสู่ระบบสำเร็จ")) {
							StartUp.vError = "No Error";// + xError
							StartUp.vResult = "Pass";
							saveScreenResult(StartUp.tcname, StartUp.tdname);
						} else if (xlsxResult.equals("เขียนคำร้องเพิ่มเติมสำเร็จ")) {
							StartUp.vError = "No Error";// + xError
							StartUp.vResult = "Pass";
							saveScreenResult(StartUp.tcname, StartUp.tdname);
						} else if (xlsxResult.equals("เสร็จสิ้นการพิจารณา")) {
							StartUp.vError = "No Error";// + xError
							StartUp.vResult = "Pass";
							saveScreenResult(StartUp.tcname, StartUp.tdname);
						} else {
							System.out.println("checkError : " + xError);
							System.out.println("checkError xlsxResult : " + xlsxResult);
							StartUp.vError = "Word Not match : " + xlsxResult;// xError
							StartUp.vResult = "Fail";
							saveScreenResult(StartUp.tcname, StartUp.tdname);

						}

					}

				} catch (Exception e) {
					e.printStackTrace();
				}
			} else { // Error
				try {
					if (xError.contains(xlsxResult)) {
						StartUp.vError = "No Error";// xError
						StartUp.vResult = "Pass";
					} else {
						StartUp.vError = "Not found xpath";// xError
						StartUp.vResult = "Fail";
					}
				} catch (Exception e) {
					e.getMessage();
				}
			}
		} catch (

		Exception e) {
			e.getMessage();
		}

	}

	// set cError
	public void setcError() throws InterruptedException {
		try {
			if (driver.findElement(By.id("android:id/message")).getText().toString() != null) {
				String result = driver.findElement(By.id("android:id/message")).getText();
				StartUp.vError = result;
			}
		} catch (Exception e) {
			e.getMessage();
			StartUp.vError = "No alert";

		}
	}

	// set vError
	public void setvError() throws InterruptedException {
		try {
			if (driver.findElement(By.id("android:id/message")).getText().toString() != null) {
				String result = driver.findElement(By.id("android:id/message")).getText();
				StartUp.vError = result;
			}
		} catch (Exception e) {
			StartUp.vError = "No Error";
			e.printStackTrace();
		}

		// System.out.println("StartUp.vError : " + StartUp.vError);
	}

	// Click with class
	public void click_class(String classname) throws InterruptedException {
		List<MobileElement> blist = driver.findElementsByClassName(classname);
		for (MobileElement m : blist) {
			if (m.getText().equals("ยกเลิก")) {
				m.click();
			} else if (m.getText().equals("รับเรื่อง/ไม่รับเรื่อง?")) {
				m.click();
			} else if (m.getText().equals("ตกลง")) {
				m.click();
			} else if (m.getText().equals("กระบวนการรับเรื่องเสร็จสิ้น")) {
				m.click();
			} else if (m.getText().equals("ยืนยันการพิจารณา")) {
				m.click();
			} else if (m.getText().equals("ตอบคำร้อง")) {
				m.click();
			}
		}
	}

	// checkbox with class
	public void checkbox_class(String fText) throws InterruptedException {
		List<MobileElement> blist = driver.findElementsByClassName("android.widget.CheckBox");
		if (fText.equals("aik nik")) {
			for (MobileElement m : blist) {
				if (m.getText().contains("aik nik")) {
					m.click();
				}
			}
		} else if (fText.equals("-")) {
			System.out.println(" - ");
		}
	}

	// checkbox with class
	public void check_submit(String fText) throws InterruptedException {
		Thread.sleep(2000);
		if (fText.equals("ยกเลิก")) {
			driver.findElement(By.id("android:id/button3")).click();
		} else if (fText.equals("ตกลง")) {
			driver.findElement(By.id("android:id/button1")).click();
		}
	}

	// edittext with class
	public void edit_text_class(String classpath, String fText) throws InterruptedException {
		List<MobileElement> blist = driver.findElementsByClassName(classpath);
		for (MobileElement m : blist) {
			if (m.getText().equals("ข้อเท็จจริงของ")) {
				m.sendKeys(fText);
				break;
			}
			if (m.getText().equals("ข้อเท็จจริงบิดา/มารดาของ")) {
				m.sendKeys(fText);
				break;
			}
			if (m.getText().equals("ความคิดเห็นทางกฎหมาย(การทะเบียนราษฎร และสัญชาติ)")) {
				m.sendKeys(fText);
				break;
			}
			if (m.getText().equals("คำแนะนำขั้นตอนดำเนินการพัฒนาสถานะ")) {
				m.sendKeys(fText);
				break;
			}
			if (m.getText().equals("คำตอบ")) {
				m.sendKeys(fText);
				break;
			}
		}
	}

	// vertical swipe by percentages
	public void verticalSwipeByPercentages2(String countnum) throws InterruptedException {

		try {
			Dimension size = driver.manage().window().getSize();

			int anchor = (int) (size.width * 0.5);
			int startPoint = (int) (size.getHeight() * 0.8);
			int endPoint = (int) (size.getHeight() * 0.2);

			if (countnum.equals("2")) {
				new TouchAction(driver).press(point(anchor, startPoint)).waitAction(waitOptions(ofMillis(1000)))
						.moveTo(point(anchor, endPoint)).release().perform();
				new TouchAction(driver).press(point(anchor, startPoint)).waitAction(waitOptions(ofMillis(1000)))
						.moveTo(point(anchor, endPoint)).release().perform();
			} else if (countnum.equals("2")) {
				new TouchAction(driver).press(point(anchor, startPoint)).waitAction(waitOptions(ofMillis(1000)))
						.moveTo(point(anchor, endPoint)).release().perform();
				new TouchAction(driver).press(point(anchor, startPoint)).waitAction(waitOptions(ofMillis(1000)))
						.moveTo(point(anchor, endPoint)).release().perform();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// back
	public void toBack() throws InterruptedException {
		// System.out.println("Back");
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		Thread.sleep(2000);
	}

	// tap confirm
	public void tapByCoordinates_Confirm(String words) throws InterruptedException {
		if (words.toString().equals("กดเพื่อดูรายละเอียด")) {
			new TouchAction(driver).tap(point(532, 975)).perform();
		}
		Thread.sleep(4000);
	}

	// tap confirm
	public void tapByCoordinates_Ans(String words) throws InterruptedException {
		if (words.toString().equals("กดเพื่อดูรายละเอียดคำร้องเพิ่มเติม")) {
			new TouchAction(driver).tap(point(526, 1504)).perform();
		} else if (words.toString().equals("ตอบคำร้อง")) {
			new TouchAction(driver).tap(point(550, 1600)).perform();
		}
		Thread.sleep(4000);
	}

	// save screen
	public void saveScreen() {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(scrFile,
					new File("D:\\work\\IT496 Project IN Information Technology (AJ.SAYAN)\\screenshots\\"
							+ StartUp.tcname + "_" + StartUp.tdname + ".png"));
//			driver.quit();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// save screen result
	public void saveScreenResult(String tcname, String tdname) {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(scrFile,
					new File("D:\\work\\IT496 Project IN Information Technology (AJ.SAYAN)\\screenshots\\" + tcname
							+ "_" + tdname + ".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public boolean check_text(String xlsxResult, String checkError) throws IOException {
		if (xlsxResult.contains(StartUp.xAlert) == true) {
			return true;
		} else {
			return false;
		}
	}

	public boolean dialog_click() {
		String text = "";
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alert = driver.switchTo().alert();
		text = alert.getText();
		alert.accept();
		String[] temp = text.split(":");

		if (temp[0].trim().equals("ไม่พบประเภทบัตรบุคคลไร้รัฐไร้สัญชาติ?")) {
			driver.findElement(By.id("android:id/button1")).click();
			return false;
		} else
			return true;
	}

	public void radio_select(String xPath, String fText) {
		WebDriver webDriver = null;
		String check = "";
		String error = "";
		webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String[] xPaths = xPath.split("&");
		List<WebElement> radio = webDriver.findElements(By.xpath(xPaths[0]));
		List<WebElement> divRadio = null;
		if (xPaths.length == 2) {
			divRadio = webDriver.findElements(By.xpath(xPaths[1]));
		}
		try {
			for (int i = 0; i < radio.size(); i++) {
				String value = radio.get(i).getAttribute("value");
				if (value.equals(fText)) {
					try {
						radio.get(i).click();
					} catch (Exception ex) {
						divRadio.get(i).click();
					}
					check = "pass";
					break;
				}
			}
			if (check.equalsIgnoreCase("fail")) {
				check = "error";
				error = "Error don't click  : " + fText + " in radio value!!!";
			}
		} catch (Exception e) {
			check = "error";
			error = "Don't find locator : " + xPath;
			System.out.println(error);
		}
	}
}
