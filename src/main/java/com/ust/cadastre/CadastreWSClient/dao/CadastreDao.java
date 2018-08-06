package com.ust.cadastre.CadastreWSClient.dao;

import java.net.URISyntaxException;

public interface CadastreDao {

	public Double getSurfaceByRefCatastro(String refCatastro) throws URISyntaxException;
}
