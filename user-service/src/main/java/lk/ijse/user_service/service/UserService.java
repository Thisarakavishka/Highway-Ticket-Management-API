package lk.ijse.user_service.service;

import lk.ijse.user_service.dto.UserDTO;
import lk.ijse.user_service.entity.User;

public interface UserService {
    boolean verifyUser(UserDTO userdto);
    boolean addUser(UserDTO userdto);
    boolean updateUser(UserDTO userdto);
}
