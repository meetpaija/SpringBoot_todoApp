package com.meetpaija.toDo.config;

import java.util.concurrent.Executor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import com.meetpaija.toDo.concurrent.ContextExecutor;

@Configuration
public class ExecutorConfig {
	
	@Bean(name = "asyncTaskExecutor")
	public Executor asyncTaskExecutor() {
		ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
		executor.setCorePoolSize(Runtime.getRuntime().availableProcessors() + 1);
		executor.setThreadGroupName("AsyncTaskExecutor");
		executor.setThreadNamePrefix("async-exec-thread-");
		executor.setWaitForTasksToCompleteOnShutdown(true);
		executor.setAwaitTerminationSeconds(5);
		executor.initialize();

		ContextExecutor asyncExecutor = new ContextExecutor(executor);
		return asyncExecutor;
	}

}
