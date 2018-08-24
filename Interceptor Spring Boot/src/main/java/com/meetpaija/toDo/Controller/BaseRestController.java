package com.meetpaija.toDo.Controller;

import java.util.concurrent.Executor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class BaseRestController {
	
	@Autowired
	@Qualifier(value="asyncTaskExecutor")
	protected Executor executor;
	
}
