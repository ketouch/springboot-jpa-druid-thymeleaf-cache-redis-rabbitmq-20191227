package edu.nustti.service;

import edu.nustti.entity.Teacher;
import edu.nustti.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author LenmonCCC
 * @description
 * @create 2019/12/27  19:30
 */
@Service
public class TeacherService {
    @Autowired
    TeacherRepository repository;

    /**
     *
     * Cacheable会在调用方法前先去检查缓存里有没有数据
     *
     */
    @Cacheable(cacheNames = "teacher")
    public Teacher findTeacher(Integer id) {
        return repository.findById(id).get();
    }

    /**
     *
     * CachePut先调用方法，调用完成后再放到缓存中
     */
    @CachePut(cacheNames = "teacher")
    public List<Teacher> findTeachers() {
        return repository.findAll();
    }

    /**
     * JPA中更新和添加都是save,区别在于是不是已经存在对应的主键
     * @param teacher
     */
    @CachePut(value = "teacher",key = "#teacher.id")
    public void updateTeacher(Teacher teacher){
        repository.save(teacher);
    }

    /**
     * CacheEvict用来清除缓存，默认是在方法执行之后，
     * 如果需要在方法执行之前清空缓存，加入beforeInvocation = true
     * @param teacher
     */
    @CacheEvict(value = "teacher"/*,beforeInvocation = true*/)
    public void deleteTeacher(Teacher teacher){
        repository.delete(teacher);
    }
}
