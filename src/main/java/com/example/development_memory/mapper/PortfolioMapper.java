package com.example.development_memory.mapper;

import com.example.development_memory.dto.PortfolioDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PortfolioMapper {
    void saveInsert(PortfolioDTO portfolioDTO);

}
