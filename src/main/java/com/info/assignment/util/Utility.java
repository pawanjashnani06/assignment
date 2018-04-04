package com.info.assignment.util;

import com.info.assignment.repository.AllocationDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class Utility {

    @Value("${ip.address.start}")
    private String ipAddressStart;

    @Value("${ip.address.end}")
    private String ipAddressEnd;

    @Autowired
    private AllocationDao allocationDao;

    public String getRandomHexString() {
        Random r = new Random();
        StringBuffer sb = new StringBuffer();
        String hexString;
        String startHexString = Long.toHexString(convertIPToHex(ipAddressStart));
        String endHexString = Long.toHexString(convertIPToHex(ipAddressEnd));
        while (sb.length() < 8) {
            hexString = Integer.toHexString(r.nextInt());
            if (startHexString.compareTo(hexString) < 0 && endHexString.compareTo(hexString) > 0) {
                sb.append(hexString);
            }
        }
        String randomIP = convertHextoIP(Long.valueOf(sb.toString(), 16));
        if (null == allocationDao.findByIpAddress(randomIP)) {
            return randomIP;
        }
        return getRandomHexString();
    }

    private String convertHextoIP(long hex) {
        StringBuilder sb = new StringBuilder(15);
        for (int i = 0; i < 4; i++) {
            sb.insert(0, Long.toString(hex & 0xff));
            if (i < 3) {
                sb.insert(0, '.');
            }
            hex >>= 8;
        }
        return sb.toString();
    }

    private long convertIPToHex(String ipAddress) {
        long result = 0;
        String[] atoms = ipAddress.split("\\.");
        for (int i = 3; i >= 0; i--) {
            result |= (Long.parseLong(atoms[3 - i]) << (i * 8));
        }
        return result & 0xFFFFFFFF;
    }

}
