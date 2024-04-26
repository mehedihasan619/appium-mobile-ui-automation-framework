# Appium Test Automation Set Up

## Table of contents
1. [Download and Install Android SDK](#Download-and-Install-Android-SDK)
2. [Download Xcode](#Download-Xcode)
3. [Install Node](#Install-Node)
4. [Set Up and Verify Appium Installation](#Set-Up-and-Verify-Appium-Installation)
5. [Download Appium Desktop Inspector](#Download-Appium-Desktop-Inspector)
6. [iOS Real Device Automation Preparation](#iOS-Real-Device-Automation-Preparation)
7. [Project Set Up](#Project-Set-Up)
8. [Run the Test](#Run-the-Test)

### Download and Install Android SDK
- Download Android SDK and platform tools and configure the environment (Easiest way to do it is via Android Studio)

### Download Xcode
- Download Xcode [here](https://developer.apple.com/xcode/) or directly from Apple App Store.
- Install Xcode Command Line Tools: `xcode-select --install` and verify your installation: `xcode-select -p`

### Install Node
- Install Node: (Homebrew) `brew install node`

### Set Up and Verify Appium Installation
- Install Appium: (via npm) `npm install -g appium` or (via Homebrew) `brew install appium`
- Install `xcuitest` Driver: `appium driver install xcuitest`
- Install `uiautomator2` Driver: `appium driver install uiautomator2`
- Install `chromium` Driver: `appium driver install chromium`
- Install `appium-doctor`: `npm install appium-doctor -g`
- Verify Appium Android and iOS Readiness: `appium-doctor --android`, `appium-doctor --ios`

### Download Appium Desktop Inspector
To inspect MobileElements Appium Inspector is required. Download it [here](https://github.com/appium/appium-inspector/releases) 

### iOS Real Device Automation Preparation
- Install `ios-deploy`: (via Homebrew) `brew install ios-deploy` or (via npm) `npm install -g ios-deploy`
- Install `libimobiledevice`: `brew install libimobiledevice`
- Install `carthage`: `brew install carthage`
- Create a WebDriverAgentRunner following the guidelines [here](https://appium.readthedocs.io/en/stable/en/drivers/ios-xcuitest-real-devices/)

### Project Set Up
- Clone the repo
- Replace appium server URL, app binary path, device name and aws profile in `config.properties` file
- Before running a test make sure you've set the correct `profile` in `config.properties` file
- Set up maven: `brew install maven`

### Run the Test
To run test via terminal: `mvn test -P<name_of_the_profile> -DemailAddress=<login_user_name> -Dpassword=<login_password>`