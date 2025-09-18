package com.nyxses.device.mapper;

import com.nyxses.device.dto.DeviceDTO;
import com.nyxses.device.entity.Device;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface DeviceMapper {
    DeviceDTO toDeviceDTO(Device device);

    @Mapping(target = "id", ignore = true)
    void updateDeviceFromDto(DeviceDTO dto, @MappingTarget Device entity);

    Device toDeviceEntity(DeviceDTO deviceDTO);






}
