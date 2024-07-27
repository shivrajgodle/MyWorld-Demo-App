package com.kpit.myworld.candidate.controller;

import com.kpit.myworld.candidate.dto.CandidateDto;
import com.kpit.myworld.candidate.service.impl.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/candidate")
public class CandidateController {

    @Autowired
    private CandidateService candidateService;


    @PostMapping("/addCandidate")
    public ResponseEntity<CandidateDto> addCandidate(@RequestBody CandidateDto candidate){
        CandidateDto candidateDto = candidateService.addCandidate(candidate);
        return new ResponseEntity<CandidateDto>(candidateDto,HttpStatus.CREATED);
    }

    @GetMapping("/getAllCandidates")
    public ResponseEntity<List<CandidateDto>> getAllCandidates(@RequestParam(defaultValue = "4", required = false)
                                                                   Integer pageSize,
                                                               @RequestParam(defaultValue = "0", required = false)
                                                                   Integer page) throws Exception {
        Pageable paging  = PageRequest.of(page, pageSize);
        List<CandidateDto> candidateDto = candidateService.getAllCandidate(paging);
        return new ResponseEntity<List<CandidateDto>>(candidateDto,HttpStatus.CREATED);
    }


    @PutMapping("/editCandidate")
    public ResponseEntity<CandidateDto> editCandidate(@RequestBody CandidateDto candidate){
        CandidateDto candidateDto = candidateService.updateCandidate(candidate);
        return new ResponseEntity<CandidateDto>(candidateDto,HttpStatus.CREATED);
    }

    @DeleteMapping("/{candidate_id}")
    public ResponseEntity<String> deleteCandidate(@PathVariable Long candidate_id){
        return new ResponseEntity<String>(candidateService.deleteCandidateById(candidate_id),HttpStatus.OK);
    }

}
