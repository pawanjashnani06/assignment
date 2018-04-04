package com.info.assignment.heartbeat;

public interface HeartbeatService {

    boolean refresh(String macAddress, String allocatedIPAddr);

}
