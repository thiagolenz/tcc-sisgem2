package br.com.sisgem.support.settings;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import br.com.sisgem.model.UsuarioEntity;
import br.com.sisgem.model.repository.IUsuarioRepository;


@Named
public class CustomAuthenticationProvider implements AuthenticationProvider {

	@Inject
	private IUsuarioRepository userRepository;

	public CustomAuthenticationProvider() {
		super();
	}

	@Override
	public Authentication authenticate(final Authentication authentication) throws AuthenticationException {
		String username = authentication.getName();
		String password = authentication.getCredentials().toString();

		UsuarioEntity user = this.userRepository.findByNameAndPassword(username, password);

		if (user != null) {
			List<GrantedAuthority> grantedAuthorities = new ArrayList<>();

			grantedAuthorities.add(new SimpleGrantedAuthority(user.getCargoS()));

			UserDetails userDetails = new User(username, password, grantedAuthorities);
			return new UsernamePasswordAuthenticationToken(userDetails, password, grantedAuthorities);
		} else {
			return null;
		}
	}

	@Override
	public boolean supports(final Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}

}
