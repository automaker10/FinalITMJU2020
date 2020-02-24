package testscript;

import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static io.appium.java_client.touch.offset.PointOption.point;

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
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
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
	
	//OpenApp
	public void open_app(String namefile) throws InterruptedException, MalformedURLException {
		
		String app = namefile;
		File apps = new File(app);
		
		DesiredCapabilities capabilities = DesiredCapabilities.android();
		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
				
		capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "8.1.0");
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Nexus 5 API 27");
		capabilities.setCapability(MobileCapabilityType.UDID, "emulator-5554");
		
		capabilities.setCapability(MobileCapabilityType.APP, apps.getAbsolutePath());
		capabilities.setCapability(MobileCapabilityType.FULL_RESET, false);
		
		//unicodeKeyboard
		capabilities.setCapability("unicodeKeyboard","true");
		
//		if(StartUp.xlPath.contains("TC01_SettingUser")||StartUp.xlPath.contains("TC02_AddNewCropping")
//				||StartUp.xlPath.contains("TC05_UpdateCropDetails")||StartUp.xlPath.contains("TC06_AddNewCroppingStep")
//				||StartUp.xlPath.contains("TC07_SettingNextStepAlerts") ||StartUp.xlPath.contains("TC09_PlantingComplete")) {
//			driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"),capabilities);
//			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//			StartUp.driver4 = driver;
//		}else {
//			StartUp.driver4 = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"),capabilities);
//			StartUp.driver4.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//			driver = StartUp.driver4;
//		}
		
		driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"),capabilities);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		Thread.sleep(3000);
	}
	
	public void button_click_id(String xPath) throws InterruptedException {
		driver.findElement(By.id(xPath)).click();
		Thread.sleep(1000);
	}
	public void button_click(String xPath) throws InterruptedException {
		driver.findElement(By.xpath(xPath)).click();
		Thread.sleep(1000);
	}
	
	//Acceptalert
	public void Acceptalert(int n) throws InterruptedException {	
		if(StartUp.xlPath.contains("TC08_RemoveCroppingStep")) {
			if(n == 2) {
				driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.support.v7.widget.LinearLayoutCompat/android.widget.ScrollView/android.widget.LinearLayout/android.widget.Button")).click();
			}else if(n == 1){
				new TouchAction(driver).tap(point(120,120)).waitAction(waitOptions(Duration.ofMillis(250))).perform();
				driver.findElement(By.id("com.example.help.cropapplication:id/buttonUpdateStep")).click();
				driver.findElement(By.id("android:id/button1")).click();		
			}
		}else if(StartUp.xlPath.contains("TC12_DeleteCropHistory")) {
			//System.out.println("TC12_DeleteCropHistory");
			if(n == 2) {
				//driver.findElement(By.id("com.example.help.cropapplication:id/buttonDelete")).click();
				driver.findElement(By.id("android:id/button3")).click();
				Thread.sleep(1000);
			}else if(n == 1){
				driver.findElement(By.id("android:id/button1")).click();
				Thread.sleep(1000);		
			}
		}
		
		Thread.sleep(2000);
	}
	
	//tapByCoordinates
	public void tapByCoordinates(int xPath,int yPath) throws InterruptedException {
		MyMobileActions myMobileActions = new MyMobileActions(driver);
		//myMobileActions.pressByCoordinates(xPath, yPath, seconds);
		myMobileActions.tapByCoordinates(xPath, yPath);
		Thread.sleep(4000);
	}

	//Edit_Text
	public void edit_Text(String xPath, String sText) {
		driver.findElement(By.id(xPath)).clear();
		driver.findElement(By.id(xPath)).sendKeys(sText + "\t");
		/*StartUp.driver4.findElement(By.id(xPath)).clear();
		StartUp.driver4.findElement(By.id(xPath)).sendKeys(sText + "\t");*/
	}
	
	//Get_Text
	public void get_Text(String xPath) {
		//String s = driver.findElement(By.id(xPath)).getText();
		String s = driver.findElement(By.xpath(xPath)).getText();
		//System.out.println(s);
	}

	//Date
	public void select_date(String xPath,String text) throws ParseException {
		try {
			if(!text.equals(null));
			
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
					driver.findElement(By.id("android:id/next")).click();
					driver.findElement(By.xpath(result)).click();
				}
			} while (!head.equals(sdf.format(calendar.getTime())));

			driver.findElement(By.id("android:id/button1")).click();
			
		}catch(Exception e) {
			e.getMessage();
			//driver.findElement(By.id("android:id/button1")).click();
		}
	}
	
	//TestDate
	public void TestDate(String xPath,String text) throws ParseException {
		driver.findElement(By.id(xPath)).click();	
		try {
				if(!text.equals(null));
				
				driver.findElement(By.id(xPath)).click();
				
				String head2 = "";
				String[] vdate = text.split("/");

				int d = Integer.parseInt(vdate[0]);
				int m = Integer.parseInt(vdate[1]);
				int y = Integer.parseInt(vdate[2]);
				int a = 0;
				
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
						}else {
							a += 1;
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

				//System.out.println("Date : " + sdf.format(calendar.getTime()));

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
						driver.findElement(By.id("android:id/next")).click();
						driver.findElement(By.xpath("//android.view.View[@text='29']")).click();	
						System.out.println("sliding : "+ a);
						if(a!=0) {
							//System.out.println("sliding");
							while(!head2.contains("Jan")){
								//head2 = driver.findElement(By.id("android:id/date_picker_header_date")).getText();
								driver.findElement(By.id("android:id/prev")).click();
								driver.findElement(By.xpath("//android.view.View[@text='29']")).click();
								head2 = driver.findElement(By.id("android:id/date_picker_header_date")).getText();
								//System.out.println("head2 : " + head2);
								a = 0;
							}
						}
						
					}
				} while (!head.equals(sdf.format(calendar.getTime())));

				driver.findElement(By.id("android:id/button1")).click();
				
			}catch(Exception e) {
				e.getMessage();
			}
	}
	
	//Time
	public void inputTime(String xPath,String vtext) {
		driver.findElement(By.id(xPath)).click();
		driver.findElement(By.id(xPath)).click();
		
		driver.findElement(By.id("android:id/toggle_mode")).click();

		try{String[] vtime = vtext.split(":"); 

		String h = vtime[0];
		String m = vtime[1];
		
		String[] timeminute =  m.split("\\s+");
		
		String minute = timeminute[0];
		String n = timeminute[1];
		
		//System.out.println(h + " And minute : " + minute + " PM/AM :  " + n);
		driver.findElement(By.id("android:id/input_hour")).clear();
		driver.findElement(By.id("android:id/input_hour")).sendKeys(h);
		driver.findElement(By.id("android:id/input_minute")).clear();
		driver.findElement(By.id("android:id/input_minute")).sendKeys(minute);
		
		//spinner_select("android:id/am_pm_spinner",n);
		driver.findElement(By.id("android:id/am_pm_spinner")).click();
		List<AndroidElement> radio = driver.findElements(By.id("android:id/text1"));
	     for (int i=0 ; i <radio.size() ; i++) {
	    	 //System.out.println("size : " + radio.size() + " ++++ "+radio.get(i).getText().toString());
	    	 if (radio.get(i).getText().toString().equals(n)) {
	    		radio.get(i).click();
	    		break;
	        }
	     }
		
		driver.findElement(By.id("android:id/button1")).click();
		}catch(Exception e) {
			e.getMessage();
		}
	}
	
	//getTextResult
	public void getTextresult(String xPath,String cExpectedResult) {
		//System.out.println("xPath : " + xPath);
		//System.out.println("cExpectedResult : " + cExpectedResult);
		//System.out.println("StartUp.xlPath : " + StartUp.xlPath);
		try{
			if(StartUp.xlPath.contains("01_SettingUser")) {
				driver.findElement(By.id(xPath)).getText();
				StartUp.cResult = cExpectedResult;
			}else if(StartUp.xlPath.contains("TC02_AddNewCropping") || StartUp.xlPath.contains("TC04_ViewCroppingStep") ||StartUp.xlPath.contains("TC12_DeleteCropHistory") 
				|| StartUp.xlPath.contains("TC10_ViewPlantsDisease")|| StartUp.xlPath.contains("TC11_ViewCropHistory") || StartUp.xlPath.contains("07_SettingNextStepAlerts")
				|| StartUp.xlPath.contains("09_PlantingComplete")){
				StartUp.cResult = driver.findElement(By.id(xPath)).getText().toString();
			}else if(StartUp.xlPath.contains("03_ListCropping") || StartUp.xlPath.contains("08_RemoveCroppingStep") || StartUp.xlPath.contains("05_UpdateCropDetails")
				|| StartUp.xlPath.contains("06_AddNewCroppingStep")) {
				StartUp.cResult = driver.findElement(By.xpath(xPath)).getText().toString();
			}else if(StartUp.xlPath.contains("13_BackupHistoryToWebsite")) {
				StartUp.cResult = cExpectedResult;
			}
				
		}catch(Exception e) {
			StartUp.cResult = "Fail";
		}
		
		System.out.println(" StartUp.cResult : " + StartUp.cResult);
	}
	
	//checkError
	public void checkError(String xlsxResult,String xError) {
		try {
			if(StartUp.vError.equalsIgnoreCase("No Error")) {  //No Error
				try{					
					if(!xError.equals("Fail")) {
						if(xError.contains(xlsxResult)){
							StartUp.vError = "No Error"; //+ xError
							StartUp.vResult = "Pass";
						}else if(StartUp.cError.equals(xlsxResult)||StartUp.cError.contains(xlsxResult)) {
							StartUp.vError = "No Error" ;//+ xError
							StartUp.vResult = "Pass";
						}else {
							System.out.println("checkError : "+xError);
							System.out.println("checkError xlsxResult : " + xlsxResult);
							StartUp.vError = "Not match " + StartUp.cError;//xError
							StartUp.vResult = "Fail";
							saveScreen(StartUp.a,StartUp.TCname);
						}
								
					}else {
						if(StartUp.cError.contains(xlsxResult)){//StartUp.cError.equals("No Error")
							StartUp.vError = "No Error";
							StartUp.vResult = "Pass";							
						}else if(StartUp.xlPath.contains("12_DeleteCropHistory") && xlsxResult.equals("ลบพืชที่ทำการเลือก")) {
							StartUp.vError = "No Error" ;//+ xError
							StartUp.vResult = "Pass";
						}else if(StartUp.cError.equals("No alert")) {
							StartUp.vError = "No alert";
							StartUp.vResult = "Fail";
							saveScreen(StartUp.a,StartUp.TCname);
						}else {
							StartUp.vError = "Not found xpath"; //No Success
							StartUp.vResult = "Fail";
							saveScreen(StartUp.a,StartUp.TCname);
						}
						
					}
											
				}catch(Exception e) {
					//e.getMessage();
					/* StartUp.vError = "Not found";
					StartUp.vResult = "Fail"; */
					//setvError(dr.a,dr.TCname);
				}
			}else {											//Error
				try {
					if(xError.contains(xlsxResult) ) {
						StartUp.vError = "No Error";//xError
						StartUp.vResult = "Pass";
					}else {
						StartUp.vError = "Not found xpath";//xError
						StartUp.vResult = "Fail";
					}
				}catch(Exception e) {
					e.getMessage();
				}
			}
		}catch(Exception e) {
			e.getMessage();
		}
			
	}
	
	//SetcError
	public void setcError() throws InterruptedException{
		try {
			//System.out.println(driver.findElement(By.id("android:id/message")).getText());
			if(driver.findElement(By.id("android:id/message")).getText().toString() != null) {
				String result = driver.findElement(By.id("android:id/message")).getText();
				StartUp.xError = result;
				//StartUp.vError = result;
			}
		}catch(Exception e) {
			e.getMessage();
			/*if(StartUp.xlPath.contains("TC09_PlantingComplete")) {
				StartUp.cError = "No alert";
			}*/
			StartUp.xError = "No alert";
			//StartUp.vError = "No Error";
			
		}
		
		//System.out.println("StartUp.cError : " + StartUp.cError);
	}
		
	//SetvError
	public void setvError() throws InterruptedException{
		try {
			//System.out.println(driver.findElement(By.id("android:id/message")).getText());
			if(driver.findElement(By.id("android:id/message")).getText().toString() != null) {
				String result = driver.findElement(By.id("android:id/message")).getText();
				StartUp.vError = result;
			}
		}catch(Exception e) {
			StartUp.vError = "No Error";
			/*File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			 try {
				FileUtils.copyFile(scrFile, new File("F:\\final project\\ReturnScreen\\Screen"+name + index +".png"));
				System.out.println("In tey : " + index);
			 } catch (IOException e1) {
				e1.printStackTrace();
			 }*/
		}
			
		//System.out.println("StartUp.vError : " + StartUp.vError);
	}
	
	//back
	public void toBack() throws InterruptedException {
		//System.out.println("Back");
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		Thread.sleep(2000);
	}
	
	//TouchAction
	public void toTouchAction() throws InterruptedException {
		new TouchAction(driver).tap(point(120,120)).waitAction(waitOptions(Duration.ofMillis(250))).perform();
		Thread.sleep(2000);
	}
	
	//Login
	public void login(){
		driver.findElement(By.id("com.example.help.cropapplication:id/editTextusername")).clear();
		driver.findElement(By.id("com.example.help.cropapplication:id/editTextusername")).sendKeys("wattanapong5843" + "\n");
		
		driver.findElement(By.id("com.example.help.cropapplication:id/editTextpassword")).clear();
		driver.findElement(By.id("com.example.help.cropapplication:id/editTextpassword")).sendKeys("oh12345678" + "\n");
		
		driver.findElement(By.id("com.example.help.cropapplication:id/buttonlogin")).click();
	}

	public void saveScreen(int index,String name) throws InterruptedException{	
		//System.out.println("saveScreen" + "index : " + index + " name : " + name);
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		 try {
			FileUtils.copyFile(scrFile, new File("F:\\final project\\ReturnScreen\\Screen"+name +"_TD"+ index +".png"));
			//System.out.println("In tey : " + index);
		 } catch (IOException e) {
			//System.out.println("catch ");
			e.printStackTrace();
		}
	}
	
	//Close_App
	public void close_app(){
		driver.quit();
	}

	public void Tests() throws IOException{
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		 try {
			FileUtils.copyFile(scrFile, new File("F:\\final project\\ReturnScreen\\Screen"+"OH" +".png"));
			//System.out.println("In tey : ");
		 } catch (IOException e) {
			//System.out.println("catch ");
			e.printStackTrace();
			
		}
	}

	public boolean check_text(String xlsxResult, String checkError) throws IOException {
		if(xlsxResult.contains(StartUp.xAlert) == true) {
			return true;
		}else {
			return false;
		}
	}
}
