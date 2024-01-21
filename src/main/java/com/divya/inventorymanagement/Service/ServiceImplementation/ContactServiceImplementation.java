package com.divya.inventorymanagement.Service.ServiceImplementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.divya.inventorymanagement.Model.Contact;
import com.divya.inventorymanagement.Repository.ContactRepository;
import com.divya.inventorymanagement.Service.ContactService;

@Service
public class ContactServiceImplementation implements ContactService{

    @Autowired
    private ContactRepository contactRepository;
    
    @Override
    public Contact addContact(Contact contact) {
        try {
            return contactRepository.save(contact);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<Contact> getAllContacts() {
        try {
            return contactRepository.findAll();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public Contact getContactById(int id) {
        try {
            return contactRepository.findById(id).get();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public Contact updateContactById(Contact contact) {
        try{
            return contactRepository.save(contact);
        }catch(Exception e){
            return null;
        }
    }

    @Override
    public String deleteContactById(int id) {
         try{
            Contact contact = contactRepository.findById(id).get();
            contactRepository.delete(contact);
            return "Contact deleted successfully";
        }catch(Exception e){
            return "Contact not found";
        }
    }
    
}
