package com.example.user_management.DTO;

public class UserDto {
	
	private Long id;
	private String name;
	private String title;
	private String description;
	private boolean completed;
	
	public UserDto() {
		super();
	}

	public UserDto(Long id, String name, String title, String description, boolean completed) {
		super();
		this.id = id;
		this.name = name;
		this.title = title;
		this.description = description;
		this.completed = completed;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isCompleted() {
		return completed;
	}

	public void setCompleted(boolean completed) {
		this.completed = completed;
	}
	

}
