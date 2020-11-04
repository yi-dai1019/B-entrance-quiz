package com.thoughtworks.capability.gtb.entrancequiz.controller;

import com.thoughtworks.capability.gtb.entrancequiz.domain.Group;
import com.thoughtworks.capability.gtb.entrancequiz.domain.Student;
import com.thoughtworks.capability.gtb.entrancequiz.service.GroupService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//TODO GTB-完成度: * 纯从功能角度看，还差个查询 groups 的接口，其它的都还行

//TODO GTB-测试: * 没有测试

@RestController
@CrossOrigin("*")
public class GroupController {

    private final GroupService groupService;

    //TODO GTB-知识点: + 使用构造函数注入
    public GroupController(GroupService groupService) {
        this.groupService = groupService;
    }

    @GetMapping(path = "/grouping")
    public ResponseEntity<List<Group>> getAllStudent() {
        List<Group> groups = groupService.group();
        return ResponseEntity.status(HttpStatus.OK).body(groups);
    }
}
