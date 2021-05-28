package tw.com.rex.resourceserver.config;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import tw.com.rex.resourceserver.properties.CasOauth2Properties;

@AllArgsConstructor
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final CasOauth2Properties oauth2Properties;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http// 所有請求都要驗證
            .authorizeRequests().anyRequest().authenticated().and()
            // resource server
            .oauth2ResourceServer()
            // opaque token
            .opaqueToken()
            // CAS 的 introspection endpoint
            .introspectionUri(oauth2Properties.getIntrospectionUri())
            // CAS 的 client id & client secret
            .introspectionClientCredentials(oauth2Properties.getClientId(), oauth2Properties.getClientSecret());
    }

}
