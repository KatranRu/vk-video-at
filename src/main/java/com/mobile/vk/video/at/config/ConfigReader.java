package com.mobile.vk.video.at.config;

import org.aeonbits.owner.ConfigFactory;

public class ConfigReader {
    public static final EmulatorConfig EMULATOR_CONFIG = ConfigFactory.create(EmulatorConfig.class, System.getProperties());
    public static final TestConfig TEST_CONFIG = ConfigFactory.create(TestConfig.class, System.getProperties());
}