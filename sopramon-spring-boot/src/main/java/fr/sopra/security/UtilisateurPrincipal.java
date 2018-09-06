package fr.sopra.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import fr.sopra.model.Utilisateur;



public class UtilisateurPrincipal implements UserDetails {
	
	private static final long serialVersionUID = 1L;
	private Utilisateur utilisateur;

	public UtilisateurPrincipal(Utilisateur utilisateur) {
		if (utilisateur == null) {
			throw new UsernameNotFoundException("L'utilisateur n'existe pas.");
		}
		this.utilisateur = utilisateur;
	}

	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> myAuthorities = new ArrayList<GrantedAuthority>();
		
		if (this.utilisateur.isAdmin()) {
			myAuthorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
			}
		
		else {
				myAuthorities.add(new SimpleGrantedAuthority("ROLE_USER"));
		}
		
		
		return myAuthorities;

	}

	public String getPassword() {
		// TODO Auto-generated method stub
		return this.utilisateur.getPassword();

	}

	public String getUsername() {
		// TODO Auto-generated method stub
		return this.utilisateur.getUsername();

	}

	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

//	
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
}