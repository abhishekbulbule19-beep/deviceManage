package com.deviceManage.deviceManage.controller;

import com.deviceManage.deviceManage.dto.DeviceDTO;
import com.deviceManage.deviceManage.service.DeviceService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.time.LocalDateTime;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
class DeviceControllerTest {

    @InjectMocks
    private DeviceController deviceController;

    @Mock
    private DeviceService deviceService;

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(deviceController).build();

    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getAllDevices() throws Exception {
        DeviceDTO deviceDTO = new DeviceDTO();
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
        List<DeviceDTO> deviceList = List.of(deviceDTO);
        when(deviceService.getAllDevices()).thenReturn(List.of(deviceDTO));
        mockMvc.perform(get("/private/devices"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()", is(deviceList.size())))
                .andExpect(jsonPath("$[0].number", is(deviceDTO.getNumber().intValue())));

    }

    @Test
    void createDevice() {
    }

    @Test
    void getDeviceById() {
    }

    @Test
    void updateDevice() {
    }

    @Test
    void deleteDevice() {
    }
}