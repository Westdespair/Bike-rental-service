package no.ntnu.bikerental.authentication;

import no.ntnu.bikerental.model.Customers;
import no.ntnu.bikerental.repository.CustomersRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Provides AccessUserDetails needed for authentication
 */
@Service
public class AuthenticationServiceController implements UserDetailsService {

    private CustomersRepository customersRepository;

    /**
     * Constructor with the parameter customer repository
     * @param customersRepository customer repository
     */
    public AccessUserService(CustomersRepository customersRepository) {
        this.customersRepository = customersRepository;
    }

    /**
     * Loads user by username
     * @param email String.
     * @return user by username, otherwise throw an exception
     * @throws UsernameNotFoundException with customer email not found
     */
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<Customers> customers = customersRepository.findByEmail(email);
        if (customers.isPresent()) {
            return new AccessUserDetails(customers.get());
        } else {
            throw new UsernameNotFoundException("Customer " + email + " not found");
        }
    }
}