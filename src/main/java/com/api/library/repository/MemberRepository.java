package com.api.library.repository;

import com.api.library.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.Date;
import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<MemberEntity, BigInteger> {
    @Query(value="select MB_ID, MB_NAME, MB_BIRTH, MB_ADRESS, MB_PHONE, MB_EMAIL, MB_ENTRYDATE \n" +
            "from Members where MB_ID =:memberId", nativeQuery=true)
    Optional<MemberEntity> findMemberById(@Param("memberId") BigInteger memberId);

    @Query(value="select MB_ID, MB_NAME, MB_BIRTH, MB_ADRESS, MB_PHONE, MB_EMAIL, MB_ENTRYDATE \n" +
            "from Members where MB_NAME =:memberName", nativeQuery=true)
    Optional<MemberEntity> findMemberByName(@Param("memberName") String memberName);

    @Modifying
    @Query(value = "INSERT INTO Members (MB_NAME, MB_BIRTH, MB_ADRESS, MB_PHONE, MB_EMAIL, MB_ENTRYDATE) " +
            "VALUES (:name, :birth, :adress, :phone, :email, :entryDate)", nativeQuery = true)
    void insertMember(@Param("name") String name,
                    @Param("birth") Date birth,
                    @Param("adress") String adress,
                    @Param("phone") String phone,
                    @Param("email") String email,
                    @Param("entryDate") Date entryDate);

    @Modifying
    @Query(value = "UPDATE Members SET MB_NAME=:name, MB_BIRTH=:birth, MB_ADRESS=:adress, " +
            "MB_PHONE=:phone, MB_EMAIL=:email, MB_ENTRYDATE=:entryDate WHERE MB_ID=:id", nativeQuery = true)
    void updateMember(@Param("name") String name,
                      @Param("birth") Date birth,
                      @Param("adress") String adress,
                      @Param("phone") String phone,
                      @Param("email") String email,
                      @Param("entryDate") Date entryDate,
                      @Param("id") BigInteger id);

    @Modifying
    @Query(value = "DELETE FROM Members WHERE MB_ID=:id", nativeQuery = true)
    void deleteMember(@Param("id") BigInteger id);
}