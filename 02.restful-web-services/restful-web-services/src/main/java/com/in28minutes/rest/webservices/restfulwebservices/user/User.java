package com.in28minutes.rest.webservices.restfulwebservices.user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@ApiModel(description="All details about the user.")
@Entity
public class User  {

	@Id
	@GeneratedValue
	private Integer id;

	@Size(min=2, message="Name should have at least 2 characters") //validations
	@ApiModelProperty(notes="Name should have at least 2 characters") //this information will be displayed in swagger-ui > definition > user > properties
	private String name;

	@Past
	@ApiModelProperty(notes="Birth date should be in the past") //this information will be displayed in swagger-ui > definition > user > properties
	private Date birthDate;

	//one user (class where we are) to many post (the attribute)
	@OneToMany(mappedBy="user")
	private List<Post> posts;

	protected User() {

	}

	public User(Integer id, String name, Date birthDate) {
		super();
		this.id = id;
		this.name = name;
		this.birthDate = birthDate;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

	@Override
	public String toString() {
		return String.format("User [id=%s, name=%s, birthDate=%s]", id, name, birthDate);
	}

}
