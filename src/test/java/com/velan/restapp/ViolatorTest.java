package com.velan.restapp;

import com.velan.restapp.model.Violator;
import com.velan.restapp.repository.ViolatorRepo;
import com.velan.restapp.serviceimp.ViolatorServiceImp;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ViolatorTest {

    @InjectMocks
    private ViolatorServiceImp violatorServiceImp;

    @Mock
    private ViolatorRepo violatorRepo;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testAddViolator() {
        Violator violator = new Violator();
        violator.setViolator_id(1);
        violatorServiceImp.addViolator(violator);
        verify(violatorRepo, times(1)).add(violator);
    }

    @Test
    public void testAuthenticate() {
        String email = "test@example.com";
        String password = "password";
        Violator violator = new Violator();
        violator.setEmail(email);
        violator.setPassword(password);
        when(violatorRepo.findByEmailAndPassword(email, password)).thenReturn(Optional.of(violator));
        Optional<Violator> result = violatorServiceImp.authenticate(email, password);
        assertTrue(result.isPresent());
        assertEquals(email, result.get().getEmail());
        assertEquals(password, result.get().getPassword());
        verify(violatorRepo, times(1)).findByEmailAndPassword(email, password);
    }

    @Test
    public void testGetViolator() {
        int violatorId = 1;
        Violator violator = new Violator();
        violator.setViolator_id(violatorId);
        when(violatorRepo.findById(violatorId)).thenReturn(violator);
        Violator result = violatorServiceImp.getViolator(violatorId);
        assertNotNull(result);
        assertEquals(violatorId, result.getViolator_id());
        verify(violatorRepo, times(1)).findById(violatorId);
    }

    @Test
    public void testGetAllViolators() {
        Violator violator1 = new Violator();
        Violator violator2 = new Violator();
        List<Violator> violators = Arrays.asList(violator1, violator2);

        when(violatorRepo.findAllViolators()).thenReturn(violators);
        List<Violator> result = violatorServiceImp.getAllViolators();

        assertNotNull(result);
        assertEquals(2, result.size());
        verify(violatorRepo, times(1)).findAllViolators();
    }

    @Test
    public void testUpdateViolator() {
        Violator violator = new Violator();
        violator.setViolator_id(1); 

        violatorServiceImp.updateViolator(violator);
        verify(violatorRepo, times(1)).update(violator);
    }

    @Test
    public void testDeleteViolator() {
        int violatorId = 1;
        violatorServiceImp.deleteViolator(violatorId);
        verify(violatorRepo, times(1)).delete(violatorId);
    }

    @Test
    public void testGetAllId() {
        List<Integer> idList = Arrays.asList(1, 2, 3);
        when(violatorRepo.getIdList()).thenReturn(idList);
        List<Integer> result = violatorServiceImp.getAllId();
        assertNotNull(result);
        assertEquals(3, result.size());
        assertTrue(result.containsAll(Arrays.asList(1, 2, 3)));
        verify(violatorRepo, times(1)).getIdList();
    }
}
