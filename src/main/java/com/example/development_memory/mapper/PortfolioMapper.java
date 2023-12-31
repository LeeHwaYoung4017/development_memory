package com.example.development_memory.mapper;

import com.example.development_memory.dto.PortfolioDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PortfolioMapper {
    void saveInsert(PortfolioDTO portfolioDTO);

    List<PortfolioDTO> portfolioList();

    PortfolioDTO readView(String num);

    void readCountUp(String num);

    void deletePortfolio(String num);

    void updateSuccess(PortfolioDTO portfolioDTO);

}