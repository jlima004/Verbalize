package br.verbalize.sc.commons;



import org.springframework.security.crypto.password.PasswordEncoder;

import br.verbalize.sc.commons.Utils;

public class CustomPasswordEncoder implements PasswordEncoder {

	@Override
	public String encode(CharSequence rawPassword) {
		return Utils.senhaToSha256(rawPassword.toString());
	}

	@Override
	public boolean matches(CharSequence rawPassword, String encodedPassword) {
		return Utils.senhaToSha256(rawPassword.toString()).equals(encodedPassword);
	}

}
