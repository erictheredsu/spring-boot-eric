package com.sap.b1.eric.ODataMeta;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(localName = "Property")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ODataMetaDataProperty {
    @JacksonXmlProperty(isAttribute = true)
    public String Name;

    @JacksonXmlProperty(isAttribute = true)
    public String Type;

    @JacksonXmlProperty(isAttribute = true)
    public String Nullable;

    @JacksonXmlProperty(isAttribute = true)
    public String MaxLength;

    @JacksonXmlProperty(isAttribute = true)
    public String FixedLength;
}