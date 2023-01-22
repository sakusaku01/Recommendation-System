package kg.megacom.Recommendation.system.Recommendation.system.services.impl;

import kg.megacom.Recommendation.system.Recommendation.system.mapper.UserEntityMapper;
import kg.megacom.Recommendation.system.Recommendation.system.model.dto.UserEntityDTO;
import kg.megacom.Recommendation.system.Recommendation.system.model.entity.Role;
import kg.megacom.Recommendation.system.Recommendation.system.model.entity.UserEntity;
import kg.megacom.Recommendation.system.Recommendation.system.model.enums.RoleStatus;
import kg.megacom.Recommendation.system.Recommendation.system.model.request.SignUpRequest;
import kg.megacom.Recommendation.system.Recommendation.system.repository.RoleRepository;
import kg.megacom.Recommendation.system.Recommendation.system.repository.UserEntityRepository;
import kg.megacom.Recommendation.system.Recommendation.system.services.UserEntityServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserEntityServicesImpl implements UserEntityServices {

    private final UserEntityRepository userRepository;
    private final RoleRepository repository;

    public UserEntityServicesImpl(UserEntityRepository userRepository, RoleRepository repository) {
        this.userRepository = userRepository;
        this.repository = repository;
    }
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserEntityDTO save(UserEntityDTO userEntityDTO, int lang) {
        return null;
    }

    @Override
    public UserEntityDTO findById(Long id, int lang) {
        return null;
    }

    @Override
    public List<UserEntityDTO> findAll(int lang) {
        return null;
    }

    @Override
    public UserEntityDTO createRegister(UserEntityDTO dto) {

        if (userRepository.existsByName(dto.getName())) {
            throw  new RuntimeException("Error: Username is exist");
        }

        if (userRepository.existsByEmail(dto.getEmail())) {
            throw new RuntimeException("Error: Email is exist");
        }

        UserEntity user = new UserEntity();
        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        user.setPassword(passwordEncoder.encode(dto.getPassword()));
        user.setAge(dto.getAge());
        user.setActive(dto.isActive());
        user.setGender(dto.getGender());


        Set<String> reqRoles = dto.getRoles();
        Set<Role> roles = new HashSet<>();

        if (reqRoles == null) {
            Role userRole = repository
                    .findByName(RoleStatus.ROLE_USER)
                    .orElseThrow(() -> new RuntimeException("Error, Role USER is not found"));
            roles.add(userRole);
        } else {
            reqRoles.forEach(r -> {
                switch (r) {
                    case "admin":
                        Role adminRole = repository
                                .findByName(RoleStatus.ROLE_ADMIN)
                                .orElseThrow(() -> new RuntimeException("Error, Role ADMIN is not found"));
                        roles.add(adminRole);

                        break;
                    default:
                        Role userRole = repository
                                .findByName(RoleStatus.ROLE_USER)
                                .orElseThrow(() -> new RuntimeException("Error, Role USER is not found"));
                        roles.add(userRole);
                }
            });
        }
        user.setRoles(roles);
        return UserEntityMapper.INSTANCE.toDto(userRepository.save(user));
    }
}
