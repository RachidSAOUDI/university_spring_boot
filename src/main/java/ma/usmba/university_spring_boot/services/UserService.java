package ma.usmba.university_spring_boot.services;

import ma.usmba.university_spring_boot.entities.Role;
import ma.usmba.university_spring_boot.entities.User;

public interface UserService {
    User addNewUser(User user);
    Role addNewRole(Role role);
    User findUserByUserName(String userName);
    Role findRoleByRolename(String roleName);
    void addRoleToUser(String userName, String roleName);
    User authenticate(String username, String password);
}
