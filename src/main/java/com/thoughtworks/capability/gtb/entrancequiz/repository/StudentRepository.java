package com.thoughtworks.capability.gtb.entrancequiz.repository;

import com.thoughtworks.capability.gtb.entrancequiz.domain.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Repository
public class StudentRepository {
    //TODO GTB-工程实践: - 这个 studentList 很奇怪，每次返回 list 还要实时根据 name 生成？以后了删除功能，student 的 id 还会发生改变？
    private static List<Student> studentList;
    private static List<String> nameList = Arrays.asList(
            "成吉思汗", "鲁班七号", "太乙真人", "钟无艳", "花木兰",
            "雅典娜", "芈月", "白起", "刘禅", "庄周",
            "马超", "刘备", "哪吒", "大乔", "蔡文姬");

    public static List<Student> findAll() {
        studentList = new ArrayList<>();
        for (int i = 0; i < nameList.size(); i++) {
            String name = nameList.get(i);
            Student student = Student.builder().id(i + 1).name(name).build();
            studentList.add(student);
        }
        return studentList;
    };

    public void addStudent(String name) {
        nameList.add(name);
    }
}
