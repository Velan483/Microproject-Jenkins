package com.velan.restapp;

import com.velan.restapp.model.TrafficOfficer;
import com.velan.restapp.repository.TrafficOfficerRepo;
import com.velan.restapp.serviceimp.TrafficOfficerServiceImp;
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

public class TrafficOfficerTest {

    @InjectMocks
    private TrafficOfficerServiceImp trafficOfficerServiceImp;

    @Mock
    private TrafficOfficerRepo trafficOfficerRepo;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testAddTrafficOfficer() {
        TrafficOfficer officer = new TrafficOfficer();
        officer.setOfficer_id(1);
        trafficOfficerServiceImp.addTrafficOfficer(officer);
        verify(trafficOfficerRepo, times(1)).add(officer);
    }

    @Test
    public void testAuthenticate() {
        String email = "test@example.com";
        String password = "password";
        TrafficOfficer officer = new TrafficOfficer();
        officer.setEmail(email);
        officer.setPassword(password);

        when(trafficOfficerRepo.findByEmailAndPassword(email, password)).thenReturn(Optional.of(officer));
        Optional<TrafficOfficer> result = trafficOfficerServiceImp.authenticate(email, password);

        assertTrue(result.isPresent());
        assertEquals(email, result.get().getEmail());
        assertEquals(password, result.get().getPassword());
        verify(trafficOfficerRepo, times(1)).findByEmailAndPassword(email, password);
    }

    @Test
    public void testGetTrafficOfficer() {
        int officerId = 1;
        TrafficOfficer officer = new TrafficOfficer();
        officer.setOfficer_id(officerId);

        when(trafficOfficerRepo.findById(officerId)).thenReturn(officer);
        TrafficOfficer result = trafficOfficerServiceImp.getTrafficOfficer(officerId);

        assertNotNull(result);
        assertEquals(officerId, result.getOfficer_id());
        verify(trafficOfficerRepo, times(1)).findById(officerId);
    }

    @Test
    public void testGetAllTrafficOfficers() {
        TrafficOfficer officer1 = new TrafficOfficer();
        TrafficOfficer officer2 = new TrafficOfficer();
        List<TrafficOfficer> officers = Arrays.asList(officer1, officer2);

        when(trafficOfficerRepo.findAllTrafficOfficers()).thenReturn(officers);
        List<TrafficOfficer> result = trafficOfficerServiceImp.getAllTrafficOfficers();

        assertNotNull(result);
        assertEquals(2, result.size());
        verify(trafficOfficerRepo, times(1)).findAllTrafficOfficers();
    }

    @Test
    public void testUpdateTrafficOfficer() {
        TrafficOfficer officer = new TrafficOfficer();
        officer.setOfficer_id(1);
        trafficOfficerServiceImp.updateTrafficOfficer(officer);
        verify(trafficOfficerRepo, times(1)).update(officer);
    }

    @Test
    public void testDeleteTrafficOfficer() {
        int officerId = 1;
        trafficOfficerServiceImp.deleteTrafficOfficer(officerId);
        verify(trafficOfficerRepo, times(1)).delete(officerId);
    }

    @Test
    public void testGetAllId() {
        List<Integer> idList = Arrays.asList(1, 2, 3);
        when(trafficOfficerRepo.getIdList()).thenReturn(idList);
        List<Integer> result = trafficOfficerServiceImp.getAllId();
        assertNotNull(result);
        assertEquals(3, result.size());
        assertTrue(result.containsAll(Arrays.asList(1, 2, 3)));
        verify(trafficOfficerRepo, times(1)).getIdList();
    }
}
