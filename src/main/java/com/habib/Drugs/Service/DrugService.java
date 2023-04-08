package com.habib.Drugs.Service;

import com.habib.Drugs.entities.Drug;
import org.springframework.data.domain.Page;

import java.util.List;

public interface DrugService {
    Drug saveDrug(Drug d);
    Drug updateDrug(Drug d);
    void deleteDrug(Drug d);
    void deleteDrugById(Long id);
    Drug getDrug(Long id);
    List<Drug> getAllDrugs();
    Page<Drug> getAllDrugsParPage(int page, int size);

}
