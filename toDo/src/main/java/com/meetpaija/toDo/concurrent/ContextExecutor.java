package com.meetpaija.toDo.concurrent;

import java.util.concurrent.Executor;

import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

public class ContextExecutor implements Executor {
	private final Executor delegate;

	public ContextExecutor(Executor delegate) {
		this.delegate = delegate;
	}

	@Override
	public void execute(Runnable task) {
		task = DelegatingContextRunnable.create(task);
		delegate.execute(task);
	}

//	void cleanupOnDestroy() {
//		if (this.delegate instanceof ThreadPoolTaskExecutor) {
////			logger.debug("Shutting down ThreadPoolTaskExecutor : " + this.delegate);
//			((ThreadPoolTaskExecutor) this.delegate).shutdown();
//		}
//		logger.debug("SoluminaContextExecutor destroyed");
//	}
}

