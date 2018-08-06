package com.ust.cadastre.CadastreWSClient;

import static org.junit.Assert.assertNotNull;

import java.net.URISyntaxException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.ust.cadastre.CadastreWSClient.dao.CadastreDao;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=CadastreWsClientApplication.class)
public class CadastreWSTest {

	@Autowired
	CadastreDao cadastreDao;	
	
	@Test
	public void catastreWSTest() throws URISyntaxException {
		Double surface = cadastreDao.getSurfaceByRefCatastro("0768705VK4706H0005LD");
		assertNotNull(surface);
	}
}
