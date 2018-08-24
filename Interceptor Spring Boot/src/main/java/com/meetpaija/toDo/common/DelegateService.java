package com.meetpaija.toDo.common;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

@Service
@Transactional
public class DelegateService {

	public void start(Runnable delegate) {
		boolean isCommit = true;
		try {
			delegate.run();
//			throw new RuntimeException();
//			System.out.println("done");
			
		} catch(Exception e) {
			isCommit = false;
			throw e;
		}
	}
}
