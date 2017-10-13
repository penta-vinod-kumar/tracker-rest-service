package com.gohiram.haj.trackerrestservice.controller;

import com.gohiram.haj.trackerrestservice.exception.TrackerException;
import com.gohiram.haj.trackerrestservice.model.Device;
import com.gohiram.haj.trackerrestservice.model.TrackerResponse;
import com.gohiram.haj.trackerrestservice.service.IDeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("/devices")
public class DeviceController {

    @Autowired
    private IDeviceService deviceService;

    @RequestMapping(path="/register/{userId}/{deviceId}",method = RequestMethod.GET, produces = {"application/json"})
    public ResponseEntity<TrackerResponse<Boolean>> addDevice(@PathVariable  String deviceId, @PathVariable long userId) throws TrackerException
    {
       return new ResponseEntity<>(new TrackerResponse<Boolean>().setData(deviceService.saveDevice(deviceId,userId)), HttpStatus.CREATED);
    }

    @RequestMapping(path="users/{userId}",method = RequestMethod.GET, produces = {"application/json"})
    public ResponseEntity<TrackerResponse<List<Device>>> getDevicesByUserId(@PathVariable long userId) throws TrackerException
    {
        return new ResponseEntity<>(new TrackerResponse<List<Device>>().setData(deviceService.getDevicesByUser(userId)), HttpStatus.CREATED);
    }

}
