package com.deviceManage.deviceManage.service;

import com.deviceManage.deviceManage.dto.DeviceDTO;
import com.deviceManage.deviceManage.entity.Device;
import com.deviceManage.deviceManage.exception.DeviceNotFoundException;
import com.deviceManage.deviceManage.mapper.DeviceMapper;
import com.deviceManage.deviceManage.repository.DeviceRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class DeviceService {
    private DeviceRepository deviceRepository;
//    create device
    public DeviceDTO createDevice(DeviceDTO deviceDTO){
//        Optional<Device> optionalDevice =  deviceRepository.findByPhone(deviceDTO.getPhone());
//        if(optionalDevice.isPresent()){
//            throw new DeviceException("Phone Number "+ deviceDTO.getPhone() +" is already present");
//        }
        Device device = DeviceMapper.toDeviceEntity(deviceDTO);
        device = deviceRepository.save(device);
        return DeviceMapper.toDeviceDTO(device);
    }
//    get all devices
    public List<DeviceDTO> getAllDevices(){
        return deviceRepository.findAll().stream().map(DeviceMapper::toDeviceDTO).toList();
    }
//    get devices by id
    public DeviceDTO getDeviceById(Long id){
        Device device = deviceRepository.findById(id).orElseThrow(()->new DeviceNotFoundException("Device with id "+ id +" Not Found"));
        return DeviceMapper.toDeviceDTO(device);
    }

//    update devices
    public DeviceDTO updateDevice(Long id, DeviceDTO deviceDTO){
        Device device = deviceRepository.findById(id).orElseThrow(()->new DeviceNotFoundException("Device with id "+ id +" Not Found"));
        device.setNumber(deviceDTO.getNumber());
        device.setDescription(deviceDTO.getDescription());
        device.setLastupdate(deviceDTO.getLastupdate());
        device.setConfigurationid(deviceDTO.getConfigurationid());
        device.setOldconfigurationid(deviceDTO.getOldconfigurationid());
        device.setInfo(deviceDTO.getInfo());
        device.setImei(deviceDTO.getImei());
        device.setPhone(deviceDTO.getPhone());
        device.setCustomerid(deviceDTO.getCustomerid());
        device.setImeiupdates(deviceDTO.getImeiupdates());
        device.setCustom1(deviceDTO.getCustom1());
        device.setCustom2(deviceDTO.getCustom2());
        device.setCustom3(deviceDTO.getCustom3());
        device.setOldnumber(deviceDTO.getOldnumber());
        device.setFastsearch(deviceDTO.getFastsearch());
        device.setEnrolltime(deviceDTO.getEnrolltime());
        device.setInfojson(deviceDTO.getInfojson());
        device.setPublicip(deviceDTO.getPublicip());
        deviceRepository.save(device);
        return DeviceMapper.toDeviceDTO(device);
    }

//    delete devices
    public String deleteDevice(Long id){
        deviceRepository.findById(id).orElseThrow(()->new DeviceNotFoundException("Device with id "+ id +" Not Found"));
        deviceRepository.deleteById(id);
        return "Device deleted successfully";
    }
}
