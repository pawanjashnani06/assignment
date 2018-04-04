package com.info.assignment.heartbeat.impl;

import com.info.assignment.heartbeat.HeartbeatService;
import com.info.assignment.pojo.Config;
import com.info.assignment.repository.AllocationDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class HeartbeatServiceImpl implements HeartbeatService {

    @Value("${expired.time}")
    private long expiredTime;

    @Autowired
    private AllocationDao allocationDao;

    @Override
    public boolean refresh(String macAddress, String allocatedIPAddr) {
        final Config config = allocationDao.findOne(macAddress);
        if (null == config) {
            return true;
        } else if (null != config) {
            long currentTimestamp = System.currentTimeMillis();
            long creationTimestamp = config.getCreatedDate().getTime();
            if (currentTimestamp - creationTimestamp > expiredTime) {
                return true;
            }
        }
        return false;
    }

}
