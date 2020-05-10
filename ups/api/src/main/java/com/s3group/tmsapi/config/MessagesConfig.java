package com.s3group.tmsapi.config;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 *
 * @author : Thamilarasi
 * @version : 1.0
 * @since : 2020-05-06
 */
@Component
@ConfigurationProperties
@PropertySource("file:${CONF_DIR}/messages.properties")
@Data
@NoArgsConstructor
public class MessagesConfig {
}