package org.domain.service.impl;

/**
 * Created by root on 3/20/19.
 */

import org.domain.dto.DeptDto;
import org.domain.model.Dept;
import org.domain.repository.DeptRepository;
import org.domain.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptRepository deptRepository;

    @Override
    public void save(DeptDto dto){
        List<Dept> old = deptRepository.findByName(dto.getDeptName());
        if(old.isEmpty()){
            Dept dept = new Dept(dto);
            deptRepository.save(dept);
        }else{
            throw new RuntimeException("This dept already exist.");
        }
    }

    @Override
    public void update(DeptDto dto){
        List<Dept> old = deptRepository.findByName(dto.getDeptOldName());

        if(old.isEmpty()){
            throw new RuntimeException("Can not find this dept.");
        }else{
            List<Dept> newDept = deptRepository.findByName(dto.getDeptName());

            if(newDept.isEmpty()){
                Dept dept = new Dept(dto);
                deptRepository.save(dept);
            }else{
                throw new RuntimeException("This dept already exist.");
            }
        }
    }

    @Override
    public void delete(long deptID) {
        Dept dept = deptRepository.findOne(deptID);
        if(dept != null){
            deptRepository.delete(deptID);
        }else{
            throw new RuntimeException("Can not find this dept.");
        }
    }
}
