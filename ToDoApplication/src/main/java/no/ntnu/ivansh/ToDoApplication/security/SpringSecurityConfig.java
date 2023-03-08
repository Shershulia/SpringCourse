package no.ntnu.ivansh.ToDoApplication.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.beans.Encoder;
import java.util.function.Function;

@Configuration
public class SpringSecurityConfig {
    @Bean
    public InMemoryUserDetailsManager configureUserDetails(){
        UserDetails user = createUser("123","123");
        UserDetails user2 = createUser("ivansh","admin");

        return new InMemoryUserDetailsManager(user,user2);
    }

    private UserDetails createUser(String name, String password) {
        Function<String,String> passwordEncoder = input->passwordEncoder().encode(input);
        UserDetails user = User.builder().passwordEncoder(passwordEncoder)
                .username(name).password(password).roles("USER","ADMIN").build();
        return user;
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {

        httpSecurity.authorizeHttpRequests(
          auth->auth.anyRequest().authenticated()
        );
        httpSecurity.formLogin(Customizer.withDefaults());

        httpSecurity.csrf().disable();
        httpSecurity.headers().frameOptions().disable();

        return httpSecurity.build();

    }
}
