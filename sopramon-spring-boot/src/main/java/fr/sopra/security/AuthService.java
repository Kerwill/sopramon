package fr.sopra.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import fr.sopra.dao.IDAOUtilisateur;



@Service
public class AuthService implements UserDetailsService {
	@Autowired
	IDAOUtilisateur daoUtilisateur;

	
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		 
		return new UtilisateurPrincipal(this.daoUtilisateur.findByUsername(username));

	}
}