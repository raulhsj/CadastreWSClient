package com.ust.cadastre.CadastreWSClient.controller;

import java.net.URISyntaxException;

public interface CadastreAPI {

	public Double findByCadastreRef(String cadastreRef) throws URISyntaxException;
}
