package com.nyxses.device;

import com.nyxses.device.mapper.DeviceMapper;
import com.nyxses.device.repository.DeviceRepository;
import com.nyxses.device.service.DeviceService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class DeviceManageApplicationTests {

    @Autowired
    private DeviceService deviceService;

    @Autowired
    private DeviceRepository deviceRepository;

    @Autowired
    private DeviceMapper deviceMapper;


	@Test
	void contextLoads() {
//        assert that important beans are loaded
        assertThat(deviceService).isNotNull();
        assertThat(deviceRepository).isNotNull();
        assertThat(deviceMapper).isNotNull();

	}

}
