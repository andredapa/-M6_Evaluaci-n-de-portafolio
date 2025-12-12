package com.skillnest.web.security;


import com.skillnest.web.model.Empleado;
import com.skillnest.web.repository.EmpleadoRepository;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final EmpleadoRepository empleadoRepository;

    public UserDetailsServiceImpl(EmpleadoRepository empleadoRepository) {
        this.empleadoRepository = empleadoRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Empleado empleado = empleadoRepository.findByEmail(username);
        if (empleado == null) throw new UsernameNotFoundException("Usuario no encontrado");
        return User.builder()
                .username(empleado.getEmail())
                .password("{noop}" + empleado.getPassword())
                .roles(empleado.getRole())
                .build();
    }
}
