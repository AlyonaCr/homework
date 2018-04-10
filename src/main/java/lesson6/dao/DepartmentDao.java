package lesson6.dao;


import lesson6.domain.Department;

import java.sql.Connection;
import java.util.Collection;

public interface DepartmentDao {


    Department create(int id, String name, String city);

    Department update(int id, String name, String city);

    void delete(int id);

    Collection <Department> findAll();

    Department findById(int id);



}
