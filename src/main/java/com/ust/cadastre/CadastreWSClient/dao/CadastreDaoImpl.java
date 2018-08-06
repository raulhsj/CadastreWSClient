package com.ust.cadastre.CadastreWSClient.dao;

import java.io.IOException;
import java.net.URISyntaxException;

import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;

import org.springframework.ws.WebServiceMessage;
import org.springframework.ws.client.core.WebServiceMessageCallback;
import org.springframework.ws.client.core.WebServiceMessageExtractor;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.saaj.SaajSoapMessage;
import org.w3c.dom.DOMException;


public class CadastreDaoImpl extends WebServiceGatewaySupport implements CadastreDao {

	private final String ACTION = "http://tempuri.org/OVCServWeb/OVCCallejero/Consulta_DNPRC";
	
	@Override
	public Double getSurfaceByRefCatastro(String refCatastro) throws URISyntaxException {
		
		String surface = (String)getWebServiceTemplate().sendAndReceive(getDefaultUri(), new WebServiceMessageCallback() {
			public void doWithMessage(WebServiceMessage message) {
	            try {
	            	SaajSoapMessage saajMessage = (SaajSoapMessage) message;
	            	saajMessage.setSoapAction(ACTION);
	                SOAPMessage soapmess = saajMessage.getSaajMessage();
	                SOAPEnvelope env = soapmess.getSOAPPart().getEnvelope();
	                env.addNamespaceDeclaration("cat", "http://www.catastro.meh.es/");
	                
	                env.getBody().addChildElement("RefCat", "cat").addTextNode(refCatastro.trim());
	            	
	            } catch (Exception e) {
	            	throw new RuntimeException("Marshalling exception", e);  
	            }
				
	        }
		}, new WebServiceMessageExtractor<Object>() {

			public Object extractData(WebServiceMessage response) throws IOException {
				
				SaajSoapMessage saajMessage = (SaajSoapMessage)response;
				SOAPMessage soapmess = saajMessage.getSaajMessage();
				String value;
				try {
					value = soapmess.getSOAPBody().getElementsByTagName("sfc").item(0).getTextContent();
				} catch (DOMException e) {
					throw new RuntimeException("Marshalling exception", e);
				} catch (SOAPException e) {
					throw new RuntimeException("Marshalling exception", e);
				}
				
				return value;
			}
		});
		
		System.out.println (surface);
		return Double.valueOf(surface);
	}

}
