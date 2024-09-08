package com.encora.flightapp;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import io.swagger.client.model.Success;
import net.bytebuddy.asm.Advice;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestClient;

import java.io.IOException;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class FlightappApplicationTests {


	@Value("${api.url.test}")
	private String url;

	@Value("${api.credential.secret")
	private String credential;

	@Value("${api.credential.id}")
	private String id;


	RestClient getClient(){

		return RestClient.builder().baseUrl(url).build();
	}

	ObjectMapper getMapper(){
		ObjectMapper objectMapper = new ObjectMapper();

		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
		objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
		objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

		objectMapper.registerModule(new JavaTimeModule());
		SimpleModule simpleModule = new SimpleModule();


		simpleModule.addDeserializer(LocalDate.class, new JsonDeserializer<LocalDate>() {

			private static final DateTimeFormatter formatter =
					DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");


			@Override
			public LocalDate deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JacksonException {
				String date = p.getText();

				return LocalDate.parse(date, formatter);

			}

		});


		objectMapper.registerModule(simpleModule);

		return objectMapper;
	}

	@Test
	void testMapper() {
		RestClient client = getClient();


		String data = client.get().uri(url + "/v2/shopping/flight-offers").retrieve().body(String.class);

		ObjectMapper mapper = getMapper();

		try{
			Success success = mapper.readValue(data, Success.class);

			System.out.println(success.toString());


		} catch (Exception e) {
			throw new RuntimeException(e);
		}



		assertEquals(3,3);



	}



}
