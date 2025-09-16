package com.deviceManage.deviceManage.repository;

import com.deviceManage.deviceManage.entity.Device;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DeviceRepository extends JpaRepository<Device, Long> {
    Optional<Device> findByPhone(String devicePhone);

}
