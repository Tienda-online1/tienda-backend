package com.tienda.services;


import com.tienda.domain.dtos.ProductoDto;
import com.tienda.domain.entities.ProductoEntity;
import com.tienda.domain.mappers.ProductoMapper;
import com.tienda.domain.repository.ProductoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private ProductoMapper productoMapper;

    public List<ProductoDto> getAllProducts() {
        List<ProductoEntity> productos = (List<ProductoEntity>) this.productoRepository.findAll();
        return this.productoMapper.productosToDtos(productos);
    }

    public Optional<ProductoDto> getById(Long id) {
        return this.productoRepository.findById(id).map(productoMapper::productToDto);
    }

    public ProductoDto createProduct(ProductoDto productoDto) {
        ProductoEntity productoEntity = this.productoMapper.productoDtoToProducto(productoDto);
        return this.productoMapper.productToDto(productoRepository.save(productoEntity));
    }

    public ProductoDto updateProduct(Long id, ProductoDto productoDetalles) {
        ProductoEntity producto = productoRepository.findById(id).orElseThrow();
        producto.setNombre(productoDetalles.getNombre());
        producto.setDescripcion(productoDetalles.getDescripcion());
        producto.setValor(productoDetalles.getValor());
        producto.setStock(productoDetalles.getStock());
        return this.productoMapper.productToDto(productoRepository.save(producto));
    }

    public ProductoDto addStock(Long id, int stockAdicional) {
        ProductoEntity producto = productoRepository.findById(id).orElseThrow();
        producto.setStock(producto.getStock() + stockAdicional);
        return this.productoMapper.productToDto(productoRepository.save(producto));
    }

    public List<ProductoDto> getAvailableProducts() {
        List<ProductoEntity> list = ((List<ProductoEntity>) productoRepository.findAll()).stream()
                .filter(product -> product.getStock() > 0)
                .toList();
        return this.productoMapper.productosToDtos(list);
    }

    public void purchaseProducts(List<ProductoDto> listaProductos) {
        double totalValue = 0;
        for (ProductoDto iter : listaProductos) {
            ProductoEntity producto = productoRepository.findById(iter.getId()).orElseThrow();
            if (producto.getStock() > 0) {
                producto.setStock(producto.getStock() - 1);
                totalValue += producto.getValor();
                productoRepository.save(producto);
            }
        }
        log.info("Total value of purchase: ${}", totalValue);
    }
}

