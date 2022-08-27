package com.uce.edu.demo.service;

import com.uce.edu.demo.repository.modelo.Producto;

public interface IProductoService {
	
	public void ingresarProducto(Producto p);
	public Producto buscar(String codigoBarras);

}
