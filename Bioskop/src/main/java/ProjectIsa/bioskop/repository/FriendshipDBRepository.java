package ProjectIsa.bioskop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ProjectIsa.bioskop.domain.Friendship;
import ProjectIsa.bioskop.domain.FriendshipPrimKey;
import ProjectIsa.bioskop.domain.User;


public interface FriendshipDBRepository extends JpaRepository<Friendship, FriendshipPrimKey> {
	@Override
	@SuppressWarnings("unchecked")
	Friendship save(Friendship friendship);
	@Override
	List<Friendship> findAll();
	@Override
	void delete(Friendship friendship);
	//boolean existsByPrimKey(FriendshipPrimKey primaryKey);
	Friendship findByPrimKey(FriendshipPrimKey primaryKey);
	
	
	@Query(value = "SELECT * FROM friendship WHERE (userID1 = ?1 OR userID2 = ?1) AND status = 0", nativeQuery = true)
	List<Friendship> nadjiPoKljucu(long userID);
	
	List<Friendship> findAllByPrimKey_UserID1OrPrimKey_UserID2(long userID, long userID2);
	
	@Query(value = "SELECT temp.* FROM "
						+ "(SELECT u.* FROM user u "
						+ "WHERE u.id = (SELECT f.userid2 FROM friendship f "
										+ "WHERE f.userid1 = ?1"
									+ ") "
						+ "OR u.id = (SELECT f.userid1 FROM friendship f "
										+ "WHERE f.userid2 = ?1"
									+ ")"
					+ ") temp",
				nativeQuery = true)
	List<User> getFriendsList(long userID);
	
	
}
