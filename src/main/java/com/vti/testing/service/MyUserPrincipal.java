//package com.vti.testing.service;
//
//import com.vti.testing.entity.Account;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import java.util.Arrays;
//import java.util.Collection;
//import java.util.List;
//
//public class MyUserPrincipal implements UserDetails {
//    private String userName;
//    private String password;
//
////    private List<GrantedAuthority> authorities;
//
//    public MyUserDetails(Account account) {
//        this.userName = account.getUsername();
//        this.password = account.getPassword();
////
////        this.authorities = Arrays.stream(account.getRole().split(","))
////                .map(SimpleGrantedAuthority::new)
////                .collect(Collectors.toList());
//    }
//
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
////        return authorities;
//        return null;
//    }
//
//    @Override
//    public String getPassword() {
//        return password;
//    }
//
//    @Override
//    public String getUsername() {
//        return userName;
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return true;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return active;
//    }
//}
