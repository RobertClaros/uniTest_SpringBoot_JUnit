package com.example.newsletter.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class EmailRepository {
    @PersistenceContext
    private EntityManager dataBase;
    @Transactional
    public void emailSave(String useremail){
        String sqlQuery = "INSERT INTO `lead` (`id`, `email`) " +
                "VALUES (NULL, '"+useremail+"')";
        dataBase.createNativeQuery(sqlQuery).executeUpdate();
    }

    @Transactional
    public void emailDelete(String useremail) {
        String consultaSql = "DELETE FROM Lead WHERE email = :paramEmail ";

        dataBase.createQuery(consultaSql)
                .setParameter("paramEmail",useremail)
                .executeUpdate();
    }

    @Transactional
    public List<String> getEmails() {
        String sqlQuery = "SELECT email FROM Lead";

        return dataBase.createQuery(sqlQuery).getResultList();
    }
}
