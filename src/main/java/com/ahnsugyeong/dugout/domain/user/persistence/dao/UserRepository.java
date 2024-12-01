package com.ahnsugyeong.dugout.domain.user.persistence.dao;

import com.ahnsugyeong.dugout.domain.user.persistence.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
