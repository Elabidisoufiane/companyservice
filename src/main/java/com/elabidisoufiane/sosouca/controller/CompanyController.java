package com.elabidisoufiane.sosouca.controller;

import java.util.List;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.elabidisoufiane.sosouca.service.CompanyService;
import com.elabidisoufiane.sosouca.dto.CompanyResponseDto;
import com.elabidisoufiane.sosouca.dto.CompanyRequestDto;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/company")
@CrossOrigin(origins = "http://localhost:3000")

public class CompanyController {

	private final CompanyService service;

	public CompanyController(CompanyService service) {
		this.service = service;
	}

	@GetMapping("/companies")
	public ResponseEntity<List<CompanyResponseDto>> getJobOffers() {
		// return service.findAll();
		return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
	}

	@PostMapping("/addCompany")
	public ResponseEntity<CompanyResponseDto> save(@Valid @ModelAttribute CompanyRequestDto request) {

		CompanyResponseDto dto = service.save(request);
		return new ResponseEntity<>(dto, HttpStatus.CREATED);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<CompanyResponseDto> update(@Valid @RequestBody CompanyRequestDto companyDto,
			@PathVariable Integer id) throws NotFoundException {
		CompanyResponseDto dto = service.update(companyDto, id);
		return ResponseEntity.accepted().body(dto);
	}

	@GetMapping("/id/{id}")
	public ResponseEntity<CompanyResponseDto> findById(@PathVariable Integer id) {
		CompanyResponseDto dto = service.findById(id);
		return ResponseEntity.ok(dto);
	}

	@GetMapping("/name/{name}")
	public CompanyResponseDto findByTitle(@PathVariable String title) {
		return service.findByName(title);
	}

	@DeleteMapping("/id/{id}")
	public ResponseEntity<?> delet(@PathVariable Integer id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

}
