package com.uce.edu.demo;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.repository.modelo.Producto;
import com.uce.edu.demo.repository.modelo.ReporteventasTo;
import com.uce.edu.demo.service.IGestorDetalesVentasService;
import com.uce.edu.demo.service.IProductoService;
import com.uce.edu.demo.service.IVentaService;

@SpringBootApplication
public class PruebaUnidad3AfApplication implements CommandLineRunner{
	
	private static final Logger LOG = LogManager.getLogger(PruebaUnidad3AfApplication.class.getName());

	@Autowired
	private IProductoService productoService;
	@Autowired
	private IVentaService ventaService;
	@Autowired
	private IGestorDetalesVentasService gestor;
	
	public static void main(String[] args) {
		SpringApplication.run(PruebaUnidad3AfApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Producto productoIngreso=new Producto();
		productoIngreso.setCodigoBarras("A1235");
		productoIngreso.setNombre("Chocolate");
		productoIngreso.setCategoria("Dulces");
		productoIngreso.setStock(100);
		productoIngreso.setPrecio(new BigDecimal(1.5));
		
		this.productoService.ingresarProducto(productoIngreso);
		LOG.info("Producto ingresado o actualizado.");
		
		List<Producto> productos=new ArrayList<Producto>();
		Producto productorCompra=new Producto();
		productorCompra.setCodigoBarras("A1235");
		productorCompra.setNombre("Chocolate");
		productorCompra.setStock(10);
		productos.add(productorCompra);
		
		this.ventaService.realizarVenta(productos, "1752310126", "2");
		LOG.info("Venta realizada.");
		
		LOG.info("Buscar producto: "+this.productoService.buscar("A1235"));
		
		LOG.info("Reporte:");
		//List<ReporteventasTo> reporte= this.gestor.reporteVentas(LocalDateTime.now().minusDays(1), "Dulces", 5);
		//reporte.stream().forEach(rep -> {LOG.info("Reporte: "+rep);});
	}

}
