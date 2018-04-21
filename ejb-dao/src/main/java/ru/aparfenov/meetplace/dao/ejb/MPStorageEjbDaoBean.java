package ru.aparfenov.meetplace.dao.ejb;

import ru.aparfenov.meetplace.jpa.enities.MeetPointEntity;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by ArtemParfenov on 01.04.2018.
 */
/*public class MPStorageEjbDaoBean implements MPStorageEjbDAO {
    @PersistenceContext(unitName = "meetpoint-oracle-unit")
    private EntityManager entityManager;

    @Override
    public MeetPointEntity getMP(String id) {
        Query booksQuery = entityManager.createQuery("SELECT m from MeetPointEntity as m");
        List<MeetPointEntity> books = booksQuery.getResultList();
        return books.get(0);
    }

    @Override
    public void addMP(MeetPointEntity newMP) {
        *//*BookEntity newBook = new BookEntity();
        newBook.setBookName(bookNameParameter);
        ISBN newIsbn = new ISBN();
        newIsbn.setIsbnNumber(isbnNumber);
        BookSpoiler newBookSpoiler = new BookSpoiler();
        newBookSpoiler.setText(spoiler);
//            newBook.setSpoiler(newBookSpoiler);
        newBook.setIsbn(newIsbn);
        entityManager.persist(newBook);
        entityManager.flush();

        newBookSpoiler.setBook(newBook);
        entityManager.merge(newBookSpoiler);*//*

        MeetPointEntity newMpEntity = new MeetPointEntity();
        newMpEntity.setId("new MP");
        newMpEntity.setX(0L);
        newMpEntity.setY(0L);
        entityManager.persist(newMpEntity);
        entityManager.flush();
    }
}*/
