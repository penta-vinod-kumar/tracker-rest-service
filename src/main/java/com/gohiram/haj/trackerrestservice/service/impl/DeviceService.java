package com.gohiram.haj.trackerrestservice.service.impl;

import com.gohiram.haj.trackerrestservice.dao.DeviceRepository;
import com.gohiram.haj.trackerrestservice.exception.TrackerException;
import com.gohiram.haj.trackerrestservice.model.Device;
import com.gohiram.haj.trackerrestservice.service.IDeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeviceService implements IDeviceService {

    @Autowired
    private DeviceRepository deviceRepository;

    @Override
    public boolean saveDevice(String id, long userId) throws TrackerException{
        return deviceRepository.save(new Device(id,userId))!=null;
    }

    @Override
    public List<Device> getDevicesByUser(long userId) throws TrackerException {
        return deviceRepository.findAllByUserId(userId);
    }
}
