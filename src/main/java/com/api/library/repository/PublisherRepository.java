package com.api.library.repository;

import com.api.library.entity.AuthorEntity;
import com.api.library.entity.PublisherEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.Optional;

@Repository
public interface PublisherRepository extends JpaRepository<PublisherEntity, BigInteger> {
    @Query(value="select PB_ID, PB_NAME \n" +
            "from Publishers where PB_ID =:publisherId", nativeQuery=true)
    Optional<PublisherEntity> getPublisherIdById(@Param("publisherId") BigInteger publisherId);
}
