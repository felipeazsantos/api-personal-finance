package com.felipeazsantos.api_personal_finance.service;

import com.felipeazsantos.api_personal_finance.model.Entry;
import com.felipeazsantos.api_personal_finance.repository.EntryRepository;
import org.springframework.stereotype.Service;

@Service
public class EntryService {

    private final EntryRepository entryRepository;

    public EntryService(EntryRepository entryRepository) {
        this.entryRepository = entryRepository;
    }

    public Entry createEntry(Entry entry) {
        return entryRepository.save(entry);
    }
}
