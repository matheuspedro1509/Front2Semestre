package br.com.fiap.dao.impl;

import org.springframework.stereotype.Repository;

import br.com.fiap.dao.MarcaDAO;
import br.com.fiap.model.Marca;

@Repository
public class MarcaDAOImpl 
					extends GenericDAOImpl<Marca,Integer>
							implements MarcaDAO{

}
