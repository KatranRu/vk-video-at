package com.mobile.vk.video.at.pages;

import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class MainPage extends BasePage {
    private SelenideElement content = $(AppiumBy.id("com.vk.vkvideo:id/content"));

    @Step("Выбор первого видео из рекомендации")
    public MinimizablePlayerContainer clickFirstVideoInRecommendation() {
        content.click();
        return new MinimizablePlayerContainer();
    }
}
