package com.choucair.app;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

public class CargarArchivo {

	public static void main(String[] args)  throws AWTException{
		// Ruta del archivo
        String filePath = "D:\\Estudio\\Pruebas\\prueba.txt";

        // Copiar la ruta al portapapeles
        StringSelection selection = new StringSelection(filePath);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);

        // Inicializar Robot
        Robot robot = new Robot();

        // Esperar que la ventana está activa
        robot.delay(1000);

        // Pegar la ruta del archivo (Ctrl + V)
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);

        // Presionar Enter para confirmar la selección
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

	}

}
