package com.gradecak.alfresco.mvc.sample.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.gradecak.alfresco.mvc.annotation.AlfrescoTransaction;
import com.gradecak.alfresco.mvc.sample.service.QueryTemplateService;

/**
 * shows how to use the Alfresco @MVC framework
 */

@Controller
@RequestMapping("/querytemplate")
public class AlfrescoMvcQueryTemplateController {

  @Autowired
  private QueryTemplateService service;  
                    
  @AlfrescoTransaction(readOnly = true)
  @RequestMapping(value = "sample", method = { RequestMethod.GET })
  public ResponseEntity<?> sample() throws IOException {
	return new ResponseEntity<>(service.getCompanyHomeFolder(), HttpStatus.OK);
  }
  
  @AlfrescoTransaction(readOnly = true)
  @RequestMapping(value = "search", method = { RequestMethod.GET })
  public ResponseEntity<?> search() throws IOException {
    return new ResponseEntity<>(service.search(), HttpStatus.OK);
  }
  
}
