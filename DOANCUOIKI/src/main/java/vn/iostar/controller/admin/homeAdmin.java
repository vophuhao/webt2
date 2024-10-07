package vn.iostar.controller.admin;



import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@RequestMapping("/admin")
public class homeAdmin {

	@GetMapping
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public String HomePageAdmin()
	{
		return "/admin/home";
		
	}
		
}
