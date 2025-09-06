package com.inspireapi.Repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inspireapi.Model.InspireSession;



@Repository
public interface InspireSessionRepository extends JpaRepository<InspireSession, UUID> {

    /**
     * Find Inspire sessions containing a specific keyword in the breatheContent
     * @param breatheKeyword the keyword to search for in breatheContent
     * @return a list of InspireSessions containing the keyword in breatheContent
     */
    List<InspireSession> findByBreatheContentContainingIgnoreCase(String breatheKeyword);

    /**
     * Find Inspire sessions containing a specific keyword in the learnContent
     * @param learnKeyword the keyword to search for in learnContent
     * @return a list of InspireSessions containing the keyword in learnContent
     */
    List<InspireSession> findByLearnContentContainingIgnoreCase(String learnKeyword);

    /**
     * Find Inspire sessions containing a specific keyword in the quoteContent
     * @param quoteKeyword the keyword to search for in quoteContent
     * @return a list of InspireSessions containing the keyword in quoteContent
     */
    List<InspireSession> findByQuoteContentContainingIgnoreCase(String quoteKeyword);


}
