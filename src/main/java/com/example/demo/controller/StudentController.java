package com.example.demo.controller;

import com.example.demo.entity.CommonResponseEntity;
import com.example.demo.entity.PageResponse;
import com.example.demo.entity.StudentEntity;
import com.example.demo.entity.StudentRequestEntity;
import com.example.demo.service.StudentService;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * 学生类，用来测试数据库的增删改查
 */
@RestController
public class StudentController {
    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    /**
     * 根据id查询单条
     * @param id int
     * @return
     */
    @RequestMapping(value = "/student/{id}", method = RequestMethod.GET)
    public Optional<StudentEntity> findById(@PathVariable int id) {
        return studentService.findById(id);
    }

    /**
     * 根据id查询单条
     * @param id int
     * @return
     */
    @RequestMapping(value = "/student/one", method = RequestMethod.GET)
    public Optional<StudentEntity> findOne(@RequestParam int id){
        return studentService.findOne(id);
    }

    /**
     * 查询所有
     * @return
     */
    @RequestMapping(value = "/student", method = RequestMethod.GET)
    public List<StudentEntity> findAll(){
        return studentService.findAll();
    }

    /**
     * 插入一条
     * @param studentRequestEntity
     * @return
     */
    @RequestMapping(value = "/student", method = RequestMethod.POST)
    public StudentEntity save(@RequestBody StudentRequestEntity studentRequestEntity){
        return studentService.save(studentRequestEntity);
    }

    /**
     * 根据id删除一条
     * @param id
     */
    @RequestMapping(value = "/student/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable int id){
        studentService.delete(id);
    }

    /**
     * 根据id修改一条
     * @param name
     * @param id
     * @return
     */
    @RequestMapping(value = "/student/{id}", method = RequestMethod.PUT)
    public StudentEntity save(@RequestParam String name, @PathVariable int id){
        return studentService.save(name, id);
    }

    /**
     * 根据id修改一条
     * @param studentRequestEntity
     * @param id
     * @return
     */
    @RequestMapping(value = "/student/one/{id}", method = RequestMethod.PUT)
    public StudentEntity saveOne(@RequestBody StudentRequestEntity studentRequestEntity, @PathVariable int id){
        String name = studentRequestEntity.getName();
        return studentService.save(name, id);
    }

    @RequestMapping(value = "/student/response", method = RequestMethod.GET)
    public Page<StudentEntity> page(@RequestParam int page, @RequestParam int pageSize){
        return studentService.pageRequest(page, pageSize);
    }

    @RequestMapping(value = "/student/responsePage", method = RequestMethod.GET)
    public CommonResponseEntity<Page<StudentEntity>> responsePage(@RequestParam int page, @RequestParam int pageSize){
        return CommonResponseEntity.success(studentService.pageRequest(page, pageSize));
    }

    @RequestMapping(value = "/student/responsePageResponse", method = RequestMethod.GET)
    public CommonResponseEntity<PageResponse<StudentEntity>> responsePageResponse(@RequestParam int page, @RequestParam int pageSize){
        return CommonResponseEntity.success(PageResponse.of(studentService.findAll(), pageSize, page));
    }
}
