package com.email.email_validator_ui;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
//theme for styling the page
@Theme("mytheme")
public class MyUI extends UI {

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        final VerticalLayout layout = new VerticalLayout();//layout
        //creating the text field with a caption above it
        final TextField email = new TextField();
        email.setCaption("Type your email here:");
        //creating a button with verification
        Button button = new Button("Verify Email");
        button.addClickListener( e -> {
            //getting the verification from the other file
        	email_validator validator = new email_validator();
            boolean validation = validator.email_validator(email.getValue());
            String result = "";
            //if the email is right
            if (validation == true) {
            	result = "Email is valid.";
            }
            //if the email is wrong
            else {
            	result = "Email is invalid. Please try again.";
            }
            //layout of the result
            layout.addComponent(new Label(result));
        });
        //layout of the page
        layout.addComponents(email, button);
        layout.setMargin(true);
        layout.setSpacing(true);
        
        setContent(layout);
    }//end of protected void

    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }
}//end of class
