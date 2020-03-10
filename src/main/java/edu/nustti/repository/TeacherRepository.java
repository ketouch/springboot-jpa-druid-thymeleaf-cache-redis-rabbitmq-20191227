package edu.nustti.repository;

import edu.nustti.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 * @author LenmonCCC
 * @description
 * @create 2019/12/27  19:24
 */
@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Integer> {
}
