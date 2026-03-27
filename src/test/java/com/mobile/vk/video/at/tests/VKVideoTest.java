package com.mobile.vk.video.at.tests;

import com.mobile.vk.video.at.pages.MainPage;
import io.qameta.allure.Description;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class VKVideoTest extends BaseTest {
    private static MainPage mainPage;

    @BeforeAll
    public static void init() {
        mainPage = new MainPage();
    }

    @Description("Сценарий просмотра первого видео из рекомендации в VK Видео")
    @Test
    public void watchFirstVideoVkVideo() {
        mainPage.clickFirstVideoInRecommendation()
                .checkPlayVideo();
    }
}
