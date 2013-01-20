/**
 * 
 */
package com.ericsson.erifly.rest.client;

import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.codec.Base64;
import org.springframework.web.client.RestTemplate;

import com.ericsson.erifly.domain.Employee;


/**
 * @author Dhrubo
 *
 */
public class EmployeeTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		create();
		
		findOne();

	}

	private static void findOne() {
		// TODO Auto-generated method stub
		
	}

	private static void create() {
		String URL = "http://localhost:8080/restapi/api/v1/employee/operations/create";
		Employee e = new Employee();
		e.setFirstName("VITO");
		e.setLastName("CORLEONNE");
		
		HttpHeaders  headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.add("apikey", "api-1234");
		headers.add("salt", "hmaciscool");
		headers.add("signature", getHmac());
		
		HttpEntity req = new HttpEntity(e, headers);
		RestTemplate rest = new RestTemplate();
		ResponseEntity<Employee> result = rest.postForEntity(URL, req, Employee.class);
		System.out.println( result.getBody() );
		
	}

	private static String getHmac(){
		String secretKey = "api-pk-9999";
        String salt = "hmaciscool";
        String publicKey = "api-1234";
 
        String generateHmacSHA256Signature = null;
		try {
			generateHmacSHA256Signature = generateHmacSHA256Signature(salt, secretKey);
			 System.out.println("Signature: " + generateHmacSHA256Signature);
		} catch (GeneralSecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       
		return generateHmacSHA256Signature;
        
	}
	
	private static String generateHmacSHA256Signature(String data, String key) throws GeneralSecurityException {
        byte[] hmacData = null;
 
        try {
            SecretKeySpec secretKey = new SecretKeySpec(key.getBytes("UTF-8"), "HmacSHA256");
            Mac mac = Mac.getInstance("HmacSHA256");
            mac.init(secretKey);
            hmacData = mac.doFinal(data.getBytes("UTF-8"));
            return new String(Base64.encode(hmacData), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new GeneralSecurityException(e);
        }
    }
	
}
