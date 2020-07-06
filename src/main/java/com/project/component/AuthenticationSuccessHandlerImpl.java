package com.project.component;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.project.service.UserService;

@Component
public class AuthenticationSuccessHandlerImpl
	implements AuthenticationSuccessHandler {

	@Autowired
	private UserService userService;
	
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		// TODO Auto-generated method stub		
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = "";
        
        if(principal instanceof UserDetails) {
        	username = ((UserDetails) principal).getUsername();
        }
        else {
        	username = principal.toString();
        }
        if(!username.equals("anonymousUser")) {
        	request.getSession().setAttribute("userSession", userService.getUserByUsername(username));
        	response.sendRedirect("trang-chu");
        }

	}

}
