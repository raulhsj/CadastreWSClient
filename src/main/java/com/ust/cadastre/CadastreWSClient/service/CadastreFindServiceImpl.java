package com.ust.cadastre.CadastreWSClient.service;

import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ust.cadastre.CadastreWSClient.dao.CadastreDao;

@Service
public class CadastreFindServiceImpl implements CadastreFindService{

	@Autowired
	CadastreDao cadastreDao;

	@Override
	public Double findByCadastreRef(String cadastreRef) throws URISyntaxException {
		return cadastreDao.getSurfaceByRefCatastro(cadastreRef);
	}

}
