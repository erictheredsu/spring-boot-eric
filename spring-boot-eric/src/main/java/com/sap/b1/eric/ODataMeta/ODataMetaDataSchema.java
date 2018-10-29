package com.sap.b1.eric.ODataMeta;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ODataMetaDataSchema {
    @JacksonXmlProperty(localName = "EntityType")
    @JacksonXmlElementWrapper(useWrapping = false)
    public List<ODataMetaDataEntityType> entityTypes;
}