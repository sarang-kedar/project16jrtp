package com.srk.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.srk.entity.Contact;

public interface ContactRepository extends JpaRepository<Contact,Serializable> {

}
