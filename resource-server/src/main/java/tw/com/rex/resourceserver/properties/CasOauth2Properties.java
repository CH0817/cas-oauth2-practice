package tw.com.rex.resourceserver.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "cas.oauth2.resource-server.opaque")
public class CasOauth2Properties {

    private String introspectionUri;
    private String clientId;
    private String clientSecret;

}
