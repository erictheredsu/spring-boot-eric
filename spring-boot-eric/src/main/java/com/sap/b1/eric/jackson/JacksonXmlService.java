package com.sap.b1.eric.jackson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.sap.b1.eric.ODataMeta.*;
import com.sap.b1.eric.utils.ResourceLoader;

@Service
public class JacksonXmlService {

	public Object loadMetadata() {

		Resource res = ResourceLoader.loadFile("xmlToParse/metatdata-simply2.xml");
		StringBuilder sb = new StringBuilder();
		ODataMetaEdmx obj = null;

		try {
			InputStream is = res.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			String line;
			while ((line = br.readLine()) != null) {
				sb.append(line);
			}
			br.close();

		    obj = convertToPojo(sb.toString());

		} catch (IOException e) {
			e.printStackTrace();
		}

		return obj;
	}

	private ODataMetaEdmx convertToPojo(String xml) {
		ODataMetaEdmx edmx = null;
		// List<ODataMetaDataProperty> udfs = new ArrayList<>();
		try {
			XmlMapper mapper = new XmlMapper();
			mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			edmx = mapper.readValue(xml, ODataMetaEdmx.class);
			for (ODataMetaDataEntityType bizObject : edmx.services.schema.entityTypes) {
				
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return edmx;
	}

//	private static String convertToXml(ODataMetaEdmx root) {
//		try {
//			XmlMapper mapper = new XmlMapper();
//			mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
//			edmx = mapper.readValue(xml, ODataMetaEdmx.class);
//			for (ODataMetaDataEntityType bizObject : edmx.services.schema.entityTypes) {
//
//			}
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
}
