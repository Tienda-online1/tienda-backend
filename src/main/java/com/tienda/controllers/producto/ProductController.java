package com.tienda.controllers.producto;

import com.tienda.domain.dtos.ProductoDto;
import com.tienda.services.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/v1/producto")
@CrossOrigin(origins = "*")
public class ProductController {

    @Autowired
    private ProductoService productoService;

    @GetMapping
    public ResponseEntity<List<ProductoDto>> getProductos(){
        return ResponseEntity.ok(this.productoService.getAllProducts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductoDto> getProducto(@PathVariable Long id){
        return this.productoService.getById(id)
                .map(ResponseEntity::ok)
                .orElseGet(()-> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ProductoDto> createProduct(@RequestBody ProductoDto product) {
        return ResponseEntity.ok(productoService.createProduct(product));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductoDto> updateProduct(@PathVariable Long id, @RequestBody ProductoDto productDetails) {
        return ResponseEntity.ok(productoService.updateProduct(id, productDetails));
    }

    @PostMapping("/{id}/addStock")
    public ResponseEntity<ProductoDto> addStock(@PathVariable Long id, @RequestParam int additionalStock) {
        return new ResponseEntity<>(productoService.addStock(id, additionalStock), HttpStatus.OK);
    }

    @GetMapping("/available")
    public ResponseEntity<List<ProductoDto>> getAvailableProducts() {
        return new ResponseEntity<>(productoService.getAvailableProducts(), HttpStatus.OK);
    }

    @PostMapping("/purchase")
    public void purchaseProducts(@RequestBody List<ProductoDto> productos) {
        productoService.purchaseProducts(productos);
    }
}
