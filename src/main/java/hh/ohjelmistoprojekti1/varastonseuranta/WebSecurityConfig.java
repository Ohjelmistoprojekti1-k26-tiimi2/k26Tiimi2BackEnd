package hh.ohjelmistoprojekti1.varastonseuranta;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.http.HttpMethod;
import hh.ohjelmistoprojekti1.varastonseuranta.web.UserDetailServiceImpl;

@Configuration
@EnableMethodSecurity(securedEnabled = true) // metoditasoinen suojaus
public class WebSecurityConfig {

    private final UserDetailServiceImpl userDetailServiceImpl;
    // käyttäjätietojen haku tietokannasta

    WebSecurityConfig(UserDetailServiceImpl userDetailServiceImpl) {
        this.userDetailServiceImpl = userDetailServiceImpl;
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        // salasanan hashays kirjautumisen yhteydessä
        return new BCryptPasswordEncoder();
    }

    // sovelluksen http -suojaus
    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(
                authorize -> authorize
                    .requestMatchers(HttpMethod.GET,"/api/**").permitAll() // frontti saa hakea dataa
                    .requestMatchers("/api/**").authenticated()            // muut vaatii loginin
                        .anyRequest()
                        .authenticated())
                .formLogin(formlogin -> formlogin // springin oletus kirjautumissivu
                        .defaultSuccessUrl("/index", true) // kirjautumisen jälkeen ohjataan index-sivulle
                        .permitAll())
                .logout(logout -> logout
                        .permitAll()
                        .invalidateHttpSession(true))
                .csrf(csrf -> csrf
                        .ignoringRequestMatchers("/h2-console/**"))
                .headers(headers -> headers
                        .frameOptions(frame -> frame.disable()));
        return http.build();
    }

    // authentikointi
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailServiceImpl).passwordEncoder(new BCryptPasswordEncoder());
    }

}
