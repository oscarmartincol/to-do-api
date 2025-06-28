package com.oscarmartincol.to_do_list.repository;

import com.oscarmartincol.to_do_list.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {

}

