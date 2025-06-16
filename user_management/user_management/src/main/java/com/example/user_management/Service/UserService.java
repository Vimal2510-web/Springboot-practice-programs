package com.example.user_management.Service;

import java.util.List;

import com.example.user_management.DTO.UserDto;

public interface UserService {
	
	UserDto addUser (UserDto userDto); 
	
	UserDto getUser (Long id);
	
	List<UserDto> getAllUsers();
	
	UserDto updateUser (UserDto userDto , Long id);
	
	void deleteUser (Long id);

}
