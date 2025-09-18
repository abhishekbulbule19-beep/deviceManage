package com.nyxses.device.service;

import com.nyxses.device.dto.DeviceDTO;
import com.nyxses.device.entity.Device;
import com.nyxses.device.exception.DeviceNotFoundException;
import com.nyxses.device.mapper.DeviceMapper;
import com.nyxses.device.repository.DeviceRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class DeviceService {
    private static final Logger log = LoggerFactory.getLogger(DeviceService.class);
    private DeviceRepository deviceRepository;
    private DeviceMapper deviceMapper;

    public DeviceService(DeviceRepository deviceRepository, DeviceMapper deviceMapper){
        this.deviceRepository = deviceRepository;
        this.deviceMapper = deviceMapper;
    }
//    create device
    public DeviceDTO createDevice(DeviceDTO deviceDTO){
        Device device = deviceMapper.toDeviceEntity(deviceDTO);
        device = deviceRepository.save(device);
        return deviceMapper.toDeviceDTO(device);
    }


//    get all devices
    public List<DeviceDTO> getAllDevices(){
        return deviceRepository.findAll()
                .stream()
                .map(deviceMapper::toDeviceDTO)
                .toList();
    }


//    get devices by id
    public DeviceDTO getDeviceById(Long id){
        Device device = deviceRepository.findById(id)
                .orElseThrow(()->new DeviceNotFoundException("Device with id "+ id +" Not Found"));
        System.out.println("Fetched Device from DB: " + device);
        var deviceMap = deviceMapper.toDeviceDTO(device);
        log.info("device map info {}",deviceMap);
        return deviceMap;
    }

//    update devices
    public DeviceDTO updateDevice(Long id, DeviceDTO deviceDTO){
        Device device = deviceRepository.findById(id).orElseThrow(()->new DeviceNotFoundException("Device with id "+ id +" Not Found"));
        deviceMapper.updateDeviceFromDto(deviceDTO,device);
        deviceRepository.save(device);
        return deviceMapper.toDeviceDTO(device);
    }

//    delete devices
    public String deleteDevice(Long id){
        deviceRepository.findById(id).orElseThrow(()->new DeviceNotFoundException("Device with id "+ id +" Not Found"));
        deviceRepository.deleteById(id);
        return "Device deleted successfully";
    }
}
