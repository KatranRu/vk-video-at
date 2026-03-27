package com.mobile.vk.video.at.pages;

import io.appium.java_client.AppiumBy;

import java.io.File;

import static com.codeborne.selenide.Selenide.$;

/**
 * Базовый тестовый класс для скриншотов
 */
public class BasePage {

    /**
     * Делает скриншот экрана без статусбара
     *
     * @return файл скриншота
     */
    public File fullPageScreenshot() {
        return $(AppiumBy.id("composerRootCl")).screenshot();
    }
}
