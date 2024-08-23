package com.velan.restapp;

import com.velan.restapp.model.Invoice;
import com.velan.restapp.repository.InvoiceRepo;
import com.velan.restapp.serviceimp.InvoiceServiceImp;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class InvoiceTest {

    @InjectMocks
    private InvoiceServiceImp invoiceServiceImp;

    @Mock
    private InvoiceRepo invoiceRepo;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testAddInvoice() {
        Invoice invoice = new Invoice();
        invoice.setInvoice_id(1); 
        invoiceServiceImp.addInvoice(invoice);
        verify(invoiceRepo, times(1)).add(invoice);
    }

    @Test
    public void testGetInvoice() {
        int invoiceId = 1;
        Invoice invoice = new Invoice();
        invoice.setInvoice_id(invoiceId);
        when(invoiceRepo.findById(invoiceId)).thenReturn(invoice);
        Invoice result = invoiceServiceImp.getInvoice(invoiceId);
        assertNotNull(result);
        assertEquals(invoiceId, result.getInvoice_id());
        verify(invoiceRepo, times(1)).findById(invoiceId);
    }

    @Test
    public void testGetAllInvoices() {
        Invoice invoice1 = new Invoice();
        Invoice invoice2 = new Invoice();
        List<Invoice> invoices = Arrays.asList(invoice1, invoice2);
        when(invoiceRepo.findAllInvoices()).thenReturn(invoices);
        List<Invoice> result = invoiceServiceImp.getAllInvoices();
        assertNotNull(result);
        assertEquals(2, result.size());
        verify(invoiceRepo, times(1)).findAllInvoices();
    }

    @Test
    public void testUpdateInvoice() {
        Invoice invoice = new Invoice();
        invoice.setInvoice_id(1); 
        invoiceServiceImp.updateInvoice(invoice);
        verify(invoiceRepo, times(1)).update(invoice);
    }

    @Test
    public void testDeleteInvoice() {
        int invoiceId = 1;
        invoiceServiceImp.deleteInvoice(invoiceId);
        verify(invoiceRepo, times(1)).delete(invoiceId);
    }

    @Test
    public void testGetAllId() {
        List<Integer> idList = Arrays.asList(1, 2, 3);
        when(invoiceRepo.getIdList()).thenReturn(idList);
        List<Integer> result = invoiceServiceImp.getAllId();
        assertNotNull(result);
        assertEquals(3, result.size());
        assertTrue(result.containsAll(Arrays.asList(1, 2, 3)));
        verify(invoiceRepo, times(1)).getIdList();
    }

    @Test
    public void testGetInvoiceByViolatorName() {
        String violatorName = "John Doe";
        Invoice invoice1 = new Invoice();
        Invoice invoice2 = new Invoice();
        List<Invoice> invoices = Arrays.asList(invoice1, invoice2);
        when(invoiceRepo.findByViolatorName(violatorName)).thenReturn(invoices);
        List<Invoice> result = invoiceServiceImp.getInvoiceByViolatorName(violatorName);
        assertNotNull(result);
        assertEquals(2, result.size());
        verify(invoiceRepo, times(1)).findByViolatorName(violatorName);
    }
}
