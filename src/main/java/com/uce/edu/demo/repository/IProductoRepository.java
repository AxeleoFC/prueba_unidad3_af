package com.uce.edu.demo.repository;

import java.util.List;

import com.uce.edu.demo.repository.modelo.Producto;

public interface IProductoRepository {
	
	public void ingresar(Producto p);
	public void actualizar(Producto p);
	public Producto buscar(String codigoBarras);
	public boolean buscarProductoExistente(String codigoBarras);
	public List<Producto> buscarPorCategoria(String categoria);

}
