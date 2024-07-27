package com.kpit.myworld.candidate.service.impl;

import com.kpit.myworld.candidate.dto.CandidateDto;
import com.kpit.myworld.candidate.exception.NoSuchCandidateException;
import com.kpit.myworld.candidate.mapper.CandidateMapper;
import com.kpit.myworld.candidate.model.Candidate;
import com.kpit.myworld.candidate.repository.CandidateRepository;
import io.micrometer.common.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CandidateServiceImpl implements CandidateService{

    @Autowired
    private CandidateRepository candidateRepository;

    @Override
    public CandidateDto addCandidate(CandidateDto candidate) {
       Candidate addCandidate = CandidateMapper.mapToCandidate(candidate);
        Candidate savedCandidate = candidateRepository.save(addCandidate);
        return CandidateMapper.mapToCandidateDto(savedCandidate);
    }

    @Override
    public CandidateDto updateCandidate(CandidateDto candidate) {
       Candidate foundCandidate = candidateRepository.findById(candidate.getCandidate_id()).orElseThrow(() -> new NoSuchCandidateException("Candidate not found with the given ID"));
        foundCandidate.setFirstName(candidate.getFirstName());
        mergeCandidates(candidate , foundCandidate);
        Candidate updatedCandidate = candidateRepository.save(foundCandidate);
        return CandidateMapper.mapToCandidateDto(updatedCandidate);
    }

    private void mergeCandidates(CandidateDto candidate, Candidate foundCandidate) {
        if(StringUtils.isNotBlank(candidate.getFirstName())){
            foundCandidate.setFirstName(candidate.getFirstName());
        }
        if(StringUtils.isNotBlank(candidate.getLastName())){
            foundCandidate.setLastName(candidate.getLastName());
        }
        if(StringUtils.isNotBlank(candidate.getMobileNumber())){
            foundCandidate.setMobileNumber(candidate.getMobileNumber());
        }
        if(StringUtils.isNotBlank(candidate.getDepartmentName())){
            foundCandidate.setDepartmentName(candidate.getDepartmentName());
        }
        if(StringUtils.isNotBlank(candidate.getPersonalEmail())){
            foundCandidate.setPersonalEmail(candidate.getPersonalEmail());
        }
    }

    @Override
    public List<CandidateDto> getAllCandidate(Pageable paging) {
        Iterable<Candidate> candidates = candidateRepository.findAll(paging);


        List<CandidateDto> CandidatesDto = new ArrayList<>();

        candidates.forEach( candidate -> {
            CandidatesDto.add(CandidateDto
                    .builder()
                    .candidate_id(candidate.getCandidate_id())
                            .departmentName(candidate.getDepartmentName())
                            .firstName(candidate.getFirstName())
                            .lastName(candidate.getLastName())
                            .mobileNumber(candidate.getMobileNumber()).build());
        });

        return CandidatesDto;
    }

    @Override
    public CandidateDto getCandidateById(Long candidateId) {
        return null;
    }

    @Override
    public String deleteCandidateById(Long candidateId) {
        Candidate foundCandidate = candidateRepository.findById(candidateId).orElseThrow(() -> new NoSuchCandidateException("Candidate not found with the given ID"));
        candidateRepository.deleteById(foundCandidate.getCandidate_id());
        return foundCandidate != null ? "candidate with id "+candidateId+" Deleted Successfully" : null;
    }
}
