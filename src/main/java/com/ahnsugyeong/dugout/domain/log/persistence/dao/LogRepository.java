package com.ahnsugyeong.dugout.domain.log.persistence.dao;

import com.ahnsugyeong.dugout.domain.log.persistence.entity.Log;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogRepository extends JpaRepository<Log, Long> {
}
