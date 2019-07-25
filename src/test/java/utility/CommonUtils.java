package utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class CommonUtils {

	public static Properties prop = new Properties();
	public static int EXPLICIT_WAIT_TIME;
	public static int IMPLICIT_WAIT_TIME;
	public static int DEFAULT_WAIT_TIME;
	public static String APPLICATION_NAME;
	public static String BASE_PKG;
	public static String APP_ACTIVITY;
	public static String APPIUM_PORT;
	public static String AUTOMATION_INSTRUMENTATION;
	public static String BROWSER_NAME;
	public static String PLATFORM_NAME;
	public static String NEW_COMMAND_TIMEOUT;
	public static String PLATFORM_VERSION;
	public static String DEVICE_READY_TIMEOUT;
	public static String DEVICE_NAME;
	public static String UDID;
	public static String DB_USERNAME;
	public static String DB_PASSWORD;
	public static String DB_BASE_URL;
	public static String USER_USERNAME;
	public static String USER_EMAIL;
	public static String USER_FIRSTNAME;
	public static String USER_SURNAME;
	public static String USER_DOB;
	public static int USER_DOB_DAY;
	public static String USER_DOB_MONTH;
	public static String USER_DOB_YEAR;
	public static String USER_BUILDINGNO;
	public static String USER_ADDRESSLINE1;
	public static String USER_TOWN;
	public static String USER_POSTCODE;
	public static String USER_MOBILENUMBER;
	public static String USER_MOBILENUMBERFULL;
	public static String BUNDLE_ID;

	private static DesiredCapabilities capabilities = new DesiredCapabilities();
	private static URL serverUrl;
	public static AppiumDriver<MobileElement> driver;
	public static String platform;

	
	public static final String PACKAGE_NAME = "gaming.eatongate.com.kwiffapp.dev:id/";
	//public static final String PACKAGE_NAME = "gaming.eatongate.com.kwiffapp.dev.debug:id/";
	

	public static final String ENVIRONMENT = "master"; 
	
	


	public static void configurePlatform() throws IOException {
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/properties/platform.properties");
		prop.load(fis);
		if (System.getenv("platform") != null && !System.getenv("platform").isEmpty()) {
			platform = System.getenv("platform");
		} else {
			platform = prop.getProperty("platform");
		}
		prop.setProperty("platform", platform);
	}

	

	public static void loadUserConfigProp(String propertyFileName) throws IOException {
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/properties/"+propertyFileName);
		prop.load(fis);
		System.out.println("The user configuration is loaded ");
		USER_USERNAME = prop.getProperty("user.username");
		USER_EMAIL = prop.getProperty("user.email");
		USER_FIRSTNAME = prop.getProperty("user.firstName");
		USER_SURNAME = prop.getProperty("user.surname");
		USER_DOB = prop.getProperty("user.dob");
		USER_DOB_DAY = Integer.parseInt(prop.getProperty("user.dob.day"));
		USER_DOB_MONTH = prop.getProperty("user.dob.month");
		USER_DOB_YEAR = prop.getProperty("user.dob.year");
		USER_BUILDINGNO = prop.getProperty("user.buildingNo");
		USER_ADDRESSLINE1 = prop.getProperty("user.addressLine1");
		USER_TOWN = prop.getProperty("user.town");
		USER_POSTCODE = prop.getProperty("user.postcode");
		USER_MOBILENUMBER = prop.getProperty("user.mobileNumber");
		USER_MOBILENUMBERFULL = prop.getProperty("user.mobileNumberFull");
	}

 

    public static void loadAndroidConfigProp(String propertyFileName) throws IOException {
    	System.out.println("Loading Desired Capabilities for Android");
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/properties/"+propertyFileName);
        prop.load(fis);
        EXPLICIT_WAIT_TIME = Integer.parseInt(prop.getProperty("explicit.wait"));
        IMPLICIT_WAIT_TIME = Integer.parseInt(prop.getProperty("implicit.wait"));
        DEFAULT_WAIT_TIME = Integer.parseInt(prop.getProperty("default.wait"));
        BASE_PKG = prop.getProperty("base.pkg");
        APP_ACTIVITY = prop.getProperty("application.activity");
        APPIUM_PORT = prop.getProperty("appium.server.port");
        AUTOMATION_INSTRUMENTATION=prop.getProperty("automation.instrumentation");
        DEVICE_NAME=prop.getProperty("device.name");
        BROWSER_NAME=prop.getProperty("browser.name");
        PLATFORM_NAME=prop.getProperty("platform.name");
        PLATFORM_VERSION=prop.getProperty("platform.version");
        NEW_COMMAND_TIMEOUT=prop.getProperty("new.command.timeout");
        DEVICE_READY_TIMEOUT=prop.getProperty("device.ready.timeout");

		if (System.getenv("JENKINS_HOME") != null && !System.getenv("JENKINS_HOME").isEmpty()) {
			APPLICATION_NAME = prop.getProperty("jenkins.app.path");
		} else {
			APPLICATION_NAME = System.getProperty("user.dir") + prop.getProperty("application.path");
		}
    }
    
    public static void setAndroidCapabilities() {
        System.out.println("The Android capabilities needs to be set ");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, PLATFORM_NAME);
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, DEVICE_NAME);
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, AUTOMATION_INSTRUMENTATION);   
        capabilities.setCapability("appActivity", APP_ACTIVITY);
        capabilities.setCapability("appPackage", BASE_PKG);
        capabilities.setCapability(MobileCapabilityType.FULL_RESET, false);
        capabilities.setCapability(MobileCapabilityType.APP, APPLICATION_NAME);
        capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, NEW_COMMAND_TIMEOUT);

        System.out.println("The driver is set with Android capabilities");
    }

	
	public static AppiumDriver<MobileElement> getAndroidDriver() throws MalformedURLException {
		serverUrl = new URL("http://localhost:" + APPIUM_PORT + "/wd/hub");		
		driver = new AndroidDriver<MobileElement>(serverUrl, capabilities);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		return driver;
	}

	public static void startAppiumServer() {
		AppiumDriverLocalService service = AppiumDriverLocalService.buildDefaultService();
		service.start();
	}

	/**
	 * Start Android Emulator running from the command line
	 */
	public static  void start_android_emulator() {
        try {
            Runtime runtime = Runtime.getRuntime();
            String userHome = System.getProperty("user.home");
           runtime.exec(userHome + "/Library/Android/sdk/emulator -avd New_Device_API_28 -screen touch -netdelay none -netspeed full -no-snapstorage");
        } catch (IOException e) {
            
        }
    }
	
	
	
	public static void backAndroid() throws IOException
	{
		System.out.println("The user wants to click back");
		Runtime runtime = Runtime.getRuntime();
        String userHome = System.getProperty("user.home");
        runtime.exec(userHome + "/Library/Android/sdk/platform-tools/adb shell input keyevent 4"); 
        
	}

	
	public static void stopServer() {
		String[] command = { "/usr/bin/killall", "-KILL", "node" };
		try {
			Runtime.getRuntime().exec(command);
			System.out.println("Appium server stopped.");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	/**
	 * Close Android Emulator from the command line
	 */
	public static void close_android_emulator() {
		try {
			Runtime rt = Runtime.getRuntime();
			rt.exec("adb -s emulator-5554 emu kill");
			
		} catch (IOException e) {
			
		}
	}

	/**
	 * This method is waiting time till the specific time
	 * Accepts integer 1=1000 milliseconds
	 *
	 * @param sleepTime
	 */
	public static void sleepTimer(int sleepTime) {
		try {
			Thread.sleep(sleepTime * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	    
	public static void pause(Integer milliseconds){
		try {
			TimeUnit.MILLISECONDS.sleep(milliseconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
