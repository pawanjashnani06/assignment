package com.info.assignment.heartbeat;

import com.info.assignment.allocation.AllocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HeartbeatThread {

    @Autowired
    private HeartbeatService heartbeatService;

    @Autowired
    private AllocationService allocationService;

    public void run(String macAddress) {
        try {
            while (true) {
                System.out.println("running thread");
                if (heartbeatService.refresh(macAddress, null)) {
                    System.out.println("allot IP");
                    allocationService.allocate(macAddress);
                }
                Thread.sleep(1 * 1000);
            }
        } catch (InterruptedException e) {
        }

    }
}
