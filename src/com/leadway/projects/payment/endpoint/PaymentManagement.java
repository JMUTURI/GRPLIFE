/**
 * PaymentManagement.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.leadway.projects.payment.endpoint;

public interface PaymentManagement extends java.rmi.Remote {
    public boolean hasUsers(java.lang.String hostName) throws java.rmi.RemoteException, com.leadway.projects.payment.endpoint.Exception;
    public void insertUserAccount(com.leadway.projects.payment.endpoint.UserAccount userAcct, java.lang.String hostName) throws java.rmi.RemoteException, com.leadway.projects.payment.endpoint.Exception;
    public com.leadway.projects.payment.endpoint.UserAccount loginUser(com.leadway.projects.payment.endpoint.UserAccount userAcct, java.lang.String hostName) throws java.rmi.RemoteException, com.leadway.projects.payment.endpoint.Exception;
    public void updateUserAccount(com.leadway.projects.payment.endpoint.UserAccount userAcct, java.lang.String hostName) throws java.rmi.RemoteException, com.leadway.projects.payment.endpoint.Exception;
    public void deleteUserAccount(com.leadway.projects.payment.endpoint.UserAccount userAcct, java.lang.String hostName) throws java.rmi.RemoteException, com.leadway.projects.payment.endpoint.Exception;
    public void startSwitchScheduler() throws java.rmi.RemoteException, com.leadway.projects.payment.endpoint.Exception;
    public void stopSwitchScheduler() throws java.rmi.RemoteException, com.leadway.projects.payment.endpoint.Exception;
    public void refreshSwitchScheduler() throws java.rmi.RemoteException, com.leadway.projects.payment.endpoint.Exception;
    public com.leadway.projects.payment.endpoint.PaymentMode[] getPaymentModeList(java.lang.String userName, java.lang.String hostName) throws java.rmi.RemoteException, com.leadway.projects.payment.endpoint.Exception;
    public com.leadway.projects.payment.endpoint.Subsystem[] getSubsystemList(java.lang.String userName, java.lang.String hostName) throws java.rmi.RemoteException, com.leadway.projects.payment.endpoint.Exception;
    public com.leadway.projects.payment.endpoint.Narration[] loadNarrationList(java.lang.String userName, java.lang.String hostName) throws java.rmi.RemoteException, com.leadway.projects.payment.endpoint.Exception;
    public com.leadway.projects.payment.endpoint.ChequeType[] loadChequeTypeList(java.lang.String userName, java.lang.String hostName) throws java.rmi.RemoteException, com.leadway.projects.payment.endpoint.Exception;
    public com.leadway.projects.payment.endpoint.DebitCreditNote findDebitNoteByDebitNoteNumber(java.lang.String debitNoteNumber, java.lang.String hostName) throws java.rmi.RemoteException, com.leadway.projects.payment.endpoint.Exception;
    public com.leadway.projects.payment.endpoint.DebitCreditNote[] findDebitNoteByPolicyNumber(java.lang.String policyNumber, java.lang.String hostName) throws java.rmi.RemoteException, com.leadway.projects.payment.endpoint.Exception;
    public com.leadway.projects.payment.endpoint.DebitCreditNote[] findDebitNoteByBranchCode(java.lang.String branchCode, java.lang.String hostName) throws java.rmi.RemoteException, com.leadway.projects.payment.endpoint.Exception;
    public com.leadway.projects.payment.endpoint.DebitCreditNote[] findPendingDebitNoteListByTransmitStatus(java.lang.String hostName) throws java.rmi.RemoteException, com.leadway.projects.payment.endpoint.Exception;
    public com.leadway.projects.payment.endpoint.DebitCreditNote[] saveDebitCreditNoteList(com.leadway.projects.payment.endpoint.DebitCreditNote[] dcNoteList, java.lang.String configCode, java.lang.String hostName) throws java.rmi.RemoteException, com.leadway.projects.payment.endpoint.Exception;
    public com.leadway.projects.payment.endpoint.DebitCreditNote saveDebitCreditNote(com.leadway.projects.payment.endpoint.DebitCreditNote debitNote, java.lang.String configCode, java.lang.String hostName) throws java.rmi.RemoteException, com.leadway.projects.payment.endpoint.Exception;
    public com.leadway.projects.payment.endpoint.DebitCreditNote reverseDebitCreditNote(com.leadway.projects.payment.endpoint.DebitCreditNote debitNote, java.lang.String configCode, java.lang.String hostName) throws java.rmi.RemoteException, com.leadway.projects.payment.endpoint.Exception;
    public void updateDebitNoteOnPaymentSwitchSuccess(java.lang.String debitNoteNumber, java.lang.String hostName) throws java.rmi.RemoteException, com.leadway.projects.payment.endpoint.Exception;
    public void updateDebitCreditNote(com.leadway.projects.payment.endpoint.DebitCreditNote debitNote, java.lang.String hostName) throws java.rmi.RemoteException, com.leadway.projects.payment.endpoint.Exception;
    public void markDebitNoteAsDeleted(com.leadway.projects.payment.endpoint.DebitCreditNote debitNote, java.lang.String hostName) throws java.rmi.RemoteException, com.leadway.projects.payment.endpoint.Exception;
    public void markDebitNoteAsNotDeleted(com.leadway.projects.payment.endpoint.DebitCreditNote debitNote, java.lang.String hostName) throws java.rmi.RemoteException, com.leadway.projects.payment.endpoint.Exception;
    public void deleteDebitNote(java.lang.String debitNoteNumber, java.lang.String hostName) throws java.rmi.RemoteException, com.leadway.projects.payment.endpoint.Exception;
    public com.leadway.projects.payment.endpoint.DebitCreditNote[] findDebitCreditNoteByCriteria(com.leadway.projects.payment.endpoint.DebitCreditNote debitNoteCriteria, java.lang.String hostName) throws java.rmi.RemoteException, com.leadway.projects.payment.endpoint.Exception;
    public com.leadway.projects.payment.endpoint.BasePayment[] findInboundPaymentByDebitNoteNumber(java.lang.String debitNoteNumber, java.lang.String hostName) throws java.rmi.RemoteException, com.leadway.projects.payment.endpoint.Exception;
    public com.leadway.projects.payment.endpoint.BasePayment[] findOutboundPaymentByDebitNoteNumber(java.lang.String debitNoteNumber, java.lang.String hostName) throws java.rmi.RemoteException, com.leadway.projects.payment.endpoint.Exception;
    public com.leadway.projects.payment.endpoint.BasePayment[] findInboundPaymentByPolicyNumber(java.lang.String policyNumber, java.lang.String hostName) throws java.rmi.RemoteException, com.leadway.projects.payment.endpoint.Exception;
    public com.leadway.projects.payment.endpoint.BasePayment[] findInboundPaymentByPayer(java.lang.String payer, java.lang.String hostName) throws java.rmi.RemoteException, com.leadway.projects.payment.endpoint.Exception;
    public com.leadway.projects.payment.endpoint.BasePayment[] findInboundPaymentByAgentCode(java.lang.String agentCode, java.lang.String hostName) throws java.rmi.RemoteException, com.leadway.projects.payment.endpoint.Exception;
    public com.leadway.projects.payment.endpoint.BasePayment[] findInboundPaymentByCriteria(com.leadway.projects.payment.endpoint.BasePayment paymentCriteria, com.leadway.projects.payment.endpoint.DateRange tranDateRange, com.leadway.projects.payment.endpoint.DateRange chequeDateRange, java.lang.String hostName) throws java.rmi.RemoteException, com.leadway.projects.payment.endpoint.Exception;
    public com.leadway.projects.payment.endpoint.BasePayment[] findInboundPaymentByPaymentDateRange(java.lang.String startDate, java.lang.String endDate, java.lang.String hostName) throws java.rmi.RemoteException, com.leadway.projects.payment.endpoint.Exception;
    public com.leadway.projects.payment.endpoint.BasePayment[] findInboundPaymentByPaymentDate(java.lang.String paymentDate, java.lang.String hostName) throws java.rmi.RemoteException, com.leadway.projects.payment.endpoint.Exception;
    public com.leadway.projects.payment.endpoint.BasePayment findInboundPaymentByReceiptNumber(java.lang.String receiptNumber, java.lang.String hostName) throws java.rmi.RemoteException, com.leadway.projects.payment.endpoint.Exception;
    public com.leadway.projects.payment.endpoint.BasePayment[] findInboundPaymentByReceiptNumberList(java.lang.String[] receiptNumberList, java.lang.String hostName) throws java.rmi.RemoteException, com.leadway.projects.payment.endpoint.Exception;
    public com.leadway.projects.payment.endpoint.BasePayment[] getInboundPaymentList(java.lang.String subsystem, java.lang.String startDate, java.lang.String endDate, java.lang.String hostName) throws java.rmi.RemoteException, com.leadway.projects.payment.endpoint.Exception;
    public long getPendingPaymentCountBySubsystem(java.lang.String subsystem, java.lang.String hostName) throws java.rmi.RemoteException, com.leadway.projects.payment.endpoint.Exception;
    public java.lang.String[] getReceiptNumberListForPendingPaymentsBySubsystem(java.lang.String subsystem, java.lang.String hostName) throws java.rmi.RemoteException, com.leadway.projects.payment.endpoint.Exception;
    public com.leadway.projects.payment.endpoint.BasePayment[] findPendingPaymentListBySubsystem(java.lang.String subsystem, java.lang.String hostName) throws java.rmi.RemoteException, com.leadway.projects.payment.endpoint.Exception;
    public com.leadway.projects.payment.endpoint.BasePayment[] findInboundPaymentByRecentInsertionDate(java.lang.String subsystem, java.lang.String hostName) throws java.rmi.RemoteException, com.leadway.projects.payment.endpoint.Exception;
    public void saveISPayment(com.leadway.projects.payment.endpoint.IsPayment payment, java.lang.String hostName) throws java.rmi.RemoteException, com.leadway.projects.payment.endpoint.Exception;
    public com.leadway.projects.payment.endpoint.BasePayment saveCashierDCPayment(com.leadway.projects.payment.endpoint.PaymentForDC payment, java.lang.String hostName) throws java.rmi.RemoteException, com.leadway.projects.payment.endpoint.Exception;
    public com.leadway.projects.payment.endpoint.BasePayment saveCashierDCBankPayment(com.leadway.projects.payment.endpoint.BankPaymentForDC payment, java.lang.String hostName) throws java.rmi.RemoteException, com.leadway.projects.payment.endpoint.Exception;
    public void saveISPaymentList(com.leadway.projects.payment.endpoint.BasePayment[] paymentList, java.lang.String hostName) throws java.rmi.RemoteException, com.leadway.projects.payment.endpoint.Exception;
    public void updatePayment(com.leadway.projects.payment.endpoint.BasePayment payment, java.lang.String hostName) throws java.rmi.RemoteException, com.leadway.projects.payment.endpoint.Exception;
    public void updateInboundPaymentOnSubsystemSuccess(java.lang.String receiptNumber, java.lang.String hostName) throws java.rmi.RemoteException, com.leadway.projects.payment.endpoint.Exception;
    public java.lang.String savePolicyHolder(com.leadway.projects.payment.endpoint.PolicyHolder policyHolder, java.lang.String hostName) throws java.rmi.RemoteException, com.leadway.projects.payment.endpoint.Exception;
    public void updatePolicyHolder(com.leadway.projects.payment.endpoint.PolicyHolder policyHolder, java.lang.String hostName) throws java.rmi.RemoteException, com.leadway.projects.payment.endpoint.Exception;
    public void updatePolicyHolderByName(java.lang.String policyNumber, java.lang.String newName, java.lang.String hostName) throws java.rmi.RemoteException, com.leadway.projects.payment.endpoint.Exception;
    public void updatePolicyHolderByAgency(java.lang.String policyNumber, java.lang.String agentCode, java.lang.String agentName, java.lang.String hostName) throws java.rmi.RemoteException, com.leadway.projects.payment.endpoint.Exception;
    public void updatePolicyHolderByAddress(java.lang.String policyNumber, java.lang.String holderAddress, java.lang.String hostName) throws java.rmi.RemoteException, com.leadway.projects.payment.endpoint.Exception;
    public void markPolicyHolderAsDeleted(com.leadway.projects.payment.endpoint.PolicyHolder policyHolder, java.lang.String hostName) throws java.rmi.RemoteException, com.leadway.projects.payment.endpoint.Exception;
    public void deletePolicyHolder(com.leadway.projects.payment.endpoint.PolicyHolder policyHolder, java.lang.String hostName) throws java.rmi.RemoteException, com.leadway.projects.payment.endpoint.Exception;
    public com.leadway.projects.payment.endpoint.PolicyHolder[] findPolicyHolderByCriteria(com.leadway.projects.payment.endpoint.PolicyHolder policyHolder, java.lang.String hostName) throws java.rmi.RemoteException, com.leadway.projects.payment.endpoint.Exception;
    public com.leadway.projects.payment.endpoint.PolicyHolder[] findPolicyHolderByPolicyNumber(java.lang.String policyNumber, java.lang.String hostName) throws java.rmi.RemoteException, com.leadway.projects.payment.endpoint.Exception;
    public com.leadway.projects.payment.endpoint.PolicyHolder[] getPolicyHolderList(java.lang.String hostName) throws java.rmi.RemoteException, com.leadway.projects.payment.endpoint.Exception;
    public com.leadway.projects.payment.endpoint.PolicyHolder[] getPolicyHolderListByHolderName(java.lang.String policyHolderName, java.lang.String hostName) throws java.rmi.RemoteException, com.leadway.projects.payment.endpoint.Exception;
    public com.leadway.projects.payment.endpoint.PolicyHolder[] getPendingPolicyHolderListAndUpdateTransStatusAsInserted(java.lang.String hostName) throws java.rmi.RemoteException, com.leadway.projects.payment.endpoint.Exception;
    public com.leadway.projects.payment.endpoint.PolicyHolder[] getPendingPolicyHolderList(java.lang.String hostName) throws java.rmi.RemoteException, com.leadway.projects.payment.endpoint.Exception;
    public void updatePolicyHolderByTransmitStatus(java.lang.String policyNumber, java.lang.String hostName) throws java.rmi.RemoteException, com.leadway.projects.payment.endpoint.Exception;
    public com.leadway.projects.payment.endpoint.PolicyHolder[] getPolicyHolderListByTransactionDate(java.lang.String startDate, java.lang.String endDate, java.lang.String hostName) throws java.rmi.RemoteException, com.leadway.projects.payment.endpoint.Exception;
    public com.leadway.projects.payment.endpoint.Transaction getTransactionByConfigCode(java.lang.String configCode, java.lang.String hostName) throws java.rmi.RemoteException, com.leadway.projects.payment.endpoint.Exception;
    public com.leadway.projects.payment.endpoint.Transaction[] getTransactionList(java.lang.String hostName) throws java.rmi.RemoteException, com.leadway.projects.payment.endpoint.Exception;
    public java.lang.String getNextReceiptNumber(java.lang.String hostName) throws java.rmi.RemoteException, com.leadway.projects.payment.endpoint.Exception;
    public com.leadway.projects.payment.endpoint.PaymentSourceConstants getPaymentSourceConstants() throws java.rmi.RemoteException, com.leadway.projects.payment.endpoint.Exception;
    public void dummyMethod(com.leadway.projects.payment.endpoint.Subsystem subsystem, com.leadway.projects.payment.endpoint.ExceptionMessage exceptionMssg, com.leadway.projects.payment.endpoint.BankPaymentForDC bankPayment, com.leadway.projects.payment.endpoint.PaymentForDC paymentForDC, com.leadway.projects.payment.endpoint.IsPayment isPayment) throws java.rmi.RemoteException, com.leadway.projects.payment.endpoint.Exception;
}
