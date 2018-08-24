package com.meetpaija.toDo.ServiceImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.meetpaija.toDo.Model.toDo_model;
import com.meetpaija.toDo.Repo.toDo_Repo;
import com.meetpaija.toDo.Service.ITodoService;
@Service("todoService")
@Transactional
public class TodoServiceImpl implements ITodoService{

	@Autowired
	toDo_Repo toDoRepo;
	
	@Override
	public toDo_model saveTodo(toDo_model model) {
		toDo_model todo=toDoRepo.save(model);
		throw new RuntimeException();
//		return todo;
	}

	@Override
	public List<toDo_model> getAll() {
		return toDoRepo.getAll();
	}

	@Override
	public toDo_model getTodoById(long id) {
		return toDoRepo.findOne(id);
	}
//
	@Override
	public toDo_model updateTodo(toDo_model td, long id) {
		toDo_model model=toDoRepo.findOne(id);
		if(model==null)return null;
		model.setTitle(td.getTitle());
		model.setDescription(td.getDescription());
		model.setcreatedon(td.getcreatedon());
		model.setmodifiedon(td.getmodifiedon());
		
		return toDoRepo.save(model);
	}
//
	@Override
	public void deleteTodo(long id) {
		toDo_model td=toDoRepo.findOne(id);
		toDoRepo.delete(td);
	}

}
