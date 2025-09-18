package com.nyxses.device.service;

import com.nyxses.device.dto.DeviceDTO;
import com.nyxses.device.entity.Device;
import com.nyxses.device.mapper.DeviceMapper;
import com.nyxses.device.repository.DeviceRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mapstruct.factory.Mappers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
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

//    use real MapStruct implementation
    @Spy
    private DeviceMapper deviceMapper = Mappers.getMapper(DeviceMapper.class);

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
        System.out.println(device);

        deviceDTO = new DeviceDTO();
        deviceDTO.setId(device.getId());
        deviceDTO.setNumber(device.getNumber());  // <-- now you can access this
        deviceDTO.setDescription(device.getDescription());
        deviceDTO.setLastupdate(device.getLastupdate());
        deviceDTO.setConfigurationid(device.getConfigurationid());
        deviceDTO.setOldconfigurationid(device.getOldconfigurationid());
        deviceDTO.setInfo(device.getInfo());
        deviceDTO.setImei(device.getImei());
        deviceDTO.setPhone(device.getPhone());
        deviceDTO.setCustomerid(device.getCustomerid());
        deviceDTO.setImeiupdates(device.getImeiupdates());
        deviceDTO.setCustom1(device.getCustom1());
        deviceDTO.setCustom2(device.getCustom2());
        deviceDTO.setCustom3(device.getCustom3());
        deviceDTO.setOldnumber(device.getOldnumber());
        deviceDTO.setFastsearch(device.getFastsearch());
        deviceDTO.setEnrolltime(device.getEnrolltime());
        deviceDTO.setInfojson(device.getInfojson());
        deviceDTO.setPublicip(device.getPublicip());

    }

    @AfterEach
    void tearDown() {
        reset(deviceRepository);
    }

    @Test
    void createDevice() {
        System.out.println("device entity " + device);
        when(deviceRepository.save(any(Device.class))).thenReturn(device);
        DeviceDTO savedDevice = deviceService.createDevice(deviceDTO);
        System.out.println("creted data "+savedDevice);
        System.out.println("DTO data "+deviceDTO);
        assertNotNull(savedDevice);
        assertEquals(deviceDTO.getNumber(), savedDevice.getNumber());
        verify(deviceRepository, times(1)).save(any(Device.class));
    }

    @Test
    void getAllDevices_returnsDummyData() {
        when(deviceRepository.findAll()).thenReturn(Collections.singletonList(device));
        var allDevices = deviceService.getAllDevices();
        System.out.println("get all device "+ allDevices);
        assertNotNull(allDevices,"Device Should not be null");
        assertEquals(1,allDevices.size(),"Device list size should be 1");
        assertEquals(device.getNumber(),allDevices.get(0).getNumber(),"Number should match");

        verify(deviceRepository, times(1)).findAll(); // verifies that findAll() was called once on mock

    }

    @Test
    void getDeviceById() {
        when(deviceRepository.findById(1L)).thenReturn(Optional.of(device));
        DeviceDTO fondDevice = deviceService.getDeviceById(1L);
        assertNotNull(fondDevice);
        assertEquals(device.getNumber(), fondDevice.getNumber());
        verify(deviceRepository, times(1)).findById(1L);

    }

    @Test
    void updateDevice() {
        when(deviceRepository.findById(1L)).thenReturn(Optional.of(device));
        when(deviceRepository.save(any(Device.class))).thenReturn(device);

        DeviceDTO updateDevice = deviceService.updateDevice(1L,deviceDTO);

        assertNotNull(updateDevice);
        assertEquals(device.getNumber(),updateDevice.getNumber());
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