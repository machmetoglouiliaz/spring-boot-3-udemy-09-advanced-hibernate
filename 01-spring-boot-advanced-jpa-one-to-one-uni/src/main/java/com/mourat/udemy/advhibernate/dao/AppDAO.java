package com.mourat.udemy.advhibernate.dao;

import com.mourat.udemy.advhibernate.entity.Instructor;

public interface AppDAO {

    void save(Instructor instructor);

    Instructor findById(int id);

    void deleteById(int id);

}
