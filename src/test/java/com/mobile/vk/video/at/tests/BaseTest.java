package com.mobile.vk.video.at.tests;


import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.mobile.vk.video.at.listeners.AllureListener;
import io.qameta.allure.Allure;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;

import static com.mobile.vk.video.at.helper.Constants.SCREENSHOT_TO_SAVE_FOLDER;
import static com.mobile.vk.video.at.helper.DeviceHelper.executeBash;
import static com.mobile.vk.video.at.helper.RunHelper.runHelper;
import static io.qameta.allure.Allure.step;

/**
 * Базовый тестовый класс
 */
@ExtendWith(AllureListener.class)//расширяем тестовый класс
public class BaseTest {

    @BeforeAll
    public static void setup() {
        //добавляем логирование действий для аллюр отчета в виде степов
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());

        // папка для сохранения скриншотов selenide
        Configuration.reportsFolder = SCREENSHOT_TO_SAVE_FOLDER;
        //инициализируем андройд драйвер
        Configuration.browser = runHelper().getDriverClass().getName();
//        Configuration.startMaximized = false;
        Configuration.browserSize = null;
        Configuration.timeout = 10000;
        disableAnimationOnEmulator();
    }

    /**
     * Отключение анимаций на эмуляторе чтобы не лагало
     */
    private static void disableAnimationOnEmulator() {
        executeBash("adb -s shell settings put global transition_animation_scale 0.0");
        executeBash("adb -s shell settings put global window_animation_scale 0.0");
        executeBash("adb -s shell settings put global animator_duration_scale 0.0");
    }


    /**
     * Перед каждый тестом открываем приложение
     */
    @BeforeEach
    public void startDriver() {
        step("Открыть приложение", (Allure.ThrowableRunnableVoid) Selenide::open);
    }

    /**
     * После каждого теста закрываем AndroidDriver чтобы тест атомарным был
     */
    @AfterEach
    public void afterEach() {
        step("Закрыть приложение", Selenide::closeWebDriver);
    }


}