package com.thoughtworks.capability.gtb.entrancequiz.repository;

import com.thoughtworks.capability.gtb.entrancequiz.domain.Group;
import com.thoughtworks.capability.gtb.entrancequiz.domain.Student;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GroupRepository {
    //TODO GTB-工程实践: - 随机分组的实现不应该输入 GroupRepository，应该是 GroupService 的
    public List<Group> group(List<Student> studentList) {
        Collections.shuffle(studentList);
        List<Group> groupList = new ArrayList<>();
        //TODO GTB-工程实践: - magic number 6
        for (int i = 0; i < 6; i++) {
            //TODO GTB-工程实践: - 实时创建出来后，不做保存吗？后面只想查询 groups 怎么办？必须要出发分组才能做查询？
            Group group = Group.builder().id(i).name(String.valueOf(i) + " 组").students(new ArrayList<>()).build();
            groupList.add(group);
        }

        for (int i = 0; i < studentList.size(); i++) {
            int index = (i % 6);
            //TODO GTB-工程实践: - 下面这三句可以提取到 Group 中去，第三句是多余的
            List<Student> students = groupList.get(index).getStudents();
            students.add(studentList.get(i));
            groupList.get(index).setStudents(students);
        }
        return groupList;
    }
}
