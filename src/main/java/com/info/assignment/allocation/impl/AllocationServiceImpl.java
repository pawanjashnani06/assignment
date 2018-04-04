package com.info.assignment.allocation.impl;

import com.info.assignment.allocation.AllocationService;
import com.info.assignment.pojo.Config;
import com.info.assignment.repository.AllocationDao;
import com.info.assignment.util.Utility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class AllocationServiceImpl implements AllocationService {

    @Autowired
    private AllocationDao allocationDao;

    @Autowired
    private Utility utility;

    @Override
    public String allocate(String macAddress) {
        String ipAddress = utility.getRandomHexString();
        System.out.println(ipAddress);
        Config config = new Config(macAddress, ipAddress, new Date(System.currentTimeMillis()));
        return allocationDao.save(config).getIpAddress();
    }
}
