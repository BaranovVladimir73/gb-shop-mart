package ru.gb.gbshopproject.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.gb.gbapi.product.api.ProductGateway;
import ru.gb.gbapi.product.dto.ProductDto;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {

    private final ProductGateway productGateway;

    public void save(ProductDto productDto) {
        if (productDto.getId() != null) {
            productGateway.handleUpdate(productDto.getId(), productDto);
        } else {
            productGateway.handlePost(productDto);
        }
    }

    public ProductDto findById(Long id) {
        return productGateway.getProduct(id).getBody();
    }

    public List<ProductDto> findAll() {
        return productGateway.getProductList();
    }

    public void deleteById(Long id) {
        productGateway.deleteById(id);
    }
}
