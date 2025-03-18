package com.sondev.productservice.security;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.Collection;
import java.util.Collections;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomUserDetail implements UserDetails {

  private Integer userID;


  private String userName;

  private String usersName;

  private String active;

  private String streetAddress;

  private String suburb;

  private String postCode;

  private String roleName;

  private String email;

  @JsonIgnore
  private String userPassword;


  public static CustomUserDetail mapUserToUserDetail(TUsers user, String roleName) {

    return CustomUserDetail.builder()
        .userID(user.getUserID())
        .userName(user.getUserName())
        .active(user.getActive())
        .streetAddress(user.getStreetAddress())
        .suburb(user.getSuburb())
        .postCode(user.getPostCode())
        .roleName(roleName)
        .userPassword(user.getUserPassword())
        .build();

  }

  ;

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    SimpleGrantedAuthority authority =
        new SimpleGrantedAuthority(roleName);
    return Collections.singletonList(authority);
  }

  @Override
  public String getPassword() {
    return this.userPassword;
  }

  @Override
  public String getUsername() {
    return this.userName;
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return true;
  }
}
