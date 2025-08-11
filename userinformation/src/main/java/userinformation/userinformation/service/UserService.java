package userinformation.userinformation.service;

import org.hibernate.Length;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.JpaSort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import userinformation.userinformation.entity.User;
import userinformation.userinformation.repository.UsersRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UsersRepository userRepo;

    public List<User> listAll() {
        return this.userRepo.findAll(JpaSort.unsafe("LENGTH(firstName)"));
    }

    public User CreateUser(User user) {
        return userRepo.save(user);
    }

    public User getUser(int id) {
        return userRepo.getUser(id);
    }

    public User updateUser(int id, User user) {
        User oldUser = userRepo.findById(id).orElse(null);
        if (oldUser == null) {
            return null;
        }
        if (user.getFirstName() != null) {
            oldUser.setFirstName(user.getFirstName());
        }
        if (user.getLastName() != null) {
            oldUser.setLastName(user.getLastName());
        }
        if (user.getEmail() != null) {
            oldUser.setEmail(user.getEmail());
        }
        if (user.getCity() != null) {
            oldUser.setCity(user.getCity());
        }
        if (user.getPhoneNo() != null) {
            oldUser.setPhoneNo(user.getPhoneNo());
        }
        return userRepo.save(oldUser);
    }

    public void deleteUser(int id){
        userRepo.deleteById(id);
    }

    public void deleteAllUser() {
        userRepo.deleteAll();
    }

    public User addUser(User  user){
       return userRepo.save(user);
    }



    public String updateUserById(User user, int id){
        if(!userRepo.findById(id).isEmpty()) {
            userRepo.updateUserById(user.getPhoneNo(), user.getCity(), id);
            return "user updated successfully";
        } else {
            return "invalid User";
        }

    }
}
