package com.sap.b1.eric.ODataMeta;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ODataMetaDataServices {
    @JacksonXmlProperty(localName = "Schema")
    public ODataMetaDataSchema schema;
}
