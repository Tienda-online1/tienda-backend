package com.tienda.controllers.venta;

import com.tienda.domain.dtos.VentaDto;
import com.tienda.services.VentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/v1/venta")
@CrossOrigin(origins = "*")
public class VentaController {

    @Autowired
    private VentaService ventaService;

    @GetMapping
    public ResponseEntity<List<VentaDto>> getVentas(){
        return ResponseEntity.ok(this.ventaService.obtenerVentas());
    }

    @PostMapping
    public ResponseEntity<VentaDto> saveVentas(@RequestBody VentaDto ventaDto){
        return ResponseEntity.ok(this.ventaService.realizarVenta(ventaDto));
    }
}
