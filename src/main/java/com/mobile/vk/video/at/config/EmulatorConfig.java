package com.mobile.vk.video.at.config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "file:src/test/resources/emulator.properties"
})
public interface EmulatorConfig extends Config {
    @Key("platformName")
    String platformName();

    @Key("deviceName")
    String deviceName();

    @Key("appPackage")
    String appPackage();

    @Key("appActivity")
    String appActivity();

    @Key("automationName")
    String automationName();

    @Key("newCommandTimeout")
    int newCommandTimeout();

    @Key("remoteURL")
    String remoteURL();

    @Key("app")
    String app();
}
