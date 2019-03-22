package org.domain.controller;

import org.domain.dto.EmpDto;
import org.domain.model.Emp;
import org.domain.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by root on 3/20/19.
 */

@Controller
public class EmpController {

    @Autowired
    private EmpService empService;

    @PostMapping("/emp/add")
    @ResponseBody
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void add(@RequestBody EmpDto dto){
        if(dto.addValidate(dto)){
            empService.save(dto);
        }else{
            throw new RuntimeException("Invalid parameter");
        }
    }

    @PutMapping("/emp/update")
    @ResponseBody
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@RequestBody EmpDto dto){
        if(dto.updateValidate(dto)){
            empService.update(dto);
        }else{
            throw new RuntimeException("Invalid parameter");
        }
    }

    @DeleteMapping("/emp/remove/{empID}")
    @ResponseBody
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remove(@PathVariable Long empID){
        if(empID != null){
            empService.delete(empID);
        }else{
            throw new RuntimeException("Invalid parameter");
        }
    }

    @PostMapping("/emp/find")
    @ResponseBody
    public List<Emp> find(@RequestBody EmpDto dto){

        List<Emp> list = new ArrayList<>();

        if(dto.findValidate(dto)){
            list = empService.findEmp(dto);
        }else{
            throw new RuntimeException("Invalid parameter");
        }

        return list;
    }

}
