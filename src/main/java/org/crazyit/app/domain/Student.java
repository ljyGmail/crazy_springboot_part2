package org.crazyit.app.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "student_inf")
// 定义命名查询，name必须为 Domain类.查询方法名
@NamedQuery(name = "Student.namedJpql",
        query = "select s from Student s where s.clazz.name like ?1 and s.gender = ?2")
@NamedNativeQuery(name = "Student.namedSql",
        query = "select s.* from student_inf s join clazz_inf c on s.clazz_code = c.clazz_code where c.name like ?1",
        resultClass = Student.class)

public class Student {
    @Id
    @Column(name = "student_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String address;
    private int age;
    private char gender;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Clazz.class)
    // 定义名为clazz_code的外键列，该外键列引用clazz_inf表的clazz_codee列
    @JoinColumn(name = "clazz_code", referencedColumnName = "clazz_code", nullable = true)
    private Clazz clazz;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public Clazz getClazz() {
        return clazz;
    }

    public void setClazz(Clazz clazz) {
        this.clazz = clazz;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                '}';
    }
}
