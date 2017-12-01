package com.gohiram.haj.trackerrestservice.controller;

import com.gohiram.haj.trackerrestservice.exception.TrackerException;
import com.gohiram.haj.trackerrestservice.model.Friend;
import com.gohiram.haj.trackerrestservice.model.TrackerResponse;
import com.gohiram.haj.trackerrestservice.model.Users;
import com.gohiram.haj.trackerrestservice.service.impl.FriendsManagerService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("/friends")
public class FriendsManagerController {

    @Autowired
    private FriendsManagerService friendsManagerService;

    @ApiOperation(value = "Change status of friends request")
    @RequestMapping(path = "/accept/{id}/{friendId}/{status}", method = RequestMethod.POST, produces = {"application/json"})
    public ResponseEntity<TrackerResponse<Boolean>> acceptFriendRequest(@PathVariable long id, @PathVariable long friendId, @ApiParam(name = "status") @PathVariable String status) throws TrackerException {
        return new ResponseEntity<>(new TrackerResponse<Boolean>().setData(friendsManagerService.acceptFriendRequest(id, friendId, status)), HttpStatus.ACCEPTED);
    }

    @RequestMapping(path = "/send-friend-request/{id}/{friendMobileNumber}", method = RequestMethod.POST, produces = {"application/json"})
    public ResponseEntity<TrackerResponse<Boolean>> sendRequest(@PathVariable long id, @PathVariable long friendMobileNumber) throws TrackerException {
        return new ResponseEntity<>(new TrackerResponse<Boolean>().setData(friendsManagerService.sendRequest(id, friendMobileNumber)), HttpStatus.OK);
    }

    @RequestMapping(path = "/find-friends/{id}", method = RequestMethod.GET, produces = {"application/json"})
    public ResponseEntity<TrackerResponse<List<Friend>>> findAllFriends(@PathVariable long id) throws TrackerException {
        return new ResponseEntity<>(new TrackerResponse<List<Friend>>().setData(friendsManagerService.findAllFriends(id)), HttpStatus.OK);
    }

    @RequestMapping(path = "/find-friend/{id}/{friendId}", method = RequestMethod.GET, produces = {"application/json"})
    public ResponseEntity<TrackerResponse<Users>> findFriendById(@PathVariable long id, @PathVariable long friendId) throws TrackerException {
        return new ResponseEntity<>(new TrackerResponse<Users>().setData(friendsManagerService.findFriendById(id, friendId)), HttpStatus.OK);
    }

    @RequestMapping(path = "/find-friend/{id}/{friendId}", method = RequestMethod.DELETE, produces = {"application/json"})
    public ResponseEntity<TrackerResponse<Boolean>> deleteFriendById(@PathVariable long id, @PathVariable long friendId) throws TrackerException {
        return new ResponseEntity<>(new TrackerResponse<Boolean>().setData(friendsManagerService.deleteFriendById(id, friendId)), HttpStatus.OK);
    }
}
