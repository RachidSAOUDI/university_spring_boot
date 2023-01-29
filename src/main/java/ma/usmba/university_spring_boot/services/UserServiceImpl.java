package ma.usmba.university_spring_boot.services;

import lombok.AllArgsConstructor;
import ma.usmba.university_spring_boot.entities.Role;
import ma.usmba.university_spring_boot.entities.User;
import ma.usmba.university_spring_boot.repositories.RoleRepository;
import ma.usmba.university_spring_boot.repositories.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@Transactional
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    private RoleRepository roleRepository;

    @Override
    public User addNewUser(User user) {
        user.setUserId(UUID.randomUUID().toString());
        return userRepository.save(user);
    }

    @Override
    public Role addNewRole(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public User findUserByUserName(String userName) {
        return userRepository.findByUsername(userName);
    }

    @Override
    public Role findRoleByRolename(String roleName) {
        return roleRepository.findByRoleName(roleName);
    }

    @Override
    public void addRoleToUser(String userName, String roleName) {
        User user = findUserByUserName(userName);
        Role role = findRoleByRolename(roleName);
        if (user.getRoles()!=null){
            user.getRoles().add(role);
            role.getUsers().add(user);
        }
        //userRepository.save(user);
    }

    @Override
    public User authenticate(String username, String password) {
        User user=userRepository.findByUsername(username);
        if (user==null) throw new RuntimeException("Bad credentials");
        if (user.getPassword().equals(password)){
            return user;
        }
        throw new RuntimeException("Bad credentials");
    }
}
