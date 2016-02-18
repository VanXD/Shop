package com.github.vanxd.repository;

import com.github.vanxd.entity.UserTest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Administrator on 2016/2/18.
 */
@Transactional
public interface UserTestRepository extends JpaRepository<UserTest, Long> {
}
