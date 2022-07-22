package sample_sso.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfigure {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{

        http.httpBasic();

        http.authorizeRequests()
//                .antMatchers("/security").permitAll()  //permitAll 해당하는 하위경로 모두 인증받지않고 사용가능
                .antMatchers("/").authenticated();

        http.csrf().disable();

        return http.build();
    }

}
