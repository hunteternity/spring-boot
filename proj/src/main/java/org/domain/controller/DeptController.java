package org.domain.controller;

import org.domain.dto.DeptDto;
import org.domain.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by root on 3/20/19.
 */

@Controller
public class DeptController {

    @Autowired
    private DeptService deptService;

    @PostMapping("/dept/add")
    @ResponseBody
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void add(@RequestBody DeptDto dto){
        if(dto.addValidate(dto)){
            deptService.save(dto);
        }else{
            throw new RuntimeException("Invalid parameter");
        }
    }

    @PutMapping("/dept/update")
    @ResponseBody
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@RequestBody DeptDto dto){
        if(dto.updateValidate(dto)){
            deptService.update(dto);
        }else{
            throw new RuntimeException("Invalid parameter");
        }
    }

    @DeleteMapping("/dept/remove/{deptID}")
    @ResponseBody
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remove(@PathVariable Long deptID){
        if(deptID != null){
            deptService.delete(deptID);
        }else{
            throw new RuntimeException("Invalid parameter");
        }
    }

    @GetMapping("/hello")
    @ResponseBody
    public String hello(){
        return "Hello world!";
    }
}
