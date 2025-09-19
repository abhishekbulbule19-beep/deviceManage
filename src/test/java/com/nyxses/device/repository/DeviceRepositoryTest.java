package com.nyxses.device.repository;

import com.nyxses.device.entity.Device;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class DeviceRepositoryTest {

    @Autowired
    private DeviceRepository deviceRepository;

    private Device device;

    @BeforeEach
    void setUp() {
//        insert row in devices table
        device = new Device();
        device.setNumber(1003L);
        device.setDescription("Test Device for QA 3 updated descriptions");
        device.setLastupdate(LocalDateTime.parse("2025-09-12T10:30:00"));
        device.setConfigurationId(5L);
        device.setOldConfigurationId(0L);
        device.setInfo("Test device registered for API validation");
        device.setImei("3598761234567567");
        device.setPhone("+918660460008");
        device.setCustomerId(103L);
        device.setImeiupdates("2025-09-12T10:30:00");
        device.setCustom1("Location: QA Lab America");
        device.setCustom2("OS: Android 10");
        device.setCustom3("Batch: TestRun_010 updated");
        device.setOldnumber("1002");
        device.setFastsearch("TESTDEVICE03");
        device.setEnrolltime(LocalDateTime.parse("2025-09-12T10:32:00"));
        device.setInfojson("{\"osVersion\":\"14\",\"model\":\"Pixel 8\"}");
        device.setPublicip("203.0.113.32");
        deviceRepository.save(device);
    }

    @AfterEach
    void tearDown() {
//        delete row from devices table
        deviceRepository.delete(device);
    }

    @Test
    void findByPhone() {
        Device foundDevice = deviceRepository.findByPhone("+918660460008").orElse(null);
        assertNotNull(foundDevice);
        assertEquals(device.getPhone(), foundDevice.getPhone());
    }
}