package com.velan.restapp;

import com.velan.restapp.model.Admin;
import com.velan.restapp.repository.AdminRepo;
import com.velan.restapp.serviceimp.AdminServiceImp;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class AdminTest {

    @InjectMocks
    private AdminServiceImp adminServiceImp;

    @Mock
    private AdminRepo adminRepo;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testAuthenticate_Success() {
        String email = "admin@example.com";
        String password = "password";
        Admin admin = new Admin();
        admin.setEmail(email);
        admin.setPassword(password);

        when(adminRepo.findByEmailAndPassword(email, password)).thenReturn(Optional.of(admin));
        Optional<Admin> result = adminServiceImp.authenticate(email, password);

        assertTrue(result.isPresent());
        assertEquals(email, result.get().getEmail());
        assertEquals(password, result.get().getPassword());
        verify(adminRepo, times(1)).findByEmailAndPassword(email, password);
    }

    @Test
    public void testAuthenticate_Failure() {
        String email = "admin@example.com";
        String password = "wrongpassword";

        when(adminRepo.findByEmailAndPassword(email, password)).thenReturn(Optional.empty());
        Optional<Admin> result = adminServiceImp.authenticate(email, password);

        assertFalse(result.isPresent());
        verify(adminRepo, times(1)).findByEmailAndPassword(email, password);
    }
}

