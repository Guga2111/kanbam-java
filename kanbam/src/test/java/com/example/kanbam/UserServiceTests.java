package com.example.kanbam;

import com.example.kanbam.entity.Board;
import com.example.kanbam.entity.User;
import com.example.kanbam.repository.UserRepository;
import com.example.kanbam.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

@ExtendWith(MockitoExtension.class)
public class UserServiceTests {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    private User user;

    @BeforeEach
    void setUp() {
        user = new User();
        user.setId(1L);
        user.setEmail("testemail@gmail.com");
        user.setPassword("testpassword123");
    }

    @Test
    public void getUsersFromRepoTest() {
        when(userRepository.findAll()).thenReturn(Arrays.asList(user));

        List<User> result = userService.getUsers();

        assertFalse(result.isEmpty());
        assertEquals("testemail@gmail.com", result.get(0).getEmail());
        assertEquals("testpassword123", result.get(0).getPassword());
    }

    @Test
    public void getUserFromRepoTest() {
        Long id = 1L;
        when(userRepository.findById(id)).thenReturn(Optional.ofNullable(user));

        User result = userService.getUser(id);

        assertEquals("testemail@gmail.com", result.getEmail());
        assertEquals("testpassword123", result.getPassword());
    }

    @Test
    public void saveUserFromRepoTest() {
        when(userRepository.save(user)).thenReturn(user);

        User result = userService.saveUser(user);

        assertEquals("testemail@gmail.com", result.getEmail());
        assertEquals("testpassword123", result.getPassword());
        verify(userRepository, times(1)).save(user);
    }

    @Test
    public void deleteUserFromRepoTest() {
        Long id = 1L;

        userService.deleteUser(id);

        verify(userRepository, times(1)).deleteById(id);
    }

    @Test
    public void updateUserFromRepoTest() {
        Long id = 1L;
        when(userRepository.findById(id)).thenReturn(Optional.of(user));
        when(userRepository.save(user)).thenReturn(user);

        User result = userService.updateUser(id);

        assertEquals("testemail@gmail.com", result.getEmail());
        assertEquals("testpassword123", result.getPassword());
        verify(userRepository, times(1)).save(user);
    }
}
