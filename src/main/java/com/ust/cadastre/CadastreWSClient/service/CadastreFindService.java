package com.ust.cadastre.CadastreWSClient.service;

import java.net.URISyntaxException;

public interface CadastreFindService {

	public Double findByCadastreRef(String cadastreRef) throws URISyntaxException;
}
