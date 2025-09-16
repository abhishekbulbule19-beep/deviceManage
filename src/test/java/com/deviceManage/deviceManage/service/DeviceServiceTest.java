package com.deviceManage.deviceManage.service;

import com.deviceManage.deviceManage.dto.DeviceDTO;
import com.deviceManage.deviceManage.entity.Device;
import com.deviceManage.deviceManage.repository.DeviceRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
class DeviceServiceTest {
    @Mock
    private DeviceRepository deviceRepository;

    @InjectMocks
    private DeviceService deviceService;

    private Device device;
    private DeviceDTO deviceDTO;


    @BeforeEach
    void setUp() {
        device = new Device();
        device.setId(1L);
        device.setNumber(1003L);
        device.setDescription("Test Device for QA 3 updated descriptions");
        device.setLastupdate(LocalDateTime.parse("2025-09-12T10:30:00"));
        device.setConfigurationid(5L);
        device.setOldconfigurationid(0L);
        device.setInfo("Test device registered for API validation");
        device.setImei("3598761234567567");
        device.setPhone("+918660460008");
        device.setCustomerid(103L);
        device.setImeiupdates("2025-09-12T10:30:00");
        device.setCustom1("Location: QA Lab America");
        device.setCustom2("OS: Android 10");
        device.setCustom3("Batch: TestRun_010 updated");
        device.setOldnumber("1002");
        device.setFastsearch("TESTDEVICE03");
        device.setEnrolltime(LocalDateTime.parse("2025-09-12T10:32:00"));
        device.setInfojson("{\"osVersion\":\"14\",\"model\":\"Pixel 8\"}");
        device.setPublicip("203.0.113.32");

        deviceDTO = new DeviceDTO();
        deviceDTO.setId(1L);
        deviceDTO.setNumber(1003L);
        deviceDTO.setDescription("Test Device for QA 3 updated descriptions");
        deviceDTO.setLastupdate(LocalDateTime.parse("2025-09-12T10:30:00"));
        deviceDTO.setConfigurationid(5L);
        deviceDTO.setOldconfigurationid(0L);
        deviceDTO.setInfo("Test deviceDTO registered for API validation");
        deviceDTO.setImei("3598761234567567");
        deviceDTO.setPhone("+918660460008");
        deviceDTO.setCustomerid(103L);
        deviceDTO.setImeiupdates("2025-09-12T10:30:00");
        deviceDTO.setCustom1("Location: QA Lab America");
        deviceDTO.setCustom2("OS: Android 10");
        deviceDTO.setCustom3("Batch: TestRun_010 updated");
        deviceDTO.setOldnumber("1002");
        deviceDTO.setFastsearch("TESTDEVICE03");
        deviceDTO.setEnrolltime(LocalDateTime.parse("2025-09-12T10:32:00"));
        deviceDTO.setInfojson("{\"osVersion\":\"14\",\"model\":\"Pixel 8\"}");
        deviceDTO.setPublicip("203.0.113.32");

    }

    @AfterEach
    void tearDown() {
        reset(deviceRepository);
    }

    @Test
    void createDevice() {
        when(deviceRepository.save(any(Device.class))).thenReturn(device);
        DeviceDTO savedDevice = deviceService.createDevice(deviceDTO);
        assertNotNull(savedDevice);
        assertEquals(deviceDTO.getPhone(), savedDevice.getPhone());
    }

    @Test
    void getAllDevices() {
        when(deviceRepository.findAll()).thenReturn(Collections.singletonList(device));
        var allDevices = deviceService.getAllDevices();
        assertNotNull(allDevices);
        assertEquals(1,allDevices.size());
        assertEquals(device.getPhone(),allDevices.get(0).getPhone());
        verify(deviceRepository, times(1)).findAll(); // verifies that findAll() was called once on mock

    }

    @Test
    void getDeviceById() {
        when(deviceRepository.findById(1L)).thenReturn(Optional.of(device));
        DeviceDTO fondDevice = deviceService.getDeviceById(1L);
        assertNotNull(fondDevice);
        assertEquals(device.getPhone(), fondDevice.getPhone());
        verify(deviceRepository, times(1)).findById(1L);

    }

    @Test
    void updateDevice() {
        when(deviceRepository.findById(1L)).thenReturn(Optional.of(device));
        when(deviceRepository.save(any(Device.class))).thenReturn(device);

        DeviceDTO updateDevice = deviceService.updateDevice(1L,deviceDTO);

        assertNotNull(updateDevice);
        assertEquals(device.getPhone(),updateDevice.getPhone());
        verify(deviceRepository, times(1)).findById(1L);
        verify(deviceRepository,times(1)).save(any(Device.class));
    }

    @Test
    void deleteDevice() {
        when(deviceRepository.findById(1L)).thenReturn(Optional.of(device));
        doNothing().when(deviceRepository).deleteById(1L);

        deviceService.deleteDevice(1L);

        verify(deviceRepository, times(1)).findById(1L);
        verify(deviceRepository,times(1)).deleteById(1L);
    }
}