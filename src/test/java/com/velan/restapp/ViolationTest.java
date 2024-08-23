package com.velan.restapp;

import com.velan.restapp.model.Violation;
import com.velan.restapp.repository.ViolationRepo;
import com.velan.restapp.serviceimp.ViolationServiceImp;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ViolationTest {

    @InjectMocks
    private ViolationServiceImp violationServiceImp;

    @Mock
    private ViolationRepo violationRepo;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testAddViolation() {
        Violation violation = new Violation();
        violation.setViolation_id(1);
        violationServiceImp.addViolation(violation);
        verify(violationRepo, times(1)).add(violation);
    }

    @Test
    public void testGetViolation() {
        int violationId = 1;
        Violation violation = new Violation();
        violation.setViolation_id(violationId);

        when(violationRepo.findById(violationId)).thenReturn(violation);
        Violation result = violationServiceImp.getViolation(violationId);

        assertNotNull(result);
        assertEquals(violationId, result.getViolation_id());
        verify(violationRepo, times(1)).findById(violationId);
    }

    @Test
    public void testGetAllViolations() {
        Violation violation1 = new Violation();
        Violation violation2 = new Violation();
        List<Violation> violations = Arrays.asList(violation1, violation2);

        when(violationRepo.findAllViolations()).thenReturn(violations);
        List<Violation> result = violationServiceImp.getAllViolations();

        assertNotNull(result);
        assertEquals(2, result.size());
        verify(violationRepo, times(1)).findAllViolations();
    }

    @Test
    public void testUpdateViolation() {
        Violation violation = new Violation();
        violation.setViolation_id(1);
        
        violationServiceImp.updateViolation(violation);
        verify(violationRepo, times(1)).update(violation);
    }

    @Test
    public void testDeleteViolation() {
        int violationId = 1;
        violationServiceImp.deleteViolation(violationId);
        verify(violationRepo, times(1)).delete(violationId);
    }

    @Test
    public void testGetAllId() {
        List<Integer> idList = Arrays.asList(1, 2, 3);

        when(violationRepo.getIdList()).thenReturn(idList);
        List<Integer> result = violationServiceImp.getAllId();

        assertNotNull(result);
        assertEquals(3, result.size());
        assertTrue(result.containsAll(Arrays.asList(1, 2, 3)));
        verify(violationRepo, times(1)).getIdList();
    }
}
