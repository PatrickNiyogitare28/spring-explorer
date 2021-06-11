package com.org.school_rest.repositories;

import com.org.school_rest.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student,Long> {
    // Querry By HQL
    @Query(value = "select stb from Student stb where stb.firstName=:firstNameParam and stb.lastName=:lastNameParam")
    List<Student> findFirstNameAndLastNameHql(@Param("firstNameParam")String firstName,@Param("lastNameParam") String lastName);

    // Querry By SQL
    @Query(value = "select * from students stb where stb.first_name=:firstNameParam and stb.last_name=:lastNameParam", nativeQuery = true)
    List<Student> findByFirstNameAndLastNameSql(@Param("firstNameParam")String firstName,@Param("lastNameParam")String lastName);
}
