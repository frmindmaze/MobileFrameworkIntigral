# MobileFrameworkIntigral

#Introduction:
Appium mobile test framework build on top of the Cucumber framework using Java, Maven & Junit.

# Appium Features
Appium has been adopted in the industry due to its wide range of features. Let us discuss the ones that bring Appium into the spotlight.

1.Support Webdriver Protocol – Webdriver Protocol gives better control over web UI. Automation without interrupting with the JS running on the page. Appium still is backwards Compatible with the JSON Wire Protocol.
2.Robust Test Execution – Appium can easily execute tests regardless of the device being locally available or being on a remote server. The tests can be monitored in real-time as well.
3.Multi-Platform Support – Appium can execute test cases across multiple platforms. As of now, Appium supports Android, iOS and Windows applications.
4.No need to Rebuild Application – Appium doesn’t reinstall the application being tested onto the system again and again. Neither does it need any access to the library or source code of the application.
5.Parallel Execution – Appium enables users to execute test automation scripts on multiple Android or iOS sessions. This can be achieved using UIAutomator, UIAutomation and Xcode9

#Tools Libraries and languages used to build this Framework:
1.Java
2.Cucumber 
3.IntelliJ
4.Maven
5.Github
6.Appium Inspector & Uiautomatorviewer

#Steps to Setup this framework in Local

#Tools to be installed
1.Install version of NodeJS supported by Appium (currently 10+, but typically the latest stable version), or Appium Desktop
2.The Java Development Kit (JDK)
3.Android Studio and related tools

#Setting up Environment
1.Set JAVA_HOME in System variables ex: JAVA_HOME= C:\Program Files\Java\jdk1.8.0
2.Set ANDROID_HOME in System variables ex: ANDROID_HOME= C:\Users\frmin\AppData\Local\Android\Sdk
3.Set Path in System variables ex: %ANDROID_HOME%\tools , %ANDROID_HOME%\platform-tools , %ANDROID_HOME%\tools\bin , %ANDROID_HOME%\emulator

#Setting up emulator/simulator or Android Phone
Emulator setup:
1.Open Android Studio. 
2.Once Android Studio is launched, click the "Configure" menu option in the launch window, where you'll see two important items: "AVD Manager" and "SDK Manager". First, click SDK Manager.
3.Once the SDK Manager is open, ensure that at least one Android SDK is installed. On this view, take note of the "Android SDK Location", since we'll need this location in a bit.
4.Close the SDK Manager and open the AVD Manager. The AVD Manager is where we will create and launch Android Virtual Devices, otherwise known as emulators. When it launches, assuming you have no other devices already, you can click "Create Device" to begin the emulator creation wizard. Here you can choose any device configuration preset.
5.Next, work through the various other prompts. You can safely pick default values unless you happen to know you have other needs. When prompted for the system version of the emulator, you'll need to pick a system image that you have downloaded. If one is not already downloaded, click the "Download" link beside it to make it available for the emulator.You can name the emulator whatever you want.
6.Once it's done being created, click the green play button looking icon to launch it! You'll see what looks like an Android device being booted. Let it boot fully and play with it a bit to make sure it works as expected.

Mobile Setup:
1.Enable Developer Option by tapping the build number in your settings of you mobile phone
2.Enable these on Developer options USB debugging , Install via USB & USB debugging (Security settings)
3.Now connect your device or emulator and open command prompt and type adb devices, it should display connected or availabble devices nad emulator.


#Setting up Appium inspector for Windows to capture objects:
1.Open Appium Desktop
2.Start the server
3.Click on the search icon in the top right corner.
4.Select Automatic Server in the window opened and set desired capabilities in json format.
ex: {
      "deviceName": "UDID",(your device or emulator id)
      "automationName": "uiautomator2",
      "platformName": "Android",
      "app": "E:\\Francis\\Framework\\MobileFrameworkIntigral\\src\\test\\resources\\mobileapps\\Android.apk",(your path of apk to be installed)
      "appActivity": "com.swaglabsmobileapp.MainActivity",
      "appPackage": "com.swaglabsmobileapp"
    }

To capture appActivity and apppackage use below command:
1.Enter the command prompt with your app open in device: adb shell (then pass either one of the command )
 (i) dumpsys window windows | grep -E 'mObscuringWindow' 
 (ii) dumpsys window windows | grep -i "mCurrentFocus"


#Setting up Framework:
1.Clone the framework to the required location
2.Run the runner class file.(set tags and feature file based on your interest)


Have fun Automating mobile Apps!!!!!!!!!!




