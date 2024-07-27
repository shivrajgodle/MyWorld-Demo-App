package com.kpit.myworld.candidate.mapper;

import com.kpit.myworld.candidate.dto.CandidateDto;
import com.kpit.myworld.candidate.model.Candidate;

public class CandidateMapper {

    public static CandidateDto mapToCandidateDto(Candidate candidate){
        return new CandidateDto(candidate.getCandidate_id(),candidate.getFirstName(),candidate.getLastName(),candidate.getPersonalEmail(), candidate.getMobileNumber(), candidate.getDepartmentName());
    }

    public static Candidate mapToCandidate(CandidateDto candidate){
        return new Candidate(candidate.getCandidate_id(),candidate.getFirstName(),candidate.getLastName(),candidate.getPersonalEmail(), candidate.getMobileNumber(), candidate.getDepartmentName());
    }

}
