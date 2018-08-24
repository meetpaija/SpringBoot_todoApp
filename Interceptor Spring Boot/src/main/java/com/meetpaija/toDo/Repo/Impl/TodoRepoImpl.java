package com.meetpaija.toDo.Repo.Impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.meetpaija.toDo.Model.toDo_model;
import com.meetpaija.toDo.Repo.toDo_Repo;

public class TodoRepoImpl implements toDo_Repo{

	  @Autowired
	    private SessionFactory sessionFactory;
	
	@Override
	public List<toDo_model> getAll() {
		 Session session = sessionFactory.getCurrentSession();
	        @SuppressWarnings("unchecked")
	        List<toDo_model> list= session.createCriteria(toDo_model.class).list();
	        return list;
	}

}
