package com.kodilla.hibernate.tasklist.dao;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TaskList extends CrudRepository<TaskList, Integer> {
    List<TaskList> findByListName(String listName);
}
