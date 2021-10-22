package com.mudi.mvc;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig
		extends WebSecurityConfigurerAdapter {

	@Autowired
	private DataSource dataSource;

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests().anyRequest().authenticated().and()
				.formLogin(form -> form.loginPage("/login")
						.defaultSuccessUrl("/home", true)
						.permitAll())
				.logout(logout -> logout.logoutUrl("/logout"));

	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth)
			throws Exception {
		PasswordEncoder encoder = new BCryptPasswordEncoder();
//		UserDetails user = User.builder().username("heitor")
//				.password(encoder.encode("123")).roles("ADM")
//				.build();

		auth.jdbcAuthentication().dataSource(dataSource)
				.passwordEncoder(encoder);// .withUser(user);
	}

}
