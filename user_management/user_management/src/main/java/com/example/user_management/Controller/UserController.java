package com.example.user_management.Controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.user_management.DTO.UserDto;
import com.example.user_management.Service.UserService;

@RestController
@RequestMapping("api/users")
public class UserController {
	
	public UserService userService;
	
	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}
	
    @PostMapping
	public ResponseEntity<UserDto> addUser (@RequestBody UserDto userDto){
		
		UserDto savedUser = userService.addUser(userDto);
		
		return new ResponseEntity<>(savedUser,HttpStatus.CREATED);
	}
    
    @GetMapping("{id}")
    public ResponseEntity<UserDto> getUser (@PathVariable("id")Long UserId){
    	
    	UserDto user = userService.getUser(UserId);
    	
    	return new ResponseEntity<UserDto>(user,HttpStatus.OK);
    }
    
    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUsers(){
    	
    	List<UserDto> user =userService.getAllUsers();
    	
    	return ResponseEntity.ok(user);
    }
    
    @PutMapping("{id}")
    public ResponseEntity<UserDto> updateUser(@RequestBody UserDto userDto, @PathVariable("id")Long id){
    	
    	UserDto user = userService.updateUser(userDto, id);
    	
    	return ResponseEntity.ok(user);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteUser(@PathVariable ("id")Long id){
    	
    	userService.deleteUser(id);
    	
    	return ResponseEntity.ok("User deleted sucessfully");
    }

}
