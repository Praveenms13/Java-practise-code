package com.example.student;

import org.springframework.web.bind.annotation.*;
import java.util.*;


@RestController
@RequestMapping("/students")
public class StudentController {
    private final List<Student> studentList = new ArrayList<>();
    @PostMapping("/addStudent")
    public String addStudent(@RequestBody Student student) {
        for  (Student s : studentList) {
            if(s.getName().equals(student.getName())) { return "Student Already Exists"; }
            if (s.getEmail().equals(student.getEmail())) { return "Student Already Exists"; }
        }
        int maxId = studentList.stream()
                .mapToInt(Student::getId)
                .max()
                .orElse(-1);
        if (maxId == -1) {
            student.setId(1);
        }
        else {
            maxId = maxId + 1; student.setId(maxId);
        }
        studentList.add(student);
        return "Student added successfully";
    }
    @GetMapping("/getAllStudents")
    public List<Student> getAllStudents() {
        return studentList;
    }
    @PutMapping("/updateStudent/{id}")
    public String updateStudent(@PathVariable int id, @RequestBody Student updatedStudent) {
        for (Student student : studentList) {
            if (student.getId() == id) {
                if (updatedStudent.getName() != null) {
                    student.setName(updatedStudent.getName());
                }
                if (updatedStudent.getEmail() != null) {
                    student.setEmail(updatedStudent.getEmail());
                }
                return "Student updated successfully";
            }
        }
        return "Student not found";
    }
    @DeleteMapping("/deleteStudent/{id}")
    public String deleteStudent(@PathVariable int id) {
        Iterator<Student> iterator = studentList.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().getId() == id) {
                iterator.remove();
                return "Student deleted successfully";
            }
        }
        return "Student not found";
    }
}
