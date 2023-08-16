package com.api.library.service.impl;

import com.api.library.entity.MemberEntity;
import com.api.library.entity.PublisherEntity;
import com.api.library.exception.NameAlreadyExistException;
import com.api.library.exception.NotFoundException;
import com.api.library.repository.PublisherRepository;
import com.api.library.service.PublisherService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class PublisherServiceImpl implements PublisherService {

    PublisherRepository publisherRepository;

    @Override
    public List<PublisherEntity> getPublishers() {
        List<PublisherEntity> publisherEntities = publisherRepository.listPublishers();
        return new ArrayList<>(publisherEntities);
    }

    @Override
    @Transactional
    public void insertPublisher(String publisherName) throws NameAlreadyExistException {
        PublisherEntity publisherEntity=publisherRepository.getPublisherByName(publisherName).orElse(null);
        if(publisherEntity==null){
            publisherRepository.insertPublisher(publisherName);
        } else {
            throw new NameAlreadyExistException("Publisher Name already exist");
        }
    }

    @Override
    @Transactional
    public void updatePublisher(String publisherName, BigInteger publisherId) throws NotFoundException, NameAlreadyExistException {
        PublisherEntity publisherById=publisherRepository.getPublisherIdById(publisherId).orElse(null);
        PublisherEntity publisherByName=publisherRepository.getPublisherByName(publisherName).orElse(null);
        if(publisherById==null){
            throw new NotFoundException("Publisher not found");
        } else if(publisherByName!=null){
            throw new NameAlreadyExistException("Publisher name already exist");
        }
        publisherRepository.updatePublisher(publisherName, publisherId);
    }

    @Override
    @Transactional
    public void deletePublisher(BigInteger publisherId) throws NotFoundException {
        PublisherEntity publisher=publisherRepository.getPublisherIdById(publisherId).orElse(null);
        if(publisher==null){
            throw new NotFoundException("Publisher not found");
        }
        publisherRepository.deletePublisher(publisherId);
    }
}
