package com.example.day39exer.Service;

import com.example.day39exer.ApiResponse.ApiException;
import com.example.day39exer.Model.Address;
import com.example.day39exer.Model.Teacher;
import com.example.day39exer.Repository.AddressRepository;
import com.example.day39exer.Repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeacherService {
    private final TeacherRepository teacherRepository;
    private final AddressRepository addressRepository;

    public List<Teacher> findAllTeachers(){
        return teacherRepository.findAll();
    }

    public void addTeacher(Teacher teacher){
       teacherRepository.save(teacher);
    }

    public void updateTeacher(Integer id,Teacher teacher){
        Teacher teacher1 = teacherRepository.findTeacherById(id);
        if(teacher1==null){

            throw new ApiException("id not found");
        }
        teacher1.setName(teacher.getName());
        teacher1.setAge(teacher.getAge());
        teacher1.setEmail(teacher.getEmail());
        teacherRepository.save(teacher1);
    }

    public void deleteTeacher(Integer id){
        Teacher teacher1 = teacherRepository.findTeacherById(id);
        if(teacher1==null){
            throw new ApiException("id not found");
        }
        Address address = addressRepository.findAddressById(id);
        if(address==null){
            throw new ApiException("address not found");
        }
        teacher1.setAddress(null);
        teacherRepository.save(teacher1);
        addressRepository.delete(address);
        teacherRepository.delete(teacher1);
    }

    public Teacher getTeacherDetails(Integer id){
        Teacher teacher1 = teacherRepository.findTeacherById(id);
        if(teacher1==null){
            throw new ApiException("id not found");
        }
        return teacher1;
    }
}
