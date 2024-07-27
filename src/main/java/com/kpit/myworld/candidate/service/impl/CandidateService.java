package com.kpit.myworld.candidate.service.impl;

import com.kpit.myworld.candidate.dto.CandidateDto;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CandidateService {

    // Add a candidate
    public CandidateDto addCandidate(CandidateDto candidate);

    // update a candidate
    public CandidateDto updateCandidate(CandidateDto candidate);

    // get all candidate
    public List<CandidateDto> getAllCandidate(Pageable paging);

    // get candidate by id
    public CandidateDto getCandidateById(Long candidateId);

    // delete candidate by id
    public String deleteCandidateById(Long candidateId);
}
