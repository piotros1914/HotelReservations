package com.piotrowski.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SecurityController {
	
	 
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginPage() {
		return "login";
	}
	
	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
	    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    if (auth != null){    
	        new SecurityContextLogoutHandler().logout(request, response, auth);
	    }
	    return "redirect:/";
	}
	
	 @RequestMapping(value = "errors", method = RequestMethod.GET)
	    public String renderErrorPage(HttpServletRequest httpRequest, Model model) {
	         
	        String errorMsg = "";
	        int httpErrorCode = getErrorCode(httpRequest);
	 
	        switch (httpErrorCode) {
	            case 400: {
	                errorMsg = "400. Nast¹pi³o niepoprane ¿adanie do serwera";
	                break;
	            }
	            case 401: {
	                errorMsg = "401. B³¹d autoryzacji.";
	                break;
	            }
	            case 404: {
	                errorMsg = "404. Podana strona nie zosta³a znaleziona";
	                break;
	            }
	            case 500: {
	                errorMsg = "500. Nast¹pi³ wewnêtrzny b³¹d serwera.";
	                break;
	            }
	        }
	        model.addAttribute("errorMsg", errorMsg);
	        return "errorPage";
	    }
	     
	    private int getErrorCode(HttpServletRequest httpRequest) {
	        return (Integer) httpRequest
	          .getAttribute("javax.servlet.error.status_code");
	    }

}
