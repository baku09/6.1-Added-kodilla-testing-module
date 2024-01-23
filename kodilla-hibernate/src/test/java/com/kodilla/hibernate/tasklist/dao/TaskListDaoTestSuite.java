package com.kodilla.hibernate.tasklist.dao;

import com.kodilla.hibernate.tasklist.TaskList;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class TaskListDaoTestSuite {

    @Autowired
    private TaskListDao taskListDao;

    @Test
    public void testFindByListName() {
        // Given
        TaskList taskList = new TaskList("Test List", "Test Description");
        taskListDao.save(taskList);

        // When
        List<TaskList> foundLists = taskListDao.findByListName("Test List");

        // Then
        assertEquals(1, foundLists.size());

        // Clean up
        taskListDao.deleteAll();
    }

}
