package base;


import java.io.File;
import java.io.IOException;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import utility.CommonUtils;

import static utility.CommonUtils.*;

/**
 * The `TestBase` class in the base class for all the `Steps` classes within the app.
 * The `Steps` classes inherit the AppiumDriver driver instance from this class.
 *
 * This class contains the setUp() method that initialises the conditions needed to
 * setup the tests.
 *
 * The tearDown() method quits the current running driver instance, stops the Appium
 * server, closes the ios simulator or android emulator and sets up the Extent Report.
 *
 */
public class TestBase {

	public static AppiumDriver<MobileElement> driver;
	
    
	public void setUp() throws IOException {
		if(driver==null) {
			//system.
		    CommonUtils.loadUserConfigProp("user.properties");
		    CommonUtils.configurePlatform();

		    if(CommonUtils.platform.equals("android")) {
				
				CommonUtils.start_android_emulator();
				sleepTimer(10); // this sleep is necessary for Jenkins, need to wait for emulator to launch fully before proceeding
				

				
				CommonUtils.loadAndroidConfigProp("android.properties");
				CommonUtils.setAndroidCapabilities();
				

				
				CommonUtils.startAppiumServer();
				
                CommonUtils.sleepTimer(3);

				driver = CommonUtils.getAndroidDriver();
		    }
		}

	}

	public void tearDown() {
		if (CommonUtils.platform.equals("android")) {
			CommonUtils.close_android_emulator();
		}
		
		CommonUtils.stopServer();
	}
	
}
