package com.mobile.vk.video.at.config;

import org.aeonbits.owner.Config;

/**
 * Чтение ключей из application.properties
 */
@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties", //читаем env
        "file:src/test/resources/application.properties", //читаем из файла
})
public interface TestConfig extends Config {
    @Key("updateScreenshots")
    @DefaultValue("false")
    boolean isScreenshotsNeedToUpdate();

    @Key("deviceHost")
    String deviceHost();
}