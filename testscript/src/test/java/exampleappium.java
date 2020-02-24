import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class exampleappium {

    private static AndroidDriver driver;

    public static void main(String[] args){
        try{
            openAppSTLP();
        }catch(Exception e){
            System.out.println(e.getCause());
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public static void openAppSTLP() throws  Exception{

        File apps = new File("app/STLPAPP.apk");

        DesiredCapabilities capabilities = DesiredCapabilities.android();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);

        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "8.1.0");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Nexus 5 API 27");
        capabilities.setCapability(MobileCapabilityType.UDID, "emulator-5554");

        capabilities.setCapability(MobileCapabilityType.APP, apps.getAbsolutePath());
        capabilities.setCapability(MobileCapabilityType.FULL_RESET, false);

        //unicodeKeyboard
        capabilities.setCapability("unicodeKeyboard","true");

        driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"),capabilities);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        Thread.sleep(3000);
    }
}
