package com.gila.codingchallenge.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import static javax.persistence.FetchType.EAGER;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "users")
public class User implements Serializable{

	@Id
	@GeneratedValue(strategy = IDENTITY)
	private Long id;
	
	@NotBlank(message = "Name is required.")
	private String name;
	
	@NotEmpty(message = "Email is required.")
	@Email(message = "It is not a valid email.")
	private String email;
	
	@NotBlank(message = "Phone is required.")
	private String phone;
	
	@ManyToMany
	@JoinTable(name = "users_categories", 
    		   joinColumns = @JoinColumn(name = "user_id"),
               inverseJoinColumns = @JoinColumn(name = "category_id"))
	private List<Category> subscribed;
	
	@ManyToMany(fetch = EAGER)
	@JoinTable(name = "users_channels", 
    		   joinColumns = @JoinColumn(name = "user_id"),
               inverseJoinColumns = @JoinColumn(name = "channel_id"))
	private List<Channel> channels;
}
