package com.myselenium;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MySelenium {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver;
		
		String fileDir = "C:\\03_training\\workspace\\SeleniumTest\\result.txt";
		
		System.setProperty("webdriver.chrome.driver", "C:\\03_training\\workspace\\myjar\\selenium\\drivers\\chromedriver.exe");
		//String targetUrlfront = "https://www.mizuhobank.co.jp/takarakuji/loto/backnumber/lt6-";
		driver = new ChromeDriver(); 
		
		// "201605-201704"
		
		//String[] urlArray = {"201605","201606","201607","201608","201609","201610","201611","201612","201701","201702","201703","201704"};
		
		String targetUrl = "";
		
		try {

			File oFile = new File(fileDir);
			BufferedWriter writer = new BufferedWriter(new FileWriter(oFile));
            
			//for(int i=0; i<urlArray.length; i++){
				//targetUrl = targetUrlfront + urlArray[i] + ".html";
				driver.get("https://www.mizuhobank.co.jp/takarakuji/loto/loto6/index.html");
				
				List<WebElement> theadElements = driver.findElements(By.tagName("thead"));
				List<WebElement> tbodyElements = driver.findElements(By.tagName("tbody"));
				
				for(int j=0; j<theadElements.size(); j++){
					String resultStr = "";
					resultStr = resultStr + theadElements.get(j).findElement(By.tagName("tr")).findElements(By.tagName("th")).get(1).getText() + "	";
					resultStr = resultStr + tbodyElements.get(j).findElements(By.tagName("tr")).get(0).findElement(By.tagName("td")).getText() + "	";
					resultStr = resultStr + tbodyElements.get(j).findElements(By.tagName("tr")).get(1).findElements(By.tagName("td")).get(0).findElement(By.tagName("strong")).getText() + "	";
					resultStr = resultStr + tbodyElements.get(j).findElements(By.tagName("tr")).get(1).findElements(By.tagName("td")).get(1).findElement(By.tagName("strong")).getText() + "	";
					resultStr = resultStr + tbodyElements.get(j).findElements(By.tagName("tr")).get(1).findElements(By.tagName("td")).get(2).findElement(By.tagName("strong")).getText() + "	";
					resultStr = resultStr + tbodyElements.get(j).findElements(By.tagName("tr")).get(1).findElements(By.tagName("td")).get(3).findElement(By.tagName("strong")).getText() + "	";
					resultStr = resultStr + tbodyElements.get(j).findElements(By.tagName("tr")).get(1).findElements(By.tagName("td")).get(4).findElement(By.tagName("strong")).getText() + "	";
					resultStr = resultStr + tbodyElements.get(j).findElements(By.tagName("tr")).get(1).findElements(By.tagName("td")).get(5).findElement(By.tagName("strong")).getText() + "	";
					resultStr = resultStr + tbodyElements.get(j).findElements(By.tagName("tr")).get(2).findElement(By.tagName("td")).findElement(By.tagName("strong")).getText();
					
					System.out.println(resultStr);
					
					writer.write(resultStr);
					writer.newLine();
				}
				
				writer.flush();
			//}
			
			driver.quit();
    		writer.close();
			
    		/*
    		 * The former results
    		 * 
    		for(int roundNumber=1; roundNumber<=1061; roundNumber+=20){
    			
    			String str = String.format("%04d", roundNumber);
    			targetUrl = targetUrlfront + str + ".html";
    			
    			System.out.println(targetUrl);
    			
    			driver.get(targetUrl);
    			//driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
    			
    			// By.table
    			WebElement tableElement = driver.findElement(By.tagName("tbody"));
    			List<WebElement> trElements = tableElement.findElements(By.tagName("tr"));
    			
    			for(WebElement trElement : trElements){
    				String resultStr = "";
    				
    				resultStr = resultStr + trElement.findElement(By.tagName("th")).getText() + "	";
    				List<WebElement> tdElements = trElement.findElements(By.tagName("td"));
    				
    				for(WebElement tdElement : tdElements){
    					resultStr = resultStr + tdElement.getText() + "	";
    				}
    				
    				// System.out.println(resultStr);

    				writer.write(resultStr);
    				writer.newLine();
    				
    				// break;
    				
    			}
    			
    			writer.flush();
    			
    			// driver.close();
    			// break;
    		}
            
    		driver.quit();
    		writer.close();
    		*/

        } catch (Exception e) {
            e.printStackTrace();
        }
		
		// wait for 5 seconds
		// driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		// set text "selenium" into element whose id/name/class is "mainCol" 
		// By.id
		// driver.findElement(By.id("mainCol")).sendKeys("selenium");
		
		// By.name
		// driver.findElement(By.name("mainCol")).sendKeys("selenium");
		
		// By.className
		// driver.findElement(By.className("mainCol")).sendKeys("selenium");
		
		// By.tagName
		// driver.findElement(By.tagName("mainCol")).sendKeys("selenium");
		
		// By.linkText
		//  driver.findElement(By.linkText("êÊåéà»ëOÇÃìñÇπÇÒî‘çÜÇÕÇ±ÇøÇÁ")).click();
		// driver.findElement(By.partialLinkText("êÊåéà»ëOÇÃìñÇπÇÒî‘çÜ")).click();
		
		// By.xPath
		// driver.findElement(By.xpath(".//*[@id='mainCol']/article/div/div/div/table/tbody/tr1/td[2]")).getText();
		
		// By.css
		// driver.findElements(By.cssSelector("th[class='alnCenter bgf7f7f7']"));
		
		/* Test
		List<WebElement> roundList = driver.findElements(By.cssSelector("th[class='alnCenter bgf7f7f7']"));
		List<WebElement> numberList = driver.findElements(By.cssSelector("td[class='alnCenter extension']"));
		List<WebElement> bonusList = driver.findElements(By.cssSelector("td[class='alnCenter extension green']"));
		
		int i = 0;
		int j = 0;
		for(WebElement roundElement : roundList){
			System.out.print(roundElement.getText() + "	");
			for(int k=0; k<6; k++){
				System.out.print(numberList.get(i).getText() + "	");
				i++;
			}
			System.out.println(bonusList.get(j).getText());
			j++;
		}
		
		// driver.close();
		*/
		
		// FireFox
//		System.setProperty("webdriver.firefox.bin", "C:\\firefox\\firefox.exe");
//		WebDriver driver = new FirefoxDriver(); 
//		String targetUrl = "https://www.mizuhobank.co.jp/takarakuji/loto/loto6/index.html";
//		driver.get(targetUrl);
//		driver.close();
		
		// Chrome
//		System.setProperty("webdriver.chrome.driver", "C:\\03_training\\workspace\\myjar\\selenium\\drivers\\chromedriver.exe");
//		WebDriver driver = new ChromeDriver(); 
//		String targetUrl = "https://www.mizuhobank.co.jp/takarakuji/loto/loto6/index.html";
//		driver.get(targetUrl);

		// IE
//		System.setProperty("webdriver.ie.driver", "C:\\03_training\\workspace\\myjar\\selenium\\drivers\\IEDriverServer64.exe");
//		WebDriver driver = new InternetExplorerDriver(); 
//		String targetUrl = "https://www.mizuhobank.co.jp/takarakuji/loto/loto6/index.html";
//		driver.get(targetUrl);
	}

}
