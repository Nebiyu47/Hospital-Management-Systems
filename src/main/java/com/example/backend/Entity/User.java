package com.example.backend.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users", uniqueConstraints ={@UniqueConstraint(columnNames = "username")} )
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "use_id")
  private Long id;
  @NotBlank
  @Size(max=30)
  @Column(name = "userName")
  private String userName;
  @NotBlank
  @Size(max=30)
  @Column(name = "password")
   private String password;
  @ManyToMany
   @JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"),inverseJoinColumns = @JoinColumn(name = "role_id"))
  Set<Role> roleSet= new HashSet<>();


}
