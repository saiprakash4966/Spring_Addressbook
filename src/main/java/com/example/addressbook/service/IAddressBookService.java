package com.example.addressbook.service;

import com.example.addressbook.dto.ContactDTO;
import com.example.addressbook.model.Contact;

import java.util.List;

public interface IAddressBookService {
    List<Contact> getContact();

    void deleteContact(int contactId);

    Contact updateContact(int contactId, ContactDTO contactDTO);

    Contact createContact(ContactDTO contactDTO);

    Contact getContactById(int contactId);

    List<Contact> getContactByCity(String city);

    List<Contact> sortByCity();

    List<Contact> sortByState();
}
