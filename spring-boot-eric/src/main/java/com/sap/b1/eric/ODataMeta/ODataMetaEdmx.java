package com.sap.b1.eric.ODataMeta;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(localName = "Edmx")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ODataMetaEdmx {
    @JacksonXmlProperty(localName = "DataServices")
    public ODataMetaDataServices services;
}