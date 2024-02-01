package org.lsi.services;

import java.util.List;
import java.util.Optional;

import org.lsi.entities.Proprety;

public interface PropretyService {
	void addProprety(Proprety p);
	Proprety updateProprety(Long id, Proprety p);
	List<Proprety> getAll();
	Optional<Proprety> getById(Long id);
	List<Proprety> getByUserId(String id);
}
