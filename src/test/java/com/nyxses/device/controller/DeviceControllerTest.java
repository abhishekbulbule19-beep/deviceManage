package com.nyxses.device.controller;

import com.nyxses.device.dto.DeviceDTO;
import com.nyxses.device.entity.Device;
import com.nyxses.device.mapper.DeviceMapper;
import com.nyxses.device.service.DeviceService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mapstruct.factory.Mappers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.time.LocalDateTime;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
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

    private DeviceMapper deviceMapper = Mappers.getMapper(DeviceMapper.class);

    private MockMvc mockMvc;
    private DeviceDTO deviceDTO;
    private Device device;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(deviceController).build();

        //        Initialize a Device Entity
        device = new Device();
        device.setId(1L);
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

    //  Map Device to DeviceDTO
        deviceDTO  = deviceMapper.toDeviceDTO(device);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getAllDevices() throws Exception {
        deviceDTO.setNumber(123L);
        List<DeviceDTO> deviceList = List.of(deviceDTO);
        when(deviceService.getAllDevices()).thenReturn(deviceList);
        mockMvc.perform(get("/private/devices"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()", is(deviceList.size())))
                .andExpect(jsonPath("$[0].number", is(deviceDTO.getNumber().intValue())));

    }

    @Test
    void createDevice()  throws Exception{
        when(deviceService.createDevice(any(DeviceDTO.class))).thenReturn(deviceDTO);
        String deviceJson = "{\n" +
                "  \"id\": 1,\n" +
                "  \"number\": 1003,\n" +
                "  \"description\": \"Test Device for QA 3\",\n" +
                "  \"lastupdate\": \"2025-09-12T10:30:00\",\n" +
                "  \"configurationid\": 5,\n" +
                "  \"oldconfigurationid\": 0,\n" +
                "  \"info\": \"Test device registered for API validation\",\n" +
                "  \"imei\": \"3598761234567567\",\n" +
                "  \"phone\": \"+918660460008\",\n" +
                "  \"customerid\": 103,\n" +
                "  \"imeiupdates\": \"2025-09-12T10:30:00\",\n" +
                "  \"custom1\": \"Location: QA Lab America\",\n" +
                "  \"custom2\": \"OS: Android 10\",\n" +
                "  \"custom3\": \"Batch: TestRun_010 updated\",\n" +
                "  \"oldnumber\": \"1002\",\n" +
                "  \"fastsearch\": \"TESTDEVICE03\",\n" +
                "  \"enrolltime\": \"2025-09-12T10:32:00\",\n" +
                "  \"infojson\": \"{\\\"osVersion\\\":\\\"14\\\",\\\"model\\\":\\\"Pixel 8\\\"}\",\n" +
                "  \"publicip\": \"203.0.113.32\"\n" +
                "}";

        mockMvc.perform(post("/private/devices")
                .contentType(MediaType.APPLICATION_JSON)
                .content(deviceJson))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.number").value(deviceDTO.getNumber()));

    }

    @Test
    void getDeviceById() throws Exception {
        when(deviceService.getDeviceById(1L)).thenReturn(deviceDTO);
        mockMvc.perform(get("/private/devices/{id}",1L))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(deviceDTO.getId()))
                .andExpect(jsonPath("$.number").value(deviceDTO.getNumber()));
    }

    @Test
    void updateDevice()  throws  Exception{
        when(deviceService.updateDevice((any(Long.class)), any(DeviceDTO.class))).thenReturn(deviceDTO);

        String deviceJson = "{ \"number\": 1005, \"description\": \"Test Device for QA 3 Updated Device\" }";
        mockMvc.perform(put("/private/devices/{id}",1L)
                .contentType(MediaType.APPLICATION_JSON)
                .content(deviceJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.number").value(deviceDTO.getNumber()))
                .andExpect(jsonPath("$.description").value(deviceDTO.getDescription()));

    }

    @Test
    void deleteDevice() throws Exception {
        mockMvc.perform(delete("/private/devices/{id}",1L))
                .andExpect(status().isOk());
    }
}