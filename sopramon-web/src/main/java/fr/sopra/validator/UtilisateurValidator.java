package fr.sopra.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import fr.sopra.idao.IDAOUtilisateur;
import fr.sopra.model.Utilisateur;

public class UtilisateurValidator implements Validator {

	@Autowired
	IDAOUtilisateur daoUser;

	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return Utilisateur.class.equals(clazz);
	}

	public void validate(Object obj, Errors e) {
		// TODO Auto-generated method stub
		
		Utilisateur user = (Utilisateur) obj;
		
		if (daoUser.findByUsernameAndPassword(user.getUsername(), user.getPassword()) != null) {
			e.rejectValue(
		}
	}
}

//	 UserLogin login = (UserLogin) target;
//     if (login.getPassword() != null
//           && login.getPassword().trim().length() < MINIMUM_PASSWORD_LENGTH) {
//        errors.rejectValue("password", "field.min.length",
//              new Object[]{Integer.valueOf(MINIMUM_PASSWORD_LENGTH)},
//              "The password must be at least [" + MINIMUM_PASSWORD_LENGTH + "] characters in length.");
