package com.mobile.vk.video.at.pages;

import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;

import static com.codeborne.selenide.Selenide.$;

public class MinimizablePlayerContainer extends BasePage {
    private SelenideElement currentProgress = $(AppiumBy.id("com.vk.vkvideo:id/current_progress"));
    private SelenideElement videoPlayButton = $(AppiumBy.id("com.vk.vkvideo:id/video_play_button"));
    private SelenideElement videoDisplay = $(AppiumBy.id("com.vk.vkvideo:id/video_display"));

    @Step("Проверка что видео воспроизводится")
    public MinimizablePlayerContainer checkPlayVideo() {
        videoDisplay.click();
        Assertions.assertTrue(videoPlayButton.getAttribute("content-desc").equalsIgnoreCase("Pause"), "Кнопка не Pause");
        String str1 = currentProgress.getAttribute("text");
        try {
            wait(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        String str2 = currentProgress.getAttribute("text");
        Assertions.assertFalse(str2 != null && str2.equalsIgnoreCase(str1), "Время не изменилось");
        return this;
    }
}
