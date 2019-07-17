package com.example.springwebapp.repositories;

import com.example.springwebapp.beans.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher,Integer> {

}
