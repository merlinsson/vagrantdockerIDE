package de.oss.dockerdui.rest;


public class Tester2 {

	public static void main(String[] args) {
		// RestTemplate restTemplate = new RestTemplate();
		// Catalog catalog =
		// restTemplate.getForObject("http://localhost:5000/v2/_catalog",
		// Catalog.class);
		// System.out.println("iam here");
		// ObjectMapper mapper = new ObjectMapper();
		// List<Catalog> aarList = new ArrayList<Catalog>();
		// String json =
		// restTemplate.getForObject("http://localhost:5000/v2/_catalog",
		// String.class);
		// aarList = mapper.readValue(json, new TypeReference<List<Catalog>>()
		// {});
		// System.out.println("klappt");
//		RestTemplate restTemplate = new RestTemplate();
//		restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
//		// restTemplate.getMessageConverters().add(new
//		// StringHttpMessageConverter());
//
//		String fooResourceUrl = "http://localhost:2375/v2/_catalog";
//		// ResponseEntity<String> response =
//		// restTemplate.getForEntity(fooResourceUrl, String.class);
//		// System.out.println(response.getBody().toString());
//
//		Catalog foo = restTemplate.getForObject(fooResourceUrl, Catalog.class);
//
//		for (String string : foo.getRepositories()) {
//			Repository repro = restTemplate.getForObject("http://localhost:5000/v2/" + string + "/tags/list",
//					Repository.class);
//			for (String string2 : repro.getTags()) {
//				System.out.println(repro.getName());
//				System.out.println(string2);
//			}
//		}
//
//		String library = restTemplate.getForObject("http://localhost:5000/v2/ubuntu/manifests/latest", String.class);
//		System.out.println(library);
//	}

}}
