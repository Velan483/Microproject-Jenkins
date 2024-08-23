package com.velan.restapp;

import com.velan.restapp.model.ContactPage;
import com.velan.restapp.repository.ContactRepo;
import com.velan.restapp.serviceimp.ContactServiceImp;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.*;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class ContactTest {

    @InjectMocks
    private ContactServiceImp contactServiceImp;

    @Mock
    private ContactRepo contactRepo;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testAddContact() {
        ContactPage contact = new ContactPage();
        contact.setContact_id(1);
        contactServiceImp.addContact(contact);
        verify(contactRepo, times(1)).add(contact);
    }

    @Test
    public void testGetAllContactPages() {
        ContactPage contact1 = new ContactPage();
        ContactPage contact2 = new ContactPage();
        List<ContactPage> contacts = Arrays.asList(contact1, contact2);
        when(contactRepo.findAllContactPages()).thenReturn(contacts);
        List<ContactPage> result = contactServiceImp.getAllContactPages();
        assertNotNull(result);
        assertEquals(2, result.size());
        verify(contactRepo, times(1)).findAllContactPages();
    }

    @Test
    public void testDeleteContactPage() {
        int contactId = 1;
        contactServiceImp.deleteContactPage(contactId);
        verify(contactRepo, times(1)).delete(contactId);
    }
}
