package com.gl.studentfestreg.security;

import javax.activation.DataSource;
import javax.annotation.sql.DataSourceDefinition;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class JdbcStudentsecurity extends WebSecurityConfigurerAdapter {

	@Autowired
	javax.sql.DataSource dataSource;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().dataSource(dataSource).withDefaultSchema()
				.withUser(User.withUsername("sri").password("sri").roles("user"))
				.withUser(User.withUsername("shyam").password("shyam").roles("admin"));

	}

	@Bean
	PasswordEncoder getpaEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/h2-console/***");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.csrf().disable().authorizeRequests().antMatchers("/students").hasRole("user")
				.antMatchers("/students", "students/new").hasAnyRole("user", "admin").antMatchers("/").permitAll().and()
				.formLogin();

	}

}
