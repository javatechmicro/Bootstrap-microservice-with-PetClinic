package com.apssouza.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.apssouza.entities.Vets;
import com.apssouza.exceptions.DataNotFoundException;
import com.apssouza.repositories.VetsRepository;

/**
 * @see VetsService
 * @author Mohammad
 */
@Service
public class VetsServiceImpl implements VetsService {

	@Autowired
	private VetsRepository vetsRepository;

	@Override
	public Optional<Vets> findById(long id) {
		return Optional.ofNullable(this.vetsRepository.findOne(id));
	}

	@Override
	public List<Vets> all() {
		return this.vetsRepository.findAll();
	}

	@Override
	public Vets save(Vets vets) {
		return this.vetsRepository.save(vets);
	}

	@Override
	public Vets update(Long id, Vets vet) throws DataNotFoundException {
		return this.findById(id).map(u -> {
			u.setName(vet.getName());
			return save(u);
		}).orElseThrow(() -> new DataNotFoundException("User not found"));
	}

	@Override
	public Optional<Vets> findByName(String name) {
		return vetsRepository.findByName(name);
	}

	@Override
	public void delete(Vets vet) {
		vetsRepository.delete(vet);
	}
}
