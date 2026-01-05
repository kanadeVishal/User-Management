package userinformation.userinformation.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import userinformation.userinformation.entity.User;
import userinformation.userinformation.service.UserService;

import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/fetch")
    public List<User> getUsers() {
        return userService.listAll();
    }

    @PostMapping("/save")
    public User saveUser(@Valid @RequestBody User user) {
        return userService.CreateUser(user);
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable int id) {
        return userService.getUser(id);

    }

    @PutMapping("/update/{id}")
    public User updateUser(@PathVariable int id, @RequestBody User user) {
        return userService.updateUser(id, user);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteUer(@PathVariable int id) {
        userService.deleteUser(id);
    }

    @DeleteMapping("/deleteAllUser")
    public void deleteAllUer() {
        userService.deleteAllUser();
    }

    //API to get hello deme time with harini
    @GetMapping("/hello")
    public String getHelloPrintMessage() {
        return "Hello";
    }
    //APi to calculate sum of two number
    @PutMapping("/sumOfTwoNumber")
    public int sumOfTwoNumber(@RequestBody int[] values) {
        int sum = 0;
        for (int value : values) {
            sum += value;
        }
        return sum;
    }
    //API is used to update the user details
    @PutMapping("/update/user/{id}")
    public ResponseEntity<String> updateUser(@RequestBody User user, @PathVariable int id){
        String output = userService.updateUserById(user, id);
        return new ResponseEntity<>(output, HttpStatus.ACCEPTED);
    }

    //Api is used to check the health of userinformation service health check
    @GetMapping("/health/check")
    public ResponseEntity<String> healthCheck(){
        return new ResponseEntity<>("User service is up", HttpStatus.OK);
    }

}
