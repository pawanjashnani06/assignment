package com.info.assignment.repository;

import com.info.assignment.pojo.Config;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AllocationDao extends CrudRepository<Config, String> {

    Config findByIpAddress(String ipAddress);
}
