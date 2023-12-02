package org.crazyit.app.domain;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "clazz_inf")

public class Clazz {
    @Id
    @Column(name = "clazz_code")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer code;
    private String name;

    // 班级与学生是一对多的关联
    @OneToMany(fetch = FetchType.LAZY, targetEntity = Student.class, mappedBy = "clazz")
    private Set<Student> students = new HashSet<>();

    public Clazz() {
    }

    public Clazz(String name) {
        this.name = name;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "Clazz{" +
                "code=" + code +
                ", name='" + name + '\'' +
                '}';
    }
}
