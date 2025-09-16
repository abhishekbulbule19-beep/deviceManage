package com.deviceManage.deviceManage.controller;

import com.deviceManage.deviceManage.dto.DeviceDTO;
import com.deviceManage.deviceManage.service.DeviceService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/private/devices")
@AllArgsConstructor
public class DeviceController {
    private DeviceService deviceService;

    //    get all devices
    @GetMapping
    public List<DeviceDTO> getAllDevices(){
        return deviceService.getAllDevices();
    }

    //    create devices
    @PostMapping
    public DeviceDTO createDevice(@RequestBody DeviceDTO deviceDTO){
        return deviceService.createDevice(deviceDTO);
    }

//    get single device
    @GetMapping("/{id}")
    public DeviceDTO getDeviceById(@PathVariable Long id){
        return deviceService.getDeviceById(id);
    }

//    update device
    @PutMapping("/{id}")
    public DeviceDTO updateDevice(@PathVariable Long id, @RequestBody DeviceDTO deviceDTO){
            return deviceService.updateDevice(id, deviceDTO);
    }

//    delete device
    @DeleteMapping("/{id}")
    public String deleteDevice(@PathVariable  Long id){
        return deviceService.deleteDevice(id);
    }



}
