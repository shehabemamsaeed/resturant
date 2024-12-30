package com.resurant.resturant.setting;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.time.Duration;

@Setter
@Getter
@ConfigurationProperties(prefix = "key-config")
public class KeyConfig {
     String key;
     Duration dur;
}
