package com.apssouza.configuration;

import com.apssouza.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
class AuthenticationConfiguration extends GlobalAuthenticationConfigurerAdapter {

    @Autowired
    UserService userService;

    @Override
    public void init(AuthenticationManagerBuilder auth) throws Exception {
    	System.out.println("AuthenticationConfiguration ===========================init");
        auth.userDetailsService(userDetailsService());
    }

    @Bean
    protected UserDetailsService userDetailsService() {
    	System.out.println("userDetailsService ===========================");
        return (email) -> {
            com.apssouza.pojos.User user = userService.getUserByEmail(email);
            System.out.println(email+" ==========================="+user.getEmail()+" Pass "+user.getPassword());
            return new User(
                    user.getEmail(),
                    user.getPassword(),
                    true, true, true, true,
                    AuthorityUtils.createAuthorityList("USER", "write")
            );
        };
    }
}
