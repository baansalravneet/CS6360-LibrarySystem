package com.librarysystem.db.repositories;

import com.librarysystem.db.dao.StoredLoan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoanRepository extends JpaRepository<StoredLoan, Long> {
    @Query(value = "SELECT * FROM LOANS WHERE LOWER(Isbn) LIKE %:isbn%", nativeQuery = true)
    List<StoredLoan> getLoanByMatchingIsbn(@Param("isbn") String isbn);

    @Query(value = "SELECT * FROM LOANS WHERE LOWER(Card_id) LIKE %:borrowerId%", nativeQuery = true)
    List<StoredLoan> getLoanByMatchingBorrowerId(@Param("borrowerId") String borrowerId);

}