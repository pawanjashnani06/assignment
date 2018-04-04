package com.info.assignment.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "Config")
public class Config {

    @Id
    private String macAddress;

    @Column
    private String ipAddress;

    @Column
    private Date createdDate;

    public Config() {
    }

    public Config(String macAddress, String ipAddress, Date createdDate) {
        this.macAddress = macAddress;
        this.ipAddress = ipAddress;
        this.createdDate = createdDate;
    }

    public String getMacAddress() {
        return macAddress;
    }

    public void setMacAddress(String macAddress) {
        this.macAddress = macAddress;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
}
