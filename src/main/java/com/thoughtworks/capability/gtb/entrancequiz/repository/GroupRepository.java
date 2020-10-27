package com.thoughtworks.capability.gtb.entrancequiz.repository;

import com.thoughtworks.capability.gtb.entrancequiz.domain.Group;
import com.thoughtworks.capability.gtb.entrancequiz.domain.Student;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GroupRepository {
    public List<Group> group(List<Student> studentList) {
        Collections.shuffle(studentList);
        List<Group> groupList = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            Group group = Group.builder().id(i).name(String.valueOf(i) + " 组").students(new ArrayList<>()).build();
            groupList.add(group);
        }

        for (int i = 0; i < studentList.size(); i++) {
            int index = (i % 6);
            List<Student> students = groupList.get(index).getStudents();
            students.add(studentList.get(i));
            groupList.get(index).setStudents(students);
        }
        return groupList;
    }
}
