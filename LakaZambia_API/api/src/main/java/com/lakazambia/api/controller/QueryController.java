package com.lakazambia.api.controller;

import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.RestController;

import com.lakazambia.api.datafetcher.AdvertisementDataFetcher;
import com.lakazambia.api.datafetcher.CategoryDataFetcher;
import com.lakazambia.api.datafetcher.UserDataFetcher;

import graphql.GraphQL;
import graphql.schema.idl.TypeDefinitionRegistry;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import graphql.ExecutionResult;


import graphql.schema.GraphQLSchema;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;


@RestController
@PropertySource("classpath:db.properties")
public class QueryController {
	
	
	private final Logger LOGGER=LoggerFactory.getLogger(QueryController.class);
	
	@Value("classpath:/schema.graphqls")
	private Resource schemaResource;
	
	
	@Value("${schema.file}")
	public String schemaFile;
	
	private GraphQL graphQL;
	
	@Autowired
	private UserDataFetcher userdatafetcher;
	
	@Autowired
	private CategoryDataFetcher categorydatafetcher;
	
	@Autowired
	private AdvertisementDataFetcher advertisentdatafetcher;
	
	@SuppressWarnings({ "static-access", "deprecation" })
	@PostConstruct
	public void loadSchema() throws IOException
	{
		/*ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource(schemaFile).getFile());*/
		//Resource resource = new ClassPathResource(schemaFile);
		 InputStream is = schemaResource.getInputStream();
         BufferedReader br = new BufferedReader(new InputStreamReader(is));
	//	File schemraFile=schemaResource.getInputStream();
		System.out.println("File Name :: " +schemaFile);
		TypeDefinitionRegistry typeRegistry=new SchemaParser().parse(br);
		RuntimeWiring wiring =buildRuntimeWiring();
		GraphQLSchema schema=new SchemaGenerator().makeExecutableSchema(typeRegistry, wiring);
		graphQL=new GraphQL(schema).newGraphQL(schema).build();


	}

	private RuntimeWiring buildRuntimeWiring() {
		// TODO Auto-generated method stub
		return RuntimeWiring.newRuntimeWiring()
	           // .scalar(CustomScalar)
	            .type("Query", typeWiring -> typeWiring
	                    .dataFetcher("allUsers", userdatafetcher)
	                    .dataFetcher("AllCategory",categorydatafetcher)
	                    .dataFetcher("AllAds", advertisentdatafetcher)).build();
	}
	
	@SuppressWarnings("rawtypes")
	@RequestMapping(value="/query",method=RequestMethod.POST)
	public ResponseEntity query(@RequestBody String query)
	{
		System.out.println("Query ::\n"+query);
		ExecutionResult result=graphQL.execute(query);
		System.out.println("Query Execute......");
		LOGGER.info(String.valueOf(result.getErrors()));
		System.out.println("Query Execute......" +result.getData());
		LOGGER.info("Query of GRAPHQL");
		return ResponseEntity.ok(result.getData());
	}


}
