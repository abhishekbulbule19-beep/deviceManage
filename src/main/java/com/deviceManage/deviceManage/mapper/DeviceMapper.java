package com.deviceManage.deviceManage.mapper;

import com.deviceManage.deviceManage.dto.DeviceDTO;
import com.deviceManage.deviceManage.entity.Device;

public class DeviceMapper {

//    entity to dto
    public static DeviceDTO toDeviceDTO(Device device){
        if(device == null){
            return null;
        }
        DeviceDTO deviceDTO = new DeviceDTO();
        deviceDTO.setId(device.getId());
        deviceDTO.setNumber(device.getNumber());
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
        return deviceDTO;

    }

//    dto to entity
    public static Device toDeviceEntity(DeviceDTO deviceDTO){
        Device device = new Device();
        device.setId(deviceDTO.getId());
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
        return device;

    }
}
