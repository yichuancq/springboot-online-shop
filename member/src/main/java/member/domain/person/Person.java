package member.domain.person;

import member.domain.base.BaseEntity;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

public abstract class Person extends BaseEntity {
    //name
    private String name;
    //年龄
    private Integer age;
    //电话
    private String phoneNumber;
    //性别
    @Enumerated(EnumType.STRING)
    private SexEnum sexEnum;
    //所在区域
    private String area;
    // 用户状态
    private Integer state;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public SexEnum getSexEnum() {
        return sexEnum;
    }

    public void setSexEnum(SexEnum sexEnum) {
        this.sexEnum = sexEnum;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}
