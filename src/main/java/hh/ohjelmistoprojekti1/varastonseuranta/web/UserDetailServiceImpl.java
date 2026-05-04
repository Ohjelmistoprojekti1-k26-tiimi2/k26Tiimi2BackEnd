package hh.ohjelmistoprojekti1.varastonseuranta.web;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import hh.ohjelmistoprojekti1.varastonseuranta.domain.User;
import hh.ohjelmistoprojekti1.varastonseuranta.domain.UserRepository;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    private final UserRepository uRepository;

    // user -luokan injektointi
    public UserDetailServiceImpl(UserRepository userRepository) {
        this.uRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User currentUser = uRepository.findByUsername(username);
        UserDetails user = new org.springframework.security.core.userdetails.User(username,
                currentUser.getPasswordHash(), AuthorityUtils.createAuthorityList(currentUser.getRole()));
        return user;
    }
}
