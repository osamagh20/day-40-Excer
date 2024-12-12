package com.example.day39exer.Repository;

import com.example.day39exer.Model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher,Integer> {

    Teacher findTeacherById(Integer id);


}
