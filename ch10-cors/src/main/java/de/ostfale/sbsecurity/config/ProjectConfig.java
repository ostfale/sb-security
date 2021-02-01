package de.ostfale.sbsecurity.config;

import de.ostfale.sbsecurity.repository.CustomCsrfTokenRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.csrf.CsrfTokenRepository;

@Configuration
public class ProjectConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public CsrfTokenRepository customTokenRepository() {
        return new CustomCsrfTokenRepository();
    }

   /* @Bean
    public UserDetailsService uds() {
        var uds = new InMemoryUserDetailsManager();
        var mary = User.withUsername("mary")
                .password("12345")
                .authorities("READ")
                .build();
        uds.createUser(mary);
        return uds;
    }*/

   /* @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }*/

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf(c -> {
            c.csrfTokenRepository(customTokenRepository());
            c.ignoringAntMatchers("/ciao");
        });
        http.authorizeRequests().antMatchers("/")
                .permitAll().and()
                .authorizeRequests().antMatchers("/h2-console/**")
                .permitAll();
        http.headers().frameOptions().disable();


       /* HandlerMappingIntrospector i = new HandlerMappingIntrospector();
        MvcRequestMatcher matcher = new MvcRequestMatcher(i, "/ciaocsrf");
        http.csrf(c -> c.ignoringRequestMatchers(matcher));

        http.addFilterAfter(new CsrfTokenLogger(), CsrfFilter.class)
                .authorizeRequests().anyRequest().permitAll();
        http.formLogin().defaultSuccessUrl("/main", true);*/
    }
}
