package org.lsi.services;

import java.util.List;
import java.util.Optional;

import org.lsi.entities.Proprety;
import org.lsi.repository.PropretyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PropretyServiceImpl implements PropretyService {

	@Autowired
	PropretyRepository propRep;

	@Override
	public void addProprety(Proprety p) {
		propRep.save(p);
	}

/*	@Override
	public Proprety updateProprety(Long id, Proprety p) {
		//Proprety existingProprety = propRep.findById(id).orElse(null);
		Proprety existingProprety = propRep.findById(id);
		if (existingProprety != null) {
			existingProprety.setOwner(p.getOwner());
			existingProprety.setDesc(p.getDesc());
		//	existingProprety.setTypePrp(p.getTypePrp());
			propRep.save(existingProprety);
		}
		return existingProprety;
	}
*/

	@Override
	public Proprety updateProprety(Long id, Proprety p) {
		Optional<Proprety> optionalExistingProprety = propRep.findById(id);

		if (optionalExistingProprety.isPresent()) {
			Proprety existingProprety = optionalExistingProprety.get();
			existingProprety.setOwner(p.getOwner());
			existingProprety.setDesc(p.getDesc());
			// existingProprety.setTypePrp(p.getTypePrp());
			propRep.save(existingProprety);
			return existingProprety;
		} else {
			// Handle the case where the property with the given ID is not found
			return null; // or throw an exception, or handle it according to your requirements
		}
	}











	@Override
	public List<Proprety> getAll() {
		return propRep.findAll();
	}

	@Override
	public Optional<Proprety> getById(Long id) {
		return propRep.findById(id);
	}

	//@Override
	public List<Proprety> getByUserId(Long id) {
		return propRep.findByOwnerId(id);
	}
}
