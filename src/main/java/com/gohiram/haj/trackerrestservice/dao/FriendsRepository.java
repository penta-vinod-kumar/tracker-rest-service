package com.gohiram.haj.trackerrestservice.dao;

import com.gohiram.haj.trackerrestservice.dao.model.Friend;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public interface FriendsRepository extends JpaRepository<Friend, Long> {

    List<Friend> findAllByMyId(long myId);

    Friend findByMyIdAndFriendId(long myId, long friendId);

    boolean deleteByMyIdAndFriendId(long myId, long friendId);

	/*@Modifying
    @Query("update Friends friend set friend.status=:status where friend.id=:id and friend.friendId=:friendId")
	public int updateFriendRequest(@Param("status") String status,@Param("id") long id,@Param("friendId") long friendId);
	*/
    //@Query("select count(friend.id) from Friends friend where friend.id=:id and friend.friendId=:friendId")
    //public int isFriendAlready(@Param("id") long id, @Param("friendId") long friendId);

	/*@Query("select friend from Friends friend where friend.id=:id")
    public List<Friend> findAllFriends(@Param("id") long id);*/
}
