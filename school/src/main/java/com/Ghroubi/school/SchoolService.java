package com.Ghroubi.school;


import com.Ghroubi.school.client.StudentClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SchoolService {
    private final SchoolRepository repository;
    private final StudentClient client;

    public void saveSchool(School student){
        repository.save(student);
    }
    public List<School> findAllSchools(){
        return repository.findAll();
    }

    public FullSchoolResponse findSchoolsWithStudents(Integer schoolId) {
        var school = repository.findById(schoolId).orElse(School.builder()
                .name("NOT_FOUND")
                .email("NOT_FOUND")
                .build());
        var students = client.findAllStudentsBySchoolId(schoolId); // find all the students from the students micro-service
        return FullSchoolResponse.builder()
                .name(school.getName())
                .email(school.getEmail())
                .students(students)
                .build();
    }
}
