package com.sondev.authservice.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import java.io.Serial;
import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Getter
@Setter
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User extends AbstractMappedEntity implements Serializable {

  @Serial
  private static final long serialVersionUID = 1L;

  @Id
  @UuidGenerator
  @Column(name = "id", unique = true, nullable = false, updatable = false)
  private String id;

  @Column(name = "zalo_id")
  private String zaloId;

  @Column(name = "first_name")
  private String firstName;

  @Column(name = "last_name")
  private String lastName;

  @Column(name = "avatar_url")
  private String avatarUrl;

  @Column(name = "public_avatar_id")
  private String publicId;

  @Email(message = "*Input must be in Email format!**")
  private String email;

  private String password;

  private String phone;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "address_id")
  private Address address;

  @ManyToOne
  @JoinColumn(name = "role_id")
  private Role role;

  private Boolean locked;

  private Boolean enabled;

//  public User(String firstName, String lastName, String email, String password, Role role) {
//    this.firstName = firstName;
//    this.lastName = lastName;
//    this.email = email;
//    this.password = password;
//    this.role = role;
//  }
//
//
//  @Override
//  public Collection<? extends GrantedAuthority> getAuthorities() {
//    SimpleGrantedAuthority authority =
//        new SimpleGrantedAuthority(role.name());
//    return Collections.singletonList(authority);
//  }
//
//  @Override
//  public String getPassword() {
//    return password;
//  }
//
//  @Override
//  public String getUsername() {
//    return this.email;
//  }
//
//  @Override
//  public boolean isAccountNonExpired() {
//    return true;
//  }
//
////    @Override
////    public boolean isAccountNonLocked() {
////        return !locked;
////    }
//
//  @Override
//  public boolean isAccountNonLocked() {
//    return true;
//  }
//
//  @Override
//  public boolean isCredentialsNonExpired() {
//    return true;
//  }
//
////    @Override
////    public boolean isEnabled() {
////        return enabled;
////    }
//
//  @Override
//  public boolean isEnabled() {
//    return true;
//  }
}
