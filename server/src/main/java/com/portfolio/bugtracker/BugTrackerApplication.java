package com.portfolio.bugtracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 * The type Bug tracker application.
 */
@EnableJpaAuditing
@SpringBootApplication
public class BugTrackerApplication
{
	
	/**
	 * The entry point of application.
	 *
	 * @param args the input arguments
	 */
	public static void main(String[] args)
	{
		SpringApplication.run(BugTrackerApplication.class, args);
	}

}
