package com.leadway.pf.service.test;

import com.leadway.pf.service.ws.PfData;
import com.leadway.pf.service.ws.PfServiceProxy;

public class MyTests {
	public static void main(String[] args) {	
		
		try{
			PfData data = new PfData();

			PfServiceProxy stub;
			stub = new PfServiceProxy("http://10.176.18.56:8086/PfServiceService/PfService");
			//stub.(receiptNumber, hostName);
			stub.quotePremiumFinancing(data);
			System.out.println("it works");
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

}

