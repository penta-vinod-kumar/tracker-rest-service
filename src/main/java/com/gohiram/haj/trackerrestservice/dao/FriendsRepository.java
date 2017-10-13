package com.gohiram.haj.trackerrestservice.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.gohiram.haj.trackerrestservice.model.Friend;

@Transactional
@Repository
public interface FriendsRepository extends JpaRepository<Friend,Long>{

	@Modifying
	@Query("update Friends friend set friend.status=:status where friend.id=:id and friend.friendId=:friendId")
	public int updateFriendRequest(@Param("status") String status,@Param("id") long id,@Param("friendId") long friendId);
	
	@Query("select count(friend.id) from Friends friend where friend.id=:id and friend.friendId=:friendId")
	public int isFriendAlready(@Param("id") long id, @Param("friendId") long friendId);
	
	@Query("select friend from Friends friend where friend.id=:id")
	public List<Friend> findAllFriends(@Param("id") long id);
}
