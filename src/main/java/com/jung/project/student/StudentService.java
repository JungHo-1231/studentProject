package com.jung.project.student;

import com.jung.project.EmailValidator;
import com.jung.project.exeception.ApiRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class StudentService {

    private final StudentDataAccessService studentDataAccessService;
    private final EmailValidator emailValidator;

    @Autowired
    public StudentService(StudentDataAccessService studentDataAccessService, EmailValidator emailValidator) {
        this.studentDataAccessService = studentDataAccessService;
        this.emailValidator = emailValidator;
    }

    public List<Student> getAllStudents(){
        return studentDataAccessService.selectAllStudents();
    }


    public void addNewStudent( Student student) {
        addNewStudent(null, student);
    }

    public void addNewStudent(UUID studentId , Student student) {
        UUID newStudentId = Optional.ofNullable(studentId).orElse(UUID.randomUUID());

        // TODO : Validate email
       if(!emailValidator.test(student.getEmail())){
           throw new ApiRequestException(student.getEmail() + " is not valid");
        }

       // TODO : Verify that email is not taken
       if(studentDataAccessService.isEmailTaken(student.getEmail())){
           throw new ApiRequestException(student.getEmail()+ " is taken");
       }
        studentDataAccessService.insertStudent(newStudentId, student);
    }

    public List<StudentCourse> getAllCoursesForStudent(UUID studentId) {
        return studentDataAccessService.getAllCoursesForStudent(studentId);
    }
}
