package com.leadway.projects.payment.endpoint;

public class PaymentManagementProxy implements com.leadway.projects.payment.endpoint.PaymentManagement {
  private String _endpoint = null;
  private com.leadway.projects.payment.endpoint.PaymentManagement paymentManagement = null;
  
  public PaymentManagementProxy() {
    _initPaymentManagementProxy();
  }
  
  public PaymentManagementProxy(String endpoint) {
    _endpoint = endpoint;
    _initPaymentManagementProxy();
  }
  
  private void _initPaymentManagementProxy() {
    try {
      paymentManagement = (new com.leadway.projects.payment.endpoint.PaymentManagementServiceLocator()).getPaymentManagementPort();
      if (paymentManagement != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)paymentManagement)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)paymentManagement)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (paymentManagement != null)
      ((javax.xml.rpc.Stub)paymentManagement)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.leadway.projects.payment.endpoint.PaymentManagement getPaymentManagement() {
    if (paymentManagement == null)
      _initPaymentManagementProxy();
    return paymentManagement;
  }
  
  public boolean hasUsers(java.lang.String hostName) throws java.rmi.RemoteException, com.leadway.projects.payment.endpoint.Exception{
    if (paymentManagement == null)
      _initPaymentManagementProxy();
    return paymentManagement.hasUsers(hostName);
  }
  
  public void insertUserAccount(com.leadway.projects.payment.endpoint.UserAccount userAcct, java.lang.String hostName) throws java.rmi.RemoteException, com.leadway.projects.payment.endpoint.Exception{
    if (paymentManagement == null)
      _initPaymentManagementProxy();
    paymentManagement.insertUserAccount(userAcct, hostName);
  }
  
  public com.leadway.projects.payment.endpoint.UserAccount loginUser(com.leadway.projects.payment.endpoint.UserAccount userAcct, java.lang.String hostName) throws java.rmi.RemoteException, com.leadway.projects.payment.endpoint.Exception{
    if (paymentManagement == null)
      _initPaymentManagementProxy();
    return paymentManagement.loginUser(userAcct, hostName);
  }
  
  public void updateUserAccount(com.leadway.projects.payment.endpoint.UserAccount userAcct, java.lang.String hostName) throws java.rmi.RemoteException, com.leadway.projects.payment.endpoint.Exception{
    if (paymentManagement == null)
      _initPaymentManagementProxy();
    paymentManagement.updateUserAccount(userAcct, hostName);
  }
  
  public void deleteUserAccount(com.leadway.projects.payment.endpoint.UserAccount userAcct, java.lang.String hostName) throws java.rmi.RemoteException, com.leadway.projects.payment.endpoint.Exception{
    if (paymentManagement == null)
      _initPaymentManagementProxy();
    paymentManagement.deleteUserAccount(userAcct, hostName);
  }
  
  public void startSwitchScheduler() throws java.rmi.RemoteException, com.leadway.projects.payment.endpoint.Exception{
    if (paymentManagement == null)
      _initPaymentManagementProxy();
    paymentManagement.startSwitchScheduler();
  }
  
  public void stopSwitchScheduler() throws java.rmi.RemoteException, com.leadway.projects.payment.endpoint.Exception{
    if (paymentManagement == null)
      _initPaymentManagementProxy();
    paymentManagement.stopSwitchScheduler();
  }
  
  public void refreshSwitchScheduler() throws java.rmi.RemoteException, com.leadway.projects.payment.endpoint.Exception{
    if (paymentManagement == null)
      _initPaymentManagementProxy();
    paymentManagement.refreshSwitchScheduler();
  }
  
  public com.leadway.projects.payment.endpoint.PaymentMode[] getPaymentModeList(java.lang.String userName, java.lang.String hostName) throws java.rmi.RemoteException, com.leadway.projects.payment.endpoint.Exception{
    if (paymentManagement == null)
      _initPaymentManagementProxy();
    return paymentManagement.getPaymentModeList(userName, hostName);
  }
  
  public com.leadway.projects.payment.endpoint.Subsystem[] getSubsystemList(java.lang.String userName, java.lang.String hostName) throws java.rmi.RemoteException, com.leadway.projects.payment.endpoint.Exception{
    if (paymentManagement == null)
      _initPaymentManagementProxy();
    return paymentManagement.getSubsystemList(userName, hostName);
  }
  
  public com.leadway.projects.payment.endpoint.Narration[] loadNarrationList(java.lang.String userName, java.lang.String hostName) throws java.rmi.RemoteException, com.leadway.projects.payment.endpoint.Exception{
    if (paymentManagement == null)
      _initPaymentManagementProxy();
    return paymentManagement.loadNarrationList(userName, hostName);
  }
  
  public com.leadway.projects.payment.endpoint.ChequeType[] loadChequeTypeList(java.lang.String userName, java.lang.String hostName) throws java.rmi.RemoteException, com.leadway.projects.payment.endpoint.Exception{
    if (paymentManagement == null)
      _initPaymentManagementProxy();
    return paymentManagement.loadChequeTypeList(userName, hostName);
  }
  
  public com.leadway.projects.payment.endpoint.DebitCreditNote findDebitNoteByDebitNoteNumber(java.lang.String debitNoteNumber, java.lang.String hostName) throws java.rmi.RemoteException, com.leadway.projects.payment.endpoint.Exception{
    if (paymentManagement == null)
      _initPaymentManagementProxy();
    return paymentManagement.findDebitNoteByDebitNoteNumber(debitNoteNumber, hostName);
  }
  
  public com.leadway.projects.payment.endpoint.DebitCreditNote[] findDebitNoteByPolicyNumber(java.lang.String policyNumber, java.lang.String hostName) throws java.rmi.RemoteException, com.leadway.projects.payment.endpoint.Exception{
    if (paymentManagement == null)
      _initPaymentManagementProxy();
    return paymentManagement.findDebitNoteByPolicyNumber(policyNumber, hostName);
  }
  
  public com.leadway.projects.payment.endpoint.DebitCreditNote[] findDebitNoteByBranchCode(java.lang.String branchCode, java.lang.String hostName) throws java.rmi.RemoteException, com.leadway.projects.payment.endpoint.Exception{
    if (paymentManagement == null)
      _initPaymentManagementProxy();
    return paymentManagement.findDebitNoteByBranchCode(branchCode, hostName);
  }
  
  public com.leadway.projects.payment.endpoint.DebitCreditNote[] findPendingDebitNoteListByTransmitStatus(java.lang.String hostName) throws java.rmi.RemoteException, com.leadway.projects.payment.endpoint.Exception{
    if (paymentManagement == null)
      _initPaymentManagementProxy();
    return paymentManagement.findPendingDebitNoteListByTransmitStatus(hostName);
  }
  
  public com.leadway.projects.payment.endpoint.DebitCreditNote[] saveDebitCreditNoteList(com.leadway.projects.payment.endpoint.DebitCreditNote[] dcNoteList, java.lang.String configCode, java.lang.String hostName) throws java.rmi.RemoteException, com.leadway.projects.payment.endpoint.Exception{
    if (paymentManagement == null)
      _initPaymentManagementProxy();
    return paymentManagement.saveDebitCreditNoteList(dcNoteList, configCode, hostName);
  }
  
  public com.leadway.projects.payment.endpoint.DebitCreditNote saveDebitCreditNote(com.leadway.projects.payment.endpoint.DebitCreditNote debitNote, java.lang.String configCode, java.lang.String hostName) throws java.rmi.RemoteException, com.leadway.projects.payment.endpoint.Exception{
    if (paymentManagement == null)
      _initPaymentManagementProxy();
    return paymentManagement.saveDebitCreditNote(debitNote, configCode, hostName);
  }
  
  public com.leadway.projects.payment.endpoint.DebitCreditNote reverseDebitCreditNote(com.leadway.projects.payment.endpoint.DebitCreditNote debitNote, java.lang.String configCode, java.lang.String hostName) throws java.rmi.RemoteException, com.leadway.projects.payment.endpoint.Exception{
    if (paymentManagement == null)
      _initPaymentManagementProxy();
    return paymentManagement.reverseDebitCreditNote(debitNote, configCode, hostName);
  }
  
  public void updateDebitNoteOnPaymentSwitchSuccess(java.lang.String debitNoteNumber, java.lang.String hostName) throws java.rmi.RemoteException, com.leadway.projects.payment.endpoint.Exception{
    if (paymentManagement == null)
      _initPaymentManagementProxy();
    paymentManagement.updateDebitNoteOnPaymentSwitchSuccess(debitNoteNumber, hostName);
  }
  
  public void updateDebitCreditNote(com.leadway.projects.payment.endpoint.DebitCreditNote debitNote, java.lang.String hostName) throws java.rmi.RemoteException, com.leadway.projects.payment.endpoint.Exception{
    if (paymentManagement == null)
      _initPaymentManagementProxy();
    paymentManagement.updateDebitCreditNote(debitNote, hostName);
  }
  
  public void markDebitNoteAsDeleted(com.leadway.projects.payment.endpoint.DebitCreditNote debitNote, java.lang.String hostName) throws java.rmi.RemoteException, com.leadway.projects.payment.endpoint.Exception{
    if (paymentManagement == null)
      _initPaymentManagementProxy();
    paymentManagement.markDebitNoteAsDeleted(debitNote, hostName);
  }
  
  public void markDebitNoteAsNotDeleted(com.leadway.projects.payment.endpoint.DebitCreditNote debitNote, java.lang.String hostName) throws java.rmi.RemoteException, com.leadway.projects.payment.endpoint.Exception{
    if (paymentManagement == null)
      _initPaymentManagementProxy();
    paymentManagement.markDebitNoteAsNotDeleted(debitNote, hostName);
  }
  
  public void deleteDebitNote(java.lang.String debitNoteNumber, java.lang.String hostName) throws java.rmi.RemoteException, com.leadway.projects.payment.endpoint.Exception{
    if (paymentManagement == null)
      _initPaymentManagementProxy();
    paymentManagement.deleteDebitNote(debitNoteNumber, hostName);
  }
  
  public com.leadway.projects.payment.endpoint.DebitCreditNote[] findDebitCreditNoteByCriteria(com.leadway.projects.payment.endpoint.DebitCreditNote debitNoteCriteria, java.lang.String hostName) throws java.rmi.RemoteException, com.leadway.projects.payment.endpoint.Exception{
    if (paymentManagement == null)
      _initPaymentManagementProxy();
    return paymentManagement.findDebitCreditNoteByCriteria(debitNoteCriteria, hostName);
  }
  
  public com.leadway.projects.payment.endpoint.BasePayment[] findInboundPaymentByDebitNoteNumber(java.lang.String debitNoteNumber, java.lang.String hostName) throws java.rmi.RemoteException, com.leadway.projects.payment.endpoint.Exception{
    if (paymentManagement == null)
      _initPaymentManagementProxy();
    return paymentManagement.findInboundPaymentByDebitNoteNumber(debitNoteNumber, hostName);
  }
  
  public com.leadway.projects.payment.endpoint.BasePayment[] findOutboundPaymentByDebitNoteNumber(java.lang.String debitNoteNumber, java.lang.String hostName) throws java.rmi.RemoteException, com.leadway.projects.payment.endpoint.Exception{
    if (paymentManagement == null)
      _initPaymentManagementProxy();
    return paymentManagement.findOutboundPaymentByDebitNoteNumber(debitNoteNumber, hostName);
  }
  
  public com.leadway.projects.payment.endpoint.BasePayment[] findInboundPaymentByPolicyNumber(java.lang.String policyNumber, java.lang.String hostName) throws java.rmi.RemoteException, com.leadway.projects.payment.endpoint.Exception{
    if (paymentManagement == null)
      _initPaymentManagementProxy();
    return paymentManagement.findInboundPaymentByPolicyNumber(policyNumber, hostName);
  }
  
  public com.leadway.projects.payment.endpoint.BasePayment[] findInboundPaymentByPayer(java.lang.String payer, java.lang.String hostName) throws java.rmi.RemoteException, com.leadway.projects.payment.endpoint.Exception{
    if (paymentManagement == null)
      _initPaymentManagementProxy();
    return paymentManagement.findInboundPaymentByPayer(payer, hostName);
  }
  
  public com.leadway.projects.payment.endpoint.BasePayment[] findInboundPaymentByAgentCode(java.lang.String agentCode, java.lang.String hostName) throws java.rmi.RemoteException, com.leadway.projects.payment.endpoint.Exception{
    if (paymentManagement == null)
      _initPaymentManagementProxy();
    return paymentManagement.findInboundPaymentByAgentCode(agentCode, hostName);
  }
  
  public com.leadway.projects.payment.endpoint.BasePayment[] findInboundPaymentByCriteria(com.leadway.projects.payment.endpoint.BasePayment paymentCriteria, com.leadway.projects.payment.endpoint.DateRange tranDateRange, com.leadway.projects.payment.endpoint.DateRange chequeDateRange, java.lang.String hostName) throws java.rmi.RemoteException, com.leadway.projects.payment.endpoint.Exception{
    if (paymentManagement == null)
      _initPaymentManagementProxy();
    return paymentManagement.findInboundPaymentByCriteria(paymentCriteria, tranDateRange, chequeDateRange, hostName);
  }
  
  public com.leadway.projects.payment.endpoint.BasePayment[] findInboundPaymentByPaymentDateRange(java.lang.String startDate, java.lang.String endDate, java.lang.String hostName) throws java.rmi.RemoteException, com.leadway.projects.payment.endpoint.Exception{
    if (paymentManagement == null)
      _initPaymentManagementProxy();
    return paymentManagement.findInboundPaymentByPaymentDateRange(startDate, endDate, hostName);
  }
  
  public com.leadway.projects.payment.endpoint.BasePayment[] findInboundPaymentByPaymentDate(java.lang.String paymentDate, java.lang.String hostName) throws java.rmi.RemoteException, com.leadway.projects.payment.endpoint.Exception{
    if (paymentManagement == null)
      _initPaymentManagementProxy();
    return paymentManagement.findInboundPaymentByPaymentDate(paymentDate, hostName);
  }
  
  public com.leadway.projects.payment.endpoint.BasePayment findInboundPaymentByReceiptNumber(java.lang.String receiptNumber, java.lang.String hostName) throws java.rmi.RemoteException, com.leadway.projects.payment.endpoint.Exception{
    if (paymentManagement == null)
      _initPaymentManagementProxy();
    return paymentManagement.findInboundPaymentByReceiptNumber(receiptNumber, hostName);
  }
  
  public com.leadway.projects.payment.endpoint.BasePayment[] findInboundPaymentByReceiptNumberList(java.lang.String[] receiptNumberList, java.lang.String hostName) throws java.rmi.RemoteException, com.leadway.projects.payment.endpoint.Exception{
    if (paymentManagement == null)
      _initPaymentManagementProxy();
    return paymentManagement.findInboundPaymentByReceiptNumberList(receiptNumberList, hostName);
  }
  
  public com.leadway.projects.payment.endpoint.BasePayment[] getInboundPaymentList(java.lang.String subsystem, java.lang.String startDate, java.lang.String endDate, java.lang.String hostName) throws java.rmi.RemoteException, com.leadway.projects.payment.endpoint.Exception{
    if (paymentManagement == null)
      _initPaymentManagementProxy();
    return paymentManagement.getInboundPaymentList(subsystem, startDate, endDate, hostName);
  }
  
  public long getPendingPaymentCountBySubsystem(java.lang.String subsystem, java.lang.String hostName) throws java.rmi.RemoteException, com.leadway.projects.payment.endpoint.Exception{
    if (paymentManagement == null)
      _initPaymentManagementProxy();
    return paymentManagement.getPendingPaymentCountBySubsystem(subsystem, hostName);
  }
  
  public java.lang.String[] getReceiptNumberListForPendingPaymentsBySubsystem(java.lang.String subsystem, java.lang.String hostName) throws java.rmi.RemoteException, com.leadway.projects.payment.endpoint.Exception{
    if (paymentManagement == null)
      _initPaymentManagementProxy();
    return paymentManagement.getReceiptNumberListForPendingPaymentsBySubsystem(subsystem, hostName);
  }
  
  public com.leadway.projects.payment.endpoint.BasePayment[] findPendingPaymentListBySubsystem(java.lang.String subsystem, java.lang.String hostName) throws java.rmi.RemoteException, com.leadway.projects.payment.endpoint.Exception{
    if (paymentManagement == null)
      _initPaymentManagementProxy();
    return paymentManagement.findPendingPaymentListBySubsystem(subsystem, hostName);
  }
  
  public com.leadway.projects.payment.endpoint.BasePayment[] findInboundPaymentByRecentInsertionDate(java.lang.String subsystem, java.lang.String hostName) throws java.rmi.RemoteException, com.leadway.projects.payment.endpoint.Exception{
    if (paymentManagement == null)
      _initPaymentManagementProxy();
    return paymentManagement.findInboundPaymentByRecentInsertionDate(subsystem, hostName);
  }
  
  public void saveISPayment(com.leadway.projects.payment.endpoint.IsPayment payment, java.lang.String hostName) throws java.rmi.RemoteException, com.leadway.projects.payment.endpoint.Exception{
    if (paymentManagement == null)
      _initPaymentManagementProxy();
    paymentManagement.saveISPayment(payment, hostName);
  }
  
  public com.leadway.projects.payment.endpoint.BasePayment saveCashierDCPayment(com.leadway.projects.payment.endpoint.PaymentForDC payment, java.lang.String hostName) throws java.rmi.RemoteException, com.leadway.projects.payment.endpoint.Exception{
    if (paymentManagement == null)
      _initPaymentManagementProxy();
    return paymentManagement.saveCashierDCPayment(payment, hostName);
  }
  
  public com.leadway.projects.payment.endpoint.BasePayment saveCashierDCBankPayment(com.leadway.projects.payment.endpoint.BankPaymentForDC payment, java.lang.String hostName) throws java.rmi.RemoteException, com.leadway.projects.payment.endpoint.Exception{
    if (paymentManagement == null)
      _initPaymentManagementProxy();
    return paymentManagement.saveCashierDCBankPayment(payment, hostName);
  }
  
  public void saveISPaymentList(com.leadway.projects.payment.endpoint.BasePayment[] paymentList, java.lang.String hostName) throws java.rmi.RemoteException, com.leadway.projects.payment.endpoint.Exception{
    if (paymentManagement == null)
      _initPaymentManagementProxy();
    paymentManagement.saveISPaymentList(paymentList, hostName);
  }
  
  public void updatePayment(com.leadway.projects.payment.endpoint.BasePayment payment, java.lang.String hostName) throws java.rmi.RemoteException, com.leadway.projects.payment.endpoint.Exception{
    if (paymentManagement == null)
      _initPaymentManagementProxy();
    paymentManagement.updatePayment(payment, hostName);
  }
  
  public void updateInboundPaymentOnSubsystemSuccess(java.lang.String receiptNumber, java.lang.String hostName) throws java.rmi.RemoteException, com.leadway.projects.payment.endpoint.Exception{
    if (paymentManagement == null)
      _initPaymentManagementProxy();
    paymentManagement.updateInboundPaymentOnSubsystemSuccess(receiptNumber, hostName);
  }
  
  public java.lang.String savePolicyHolder(com.leadway.projects.payment.endpoint.PolicyHolder policyHolder, java.lang.String hostName) throws java.rmi.RemoteException, com.leadway.projects.payment.endpoint.Exception{
    if (paymentManagement == null)
      _initPaymentManagementProxy();
    return paymentManagement.savePolicyHolder(policyHolder, hostName);
  }
  
  public void updatePolicyHolder(com.leadway.projects.payment.endpoint.PolicyHolder policyHolder, java.lang.String hostName) throws java.rmi.RemoteException, com.leadway.projects.payment.endpoint.Exception{
    if (paymentManagement == null)
      _initPaymentManagementProxy();
    paymentManagement.updatePolicyHolder(policyHolder, hostName);
  }
  
  public void updatePolicyHolderByName(java.lang.String policyNumber, java.lang.String newName, java.lang.String hostName) throws java.rmi.RemoteException, com.leadway.projects.payment.endpoint.Exception{
    if (paymentManagement == null)
      _initPaymentManagementProxy();
    paymentManagement.updatePolicyHolderByName(policyNumber, newName, hostName);
  }
  
  public void updatePolicyHolderByAgency(java.lang.String policyNumber, java.lang.String agentCode, java.lang.String agentName, java.lang.String hostName) throws java.rmi.RemoteException, com.leadway.projects.payment.endpoint.Exception{
    if (paymentManagement == null)
      _initPaymentManagementProxy();
    paymentManagement.updatePolicyHolderByAgency(policyNumber, agentCode, agentName, hostName);
  }
  
  public void updatePolicyHolderByAddress(java.lang.String policyNumber, java.lang.String holderAddress, java.lang.String hostName) throws java.rmi.RemoteException, com.leadway.projects.payment.endpoint.Exception{
    if (paymentManagement == null)
      _initPaymentManagementProxy();
    paymentManagement.updatePolicyHolderByAddress(policyNumber, holderAddress, hostName);
  }
  
  public void markPolicyHolderAsDeleted(com.leadway.projects.payment.endpoint.PolicyHolder policyHolder, java.lang.String hostName) throws java.rmi.RemoteException, com.leadway.projects.payment.endpoint.Exception{
    if (paymentManagement == null)
      _initPaymentManagementProxy();
    paymentManagement.markPolicyHolderAsDeleted(policyHolder, hostName);
  }
  
  public void deletePolicyHolder(com.leadway.projects.payment.endpoint.PolicyHolder policyHolder, java.lang.String hostName) throws java.rmi.RemoteException, com.leadway.projects.payment.endpoint.Exception{
    if (paymentManagement == null)
      _initPaymentManagementProxy();
    paymentManagement.deletePolicyHolder(policyHolder, hostName);
  }
  
  public com.leadway.projects.payment.endpoint.PolicyHolder[] findPolicyHolderByCriteria(com.leadway.projects.payment.endpoint.PolicyHolder policyHolder, java.lang.String hostName) throws java.rmi.RemoteException, com.leadway.projects.payment.endpoint.Exception{
    if (paymentManagement == null)
      _initPaymentManagementProxy();
    return paymentManagement.findPolicyHolderByCriteria(policyHolder, hostName);
  }
  
  public com.leadway.projects.payment.endpoint.PolicyHolder[] findPolicyHolderByPolicyNumber(java.lang.String policyNumber, java.lang.String hostName) throws java.rmi.RemoteException, com.leadway.projects.payment.endpoint.Exception{
    if (paymentManagement == null)
      _initPaymentManagementProxy();
    return paymentManagement.findPolicyHolderByPolicyNumber(policyNumber, hostName);
  }
  
  public com.leadway.projects.payment.endpoint.PolicyHolder[] getPolicyHolderList(java.lang.String hostName) throws java.rmi.RemoteException, com.leadway.projects.payment.endpoint.Exception{
    if (paymentManagement == null)
      _initPaymentManagementProxy();
    return paymentManagement.getPolicyHolderList(hostName);
  }
  
  public com.leadway.projects.payment.endpoint.PolicyHolder[] getPolicyHolderListByHolderName(java.lang.String policyHolderName, java.lang.String hostName) throws java.rmi.RemoteException, com.leadway.projects.payment.endpoint.Exception{
    if (paymentManagement == null)
      _initPaymentManagementProxy();
    return paymentManagement.getPolicyHolderListByHolderName(policyHolderName, hostName);
  }
  
  public com.leadway.projects.payment.endpoint.PolicyHolder[] getPendingPolicyHolderListAndUpdateTransStatusAsInserted(java.lang.String hostName) throws java.rmi.RemoteException, com.leadway.projects.payment.endpoint.Exception{
    if (paymentManagement == null)
      _initPaymentManagementProxy();
    return paymentManagement.getPendingPolicyHolderListAndUpdateTransStatusAsInserted(hostName);
  }
  
  public com.leadway.projects.payment.endpoint.PolicyHolder[] getPendingPolicyHolderList(java.lang.String hostName) throws java.rmi.RemoteException, com.leadway.projects.payment.endpoint.Exception{
    if (paymentManagement == null)
      _initPaymentManagementProxy();
    return paymentManagement.getPendingPolicyHolderList(hostName);
  }
  
  public void updatePolicyHolderByTransmitStatus(java.lang.String policyNumber, java.lang.String hostName) throws java.rmi.RemoteException, com.leadway.projects.payment.endpoint.Exception{
    if (paymentManagement == null)
      _initPaymentManagementProxy();
    paymentManagement.updatePolicyHolderByTransmitStatus(policyNumber, hostName);
  }
  
  public com.leadway.projects.payment.endpoint.PolicyHolder[] getPolicyHolderListByTransactionDate(java.lang.String startDate, java.lang.String endDate, java.lang.String hostName) throws java.rmi.RemoteException, com.leadway.projects.payment.endpoint.Exception{
    if (paymentManagement == null)
      _initPaymentManagementProxy();
    return paymentManagement.getPolicyHolderListByTransactionDate(startDate, endDate, hostName);
  }
  
  public com.leadway.projects.payment.endpoint.Transaction getTransactionByConfigCode(java.lang.String configCode, java.lang.String hostName) throws java.rmi.RemoteException, com.leadway.projects.payment.endpoint.Exception{
    if (paymentManagement == null)
      _initPaymentManagementProxy();
    return paymentManagement.getTransactionByConfigCode(configCode, hostName);
  }
  
  public com.leadway.projects.payment.endpoint.Transaction[] getTransactionList(java.lang.String hostName) throws java.rmi.RemoteException, com.leadway.projects.payment.endpoint.Exception{
    if (paymentManagement == null)
      _initPaymentManagementProxy();
    return paymentManagement.getTransactionList(hostName);
  }
  
  public java.lang.String getNextReceiptNumber(java.lang.String hostName) throws java.rmi.RemoteException, com.leadway.projects.payment.endpoint.Exception{
    if (paymentManagement == null)
      _initPaymentManagementProxy();
    return paymentManagement.getNextReceiptNumber(hostName);
  }
  
  public com.leadway.projects.payment.endpoint.PaymentSourceConstants getPaymentSourceConstants() throws java.rmi.RemoteException, com.leadway.projects.payment.endpoint.Exception{
    if (paymentManagement == null)
      _initPaymentManagementProxy();
    return paymentManagement.getPaymentSourceConstants();
  }
  
  public void dummyMethod(com.leadway.projects.payment.endpoint.Subsystem subsystem, com.leadway.projects.payment.endpoint.ExceptionMessage exceptionMssg, com.leadway.projects.payment.endpoint.BankPaymentForDC bankPayment, com.leadway.projects.payment.endpoint.PaymentForDC paymentForDC, com.leadway.projects.payment.endpoint.IsPayment isPayment) throws java.rmi.RemoteException, com.leadway.projects.payment.endpoint.Exception{
    if (paymentManagement == null)
      _initPaymentManagementProxy();
    paymentManagement.dummyMethod(subsystem, exceptionMssg, bankPayment, paymentForDC, isPayment);
  }
  
  
}