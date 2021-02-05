package de.ostfale.sbsecurity.config;

import de.ostfale.sbsecurity.auth.InitialAuthenticationFilter;
import de.ostfale.sbsecurity.auth.JwtAuthenticationFilter;
import de.ostfale.sbsecurity.auth.OtpAuthenticationProvider;
import de.ostfale.sbsecurity.auth.UserNamePasswordAuthenticationProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final InitialAuthenticationFilter initialAuthenticationFilter;
    private final JwtAuthenticationFilter jwtAuthenticationFilter;
    private final OtpAuthenticationProvider otpAuthenticationProvider;
    private final UserNamePasswordAuthenticationProvider userNamePasswordAuthenticationProvider;

    public SecurityConfig(
            @Lazy InitialAuthenticationFilter iaFilter,
            JwtAuthenticationFilter jwtFilter,
            OtpAuthenticationProvider otpProvider,
            UserNamePasswordAuthenticationProvider authProvider) {
        this.initialAuthenticationFilter = iaFilter;
        this.jwtAuthenticationFilter = jwtFilter;
        this.otpAuthenticationProvider = otpProvider;
        this.userNamePasswordAuthenticationProvider = authProvider;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) {
        auth.authenticationProvider(otpAuthenticationProvider)
                .authenticationProvider(userNamePasswordAuthenticationProvider);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.addFilterAt(
                initialAuthenticationFilter,
                BasicAuthenticationFilter.class)
                .addFilterAfter(
                        jwtAuthenticationFilter,
                        BasicAuthenticationFilter.class
                );

        http.authorizeRequests()
                .anyRequest()
                .authenticated();
    }

    @Override
    @Bean
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }
}
