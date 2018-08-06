package com.ust.cadastre.CadastreWSClient.controller;

import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.ust.cadastre.CadastreWSClient.service.CadastreFindService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class CadastreAPIImpl implements CadastreAPI{

	@Autowired
	CadastreFindService cadastreFindService;
	
	@Override
	@ApiOperation(value = "get surface by cadastreRef", 
	response = Double.class, nickname = "findByCadastreRef", 
	httpMethod = "GET", produces = MediaType.APPLICATION_JSON_VALUE, tags= {"surface"})
	@ApiResponses({ @ApiResponse(code = 200, message = "surface") })
	@GetMapping(path = "/surface/{cadastreRef}")
	public Double findByCadastreRef(@ApiParam(value="Cadastre Ref") 
						@PathVariable(required=true) String cadastreRef) throws URISyntaxException {
		return cadastreFindService.getSurfaceByCadastreRef(cadastreRef);
	}

}
