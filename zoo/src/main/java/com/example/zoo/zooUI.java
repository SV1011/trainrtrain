package com.example.zoo;

import javax.servlet.annotation.WebServlet;

import java.util.Date;
import java.util.Vector;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Button;
import com.vaadin.ui.TextField;
import com.vaadin.ui.DateField;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.CheckBox;
import com.vaadin.ui.Label;
import com.vaadin.ui.Table;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.HorizontalLayout;

class tabElement {
	
	public CheckBox isSlected;
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
		isSlected = new CheckBox();
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
		isSlected = new CheckBox();
	}
}

@Theme("zooTheme")
public class zooUI extends UI {
    @Override
    protected void init(VaadinRequest vaadinRequest) {
    	Vector <tabElement> table = new Vector<>();
    	Table tableRender = new Table();
    	tableRender.addContainerProperty("*", CheckBox.class, null);
    	tableRender.addContainerProperty("ID", String.class, null);
    	tableRender.addContainerProperty("Имя животного", String.class, null);
    	tableRender.addContainerProperty("Тип животного", String.class, null);
    	tableRender.addContainerProperty("Пол животного", String.class, null);
    	tableRender.addContainerProperty("День рождения животного", String.class, null);
    	tableRender.addContainerProperty("Ф.И.О. хозяина", String.class, null);
    	tableRender.addContainerProperty("E-Mail хозяина", String.class, null);
    	tableRender.addContainerProperty("Номер телефона хозяина", String.class, null);
    	table.add(new tabElement());
    	table.add(new tabElement());
    	table.add(new tabElement());
    	table.add(new tabElement());
    	VerticalLayout inputLayer = new VerticalLayout();
        VerticalLayout mainLayout = new VerticalLayout();
        HorizontalLayout navigationPanelLayout = new HorizontalLayout();
        HorizontalLayout bottomLayout = new HorizontalLayout();
        VerticalLayout tableLayout = new VerticalLayout();
        
        TextField iPetName = new TextField("Имя животного");
        ComboBox iPetType = new ComboBox("Тип животного");
        ComboBox iPetGender = new ComboBox("Пол животного");
        DateField iPetBirthday = new DateField("День рождения животного");
        TextField iName = new TextField("Имя хозяина");
        TextField iEMail = new TextField("E-mail");
        TextField iPhoneNumber = new TextField("Номер телефона");
        
        iPetType.addItem("Собака");
        iPetType.addItem("Кошка");
        iPetType.addItem("Корова");
        iPetType.addItem("Динозавр");
        iPetType.addItem("Хомяк");
        iPetGender.addItem("Мужской");
        iPetGender.addItem("Женский");
        
        Label currentID = new Label();
        
        Button add = new Button("Отправить в БД");
        Button edit = new Button("Отправить в БД");
        
        Button refreshTable = new Button("Обновить");
        Button addLine = new Button("Добавить элемент");
        Button editLine = new Button("Изменить элемент");
        Button removeLine = new Button("Удалить элемент");
        
        add.addClickListener( e -> {
        	bottomLayout.removeComponent(inputLayer);
        	bottomLayout.setExpandRatio(tableLayout, 1f);
        });
        
        edit.addClickListener( e -> {
        	bottomLayout.removeComponent(inputLayer);
        	bottomLayout.setExpandRatio(tableLayout, 1f);
        });
        
        addLine.addClickListener( e -> {
        	inputLayer.removeAllComponents();
        	bottomLayout.removeComponent(tableLayout);
        	bottomLayout.addComponents(inputLayer, tableLayout);
        	bottomLayout.setExpandRatio(inputLayer, 0.20f);
        	bottomLayout.setExpandRatio(tableLayout, 0.80f);
        	inputLayer.addComponents(
        			iPetName, iPetType, iPetGender,
        			iEMail, iPetBirthday, iName, iPhoneNumber, currentID, edit
        	);
        });
        
        editLine.addClickListener( e -> {
        	inputLayer.removeAllComponents();
        	bottomLayout.removeComponent(tableLayout);
        	bottomLayout.addComponents(inputLayer, tableLayout);
        	bottomLayout.setExpandRatio(inputLayer, 0.20f);
        	bottomLayout.setExpandRatio(tableLayout, 0.80f);
        	inputLayer.addComponents(
        			iPetName, iPetType, iPetGender,
        			iEMail, iPetBirthday, iName, iPhoneNumber, currentID, edit
        	);
        });
        
        refreshTable.addClickListener( e -> {
            if(table.size() != 0) {
            	for(int x = 0; x < table.size(); x++) {
            		tableRender.addItem(new Object[] {new CheckBox(), String.valueOf(table.get(x).id),
            				table.get(x).petName, table.get(x).petType, table.get(x).petGender,
            				table.get(x).petBirthday.toString(), table.get(x).name,
            				table.get(x).eMail, table.get(x).phoneNumber},
            				table.get(x).id);
            	}
            	tableLayout.addComponent(tableRender);
            }
        });
        
        inputLayer.setStyleName("input");
        bottomLayout.addComponent(tableLayout);
        bottomLayout.setWidth("100%");
        bottomLayout.setHeight("100%");
        bottomLayout.setStyleName("tableC");
        tableRender.setColumnWidth("*", 42);
        tableRender.setWidth("100%");
        tableRender.setHeight("100%");
        tableLayout.setWidth("100%");
        tableLayout.setHeight("100%");
        tableLayout.setStyleName("tableC");
        navigationPanelLayout.setStyleName("navPanel");
        navigationPanelLayout.addComponents(addLine, editLine, removeLine, refreshTable);
        mainLayout.addComponents(navigationPanelLayout, bottomLayout);
        mainLayout.setHeight("100%");
        mainLayout.setExpandRatio(navigationPanelLayout, 0.05f);
        mainLayout.setExpandRatio(bottomLayout, 0.95f);
        
        setContent(mainLayout);
    }

    @WebServlet(urlPatterns = "/*", name = "zooUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = zooUI.class, productionMode = false)
    public static class zooUIServlet extends VaadinServlet {
    }
}
