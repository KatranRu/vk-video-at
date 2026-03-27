package com.mobile.vk.video.at.driver;

import com.codeborne.selenide.WebDriverProvider;
import com.mobile.vk.video.at.config.ConfigReader;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;


public class EmulatorDriver implements WebDriverProvider {
    protected static AndroidDriver driver;
    private static final String DEVICE_NAME = ConfigReader.EMULATOR_CONFIG.deviceName();
    private static final String PLATFORM_NAME = ConfigReader.EMULATOR_CONFIG.platformName();
    private static final String AUTOMATION_NAME = ConfigReader.EMULATOR_CONFIG.automationName();

    private static int NEW_COMMAND_TIMEOUT = ConfigReader.EMULATOR_CONFIG.newCommandTimeout();
//    private static String APP_PACKAGE = ConfigReader.EMULATOR_CONFIG.appPackage();
//    private static String APP_ACTIVITY = ConfigReader.EMULATOR_CONFIG.appActivity();
private static final String APP_PACKAGE = "com.vk.vkvideo";
    private static final String APP_ACTIVITY = ".video.screens.main.MainActivity";
    private static final String URL = ConfigReader.EMULATOR_CONFIG.remoteURL();


    @Override
    public WebDriver createDriver(Capabilities capabilities) {
        // Инициализация пакета и активности
//        initPackageAndActivity();

        // Создание опций с использованием UiAutomator2Options (рекомендуемый способ)
        UiAutomator2Options options = new UiAutomator2Options();

        // Копирование всех capabilities из переданных
        if (capabilities != null) {
            capabilities.getCapabilityNames().forEach(capName -> {
                options.setCapability(capName, capabilities.getCapability(capName));
            });
        }

        // Добавление специфичных для Android настроек
        options.setAppPackage(APP_PACKAGE);
//        options.setAppActivity(APP_ACTIVITY);
        options.setAutomationName(AUTOMATION_NAME);
        options.setPlatformName(PLATFORM_NAME);
        options.setNoReset(true);
        options.setFullReset(false);

        // Дополнительные настройки
        options.setCapability("newCommandTimeout", NEW_COMMAND_TIMEOUT);
        options.setCapability("autoGrantPermissions", true);
        options.setNoReset(true);
        options.setFullReset(false);
        options.setAutoGrantPermissions(true);
//        options.setNewCommandTimeout(NEW_COMMAND_TIMEOUT);

        // Ключевые настройки для автоматического поиска activity
        options.setCapability("appWaitActivity", "*");
        options.setCapability("appWaitForLaunch", true);
        options.setCapability("appWaitDuration", 30000);

        // Дополнительные настройки
        options.setCapability("unicodeKeyboard", true);
        options.setCapability("resetKeyboard", true);

        // Логирование для отладки
        options.setCapability("logLevel", "info");
        options.setCapability("eventTimings", true);

        driver = new AndroidDriver(getURL(), options);
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        return driver;
    }

    public static URL getURL() {
        try {
            return URI.create(URL).toURL();
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

//    private void initPackageAndActivity() {
//        APP_PACKAGE = APP_PACKAGE.isEmpty() ? helper.getAppPackageFromApk() : APP_PACKAGE;
//        APP_ACTIVITY = APP_ACTIVITY.isEmpty() ? helper.getAppMainActivity() : APP_ACTIVITY;
//
//    }
}