package com.kpit.myworld.candidate.repository;

import com.kpit.myworld.candidate.model.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CandidateRepository extends JpaRepository<Candidate,Long> {
}
