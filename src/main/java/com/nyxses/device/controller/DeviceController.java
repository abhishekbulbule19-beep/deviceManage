package com.nyxses.device.controller;

import com.nyxses.device.dto.DeviceDTO;
import com.nyxses.device.service.DeviceService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    public ResponseEntity<DeviceDTO> createDevice(@RequestBody DeviceDTO deviceDTO){
        DeviceDTO createdDevice = deviceService.createDevice(deviceDTO);
        return new ResponseEntity<>(createdDevice, HttpStatus.CREATED);
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
