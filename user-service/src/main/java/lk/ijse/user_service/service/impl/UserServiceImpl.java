package lk.ijse.user_service.service.impl;

import lk.ijse.user_service.dto.UserDTO;
import lk.ijse.user_service.entity.User;
import lk.ijse.user_service.exception.DuplicateException;
import lk.ijse.user_service.exception.NotFoundException;
import lk.ijse.user_service.repository.UserRepository;
import lk.ijse.user_service.service.UserService;
import lk.ijse.user_service.util.Convertor;
import lk.ijse.user_service.util.Generator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final Convertor convertor;
    private final Generator generator;

    @Override
    public boolean verifyUser(UserDTO userdto) {
        User user = userRepository.findByUsername(userdto.getUsername());
        if (user != null) {
            UserDTO userDTO = convertor.userToUserDTO(user);
            return userDTO.getPassword().equals(userdto.getPassword());
        }
        return false;
    }

    @Override
    public boolean addUser(UserDTO userdto) {
        if (userRepository.findByUsername(userdto.getUsername()) == null) {
            userdto.setUserId(generator.generateId());
            userRepository.save(convertor.userDTOToUser(userdto));
            return true;
        }
        throw new DuplicateException("User with username " + userdto.getUsername() + " already exists");
    }

    @Override
    public boolean updateUser(UserDTO userdto) {
        if(userRepository.existsById(userdto.getUserId())){
            userRepository.save(convertor.userDTOToUser(userdto));
            return true;
        }
        throw new NotFoundException("User with username " + userdto.getUsername() + " does not exist");
    }
}
