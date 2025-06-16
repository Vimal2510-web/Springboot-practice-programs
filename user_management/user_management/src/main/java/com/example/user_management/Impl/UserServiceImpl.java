package com.example.user_management.Impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.user_management.DTO.UserDto;
import com.example.user_management.Entity.User;
import com.example.user_management.Exception.ResourceNotFoundException;
import com.example.user_management.Repository.UserRepository;
import com.example.user_management.Service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	public final UserRepository userRepository;
	public final ModelMapper modelMapper;
	
	public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper) {
		super();
		this.userRepository = userRepository;
		this.modelMapper = modelMapper;
	}
	
	public UserDto addUser (UserDto userDto) {
		
		User user = modelMapper.map(userDto,User.class);
		
		User savedUser = userRepository.save(user);
		
		UserDto savedUserDto = modelMapper.map(savedUser,UserDto.class);
		
		return savedUserDto;
	}

	@Override
	public UserDto getUser(Long id) {
		
		User user = userRepository.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException ("User not found with id : " + id));
		
		return modelMapper.map(user,UserDto.class);
		
	}
	
	public List<UserDto> getAllUsers(){
		
		List<User> user = userRepository.findAll();
		
		return user.stream().map((users) -> modelMapper.map(user,UserDto.class))
				.collect(Collectors.toList());
	}

	@Override
	public UserDto updateUser(UserDto userDto, Long id) {
		
		User user = userRepository.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException("User not found with id : " + id));
		user.setName(userDto.getName());
		user.setTitle(userDto.getTitle());
		user.setDescription(userDto.getDescription());
		user.setCompleted(userDto.isCompleted());
		
		User updatedUser = userRepository.save(user);
		return modelMapper.map(updatedUser,UserDto.class);
	}

	@Override
	public void  deleteUser(Long id) {
		
		User user= userRepository.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException("User not found with id : " + id));
		
		userRepository.deleteById(id);
	}


}


