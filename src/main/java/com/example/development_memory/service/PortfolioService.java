package com.example.development_memory.service;

import com.example.development_memory.dto.PortfolioDTO;
import com.example.development_memory.mapper.PortfolioMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PortfolioService {

    @Autowired
    private PortfolioMapper portfolioMapper;

    @Transactional
    public void saveInsert(PortfolioDTO portfolioDTO) {
        portfolioMapper.saveInsert(portfolioDTO);
    }

}
