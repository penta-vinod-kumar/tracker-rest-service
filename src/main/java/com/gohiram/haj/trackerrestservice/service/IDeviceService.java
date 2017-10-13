package com.gohiram.haj.trackerrestservice.service;

import com.gohiram.haj.trackerrestservice.exception.TrackerException;
import com.gohiram.haj.trackerrestservice.model.Device;

import java.util.List;

public interface IDeviceService {

    public boolean saveDevice(String id, long userId) throws TrackerException;

    public List<Device> getDevicesByUser(long userId) throws TrackerException;
}
