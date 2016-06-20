package org.kisti.edison.wfapi.custom;


import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.w3c.dom.Document;

public class Transformer {
  
  public static <T> String pojo2Xml(T t){
    String result = "";
    StringWriter sw = new StringWriter();
    try{
      JAXBContext context = JAXBContext.newInstance(t.getClass());
      Marshaller marshaller = context.createMarshaller();
      marshaller.marshal(t, sw);
      result = sw.toString();
    }catch(JAXBException e){
      throw new RuntimeException(e);
    }
    return result;
  }
  
  public static <T> T xml2Pojo(String xml, Class<T> clazz){
    return  xml2Pojo(xml.getBytes(), clazz);
  }
  
  public static <T> T xml2Pojo(byte[] xml, Class<T> clazz){
    return  xml2Pojo(new ByteArrayInputStream(xml), clazz);
  }
  
  @SuppressWarnings("unchecked")
  public static <T> T xml2Pojo(InputStream xml, Class<T> clazz){
    T t = null;
    try {
      JAXBContext context = JAXBContext.newInstance(clazz);
      Unmarshaller unmarshaller = context.createUnmarshaller();
      t = (T) unmarshaller.unmarshal(xml);
    } catch (JAXBException e) {
      throw new RuntimeException(e);
    }
    return t;
  }
  
  @SuppressWarnings("unchecked")
  public static <T> T xml2Pojo(Document xml, Class<T> clazz){
    T t = null;
    try {
      JAXBContext context = JAXBContext.newInstance(clazz);
      Unmarshaller unmarshaller = context.createUnmarshaller();
      t = (T) unmarshaller.unmarshal(xml);
    } catch (JAXBException e) {
      throw new RuntimeException(e);
    }
    return t;
  }
  
  public static <T> T json2Pojo(JsonNode json, Class<T> clazz){
    T t = null;
    try {
      t = (T) new ObjectMapper().configure(org.codehaus.jackson.map.DeserializationConfig.Feature.UNWRAP_ROOT_VALUE, true).readValue(json, clazz);
    } catch (JsonParseException e) {
      throw new RuntimeException(e);
    } catch (JsonMappingException e) {
      throw new RuntimeException(e);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
    return t; 
  }
  
  public static <T> T json2Pojo(String json, Class<T> clazz){
    T t = null;
    try {
      t = (T) new ObjectMapper().configure(org.codehaus.jackson.map.DeserializationConfig.Feature.UNWRAP_ROOT_VALUE, true).readValue(json, clazz);
    } catch (JsonParseException e) {
      throw new RuntimeException(e);
    } catch (JsonMappingException e) {
      throw new RuntimeException(e);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
    return t; 
  }
  
  public static <T> JsonNode pojo2Json(T t){
    return new ObjectMapper().configure(org.codehaus.jackson.map.SerializationConfig.Feature.WRAP_ROOT_VALUE, true).valueToTree(t);
  }
  
  public static JsonNode string2Json(String src){
    ObjectMapper mapper = new ObjectMapper();
    JsonFactory factory = mapper.getJsonFactory();
    JsonParser jp = null;
    JsonNode json = null;
    try {
      jp = factory.createJsonParser(src);
      json = mapper.readTree(jp);
    } catch (JsonParseException e) {
      throw new RuntimeException(e);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
    return json;
  }
  
  public static JsonNode inputSteam2Json(InputStream is){
    ObjectMapper mapper = new ObjectMapper();
    JsonFactory factory = mapper.getJsonFactory();
    JsonParser jp = null;
    JsonNode json = null;
    try {
      jp = factory.createJsonParser(is);
      json = mapper.readTree(jp);
    } catch (JsonParseException e) {
      throw new RuntimeException(e);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
    return json;
  }
}