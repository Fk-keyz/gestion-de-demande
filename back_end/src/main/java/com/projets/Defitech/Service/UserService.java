package com.projets.Defitech.Service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

import com.projets.Defitech.Models.Demand;
import com.projets.Defitech.Repository.DemandRepository;
import com.projets.Defitech.Repository.UserRepository;
import com.votreentreprise.pidgec.util.MappingUtil;
import com.projets.Defitech.Models.User;


@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<UserDTO> getAllUsers() {
        List<User> users = userRepository.findAll();
        return MappingUtil.mapList(users, UserDTO.class);
    }

    public UserDTO getUserById(Long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            return MappingUtil.map(optionalUser.get(), UserDTO.class);
        }
        // Gérer la situation où l'utilisateur n'est pas trouvé
        return null;
    }

    public UserDTO createUser(UserDTO userDTO) {
        User user = MappingUtil.map(userDTO, User.class);
        user = userRepository.save(user);
        return MappingUtil.map(user, UserDTO.class);
    }

    public UserDTO updateUser(Long id, UserDTO userDTO) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            User existingUser = optionalUser.get();
            existingUser.setUsername(userDTO.getUsername());
            existingUser.setPassword(userDTO.getPassword());
            // Mettre à jour d'autres attributs si nécessaire
            existingUser = userRepository.save(existingUser);
            return MappingUtil.map(existingUser, UserDTO.class);
        }
        // Gérer la situation où l'utilisateur n'est pas trouvé
        return null;
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
