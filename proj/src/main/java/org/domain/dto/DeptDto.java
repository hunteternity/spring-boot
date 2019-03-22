package org.domain.dto;

/**
 * Created by root on 3/20/19.
 */

public class DeptDto {

    private String deptName;
    private String deptOldName;

    public DeptDto() {
    }

    public DeptDto(String deptName) {
        this.deptName = deptName;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getDeptOldName() {
        return deptOldName;
    }

    public void setDeptOldName(String deptOldName) {
        this.deptOldName = deptOldName;
    }

    public boolean addValidate(DeptDto dept){
        boolean result = true;
        if(dept.getDeptName() == null || dept.getDeptName().isEmpty()){
            result = false;
        }
        return result;
    }

    public boolean updateValidate(DeptDto dept){
        boolean result = true;
        if(dept.getDeptName() == null || dept.getDeptOldName() == null || dept.getDeptName().isEmpty() || dept.getDeptOldName().isEmpty()){
            result = false;
        }
        return result;
    }
}
