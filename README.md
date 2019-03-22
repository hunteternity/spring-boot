# spring-boot

POST : /dept/add 
ex:
  {
	  "deptName" : "dept1"
  }


PUT : /dept/update
ex:
  {
	  "deptName" : "dept2",
	  "deptOldName" : "dept1"
  }
  
  
DELETE : /dept/remove/{deptID}
ex:
  /dept/remove/1
  
----------------------------------

POST : /emp/add
ex:
  {
	  "empName" : "Jamari",
	  "deptID" : "1",
	  "gender" : "male",
	  "empPhone" : "16138",
	  "address" : "BU9",
	  "age" : 30
  }
  
  
PUT : /emp/update
ex:
  {
	  "empName" : "Jamari1,
	  "deptID" : "2",
	  "gender" : "male",
	  "empPhone" : "16138",
	  "address" : "BU10,
	  "age" : 30
  }


DELETE : /emp/remove/{empID}
ex:
  /emp/remove/2
  

POST : /emp/find
ex:
  {
	  "empName" : "Jamari",
	  "page" : 1,
	  "size" : 10
  }

