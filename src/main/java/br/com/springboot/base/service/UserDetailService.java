package br.com.springboot.base.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import javax.servlet.http.HttpServletRequest;
import java.util.Collections;
import java.util.List;

@Service
public class UserDetailService implements UserDetailsService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String password = request.getParameter("password");
        return mockUser(username, password);
    }

    private UserDetails mockUser(String username, String password) {
        String userName = "test@test.com";
        String userPass = "Teste@1$2#vc";

        if (!userName.equals(username) &&
                !userPass.equals(password)) {
            throw new UsernameNotFoundException("Invalid username or password.");
        }

        UserDetails user = User.withUsername(username)
                .username(username)
                .password(passwordEncoder.encode(userPass))
                .authorities(getAuthority())
                .build();

        return user;
    }

    private List<SimpleGrantedAuthority> getAuthority() {
        return Collections.emptyList();
    }

}
