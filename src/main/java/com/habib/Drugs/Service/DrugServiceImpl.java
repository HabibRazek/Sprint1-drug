package com.habib.Drugs.Service;

import com.habib.Drugs.entities.Drug;
import com.habib.Drugs.repos.DrugRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DrugServiceImpl implements DrugService{
    @Autowired
    private DrugRepository drugRepository;
    @Override
    public Drug saveDrug(Drug d) {
        return drugRepository.save(d);
    }

    @Override
    public Drug updateDrug(Drug d) {
        return drugRepository.save(d);
    }

    @Override
    public void deleteDrug(Drug d) {
    drugRepository.delete(d);
    }

    @Override
    public void deleteDrugById(Long id) {
    drugRepository.deleteById(id);
    }

    @Override
    public Drug getDrug(Long id) {
        return drugRepository.findById(id).get();
    }

    @Override
    public List<Drug> getAllDrugs() {
        return drugRepository.findAll();
    }

    @Override
    public Page<Drug> getAllDrugsParPage(int page, int size) {
        return drugRepository.findAll(PageRequest.of(page, size));

    }
}
