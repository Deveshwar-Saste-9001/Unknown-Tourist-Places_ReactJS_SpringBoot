package com.example.unknownplaces.controllers;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.unknownplaces.model.Places;
import com.example.unknownplaces.servises.PlaceService;

@RestController
@CrossOrigin
public class PlaceController {
	
	@Autowired
	private PlaceService placeservice;

	private String getPathOfUser() throws IOException{
		return "C:\\Users\\deveshwar\\Desktop\\CDAC_MAY_2021\\Adv_Java\\spring_workspace\\unknown_places\\src\\main\\resources\\static\\image\\";
	}

	@PostMapping("/addplace")
	public String addPlaces(@RequestParam("placename") String placename,
			@RequestParam("placecity") String city,
			@RequestParam("address") String address,
			@RequestParam("placestate") String placestate,
			@RequestParam("placecountry") String placecountry,
			@RequestParam("pincode") String pincode,
			@RequestParam("placedesc") String placedesc,
			@RequestParam("roadcondition") String roadcondition,
			@RequestParam("safetylevel") String safetylevel,
			@RequestParam("touritlevel") String touritlevel,
			@RequestParam("adventurelevel") String adventurelevel,
			@RequestParam("costlevel") String costlevel,
			@RequestParam("hostelpresent") String hostelpresent,
			@RequestParam("guesthousepresent") String guesthousepresent,
			@RequestParam("campingspot") String campingspot,
			@RequestParam("hotelpresent") String hotelpresent,
			@RequestParam("otherpresent") String otherpresent,
			@RequestParam("latitude") String latitude,
			@RequestParam("category") String category,
			@RequestParam("longtitude") String longtitude,
			final @RequestParam("placeimage") MultipartFile file) throws IOException {
		
		String imgdirectory = getPathOfUser();
//		String imgdirectory ="C:/Users/deveshwar/Desktop/CDAC_MAY_2021/Adv_Java/spring_workspace/unknown_places/static/image/";
		System.out.println("ghe na");
		
		Places place=new Places();
		place.setPlacename(placename);
		place.setPlacecity(city);
		place.setAddress(address);
		place.setPlacestate(placestate);
		place.setPlacedesc(placedesc);
		place.setCategory(category);
		place.setPlacecountry(placecountry);
		place.setPincode(Integer.parseInt(pincode));
		place.setRoadcondition(Integer.parseInt(roadcondition));
		place.setTouritlevel(Integer.parseInt(touritlevel));
		place.setAdventurelevel(Integer.parseInt(adventurelevel));
		place.setCostlevel(Integer.parseInt(costlevel));
		if(!hostelpresent.equals("")) {
			place.setHostelpresent(true);
		}else {
			place.setHostelpresent(false);
		}
		if(!guesthousepresent.equals("")) {
			place.setGuesthousepresent(true);
		}else {
			place.setGuesthousepresent(false);
		}
		if(!campingspot.equals("")) {
			place.setCampingspot(true);
		}else {
			place.setCampingspot(false);
		}
		if(!hotelpresent.equals("")) {
			place.setHotelpresent(true);
		}else {
			place.setHotelpresent(false);
		}
		if(!otherpresent.equals("")) {
			place.setOtherpresent(true);
		}else {
			place.setOtherpresent(false);
		}
		place.setLatitude(Double.parseDouble(latitude));
		place.setLongtitude(Double.parseDouble(longtitude));
		
		place.setVerified(false);
		place.setRequest("pending");
		
		
		
		makeDireIfNot(imgdirectory);
		
		Path filepath=Paths.get(imgdirectory,file.getOriginalFilename());
		
		try {
			 Files.copy(file.getInputStream(), Paths.get(imgdirectory+File.separator+file.getOriginalFilename()),
	                    StandardCopyOption.REPLACE_EXISTING);
			place.setPlaceimage("http://localhost:8081/image/"+file.getOriginalFilename());
			placeservice.addPlace(place);
			return "Your Request Submited SuccessFully admin will verify it soon <a href='http://localhost:3000/'>Go BACK</a>";
		}catch(IOException io){
			return "failed";
		}
		
	}
	
	private void makeDireIfNot(String imageDir) {
		
		File directory=new File(imageDir);
		if(!directory.exists()) {
			directory.mkdir();
		}
		
	}
	
	@PostMapping("/viewplace")
	 public Places getOnePlace(@RequestBody Places place) {
		return placeservice.getPlaceById(place.getPlaceid());
	 }
	
	@PostMapping("/getplacebycat")
	public List<Places> getCatPlaces(@RequestBody Places place){
		return placeservice.getCatPlaces(place.getCategory());
	}
	
	
	
	@GetMapping("/getplaces")
	private List<Places> getPlace() {
		return  placeservice.getPlaces();
	}
	
	
	@PostMapping("/verifyplace")
	public String verifyPlace(@RequestBody Places place) {
		Places places=placeservice.getPlaceById(place.getPlaceid());
		places.setRequest("accepted");
		places.setVerified(true);
		
		placeservice.addPlace(places);
		return "You Verify this place";
		
		
				
	}
	
	@PostMapping("/rejectplace")
	public String rejectPlace(@RequestBody Places place) {
		Places places=placeservice.getPlaceById(place.getPlaceid());
		places.setRequest("rejected");
		places.setVerified(false);
		
		placeservice.addPlace(places);
		return "You Rejected this place";
	}
	
	@PostMapping("/searchplaced")
	public List<Places> getBySearch(@RequestBody Places place){
		return placeservice.getSearch(place.getPlacename());
	}
	
}
