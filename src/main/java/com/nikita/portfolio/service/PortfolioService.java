package com.nikita.portfolio.service;

import com.nikita.portfolio.entity.Portfolio;
import com.nikita.portfolio.repository.PortfolioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PortfolioService {

    private final PortfolioRepository repository;

    public PortfolioService(PortfolioRepository repository) {
        this.repository = repository;
    }

    public Portfolio savePortfolio(Portfolio portfolio) {
        return repository.save(portfolio);
    }

    public List<Portfolio> getAllPortfolios() {
        return repository.findAll();
    }
}
