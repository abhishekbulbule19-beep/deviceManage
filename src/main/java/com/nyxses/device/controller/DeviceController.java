package com.nyxses.device.controller;

import com.nyxses.device.dto.DeviceDTO;
import com.nyxses.device.service.DeviceService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(
        name="Device REST API CURD Operation",
        description = "CREATE, READ, UPDATE, and DELETE Operations for Device REST API"
)
@RestController
@RequestMapping("/private/devices")
@AllArgsConstructor
public class DeviceController {
    private DeviceService deviceService;

    //    get all devices
    @ApiResponse(
            responseCode = "201",
            description = "CREATED"

    )
    @PostMapping
    @Operation(
            summary = "Create device",
            description = "REST API to create Device"
    )
    public ResponseEntity<DeviceDTO> createDevice(@RequestBody DeviceDTO deviceDTO){
        DeviceDTO createdDevice = deviceService.createDevice(deviceDTO);
        return new ResponseEntity<>(createdDevice, HttpStatus.CREATED);
    }

    @Operation(
            summary = "Fetch all devices",
            description = "REST API to fetch all Devices"
    )
    @GetMapping
    public List<DeviceDTO> getAllDevices(){
        return deviceService.getAllDevices();
    }
    //    create devices

//    get single device
    @Operation(
            summary = "Fetch device by id",
            description = "REST API to fetch Device by id"
    )
    @GetMapping("/{id}")
    public DeviceDTO getDeviceById(@PathVariable Long id){
        return deviceService.getDeviceById(id);
    }

//    update device
    @Operation(
            summary = "update device by id",
            description = "REST API to update Device by id"
    )
    @PutMapping("/{id}")
    public DeviceDTO updateDevice(@PathVariable Long id, @RequestBody DeviceDTO deviceDTO){
            return deviceService.updateDevice(id, deviceDTO);
    }

//    delete device
    @Operation(
            summary = "Delete device by id",
            description = "REST API to delete Device by id"
    )
    @DeleteMapping("/{id}")
    public String deleteDevice(@PathVariable  Long id){
        return deviceService.deleteDevice(id);
    }



}
