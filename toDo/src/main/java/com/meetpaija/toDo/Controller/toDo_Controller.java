package com.meetpaija.toDo.Controller;

import java.util.List;

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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import com.meetpaija.toDo.Model.toDo_model;
import com.meetpaija.toDo.Repo.toDo_Repo;


@CrossOrigin
@RestController
@RequestMapping("/api")
public class toDo_Controller {
	@Autowired
	toDo_Repo todo;
	
	@GetMapping("/toDo")
	public List<toDo_model> getDetails()
	{
		return todo.findAll();
	}
	
	@PostMapping("/toDo")
	public toDo_model createToDo(@Valid toDo_model td)
	{
		return todo.save(td);
	}
	
	@GetMapping("/toDo/{id}")
	public ResponseEntity<toDo_model> getById(@PathVariable(value="id") Long todoId)
	{
		toDo_model td=todo.findOne(todoId);
		if(td==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(td);
	}
	
	@PutMapping("/toDo/{id}")
	public ResponseEntity<toDo_model> updateTodo(@PathVariable(value="id") Long todoId,@Valid toDo_model td)
	{
		toDo_model model=todo.findOne(todoId);
		if(model==null)
		{
			return ResponseEntity.notFound().build();
		}
		model.setTitle(td.getTitle());
		model.setDescription(td.getDescription());
		model.setcreatedon(td.getcreatedon());
		model.setmodifiedon(td.getmodifiedon());
		
		toDo_model updatedtd=todo.save(model);
		return ResponseEntity.ok(updatedtd);
	}
	
	//delete method
	@DeleteMapping("/toDo/{id}")
	public ResponseEntity<toDo_model> deletetd(@PathVariable(value="id") Long todoId){
		toDo_model td=todo.findOne(todoId);
		if(td==null) {
			return ResponseEntity.notFound().build();
		}
		todo.delete(td);
		return ResponseEntity.ok().build();
	}
}
