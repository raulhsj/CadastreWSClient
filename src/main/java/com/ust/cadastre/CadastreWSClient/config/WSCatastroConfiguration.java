package com.ust.cadastre.CadastreWSClient.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

import com.ust.cadastre.CadastreWSClient.dao.CadastreDao;
import com.ust.cadastre.CadastreWSClient.dao.CadastreDaoImpl;

@Configuration
public class WSCatastroConfiguration {

	@Bean
	public Jaxb2Marshaller marshaller() {
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		// this package must match the package in the <generatePackage> specified in
		// pom.xml
		marshaller.setContextPath("com.ust.calc.cadastre.wsdlstub");
		return marshaller;
	}

	@Bean
	public CadastreDao countryClient(Jaxb2Marshaller marshaller) {
		CadastreDaoImpl client = new CadastreDaoImpl();
		client.setDefaultUri("http://ovc.catastro.meh.es/ovcservweb/ovcswlocalizacionrc/ovccallejero.asmx");
		return client;
	}

}