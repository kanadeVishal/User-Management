package userinformation.userinformation.repository;

import jakarta.persistence.GeneratedValue;
import jakarta.transaction.Transactional;
import jdk.jfr.Percentage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import userinformation.userinformation.entity.User;

@Repository
public interface UsersRepository extends JpaRepository<User, Integer> {
    public static final String userDetails = "select * from users where id=:id";

    @Query(value = userDetails, nativeQuery = true)
    public User getUser(@Param("id") int id);

    @Transactional
    @Modifying
    @Query(value = "update users set phone_no=:phoneNo, city=:city where id=:id", nativeQuery = true)
    public void updateUserById(@Param("phoneNo") String phoneNo, @Param("city") String city, @Param("id") int id);



}
