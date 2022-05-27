package com.example.addressbook.service;

import com.example.addressbook.dto.ContactDTO;
import com.example.addressbook.exceptions.AddressBookException;
import com.example.addressbook.model.Contact;
import com.example.addressbook.repository.AddressBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AddressBookService implements IAddressBookService {

    @Autowired
    private AddressBookRepository addressBookRepository;
    List<Contact> contactList = new ArrayList<>();
    @Override
    public List<Contact> getContact() {

        return addressBookRepository.findAll();
    }

    @Override
    public Contact getContactById(int contactId) {
        return addressBookRepository.findById(contactId).orElseThrow(()->new AddressBookException("Addressbook with ContactId" + contactId
                + " Doesn't Exists...!"));
    }

    @Override
    public Contact createContact(ContactDTO contactDTO) {

        Contact contact=null;
        contact=new Contact(contactDTO);
        contactList.add(contact);
        return addressBookRepository.save(contact);
    }

    @Override
    public Contact updateContact(int contactId, ContactDTO contactDTO) {
        Contact contact = this.getContactById(contactId);
        contact.updateAddressBookData(contactDTO);

        return addressBookRepository.save(contact);
    }

    @Override
    public void deleteContact(int contactId) {
        Contact contact = this.getContactById(contactId);
        addressBookRepository.delete(contact);

    }
}