/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.utez.cli.cliweb4.controller.rest;


import mx.edu.utez.cli.cliweb4.constant.ViewConstant;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Lenovo
 */
@Controller
public class LoginController {
    
	private static final Log LOG=LogFactory.getLog(LoginController.class);
	/*
	@GetMapping("/")
	public String redirectToLogin(){
		LOG.info("METHOD: redirectToLogin()");
		return "redirect:login";
	}
	
	@GetMapping("/login")
	public String showLoginForm(Model model,
			@RequestParam(name="error",required=false)String error,
		 @RequestParam(name="logout",required=false)String logout){
		LOG.info("METHOD: showLoginForm() --PARAM : error="+error+", logout:"+logout);
		UserCredential  userCredential=new UserCredential();
		model.addAttribute("error", error);
		model.addAttribute("logout", logout);
		model.addAttribute("userCredentials", userCredential);
		LOG.info("Returning to login view");
		return ViewConstant.LOGIN;
	}
	*/
	@GetMapping("/login")
	public String showLoginForm(Model model,
			@RequestParam(name="error",required=false)String error,
		 @RequestParam(name="logout",required=false)String logout){
		LOG.info("METHOD: showLoginForm() --PARAM : error="+error+", logout:"+logout);
		
		model.addAttribute("error", error);
		model.addAttribute("logout", logout);
	
		LOG.info("Returning to login view");
		return ViewConstant.LOGIN;
	}
	/*
	@PostMapping("/logincheck")
	public String loginCheck(@ModelAttribute("userCredentials") UserCredential userCredential){
		LOG.info("METHOD: loginCheck() --PARAM : userCredentials="+userCredential);
		if(userCredential.getUsername().equals("user") && userCredential.getPassword().equals("user")){
			LOG.info("Returning to contacts view");
			return "redirect:/contacts/showcontacts";
		}
		LOG.info("Returning to login?error view");
		return "redirect:login?error";
	}*/
	
	@GetMapping({"/loginsuccess","/"})
	public String loginCheck(){
		LOG.info("METHOD: loginCheck() --PARAM : userCredentials=");
		LOG.info("Returning to login?error view");
		return "redirect:/pacientesConsulta";
	}
    
    
}
