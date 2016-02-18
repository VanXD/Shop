package com.github.vanxd.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Administrator on 2016/2/18.
 */
@Entity
@Table(name="user_test")
public class UserTest implements Serializable {
    @Id
    private Long id;
    private Integer num;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }
}
