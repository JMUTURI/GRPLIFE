package com.leadway.projects.payment.test;

import com.leadway.projects.payment.endpoint.PaymentManagementProxy;

public class MyTests {
	
	public static void main(String[] args) {	
		
		try{
			String receiptNumber = "324324234";
			String hostName = "10.176.18.128";
			PaymentManagementProxy stub;
			stub = new PaymentManagementProxy("http://10.176.18.56:8080/PaymentManagementService/PaymentManagement");
			stub.updateInboundPaymentOnSubsystemSuccess(receiptNumber, hostName);
			System.out.println("it works");
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	

}
