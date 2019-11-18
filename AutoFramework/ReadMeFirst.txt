1/ You Need to run Ant (select "main" target) to build the project
2/ Add the .jar(s) in "lib" folder To the Project Build-Path to resolve compile errors
3/ Install Android Studio to have the mobile SDK:
    - set classpath: aapt (C:\Users\dvathu\AppData\Local\Android\Sdk\build-tools\29.0.2)
    - set classpath: abd (C:\Users\dvathu\AppData\Local\Android\Sdk\platform-tools)
    - plug in your Android phone to your laptop/ machine, set it to developer mode
    - run adb devices to get the device name RQ3005UBHG
4/ Install Apium:
    - Run test, observe the Apium server logs
    - test success
    - Remove unnecessary files in mobile:
        - adb uninstall io.appium.settings
        - adb uninstall io.appium.unlock
        - adb uninstall io.appium.uiautomator2.server
        - adb uninstall io.appium.uiautomator2.server.test
5/ Run ant -d main to compile the project

