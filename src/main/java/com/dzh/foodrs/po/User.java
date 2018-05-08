package com.dzh.foodrs.po;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;





import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.Collection;

/**
 * Created by holyfrans on 2017/3/6.
 * �û���
 */
@Entity
@Table(name = "users")
public class User implements Serializable,UserDetails {
    @Id
    private String id;

    @Column(nullable = false, unique = true, length = 10)
    @NotNull
    @Size(min = 5, max = 10)
    private String username;

    @Column(nullable = false, length = 63)
    @NotNull
    @Size(min = 6)
    private String password;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;


	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

   
    public void setUsername(String username) {
        this.username = username;
    }

   

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}
}
