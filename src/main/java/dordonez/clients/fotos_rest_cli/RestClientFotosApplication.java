package dordonez.clients.fotos_rest_cli;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Base64;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class RestClientFotosApplication implements ApplicationRunner {
	private static final String BASE_URL = "http://localhost:8080"; 
	private RestTemplate client = new RestTemplate();
	
	public static void main(String[] args) {
		SpringApplication.run(RestClientFotosApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		testSendFoto();
		testGetList();
		testGetById(1);
	}
	
	private void testSendFoto() throws Exception {
		Foto foto = new Foto();
		foto.setTitulo("dog01.jpg");
		foto.setDescripcion("Perro de prueba 01");
		byte[] bytes = Files.readAllBytes(Paths.get("dog01.jpg"));
		foto.setFotoB64(Base64.getEncoder().encodeToString(bytes));
		
		ResponseEntity<?> response = client.postForEntity(BASE_URL + "/create", foto, HttpEntity.class);
		System.out.println(response);
	}

	private void testGetList() {
		Object[] listado = client.getForObject(BASE_URL + "/fotos/list", Object[].class);
		System.out.println(Arrays.toString(listado));
	}
	
	private void testGetById(int id) throws Exception {
		Foto foto = client.getForObject(BASE_URL + "/fotos/" + id, Foto.class);
		System.out.println(foto);
		
		byte[] decodedBytes = Base64.getDecoder().decode(foto.getFotoB64());
		Path path = Paths.get("C:\\Users\\ordon\\Downloads\\myfile.jpg");
		Files.write(path, decodedBytes);
	}
	
}
