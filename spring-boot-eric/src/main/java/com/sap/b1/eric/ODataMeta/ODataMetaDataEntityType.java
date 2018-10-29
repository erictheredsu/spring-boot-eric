package com.sap.b1.eric.ODataMeta;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ODataMetaDataEntityType {
    @JacksonXmlProperty(localName = "Property")
    @JacksonXmlElementWrapper(useWrapping = false)
    public List<ODataMetaDataProperty> properties;

    @JacksonXmlProperty(isAttribute = true)
    public String Name;
}