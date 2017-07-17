package com.example.zoo;

import javax.servlet.annotation.WebServlet;

import java.util.Date;
import java.util.Vector;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.HorizontalLayout;

class tab {
	Vector vector = new Vector();
	
}

class tabElement {
	public int id;
	public String petName;
	public String petType;
	public String petGender;
	public Date petBirthday;
	public String name;
	public String eMail;
	public String phoneNumber;
	public tabElement() {
		id = -1;
		petName = "noset";
		petType = "noset";
		petGender = "noset";
		petBirthday = new Date();
		name = "noset";
		eMail = "noset";
		phoneNumber = "noset";
	}
	public tabElement(int q, String w, String e, String r, Date t, String y, String u, String i) {
		id = q;
		petName = w;
		petType = e;
		petGender = r;
		petBirthday = t;
		name = y;
		eMail = u;
		phoneNumber = i;
	}
}

@Theme("zooTheme")
public class zooUI extends UI {
    @Override
    protected void init(VaadinRequest vaadinRequest) {

    	
        VerticalLayout mainLayout = new VerticalLayout();
        HorizontalLayout navigationPanelLayout = new HorizontalLayout();
        HorizontalLayout tableLayout = new HorizontalLayout();
        
        Button addLine = new Button("Добавить элемент");
        Button editLine = new Button("Изменить элемент");
        Button removeLine = new Button("Удалить элемент");
        
        
        
        navigationPanelLayout.setStyleName("navPanel");
        navigationPanelLayout.addComponents(addLine, editLine, removeLine);
        mainLayout.addComponents(navigationPanelLayout, tableLayout);
        
        setContent(mainLayout);
    }

    @WebServlet(urlPatterns = "/*", name = "zooUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = zooUI.class, productionMode = false)
    public static class zooUIServlet extends VaadinServlet {
    }
}
