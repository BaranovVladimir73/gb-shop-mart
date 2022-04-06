package ru.gb.gbexternalapi.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.gb.gbapi.manufacturer.api.ManufacturerGateway;
import ru.gb.gbapi.manufacturer.dto.ManufacturerDto;
import ru.gb.gbapi.product.api.ProductGateway;
import ru.gb.gbapi.product.dto.ProductDto;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/list-products")
public class ShopController {

    private final ProductGateway productGateway;
    private final ManufacturerGateway manufacturerGateway;

    @GetMapping
    List<ProductDto> getProductList(){
        return productGateway.getProductList();
    }

    @GetMapping("/manufacturers")
    List<ManufacturerDto> getManufacturerList(){
        return manufacturerGateway.getManufacturerList();
    }

}
