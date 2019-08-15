package com.leadway.pf.service.ws;

public class PfServiceProxy implements com.leadway.pf.service.ws.PfService {
  private String _endpoint = null;
  private com.leadway.pf.service.ws.PfService pfService = null;
  
  public PfServiceProxy() {
    _initPfServiceProxy();
  }
  
  public PfServiceProxy(String endpoint) {
    _endpoint = endpoint;
    _initPfServiceProxy();
  }
  
  private void _initPfServiceProxy() {
    try {
      pfService = (new com.leadway.pf.service.ws.PfServiceServiceLocator()).getPfServicePort();
      if (pfService != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)pfService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)pfService)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (pfService != null)
      ((javax.xml.rpc.Stub)pfService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.leadway.pf.service.ws.PfService getPfService() {
    if (pfService == null)
      _initPfServiceProxy();
    return pfService;
  }
  
  public void processRepaymentFinalization() throws java.rmi.RemoteException, com.leadway.pf.service.ws.BusinessException{
    if (pfService == null)
      _initPfServiceProxy();
    pfService.processRepaymentFinalization();
  }
  
  public void processDefaultPayment() throws java.rmi.RemoteException, com.leadway.pf.service.ws.BusinessException{
    if (pfService == null)
      _initPfServiceProxy();
    pfService.processDefaultPayment();
  }
  
  public com.leadway.pf.service.ws.PfScheduleData[] calculateAmortization(com.leadway.pf.service.ws.PfData data) throws java.rmi.RemoteException, com.leadway.pf.service.ws.BusinessException{
    if (pfService == null)
      _initPfServiceProxy();
    return pfService.calculateAmortization(data);
  }
  
  public void initiateDDRequest() throws java.rmi.RemoteException, com.leadway.pf.service.ws.BusinessException{
    if (pfService == null)
      _initPfServiceProxy();
    pfService.initiateDDRequest();
  }
  
  public void processRepayments() throws java.rmi.RemoteException, com.leadway.pf.service.ws.BusinessException{
    if (pfService == null)
      _initPfServiceProxy();
    pfService.processRepayments();
  }
  
  public void initiateRepaymentScheduleRequest() throws java.rmi.RemoteException, com.leadway.pf.service.ws.BusinessException{
    if (pfService == null)
      _initPfServiceProxy();
    pfService.initiateRepaymentScheduleRequest();
  }
  
  public void registerDepositOnPolicy(com.leadway.pf.service.ws.PfData data) throws java.rmi.RemoteException, com.leadway.pf.service.ws.BusinessException{
    if (pfService == null)
      _initPfServiceProxy();
    pfService.registerDepositOnPolicy(data);
  }
  
  public com.leadway.pf.service.ws.PfData registerNewPolicy(com.leadway.pf.service.ws.PfData data) throws java.rmi.RemoteException, com.leadway.pf.service.ws.BusinessException{
    if (pfService == null)
      _initPfServiceProxy();
    return pfService.registerNewPolicy(data);
  }
  
  public void registerDirectDebitPayment(com.leadway.pf.service.ws.PaymentData arg0) throws java.rmi.RemoteException, com.leadway.pf.service.ws.BusinessException{
    if (pfService == null)
      _initPfServiceProxy();
    pfService.registerDirectDebitPayment(arg0);
  }
  
  public com.leadway.pf.service.ws.PfData quotePremiumFinancing(com.leadway.pf.service.ws.PfData data) throws java.rmi.RemoteException, com.leadway.pf.service.ws.BusinessException{
    if (pfService == null)
      _initPfServiceProxy();
    return pfService.quotePremiumFinancing(data);
  }
  
  
}