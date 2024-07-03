package lk.ijse.user_service.util;

import lk.ijse.user_service.dto.UserDTO;
import lk.ijse.user_service.entity.User;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.Base64;

@Component
@RequiredArgsConstructor
public class Convertor {

    private final ModelMapper modelMapper;

    public UserDTO userToUserDTO(User user) {
        UserDTO userDTO = modelMapper.map(user, UserDTO.class);
        userDTO.setPassword(new String(Base64.getDecoder().decode(userDTO.getPassword())));
        return userDTO;
    }

    public User userDTOToUser(UserDTO userDTO) {
        userDTO.setPassword(Base64.getEncoder().encodeToString(userDTO.getPassword().getBytes()));
        return modelMapper.map(userDTO, User.class);
    }
}
