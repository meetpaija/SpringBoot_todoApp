package com.meetpaija.toDo.Controller;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.meetpaija.toDo.Model.toDo_model;
import com.meetpaija.toDo.Service.ITodoService;
import com.meetpaija.toDo.ServiceImpl.TodoServiceImpl;
import com.meetpaija.toDo.client.ServiceLocator;

@CrossOrigin
@RestController
//@EnableAsync
@RequestMapping("/api")
public class toDo_Controller extends BaseRestController {

	private toDo_model model;

	@Autowired
	private ITodoService todoService;

	@GetMapping("/toDo")
	public ResponseEntity<List<toDo_model>> getDetails() {
		return ResponseEntity.ok(todoService.getAll());
	}

	@PostMapping("/toDo")
//	@Async(value = "asyncTaskExecutor")
	public ResponseEntity<toDo_model> createToDo(@RequestBody toDo_model td) throws Exception {

//			CompletableFuture<toDo_model> future = CompletableFuture.supplyAsync(() -> {
//				try {
//					return todoService.saveTodo(td);
//				} catch (Exception ex) {
//					throw new RuntimeException("error");
//				}
//			}, executor);
//			throw new RuntimeException(future.get().toString());
//		return ResponseEntity.ok(todoService.saveTodo(td));
			//todoService=(TodoServiceImpl) ServiceLocator.getBean("todoService");
			CompletableFuture<toDo_model> todo=CompletableFuture.supplyAsync(() -> {
				return todoService.saveTodo(td);
				},executor);
			todo.handle((i, err) -> {
				  if (err != null) {
				    throw new RuntimeException("2");
				  } else {
				    System.out.println(i);
				    return i;
				  }
				}).join();
		
		
//		ExecutorService executor = Executors.newSingleThreadExecutor();
//		Future<Void> future = executor.submit(new Callable<Void>() {
//		    @Override
//		    public Void call() throws Exception {
//		        System.out.println("** Started");
////		        toDo_model res=todoService.saveTodo(td);
//		        Thread.sleep(2000);
//		        throw new IllegalStateException("exception from thread");
//		    }
//		});
//		try {
//		    future.get(); // raises ExecutionException for any uncaught exception in child
//		} catch (ExecutionException e) {
//		    System.out.println("** RuntimeException from thread ");
//		    e.getCause().printStackTrace(System.out);
//		}
//		executor.shutdown();
//		System.out.println("** Main stopped");
			
			
//			try {
//				toDo_model res=todoService.saveTodo(td);
////				return ResponseEntity.ok(res);
//			}catch(Exception ex) {
//				throw new Exception();
//			}
//		 return ResponseEntity.ok(model);
		throw new RuntimeException();
	}

	@GetMapping("/toDo/{id}")
	public ResponseEntity<toDo_model> getById(@PathVariable(value = "id") Long todoId) {

		toDo_model todo = todoService.getTodoById(todoId);
		return ResponseEntity.ok(todo);
	}

	@PutMapping("/toDo/{id}")
	public ResponseEntity<toDo_model> updateTodo(@PathVariable(value = "id") Long todoId, @Valid toDo_model td) {
		return ResponseEntity.ok(todoService.updateTodo(td, todoId));
	}

	@DeleteMapping("/toDo/{id}")
	public ResponseEntity<toDo_model> deletetd(@PathVariable(value = "id") Long todoId) {
		todoService.deleteTodo(todoId);
		return ResponseEntity.ok().build();
	}
}
