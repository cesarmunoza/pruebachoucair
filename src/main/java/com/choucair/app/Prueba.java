package com.choucair.app;

import java.awt.AWTException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Prueba {
	public static void main(String[] args) throws AWTException {
//		System.setProperty("webdriver.gecko.driver",
//				"D:\\Estudio\\Udemy\\TestingWorkspaceSTS\\Drivers\\20 de noviembre 2024\\geckodriver-v0.35.0-win64\\geckodriver.exe");
		WebDriver driverFirefox = new FirefoxDriver();
		// Cargar la página
		driverFirefox.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

		// Maximizar la página
		driverFirefox.manage().window().maximize();

		// Buscar por el name e ingresar el usuario
		driverFirefox.findElement(By.name("username")).sendKeys("Admin");
	
		// Buscar por el name e ingresar clave
		driverFirefox.findElement(By.name("password")).sendKeys("admin123");
		
		//Buscar el login por medio del xpath y hacer clic
		WebElement loginButton = driverFirefox.findElement(By.xpath("/html/body/div/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button"));
		loginButton.click();
		
		
		//Esperar a que el menú desplegable esté visible completamente para ingresar a recruitment
		WebDriverWait wait = new WebDriverWait(driverFirefox, Duration.ofSeconds(10));
		WebElement dropdownMenu = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("ul.oxd-main-menu")));
		WebElement recruitLink = dropdownMenu.findElement(By.xpath("//span[text()='Recruitment']"));
		recruitLink.click();
		
		//Esperar a que el botón sea visible y darle clic
		WebElement addButton = wait.until(ExpectedConditions.visibilityOfElementLocated(
			    By.cssSelector("div.orangehrm-header-container button.oxd-button--secondary")
			));
		//Hacer clic en el botón "Add"
		addButton.click();
		
		//Esperar la página nueva se vea para ingresar nombre	
		WebElement campoNombre = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("firstName")));
		campoNombre.sendKeys("oscar");

		//Esperar a que el campo "middleName" esté visible y llena el valor
		WebElement segundoNombre = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("lastName")));
		segundoNombre.sendKeys("andres");
		
		//Esperar a que el campo "lastName" esté visible y llena el valor
		WebElement apellido = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("lastName")));
		apellido.sendKeys("roa");
		
		//Esperar a que el ícono del select sea visible y hacer clic en él		
		WebElement selectIcon = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div/div/div[2]/div/div/div[2]/i")));
		selectIcon.click();
		
		//Esperar a que las opciones del select se muestren y elegir Payroll administrator
		WebElement option = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Payroll Administrator']")));
		option.click();
		
		//Esperar que el campo de email sea visible		
		WebElement correoField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@placeholder='Type here'])[1]")));
		// Llenar el campo de email
		correoField.sendKeys("oscarandres@gmail.com");
		
		//Esperar que el campo de telefono sea visible		
		WebElement telefono = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@placeholder='Type here'])[2]")));
		// Llenar el campo de telefono
		telefono.sendKeys("453465464347");
		
		WebElement browseButton = driverFirefox.findElement(By.xpath("//div[@class='oxd-file-button']"));
		browseButton.click();

		// Llamar al método para manejar la ventana
		CargarArchivo.main(null);

		WebElement consentimiento = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(@class,'oxd-checkbox-input')]")));
		consentimiento.click();
		
		WebElement saveButton = driverFirefox.findElement(By.cssSelector("button.oxd-button--secondary.orangehrm-left-space"));
		saveButton.click();


	}

}
