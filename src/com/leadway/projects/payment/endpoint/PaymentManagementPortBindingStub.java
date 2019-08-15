/**
 * PaymentManagementPortBindingStub.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.leadway.projects.payment.endpoint;

public class PaymentManagementPortBindingStub extends org.apache.axis.client.Stub implements com.leadway.projects.payment.endpoint.PaymentManagement {
    private java.util.Vector cachedSerClasses = new java.util.Vector();
    private java.util.Vector cachedSerQNames = new java.util.Vector();
    private java.util.Vector cachedSerFactories = new java.util.Vector();
    private java.util.Vector cachedDeserFactories = new java.util.Vector();

    static org.apache.axis.description.OperationDesc [] _operations;

    static {
        _operations = new org.apache.axis.description.OperationDesc[66];
        _initOperationDesc1();
        _initOperationDesc2();
        _initOperationDesc3();
        _initOperationDesc4();
        _initOperationDesc5();
        _initOperationDesc6();
        _initOperationDesc7();
    }

    private static void _initOperationDesc1(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("hasUsers");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "hostName"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        oper.setReturnClass(boolean.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "return"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "Exception"),
                      "com.leadway.projects.payment.endpoint.Exception",
                      new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "Exception"), 
                      true
                     ));
        _operations[0] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("insertUserAccount");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "userAcct"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "userAccount"), com.leadway.projects.payment.endpoint.UserAccount.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "hostName"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "Exception"),
                      "com.leadway.projects.payment.endpoint.Exception",
                      new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "Exception"), 
                      true
                     ));
        _operations[1] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("loginUser");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "userAcct"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "userAccount"), com.leadway.projects.payment.endpoint.UserAccount.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "hostName"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "userAccount"));
        oper.setReturnClass(com.leadway.projects.payment.endpoint.UserAccount.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "return"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "Exception"),
                      "com.leadway.projects.payment.endpoint.Exception",
                      new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "Exception"), 
                      true
                     ));
        _operations[2] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("updateUserAccount");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "userAcct"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "userAccount"), com.leadway.projects.payment.endpoint.UserAccount.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "hostName"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "Exception"),
                      "com.leadway.projects.payment.endpoint.Exception",
                      new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "Exception"), 
                      true
                     ));
        _operations[3] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("deleteUserAccount");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "userAcct"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "userAccount"), com.leadway.projects.payment.endpoint.UserAccount.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "hostName"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "Exception"),
                      "com.leadway.projects.payment.endpoint.Exception",
                      new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "Exception"), 
                      true
                     ));
        _operations[4] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("startSwitchScheduler");
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "Exception"),
                      "com.leadway.projects.payment.endpoint.Exception",
                      new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "Exception"), 
                      true
                     ));
        _operations[5] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("stopSwitchScheduler");
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "Exception"),
                      "com.leadway.projects.payment.endpoint.Exception",
                      new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "Exception"), 
                      true
                     ));
        _operations[6] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("refreshSwitchScheduler");
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "Exception"),
                      "com.leadway.projects.payment.endpoint.Exception",
                      new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "Exception"), 
                      true
                     ));
        _operations[7] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getPaymentModeList");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "userName"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "hostName"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "paymentMode"));
        oper.setReturnClass(com.leadway.projects.payment.endpoint.PaymentMode[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "return"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "Exception"),
                      "com.leadway.projects.payment.endpoint.Exception",
                      new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "Exception"), 
                      true
                     ));
        _operations[8] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getSubsystemList");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "userName"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "hostName"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "subsystem"));
        oper.setReturnClass(com.leadway.projects.payment.endpoint.Subsystem[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "return"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "Exception"),
                      "com.leadway.projects.payment.endpoint.Exception",
                      new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "Exception"), 
                      true
                     ));
        _operations[9] = oper;

    }

    private static void _initOperationDesc2(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("loadNarrationList");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "userName"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "hostName"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "narration"));
        oper.setReturnClass(com.leadway.projects.payment.endpoint.Narration[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "return"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "Exception"),
                      "com.leadway.projects.payment.endpoint.Exception",
                      new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "Exception"), 
                      true
                     ));
        _operations[10] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("loadChequeTypeList");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "userName"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "hostName"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "chequeType"));
        oper.setReturnClass(com.leadway.projects.payment.endpoint.ChequeType[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "return"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "Exception"),
                      "com.leadway.projects.payment.endpoint.Exception",
                      new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "Exception"), 
                      true
                     ));
        _operations[11] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("findDebitNoteByDebitNoteNumber");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "debitNoteNumber"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "hostName"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "debitCreditNote"));
        oper.setReturnClass(com.leadway.projects.payment.endpoint.DebitCreditNote.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "return"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "Exception"),
                      "com.leadway.projects.payment.endpoint.Exception",
                      new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "Exception"), 
                      true
                     ));
        _operations[12] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("findDebitNoteByPolicyNumber");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "policyNumber"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "hostName"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "debitCreditNote"));
        oper.setReturnClass(com.leadway.projects.payment.endpoint.DebitCreditNote[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "return"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "Exception"),
                      "com.leadway.projects.payment.endpoint.Exception",
                      new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "Exception"), 
                      true
                     ));
        _operations[13] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("findDebitNoteByBranchCode");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "branchCode"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "hostName"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "debitCreditNote"));
        oper.setReturnClass(com.leadway.projects.payment.endpoint.DebitCreditNote[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "return"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "Exception"),
                      "com.leadway.projects.payment.endpoint.Exception",
                      new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "Exception"), 
                      true
                     ));
        _operations[14] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("findPendingDebitNoteListByTransmitStatus");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "hostName"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "debitCreditNote"));
        oper.setReturnClass(com.leadway.projects.payment.endpoint.DebitCreditNote[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "return"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "Exception"),
                      "com.leadway.projects.payment.endpoint.Exception",
                      new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "Exception"), 
                      true
                     ));
        _operations[15] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("saveDebitCreditNoteList");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "dcNoteList"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "debitCreditNote"), com.leadway.projects.payment.endpoint.DebitCreditNote[].class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "configCode"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "hostName"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "debitCreditNote"));
        oper.setReturnClass(com.leadway.projects.payment.endpoint.DebitCreditNote[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "return"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "Exception"),
                      "com.leadway.projects.payment.endpoint.Exception",
                      new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "Exception"), 
                      true
                     ));
        _operations[16] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("saveDebitCreditNote");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "debitNote"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "debitCreditNote"), com.leadway.projects.payment.endpoint.DebitCreditNote.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "configCode"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "hostName"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "debitCreditNote"));
        oper.setReturnClass(com.leadway.projects.payment.endpoint.DebitCreditNote.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "return"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "Exception"),
                      "com.leadway.projects.payment.endpoint.Exception",
                      new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "Exception"), 
                      true
                     ));
        _operations[17] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("reverseDebitCreditNote");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "debitNote"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "debitCreditNote"), com.leadway.projects.payment.endpoint.DebitCreditNote.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "configCode"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "hostName"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "debitCreditNote"));
        oper.setReturnClass(com.leadway.projects.payment.endpoint.DebitCreditNote.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "return"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "Exception"),
                      "com.leadway.projects.payment.endpoint.Exception",
                      new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "Exception"), 
                      true
                     ));
        _operations[18] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("updateDebitNoteOnPaymentSwitchSuccess");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "debitNoteNumber"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "hostName"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "Exception"),
                      "com.leadway.projects.payment.endpoint.Exception",
                      new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "Exception"), 
                      true
                     ));
        _operations[19] = oper;

    }

    private static void _initOperationDesc3(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("updateDebitCreditNote");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "debitNote"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "debitCreditNote"), com.leadway.projects.payment.endpoint.DebitCreditNote.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "hostName"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "Exception"),
                      "com.leadway.projects.payment.endpoint.Exception",
                      new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "Exception"), 
                      true
                     ));
        _operations[20] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("markDebitNoteAsDeleted");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "debitNote"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "debitCreditNote"), com.leadway.projects.payment.endpoint.DebitCreditNote.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "hostName"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "Exception"),
                      "com.leadway.projects.payment.endpoint.Exception",
                      new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "Exception"), 
                      true
                     ));
        _operations[21] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("markDebitNoteAsNotDeleted");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "debitNote"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "debitCreditNote"), com.leadway.projects.payment.endpoint.DebitCreditNote.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "hostName"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "Exception"),
                      "com.leadway.projects.payment.endpoint.Exception",
                      new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "Exception"), 
                      true
                     ));
        _operations[22] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("deleteDebitNote");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "debitNoteNumber"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "hostName"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "Exception"),
                      "com.leadway.projects.payment.endpoint.Exception",
                      new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "Exception"), 
                      true
                     ));
        _operations[23] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("findDebitCreditNoteByCriteria");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "debitNoteCriteria"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "debitCreditNote"), com.leadway.projects.payment.endpoint.DebitCreditNote.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "hostName"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "debitCreditNote"));
        oper.setReturnClass(com.leadway.projects.payment.endpoint.DebitCreditNote[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "return"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "Exception"),
                      "com.leadway.projects.payment.endpoint.Exception",
                      new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "Exception"), 
                      true
                     ));
        _operations[24] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("findInboundPaymentByDebitNoteNumber");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "debitNoteNumber"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "hostName"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "basePayment"));
        oper.setReturnClass(com.leadway.projects.payment.endpoint.BasePayment[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "return"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "Exception"),
                      "com.leadway.projects.payment.endpoint.Exception",
                      new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "Exception"), 
                      true
                     ));
        _operations[25] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("findOutboundPaymentByDebitNoteNumber");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "debitNoteNumber"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "hostName"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "basePayment"));
        oper.setReturnClass(com.leadway.projects.payment.endpoint.BasePayment[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "return"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "Exception"),
                      "com.leadway.projects.payment.endpoint.Exception",
                      new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "Exception"), 
                      true
                     ));
        _operations[26] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("findInboundPaymentByPolicyNumber");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "policyNumber"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "hostName"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "basePayment"));
        oper.setReturnClass(com.leadway.projects.payment.endpoint.BasePayment[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "return"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "Exception"),
                      "com.leadway.projects.payment.endpoint.Exception",
                      new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "Exception"), 
                      true
                     ));
        _operations[27] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("findInboundPaymentByPayer");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "payer"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "hostName"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "basePayment"));
        oper.setReturnClass(com.leadway.projects.payment.endpoint.BasePayment[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "return"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "Exception"),
                      "com.leadway.projects.payment.endpoint.Exception",
                      new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "Exception"), 
                      true
                     ));
        _operations[28] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("findInboundPaymentByAgentCode");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "agentCode"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "hostName"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "basePayment"));
        oper.setReturnClass(com.leadway.projects.payment.endpoint.BasePayment[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "return"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "Exception"),
                      "com.leadway.projects.payment.endpoint.Exception",
                      new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "Exception"), 
                      true
                     ));
        _operations[29] = oper;

    }

    private static void _initOperationDesc4(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("findInboundPaymentByCriteria");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "paymentCriteria"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "basePayment"), com.leadway.projects.payment.endpoint.BasePayment.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "tranDateRange"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "dateRange"), com.leadway.projects.payment.endpoint.DateRange.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "chequeDateRange"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "dateRange"), com.leadway.projects.payment.endpoint.DateRange.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "hostName"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "basePayment"));
        oper.setReturnClass(com.leadway.projects.payment.endpoint.BasePayment[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "return"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "Exception"),
                      "com.leadway.projects.payment.endpoint.Exception",
                      new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "Exception"), 
                      true
                     ));
        _operations[30] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("findInboundPaymentByPaymentDateRange");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "startDate"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "endDate"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "hostName"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "basePayment"));
        oper.setReturnClass(com.leadway.projects.payment.endpoint.BasePayment[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "return"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "Exception"),
                      "com.leadway.projects.payment.endpoint.Exception",
                      new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "Exception"), 
                      true
                     ));
        _operations[31] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("findInboundPaymentByPaymentDate");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "paymentDate"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "hostName"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "basePayment"));
        oper.setReturnClass(com.leadway.projects.payment.endpoint.BasePayment[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "return"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "Exception"),
                      "com.leadway.projects.payment.endpoint.Exception",
                      new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "Exception"), 
                      true
                     ));
        _operations[32] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("findInboundPaymentByReceiptNumber");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "receiptNumber"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "hostName"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "basePayment"));
        oper.setReturnClass(com.leadway.projects.payment.endpoint.BasePayment.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "return"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "Exception"),
                      "com.leadway.projects.payment.endpoint.Exception",
                      new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "Exception"), 
                      true
                     ));
        _operations[33] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("findInboundPaymentByReceiptNumberList");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "receiptNumberList"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String[].class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "hostName"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "basePayment"));
        oper.setReturnClass(com.leadway.projects.payment.endpoint.BasePayment[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "return"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "Exception"),
                      "com.leadway.projects.payment.endpoint.Exception",
                      new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "Exception"), 
                      true
                     ));
        _operations[34] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getInboundPaymentList");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "subsystem"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "startDate"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "endDate"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "hostName"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "basePayment"));
        oper.setReturnClass(com.leadway.projects.payment.endpoint.BasePayment[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "return"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "Exception"),
                      "com.leadway.projects.payment.endpoint.Exception",
                      new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "Exception"), 
                      true
                     ));
        _operations[35] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getPendingPaymentCountBySubsystem");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "subsystem"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "hostName"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        oper.setReturnClass(long.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "return"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "Exception"),
                      "com.leadway.projects.payment.endpoint.Exception",
                      new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "Exception"), 
                      true
                     ));
        _operations[36] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getReceiptNumberListForPendingPaymentsBySubsystem");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "subsystem"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "hostName"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        oper.setReturnClass(java.lang.String[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "return"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "Exception"),
                      "com.leadway.projects.payment.endpoint.Exception",
                      new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "Exception"), 
                      true
                     ));
        _operations[37] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("findPendingPaymentListBySubsystem");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "subsystem"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "hostName"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "basePayment"));
        oper.setReturnClass(com.leadway.projects.payment.endpoint.BasePayment[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "return"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "Exception"),
                      "com.leadway.projects.payment.endpoint.Exception",
                      new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "Exception"), 
                      true
                     ));
        _operations[38] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("findInboundPaymentByRecentInsertionDate");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "subsystem"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "hostName"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "basePayment"));
        oper.setReturnClass(com.leadway.projects.payment.endpoint.BasePayment[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "return"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "Exception"),
                      "com.leadway.projects.payment.endpoint.Exception",
                      new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "Exception"), 
                      true
                     ));
        _operations[39] = oper;

    }

    private static void _initOperationDesc5(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("saveISPayment");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "payment"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "isPayment"), com.leadway.projects.payment.endpoint.IsPayment.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "hostName"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "Exception"),
                      "com.leadway.projects.payment.endpoint.Exception",
                      new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "Exception"), 
                      true
                     ));
        _operations[40] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("saveCashierDCPayment");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "payment"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "paymentForDC"), com.leadway.projects.payment.endpoint.PaymentForDC.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "hostName"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "basePayment"));
        oper.setReturnClass(com.leadway.projects.payment.endpoint.BasePayment.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "return"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "Exception"),
                      "com.leadway.projects.payment.endpoint.Exception",
                      new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "Exception"), 
                      true
                     ));
        _operations[41] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("saveCashierDCBankPayment");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "payment"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "bankPaymentForDC"), com.leadway.projects.payment.endpoint.BankPaymentForDC.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "hostName"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "basePayment"));
        oper.setReturnClass(com.leadway.projects.payment.endpoint.BasePayment.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "return"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "Exception"),
                      "com.leadway.projects.payment.endpoint.Exception",
                      new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "Exception"), 
                      true
                     ));
        _operations[42] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("saveISPaymentList");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "paymentList"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "basePayment"), com.leadway.projects.payment.endpoint.BasePayment[].class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "hostName"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "Exception"),
                      "com.leadway.projects.payment.endpoint.Exception",
                      new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "Exception"), 
                      true
                     ));
        _operations[43] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("updatePayment");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "payment"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "basePayment"), com.leadway.projects.payment.endpoint.BasePayment.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "hostName"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "Exception"),
                      "com.leadway.projects.payment.endpoint.Exception",
                      new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "Exception"), 
                      true
                     ));
        _operations[44] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("updateInboundPaymentOnSubsystemSuccess");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "receiptNumber"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "hostName"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "Exception"),
                      "com.leadway.projects.payment.endpoint.Exception",
                      new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "Exception"), 
                      true
                     ));
        _operations[45] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("savePolicyHolder");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "policyHolder"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "policyHolder"), com.leadway.projects.payment.endpoint.PolicyHolder.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "hostName"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        oper.setReturnClass(java.lang.String.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "return"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "Exception"),
                      "com.leadway.projects.payment.endpoint.Exception",
                      new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "Exception"), 
                      true
                     ));
        _operations[46] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("updatePolicyHolder");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "policyHolder"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "policyHolder"), com.leadway.projects.payment.endpoint.PolicyHolder.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "hostName"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "Exception"),
                      "com.leadway.projects.payment.endpoint.Exception",
                      new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "Exception"), 
                      true
                     ));
        _operations[47] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("updatePolicyHolderByName");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "policyNumber"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "newName"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "hostName"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "Exception"),
                      "com.leadway.projects.payment.endpoint.Exception",
                      new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "Exception"), 
                      true
                     ));
        _operations[48] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("updatePolicyHolderByAgency");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "policyNumber"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "agentCode"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "agentName"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "hostName"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "Exception"),
                      "com.leadway.projects.payment.endpoint.Exception",
                      new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "Exception"), 
                      true
                     ));
        _operations[49] = oper;

    }

    private static void _initOperationDesc6(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("updatePolicyHolderByAddress");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "policyNumber"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "holderAddress"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "hostName"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "Exception"),
                      "com.leadway.projects.payment.endpoint.Exception",
                      new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "Exception"), 
                      true
                     ));
        _operations[50] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("markPolicyHolderAsDeleted");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "policyHolder"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "policyHolder"), com.leadway.projects.payment.endpoint.PolicyHolder.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "hostName"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "Exception"),
                      "com.leadway.projects.payment.endpoint.Exception",
                      new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "Exception"), 
                      true
                     ));
        _operations[51] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("deletePolicyHolder");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "policyHolder"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "policyHolder"), com.leadway.projects.payment.endpoint.PolicyHolder.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "hostName"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "Exception"),
                      "com.leadway.projects.payment.endpoint.Exception",
                      new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "Exception"), 
                      true
                     ));
        _operations[52] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("findPolicyHolderByCriteria");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "policyHolder"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "policyHolder"), com.leadway.projects.payment.endpoint.PolicyHolder.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "hostName"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "policyHolder"));
        oper.setReturnClass(com.leadway.projects.payment.endpoint.PolicyHolder[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "return"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "Exception"),
                      "com.leadway.projects.payment.endpoint.Exception",
                      new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "Exception"), 
                      true
                     ));
        _operations[53] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("findPolicyHolderByPolicyNumber");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "policyNumber"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "hostName"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "policyHolder"));
        oper.setReturnClass(com.leadway.projects.payment.endpoint.PolicyHolder[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "return"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "Exception"),
                      "com.leadway.projects.payment.endpoint.Exception",
                      new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "Exception"), 
                      true
                     ));
        _operations[54] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getPolicyHolderList");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "hostName"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "policyHolder"));
        oper.setReturnClass(com.leadway.projects.payment.endpoint.PolicyHolder[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "return"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "Exception"),
                      "com.leadway.projects.payment.endpoint.Exception",
                      new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "Exception"), 
                      true
                     ));
        _operations[55] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getPolicyHolderListByHolderName");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "policyHolderName"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "hostName"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "policyHolder"));
        oper.setReturnClass(com.leadway.projects.payment.endpoint.PolicyHolder[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "return"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "Exception"),
                      "com.leadway.projects.payment.endpoint.Exception",
                      new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "Exception"), 
                      true
                     ));
        _operations[56] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getPendingPolicyHolderListAndUpdateTransStatusAsInserted");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "hostName"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "policyHolder"));
        oper.setReturnClass(com.leadway.projects.payment.endpoint.PolicyHolder[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "return"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "Exception"),
                      "com.leadway.projects.payment.endpoint.Exception",
                      new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "Exception"), 
                      true
                     ));
        _operations[57] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getPendingPolicyHolderList");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "hostName"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "policyHolder"));
        oper.setReturnClass(com.leadway.projects.payment.endpoint.PolicyHolder[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "return"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "Exception"),
                      "com.leadway.projects.payment.endpoint.Exception",
                      new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "Exception"), 
                      true
                     ));
        _operations[58] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("updatePolicyHolderByTransmitStatus");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "policyNumber"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "hostName"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "Exception"),
                      "com.leadway.projects.payment.endpoint.Exception",
                      new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "Exception"), 
                      true
                     ));
        _operations[59] = oper;

    }

    private static void _initOperationDesc7(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getPolicyHolderListByTransactionDate");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "startDate"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "endDate"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "hostName"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "policyHolder"));
        oper.setReturnClass(com.leadway.projects.payment.endpoint.PolicyHolder[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "return"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "Exception"),
                      "com.leadway.projects.payment.endpoint.Exception",
                      new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "Exception"), 
                      true
                     ));
        _operations[60] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getTransactionByConfigCode");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "configCode"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "hostName"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "transaction"));
        oper.setReturnClass(com.leadway.projects.payment.endpoint.Transaction.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "return"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "Exception"),
                      "com.leadway.projects.payment.endpoint.Exception",
                      new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "Exception"), 
                      true
                     ));
        _operations[61] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getTransactionList");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "hostName"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "transaction"));
        oper.setReturnClass(com.leadway.projects.payment.endpoint.Transaction[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "return"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "Exception"),
                      "com.leadway.projects.payment.endpoint.Exception",
                      new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "Exception"), 
                      true
                     ));
        _operations[62] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getNextReceiptNumber");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "hostName"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        oper.setReturnClass(java.lang.String.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "return"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "Exception"),
                      "com.leadway.projects.payment.endpoint.Exception",
                      new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "Exception"), 
                      true
                     ));
        _operations[63] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getPaymentSourceConstants");
        oper.setReturnType(new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "paymentSourceConstants"));
        oper.setReturnClass(com.leadway.projects.payment.endpoint.PaymentSourceConstants.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "return"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "Exception"),
                      "com.leadway.projects.payment.endpoint.Exception",
                      new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "Exception"), 
                      true
                     ));
        _operations[64] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("dummyMethod");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "subsystem"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "subsystem"), com.leadway.projects.payment.endpoint.Subsystem.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "exceptionMssg"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "exceptionMessage"), com.leadway.projects.payment.endpoint.ExceptionMessage.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "bankPayment"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "bankPaymentForDC"), com.leadway.projects.payment.endpoint.BankPaymentForDC.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "paymentForDC"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "paymentForDC"), com.leadway.projects.payment.endpoint.PaymentForDC.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "isPayment"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "isPayment"), com.leadway.projects.payment.endpoint.IsPayment.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "Exception"),
                      "com.leadway.projects.payment.endpoint.Exception",
                      new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "Exception"), 
                      true
                     ));
        _operations[65] = oper;

    }

    public PaymentManagementPortBindingStub() throws org.apache.axis.AxisFault {
         this(null);
    }

    public PaymentManagementPortBindingStub(java.net.URL endpointURL, javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
         this(service);
         super.cachedEndpoint = endpointURL;
    }

    public PaymentManagementPortBindingStub(javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
        if (service == null) {
            super.service = new org.apache.axis.client.Service();
        } else {
            super.service = service;
        }
        ((org.apache.axis.client.Service)super.service).setTypeMappingVersion("1.2");
            java.lang.Class cls;
            javax.xml.namespace.QName qName;
            javax.xml.namespace.QName qName2;
            java.lang.Class beansf = org.apache.axis.encoding.ser.BeanSerializerFactory.class;
            java.lang.Class beandf = org.apache.axis.encoding.ser.BeanDeserializerFactory.class;
            java.lang.Class enumsf = org.apache.axis.encoding.ser.EnumSerializerFactory.class;
            java.lang.Class enumdf = org.apache.axis.encoding.ser.EnumDeserializerFactory.class;
            java.lang.Class arraysf = org.apache.axis.encoding.ser.ArraySerializerFactory.class;
            java.lang.Class arraydf = org.apache.axis.encoding.ser.ArrayDeserializerFactory.class;
            java.lang.Class simplesf = org.apache.axis.encoding.ser.SimpleSerializerFactory.class;
            java.lang.Class simpledf = org.apache.axis.encoding.ser.SimpleDeserializerFactory.class;
            java.lang.Class simplelistsf = org.apache.axis.encoding.ser.SimpleListSerializerFactory.class;
            java.lang.Class simplelistdf = org.apache.axis.encoding.ser.SimpleListDeserializerFactory.class;
        addBindings0();
        addBindings1();
    }

    private void addBindings0() {
            java.lang.Class cls;
            javax.xml.namespace.QName qName;
            javax.xml.namespace.QName qName2;
            java.lang.Class beansf = org.apache.axis.encoding.ser.BeanSerializerFactory.class;
            java.lang.Class beandf = org.apache.axis.encoding.ser.BeanDeserializerFactory.class;
            java.lang.Class enumsf = org.apache.axis.encoding.ser.EnumSerializerFactory.class;
            java.lang.Class enumdf = org.apache.axis.encoding.ser.EnumDeserializerFactory.class;
            java.lang.Class arraysf = org.apache.axis.encoding.ser.ArraySerializerFactory.class;
            java.lang.Class arraydf = org.apache.axis.encoding.ser.ArrayDeserializerFactory.class;
            java.lang.Class simplesf = org.apache.axis.encoding.ser.SimpleSerializerFactory.class;
            java.lang.Class simpledf = org.apache.axis.encoding.ser.SimpleDeserializerFactory.class;
            java.lang.Class simplelistsf = org.apache.axis.encoding.ser.SimpleListSerializerFactory.class;
            java.lang.Class simplelistdf = org.apache.axis.encoding.ser.SimpleListDeserializerFactory.class;
            qName = new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "account");
            cachedSerQNames.add(qName);
            cls = com.leadway.projects.payment.endpoint.Account.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "bankPaymentForDC");
            cachedSerQNames.add(qName);
            cls = com.leadway.projects.payment.endpoint.BankPaymentForDC.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "basePayment");
            cachedSerQNames.add(qName);
            cls = com.leadway.projects.payment.endpoint.BasePayment.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "chequeType");
            cachedSerQNames.add(qName);
            cls = com.leadway.projects.payment.endpoint.ChequeType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "currentInsurancePeriod");
            cachedSerQNames.add(qName);
            cls = com.leadway.projects.payment.endpoint.CurrentInsurancePeriod.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "dateBean");
            cachedSerQNames.add(qName);
            cls = com.leadway.projects.payment.endpoint.DateBean.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "dateRange");
            cachedSerQNames.add(qName);
            cls = com.leadway.projects.payment.endpoint.DateRange.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "dateVO");
            cachedSerQNames.add(qName);
            cls = com.leadway.projects.payment.endpoint.DateVO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "debitCreditNote");
            cachedSerQNames.add(qName);
            cls = com.leadway.projects.payment.endpoint.DebitCreditNote.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "deleteDebitNote");
            cachedSerQNames.add(qName);
            cls = com.leadway.projects.payment.endpoint.DeleteDebitNote.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "deleteDebitNoteResponse");
            cachedSerQNames.add(qName);
            cls = com.leadway.projects.payment.endpoint.DeleteDebitNoteResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "deletePolicyHolder");
            cachedSerQNames.add(qName);
            cls = com.leadway.projects.payment.endpoint.DeletePolicyHolder.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "deletePolicyHolderResponse");
            cachedSerQNames.add(qName);
            cls = com.leadway.projects.payment.endpoint.DeletePolicyHolderResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "deleteUserAccount");
            cachedSerQNames.add(qName);
            cls = com.leadway.projects.payment.endpoint.DeleteUserAccount.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "deleteUserAccountResponse");
            cachedSerQNames.add(qName);
            cls = com.leadway.projects.payment.endpoint.DeleteUserAccountResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "dummyMethod");
            cachedSerQNames.add(qName);
            cls = com.leadway.projects.payment.endpoint.DummyMethod.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "dummyMethodResponse");
            cachedSerQNames.add(qName);
            cls = com.leadway.projects.payment.endpoint.DummyMethodResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "Exception");
            cachedSerQNames.add(qName);
            cls = com.leadway.projects.payment.endpoint.Exception.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "exceptionMessage");
            cachedSerQNames.add(qName);
            cls = com.leadway.projects.payment.endpoint.ExceptionMessage.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "findDebitCreditNoteByCriteria");
            cachedSerQNames.add(qName);
            cls = com.leadway.projects.payment.endpoint.FindDebitCreditNoteByCriteria.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "findDebitCreditNoteByCriteriaResponse");
            cachedSerQNames.add(qName);
            cls = com.leadway.projects.payment.endpoint.DebitCreditNote[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "debitCreditNote");
            qName2 = new javax.xml.namespace.QName("", "return");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "findDebitNoteByBranchCode");
            cachedSerQNames.add(qName);
            cls = com.leadway.projects.payment.endpoint.FindDebitNoteByBranchCode.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "findDebitNoteByBranchCodeResponse");
            cachedSerQNames.add(qName);
            cls = com.leadway.projects.payment.endpoint.DebitCreditNote[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "debitCreditNote");
            qName2 = new javax.xml.namespace.QName("", "return");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "findDebitNoteByDebitNoteNumber");
            cachedSerQNames.add(qName);
            cls = com.leadway.projects.payment.endpoint.FindDebitNoteByDebitNoteNumber.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "findDebitNoteByDebitNoteNumberResponse");
            cachedSerQNames.add(qName);
            cls = com.leadway.projects.payment.endpoint.FindDebitNoteByDebitNoteNumberResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "findDebitNoteByPolicyNumber");
            cachedSerQNames.add(qName);
            cls = com.leadway.projects.payment.endpoint.FindDebitNoteByPolicyNumber.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "findDebitNoteByPolicyNumberResponse");
            cachedSerQNames.add(qName);
            cls = com.leadway.projects.payment.endpoint.DebitCreditNote[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "debitCreditNote");
            qName2 = new javax.xml.namespace.QName("", "return");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "findInboundPaymentByAgentCode");
            cachedSerQNames.add(qName);
            cls = com.leadway.projects.payment.endpoint.FindInboundPaymentByAgentCode.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "findInboundPaymentByAgentCodeResponse");
            cachedSerQNames.add(qName);
            cls = com.leadway.projects.payment.endpoint.BasePayment[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "basePayment");
            qName2 = new javax.xml.namespace.QName("", "return");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "findInboundPaymentByCriteria");
            cachedSerQNames.add(qName);
            cls = com.leadway.projects.payment.endpoint.FindInboundPaymentByCriteria.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "findInboundPaymentByCriteriaResponse");
            cachedSerQNames.add(qName);
            cls = com.leadway.projects.payment.endpoint.BasePayment[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "basePayment");
            qName2 = new javax.xml.namespace.QName("", "return");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "findInboundPaymentByDebitNoteNumber");
            cachedSerQNames.add(qName);
            cls = com.leadway.projects.payment.endpoint.FindInboundPaymentByDebitNoteNumber.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "findInboundPaymentByDebitNoteNumberResponse");
            cachedSerQNames.add(qName);
            cls = com.leadway.projects.payment.endpoint.BasePayment[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "basePayment");
            qName2 = new javax.xml.namespace.QName("", "return");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "findInboundPaymentByPayer");
            cachedSerQNames.add(qName);
            cls = com.leadway.projects.payment.endpoint.FindInboundPaymentByPayer.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "findInboundPaymentByPayerResponse");
            cachedSerQNames.add(qName);
            cls = com.leadway.projects.payment.endpoint.BasePayment[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "basePayment");
            qName2 = new javax.xml.namespace.QName("", "return");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "findInboundPaymentByPaymentDate");
            cachedSerQNames.add(qName);
            cls = com.leadway.projects.payment.endpoint.FindInboundPaymentByPaymentDate.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "findInboundPaymentByPaymentDateRange");
            cachedSerQNames.add(qName);
            cls = com.leadway.projects.payment.endpoint.FindInboundPaymentByPaymentDateRange.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "findInboundPaymentByPaymentDateRangeResponse");
            cachedSerQNames.add(qName);
            cls = com.leadway.projects.payment.endpoint.BasePayment[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "basePayment");
            qName2 = new javax.xml.namespace.QName("", "return");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "findInboundPaymentByPaymentDateResponse");
            cachedSerQNames.add(qName);
            cls = com.leadway.projects.payment.endpoint.BasePayment[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "basePayment");
            qName2 = new javax.xml.namespace.QName("", "return");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "findInboundPaymentByPolicyNumber");
            cachedSerQNames.add(qName);
            cls = com.leadway.projects.payment.endpoint.FindInboundPaymentByPolicyNumber.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "findInboundPaymentByPolicyNumberResponse");
            cachedSerQNames.add(qName);
            cls = com.leadway.projects.payment.endpoint.BasePayment[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "basePayment");
            qName2 = new javax.xml.namespace.QName("", "return");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "findInboundPaymentByReceiptNumber");
            cachedSerQNames.add(qName);
            cls = com.leadway.projects.payment.endpoint.FindInboundPaymentByReceiptNumber.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "findInboundPaymentByReceiptNumberList");
            cachedSerQNames.add(qName);
            cls = com.leadway.projects.payment.endpoint.FindInboundPaymentByReceiptNumberList.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "findInboundPaymentByReceiptNumberListResponse");
            cachedSerQNames.add(qName);
            cls = com.leadway.projects.payment.endpoint.BasePayment[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "basePayment");
            qName2 = new javax.xml.namespace.QName("", "return");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "findInboundPaymentByReceiptNumberResponse");
            cachedSerQNames.add(qName);
            cls = com.leadway.projects.payment.endpoint.FindInboundPaymentByReceiptNumberResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "findInboundPaymentByRecentInsertionDate");
            cachedSerQNames.add(qName);
            cls = com.leadway.projects.payment.endpoint.FindInboundPaymentByRecentInsertionDate.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "findInboundPaymentByRecentInsertionDateResponse");
            cachedSerQNames.add(qName);
            cls = com.leadway.projects.payment.endpoint.BasePayment[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "basePayment");
            qName2 = new javax.xml.namespace.QName("", "return");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "findOutboundPaymentByDebitNoteNumber");
            cachedSerQNames.add(qName);
            cls = com.leadway.projects.payment.endpoint.FindOutboundPaymentByDebitNoteNumber.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "findOutboundPaymentByDebitNoteNumberResponse");
            cachedSerQNames.add(qName);
            cls = com.leadway.projects.payment.endpoint.BasePayment[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "basePayment");
            qName2 = new javax.xml.namespace.QName("", "return");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "findPendingDebitNoteListByTransmitStatus");
            cachedSerQNames.add(qName);
            cls = com.leadway.projects.payment.endpoint.FindPendingDebitNoteListByTransmitStatus.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "findPendingDebitNoteListByTransmitStatusResponse");
            cachedSerQNames.add(qName);
            cls = com.leadway.projects.payment.endpoint.DebitCreditNote[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "debitCreditNote");
            qName2 = new javax.xml.namespace.QName("", "return");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "findPendingPaymentListBySubsystem");
            cachedSerQNames.add(qName);
            cls = com.leadway.projects.payment.endpoint.FindPendingPaymentListBySubsystem.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "findPendingPaymentListBySubsystemResponse");
            cachedSerQNames.add(qName);
            cls = com.leadway.projects.payment.endpoint.BasePayment[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "basePayment");
            qName2 = new javax.xml.namespace.QName("", "return");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "findPolicyHolderByCriteria");
            cachedSerQNames.add(qName);
            cls = com.leadway.projects.payment.endpoint.FindPolicyHolderByCriteria.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "findPolicyHolderByCriteriaResponse");
            cachedSerQNames.add(qName);
            cls = com.leadway.projects.payment.endpoint.PolicyHolder[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "policyHolder");
            qName2 = new javax.xml.namespace.QName("", "return");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "findPolicyHolderByPolicyNumber");
            cachedSerQNames.add(qName);
            cls = com.leadway.projects.payment.endpoint.FindPolicyHolderByPolicyNumber.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "findPolicyHolderByPolicyNumberResponse");
            cachedSerQNames.add(qName);
            cls = com.leadway.projects.payment.endpoint.PolicyHolder[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "policyHolder");
            qName2 = new javax.xml.namespace.QName("", "return");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "getInboundPaymentList");
            cachedSerQNames.add(qName);
            cls = com.leadway.projects.payment.endpoint.GetInboundPaymentList.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "getInboundPaymentListResponse");
            cachedSerQNames.add(qName);
            cls = com.leadway.projects.payment.endpoint.BasePayment[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "basePayment");
            qName2 = new javax.xml.namespace.QName("", "return");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "getNextReceiptNumber");
            cachedSerQNames.add(qName);
            cls = com.leadway.projects.payment.endpoint.GetNextReceiptNumber.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "getNextReceiptNumberResponse");
            cachedSerQNames.add(qName);
            cls = com.leadway.projects.payment.endpoint.GetNextReceiptNumberResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "getPaymentModeList");
            cachedSerQNames.add(qName);
            cls = com.leadway.projects.payment.endpoint.GetPaymentModeList.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "getPaymentModeListResponse");
            cachedSerQNames.add(qName);
            cls = com.leadway.projects.payment.endpoint.PaymentMode[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "paymentMode");
            qName2 = new javax.xml.namespace.QName("", "return");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "getPaymentSourceConstants");
            cachedSerQNames.add(qName);
            cls = com.leadway.projects.payment.endpoint.GetPaymentSourceConstants.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "getPaymentSourceConstantsResponse");
            cachedSerQNames.add(qName);
            cls = com.leadway.projects.payment.endpoint.GetPaymentSourceConstantsResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "getPendingPaymentCountBySubsystem");
            cachedSerQNames.add(qName);
            cls = com.leadway.projects.payment.endpoint.GetPendingPaymentCountBySubsystem.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "getPendingPaymentCountBySubsystemResponse");
            cachedSerQNames.add(qName);
            cls = com.leadway.projects.payment.endpoint.GetPendingPaymentCountBySubsystemResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "getPendingPolicyHolderList");
            cachedSerQNames.add(qName);
            cls = com.leadway.projects.payment.endpoint.GetPendingPolicyHolderList.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "getPendingPolicyHolderListAndUpdateTransStatusAsInserted");
            cachedSerQNames.add(qName);
            cls = com.leadway.projects.payment.endpoint.GetPendingPolicyHolderListAndUpdateTransStatusAsInserted.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "getPendingPolicyHolderListAndUpdateTransStatusAsInsertedResponse");
            cachedSerQNames.add(qName);
            cls = com.leadway.projects.payment.endpoint.PolicyHolder[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "policyHolder");
            qName2 = new javax.xml.namespace.QName("", "return");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "getPendingPolicyHolderListResponse");
            cachedSerQNames.add(qName);
            cls = com.leadway.projects.payment.endpoint.PolicyHolder[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "policyHolder");
            qName2 = new javax.xml.namespace.QName("", "return");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "getPolicyHolderList");
            cachedSerQNames.add(qName);
            cls = com.leadway.projects.payment.endpoint.GetPolicyHolderList.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "getPolicyHolderListByHolderName");
            cachedSerQNames.add(qName);
            cls = com.leadway.projects.payment.endpoint.GetPolicyHolderListByHolderName.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "getPolicyHolderListByHolderNameResponse");
            cachedSerQNames.add(qName);
            cls = com.leadway.projects.payment.endpoint.PolicyHolder[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "policyHolder");
            qName2 = new javax.xml.namespace.QName("", "return");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "getPolicyHolderListByTransactionDate");
            cachedSerQNames.add(qName);
            cls = com.leadway.projects.payment.endpoint.GetPolicyHolderListByTransactionDate.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "getPolicyHolderListByTransactionDateResponse");
            cachedSerQNames.add(qName);
            cls = com.leadway.projects.payment.endpoint.PolicyHolder[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "policyHolder");
            qName2 = new javax.xml.namespace.QName("", "return");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "getPolicyHolderListResponse");
            cachedSerQNames.add(qName);
            cls = com.leadway.projects.payment.endpoint.PolicyHolder[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "policyHolder");
            qName2 = new javax.xml.namespace.QName("", "return");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "getReceiptNumberListForPendingPaymentsBySubsystem");
            cachedSerQNames.add(qName);
            cls = com.leadway.projects.payment.endpoint.GetReceiptNumberListForPendingPaymentsBySubsystem.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "getReceiptNumberListForPendingPaymentsBySubsystemResponse");
            cachedSerQNames.add(qName);
            cls = java.lang.String[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string");
            qName2 = new javax.xml.namespace.QName("", "return");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "getSubsystemList");
            cachedSerQNames.add(qName);
            cls = com.leadway.projects.payment.endpoint.GetSubsystemList.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "getSubsystemListResponse");
            cachedSerQNames.add(qName);
            cls = com.leadway.projects.payment.endpoint.Subsystem[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "subsystem");
            qName2 = new javax.xml.namespace.QName("", "return");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "getTransactionByConfigCode");
            cachedSerQNames.add(qName);
            cls = com.leadway.projects.payment.endpoint.GetTransactionByConfigCode.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "getTransactionByConfigCodeResponse");
            cachedSerQNames.add(qName);
            cls = com.leadway.projects.payment.endpoint.GetTransactionByConfigCodeResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "getTransactionList");
            cachedSerQNames.add(qName);
            cls = com.leadway.projects.payment.endpoint.GetTransactionList.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "getTransactionListResponse");
            cachedSerQNames.add(qName);
            cls = com.leadway.projects.payment.endpoint.Transaction[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "transaction");
            qName2 = new javax.xml.namespace.QName("", "return");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "hasUsers");
            cachedSerQNames.add(qName);
            cls = com.leadway.projects.payment.endpoint.HasUsers.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "hasUsersResponse");
            cachedSerQNames.add(qName);
            cls = com.leadway.projects.payment.endpoint.HasUsersResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "insertUserAccount");
            cachedSerQNames.add(qName);
            cls = com.leadway.projects.payment.endpoint.InsertUserAccount.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "insertUserAccountResponse");
            cachedSerQNames.add(qName);
            cls = com.leadway.projects.payment.endpoint.InsertUserAccountResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "isPayment");
            cachedSerQNames.add(qName);
            cls = com.leadway.projects.payment.endpoint.IsPayment.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "loadChequeTypeList");
            cachedSerQNames.add(qName);
            cls = com.leadway.projects.payment.endpoint.LoadChequeTypeList.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "loadChequeTypeListResponse");
            cachedSerQNames.add(qName);
            cls = com.leadway.projects.payment.endpoint.ChequeType[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "chequeType");
            qName2 = new javax.xml.namespace.QName("", "return");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "loadNarrationList");
            cachedSerQNames.add(qName);
            cls = com.leadway.projects.payment.endpoint.LoadNarrationList.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "loadNarrationListResponse");
            cachedSerQNames.add(qName);
            cls = com.leadway.projects.payment.endpoint.Narration[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "narration");
            qName2 = new javax.xml.namespace.QName("", "return");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "loginUser");
            cachedSerQNames.add(qName);
            cls = com.leadway.projects.payment.endpoint.LoginUser.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "loginUserResponse");
            cachedSerQNames.add(qName);
            cls = com.leadway.projects.payment.endpoint.LoginUserResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "markDebitNoteAsDeleted");
            cachedSerQNames.add(qName);
            cls = com.leadway.projects.payment.endpoint.MarkDebitNoteAsDeleted.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "markDebitNoteAsDeletedResponse");
            cachedSerQNames.add(qName);
            cls = com.leadway.projects.payment.endpoint.MarkDebitNoteAsDeletedResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "markDebitNoteAsNotDeleted");
            cachedSerQNames.add(qName);
            cls = com.leadway.projects.payment.endpoint.MarkDebitNoteAsNotDeleted.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "markDebitNoteAsNotDeletedResponse");
            cachedSerQNames.add(qName);
            cls = com.leadway.projects.payment.endpoint.MarkDebitNoteAsNotDeletedResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

    }
    private void addBindings1() {
            java.lang.Class cls;
            javax.xml.namespace.QName qName;
            javax.xml.namespace.QName qName2;
            java.lang.Class beansf = org.apache.axis.encoding.ser.BeanSerializerFactory.class;
            java.lang.Class beandf = org.apache.axis.encoding.ser.BeanDeserializerFactory.class;
            java.lang.Class enumsf = org.apache.axis.encoding.ser.EnumSerializerFactory.class;
            java.lang.Class enumdf = org.apache.axis.encoding.ser.EnumDeserializerFactory.class;
            java.lang.Class arraysf = org.apache.axis.encoding.ser.ArraySerializerFactory.class;
            java.lang.Class arraydf = org.apache.axis.encoding.ser.ArrayDeserializerFactory.class;
            java.lang.Class simplesf = org.apache.axis.encoding.ser.SimpleSerializerFactory.class;
            java.lang.Class simpledf = org.apache.axis.encoding.ser.SimpleDeserializerFactory.class;
            java.lang.Class simplelistsf = org.apache.axis.encoding.ser.SimpleListSerializerFactory.class;
            java.lang.Class simplelistdf = org.apache.axis.encoding.ser.SimpleListDeserializerFactory.class;
            qName = new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "markPolicyHolderAsDeleted");
            cachedSerQNames.add(qName);
            cls = com.leadway.projects.payment.endpoint.MarkPolicyHolderAsDeleted.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "markPolicyHolderAsDeletedResponse");
            cachedSerQNames.add(qName);
            cls = com.leadway.projects.payment.endpoint.MarkPolicyHolderAsDeletedResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "narration");
            cachedSerQNames.add(qName);
            cls = com.leadway.projects.payment.endpoint.Narration.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "paymentForDC");
            cachedSerQNames.add(qName);
            cls = com.leadway.projects.payment.endpoint.PaymentForDC.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "paymentMode");
            cachedSerQNames.add(qName);
            cls = com.leadway.projects.payment.endpoint.PaymentMode.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "paymentSourceConstants");
            cachedSerQNames.add(qName);
            cls = com.leadway.projects.payment.endpoint.PaymentSourceConstants.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "policyHolder");
            cachedSerQNames.add(qName);
            cls = com.leadway.projects.payment.endpoint.PolicyHolder.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "policyPrefixConfig");
            cachedSerQNames.add(qName);
            cls = com.leadway.projects.payment.endpoint.PolicyPrefixConfig.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "refreshSwitchScheduler");
            cachedSerQNames.add(qName);
            cls = com.leadway.projects.payment.endpoint.RefreshSwitchScheduler.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "refreshSwitchSchedulerResponse");
            cachedSerQNames.add(qName);
            cls = com.leadway.projects.payment.endpoint.RefreshSwitchSchedulerResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "reverseDebitCreditNote");
            cachedSerQNames.add(qName);
            cls = com.leadway.projects.payment.endpoint.ReverseDebitCreditNote.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "reverseDebitCreditNoteResponse");
            cachedSerQNames.add(qName);
            cls = com.leadway.projects.payment.endpoint.ReverseDebitCreditNoteResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "saveCashierDCBankPayment");
            cachedSerQNames.add(qName);
            cls = com.leadway.projects.payment.endpoint.SaveCashierDCBankPayment.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "saveCashierDCBankPaymentResponse");
            cachedSerQNames.add(qName);
            cls = com.leadway.projects.payment.endpoint.SaveCashierDCBankPaymentResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "saveCashierDCPayment");
            cachedSerQNames.add(qName);
            cls = com.leadway.projects.payment.endpoint.SaveCashierDCPayment.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "saveCashierDCPaymentResponse");
            cachedSerQNames.add(qName);
            cls = com.leadway.projects.payment.endpoint.SaveCashierDCPaymentResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "saveDebitCreditNote");
            cachedSerQNames.add(qName);
            cls = com.leadway.projects.payment.endpoint.SaveDebitCreditNote.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "saveDebitCreditNoteList");
            cachedSerQNames.add(qName);
            cls = com.leadway.projects.payment.endpoint.SaveDebitCreditNoteList.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "saveDebitCreditNoteListResponse");
            cachedSerQNames.add(qName);
            cls = com.leadway.projects.payment.endpoint.DebitCreditNote[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "debitCreditNote");
            qName2 = new javax.xml.namespace.QName("", "return");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "saveDebitCreditNoteResponse");
            cachedSerQNames.add(qName);
            cls = com.leadway.projects.payment.endpoint.SaveDebitCreditNoteResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "saveISPayment");
            cachedSerQNames.add(qName);
            cls = com.leadway.projects.payment.endpoint.SaveISPayment.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "saveISPaymentList");
            cachedSerQNames.add(qName);
            cls = com.leadway.projects.payment.endpoint.SaveISPaymentList.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "saveISPaymentListResponse");
            cachedSerQNames.add(qName);
            cls = com.leadway.projects.payment.endpoint.SaveISPaymentListResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "saveISPaymentResponse");
            cachedSerQNames.add(qName);
            cls = com.leadway.projects.payment.endpoint.SaveISPaymentResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "savePolicyHolder");
            cachedSerQNames.add(qName);
            cls = com.leadway.projects.payment.endpoint.SavePolicyHolder.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "savePolicyHolderResponse");
            cachedSerQNames.add(qName);
            cls = com.leadway.projects.payment.endpoint.SavePolicyHolderResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "selectItem");
            cachedSerQNames.add(qName);
            cls = com.leadway.projects.payment.endpoint.SelectItem.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "startSwitchScheduler");
            cachedSerQNames.add(qName);
            cls = com.leadway.projects.payment.endpoint.StartSwitchScheduler.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "startSwitchSchedulerResponse");
            cachedSerQNames.add(qName);
            cls = com.leadway.projects.payment.endpoint.StartSwitchSchedulerResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "stopSwitchScheduler");
            cachedSerQNames.add(qName);
            cls = com.leadway.projects.payment.endpoint.StopSwitchScheduler.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "stopSwitchSchedulerResponse");
            cachedSerQNames.add(qName);
            cls = com.leadway.projects.payment.endpoint.StopSwitchSchedulerResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "subsystem");
            cachedSerQNames.add(qName);
            cls = com.leadway.projects.payment.endpoint.Subsystem.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "subsystemConfig");
            cachedSerQNames.add(qName);
            cls = com.leadway.projects.payment.endpoint.SubsystemConfig.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "transaction");
            cachedSerQNames.add(qName);
            cls = com.leadway.projects.payment.endpoint.Transaction.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "updateDebitCreditNote");
            cachedSerQNames.add(qName);
            cls = com.leadway.projects.payment.endpoint.UpdateDebitCreditNote.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "updateDebitCreditNoteResponse");
            cachedSerQNames.add(qName);
            cls = com.leadway.projects.payment.endpoint.UpdateDebitCreditNoteResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "updateDebitNoteOnPaymentSwitchSuccess");
            cachedSerQNames.add(qName);
            cls = com.leadway.projects.payment.endpoint.UpdateDebitNoteOnPaymentSwitchSuccess.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "updateDebitNoteOnPaymentSwitchSuccessResponse");
            cachedSerQNames.add(qName);
            cls = com.leadway.projects.payment.endpoint.UpdateDebitNoteOnPaymentSwitchSuccessResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "updateInboundPaymentOnSubsystemSuccess");
            cachedSerQNames.add(qName);
            cls = com.leadway.projects.payment.endpoint.UpdateInboundPaymentOnSubsystemSuccess.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "updateInboundPaymentOnSubsystemSuccessResponse");
            cachedSerQNames.add(qName);
            cls = com.leadway.projects.payment.endpoint.UpdateInboundPaymentOnSubsystemSuccessResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "updatePayment");
            cachedSerQNames.add(qName);
            cls = com.leadway.projects.payment.endpoint.UpdatePayment.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "updatePaymentResponse");
            cachedSerQNames.add(qName);
            cls = com.leadway.projects.payment.endpoint.UpdatePaymentResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "updatePolicyHolder");
            cachedSerQNames.add(qName);
            cls = com.leadway.projects.payment.endpoint.UpdatePolicyHolder.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "updatePolicyHolderByAddress");
            cachedSerQNames.add(qName);
            cls = com.leadway.projects.payment.endpoint.UpdatePolicyHolderByAddress.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "updatePolicyHolderByAddressResponse");
            cachedSerQNames.add(qName);
            cls = com.leadway.projects.payment.endpoint.UpdatePolicyHolderByAddressResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "updatePolicyHolderByAgency");
            cachedSerQNames.add(qName);
            cls = com.leadway.projects.payment.endpoint.UpdatePolicyHolderByAgency.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "updatePolicyHolderByAgencyResponse");
            cachedSerQNames.add(qName);
            cls = com.leadway.projects.payment.endpoint.UpdatePolicyHolderByAgencyResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "updatePolicyHolderByName");
            cachedSerQNames.add(qName);
            cls = com.leadway.projects.payment.endpoint.UpdatePolicyHolderByName.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "updatePolicyHolderByNameResponse");
            cachedSerQNames.add(qName);
            cls = com.leadway.projects.payment.endpoint.UpdatePolicyHolderByNameResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "updatePolicyHolderByTransmitStatus");
            cachedSerQNames.add(qName);
            cls = com.leadway.projects.payment.endpoint.UpdatePolicyHolderByTransmitStatus.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "updatePolicyHolderByTransmitStatusResponse");
            cachedSerQNames.add(qName);
            cls = com.leadway.projects.payment.endpoint.UpdatePolicyHolderByTransmitStatusResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "updatePolicyHolderResponse");
            cachedSerQNames.add(qName);
            cls = com.leadway.projects.payment.endpoint.UpdatePolicyHolderResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "updateUserAccount");
            cachedSerQNames.add(qName);
            cls = com.leadway.projects.payment.endpoint.UpdateUserAccount.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "updateUserAccountResponse");
            cachedSerQNames.add(qName);
            cls = com.leadway.projects.payment.endpoint.UpdateUserAccountResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "userAccount");
            cachedSerQNames.add(qName);
            cls = com.leadway.projects.payment.endpoint.UserAccount.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

    }

    protected org.apache.axis.client.Call createCall() throws java.rmi.RemoteException {
        try {
            org.apache.axis.client.Call _call = super._createCall();
            if (super.maintainSessionSet) {
                _call.setMaintainSession(super.maintainSession);
            }
            if (super.cachedUsername != null) {
                _call.setUsername(super.cachedUsername);
            }
            if (super.cachedPassword != null) {
                _call.setPassword(super.cachedPassword);
            }
            if (super.cachedEndpoint != null) {
                _call.setTargetEndpointAddress(super.cachedEndpoint);
            }
            if (super.cachedTimeout != null) {
                _call.setTimeout(super.cachedTimeout);
            }
            if (super.cachedPortName != null) {
                _call.setPortName(super.cachedPortName);
            }
            java.util.Enumeration keys = super.cachedProperties.keys();
            while (keys.hasMoreElements()) {
                java.lang.String key = (java.lang.String) keys.nextElement();
                _call.setProperty(key, super.cachedProperties.get(key));
            }
            // All the type mapping information is registered
            // when the first call is made.
            // The type mapping information is actually registered in
            // the TypeMappingRegistry of the service, which
            // is the reason why registration is only needed for the first call.
            synchronized (this) {
                if (firstCall()) {
                    // must set encoding style before registering serializers
                    _call.setEncodingStyle(null);
                    for (int i = 0; i < cachedSerFactories.size(); ++i) {
                        java.lang.Class cls = (java.lang.Class) cachedSerClasses.get(i);
                        javax.xml.namespace.QName qName =
                                (javax.xml.namespace.QName) cachedSerQNames.get(i);
                        java.lang.Object x = cachedSerFactories.get(i);
                        if (x instanceof Class) {
                            java.lang.Class sf = (java.lang.Class)
                                 cachedSerFactories.get(i);
                            java.lang.Class df = (java.lang.Class)
                                 cachedDeserFactories.get(i);
                            _call.registerTypeMapping(cls, qName, sf, df, false);
                        }
                        else if (x instanceof javax.xml.rpc.encoding.SerializerFactory) {
                            org.apache.axis.encoding.SerializerFactory sf = (org.apache.axis.encoding.SerializerFactory)
                                 cachedSerFactories.get(i);
                            org.apache.axis.encoding.DeserializerFactory df = (org.apache.axis.encoding.DeserializerFactory)
                                 cachedDeserFactories.get(i);
                            _call.registerTypeMapping(cls, qName, sf, df, false);
                        }
                    }
                }
            }
            return _call;
        }
        catch (java.lang.Throwable _t) {
            throw new org.apache.axis.AxisFault("Failure trying to get the Call object", _t);
        }
    }

    public boolean hasUsers(java.lang.String hostName) throws java.rmi.RemoteException, com.leadway.projects.payment.endpoint.Exception {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[0]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "hasUsers"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {hostName});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return ((java.lang.Boolean) _resp).booleanValue();
            } catch (java.lang.Exception _exception) {
                return ((java.lang.Boolean) org.apache.axis.utils.JavaUtils.convert(_resp, boolean.class)).booleanValue();
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.leadway.projects.payment.endpoint.Exception) {
              throw (com.leadway.projects.payment.endpoint.Exception) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public void insertUserAccount(com.leadway.projects.payment.endpoint.UserAccount userAcct, java.lang.String hostName) throws java.rmi.RemoteException, com.leadway.projects.payment.endpoint.Exception {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[1]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "insertUserAccount"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {userAcct, hostName});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        extractAttachments(_call);
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.leadway.projects.payment.endpoint.Exception) {
              throw (com.leadway.projects.payment.endpoint.Exception) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public com.leadway.projects.payment.endpoint.UserAccount loginUser(com.leadway.projects.payment.endpoint.UserAccount userAcct, java.lang.String hostName) throws java.rmi.RemoteException, com.leadway.projects.payment.endpoint.Exception {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[2]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "loginUser"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {userAcct, hostName});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.leadway.projects.payment.endpoint.UserAccount) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.leadway.projects.payment.endpoint.UserAccount) org.apache.axis.utils.JavaUtils.convert(_resp, com.leadway.projects.payment.endpoint.UserAccount.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.leadway.projects.payment.endpoint.Exception) {
              throw (com.leadway.projects.payment.endpoint.Exception) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public void updateUserAccount(com.leadway.projects.payment.endpoint.UserAccount userAcct, java.lang.String hostName) throws java.rmi.RemoteException, com.leadway.projects.payment.endpoint.Exception {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[3]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "updateUserAccount"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {userAcct, hostName});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        extractAttachments(_call);
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.leadway.projects.payment.endpoint.Exception) {
              throw (com.leadway.projects.payment.endpoint.Exception) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public void deleteUserAccount(com.leadway.projects.payment.endpoint.UserAccount userAcct, java.lang.String hostName) throws java.rmi.RemoteException, com.leadway.projects.payment.endpoint.Exception {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[4]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "deleteUserAccount"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {userAcct, hostName});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        extractAttachments(_call);
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.leadway.projects.payment.endpoint.Exception) {
              throw (com.leadway.projects.payment.endpoint.Exception) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public void startSwitchScheduler() throws java.rmi.RemoteException, com.leadway.projects.payment.endpoint.Exception {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[5]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "startSwitchScheduler"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        extractAttachments(_call);
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.leadway.projects.payment.endpoint.Exception) {
              throw (com.leadway.projects.payment.endpoint.Exception) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public void stopSwitchScheduler() throws java.rmi.RemoteException, com.leadway.projects.payment.endpoint.Exception {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[6]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "stopSwitchScheduler"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        extractAttachments(_call);
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.leadway.projects.payment.endpoint.Exception) {
              throw (com.leadway.projects.payment.endpoint.Exception) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public void refreshSwitchScheduler() throws java.rmi.RemoteException, com.leadway.projects.payment.endpoint.Exception {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[7]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "refreshSwitchScheduler"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        extractAttachments(_call);
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.leadway.projects.payment.endpoint.Exception) {
              throw (com.leadway.projects.payment.endpoint.Exception) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public com.leadway.projects.payment.endpoint.PaymentMode[] getPaymentModeList(java.lang.String userName, java.lang.String hostName) throws java.rmi.RemoteException, com.leadway.projects.payment.endpoint.Exception {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[8]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "getPaymentModeList"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {userName, hostName});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.leadway.projects.payment.endpoint.PaymentMode[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.leadway.projects.payment.endpoint.PaymentMode[]) org.apache.axis.utils.JavaUtils.convert(_resp, com.leadway.projects.payment.endpoint.PaymentMode[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.leadway.projects.payment.endpoint.Exception) {
              throw (com.leadway.projects.payment.endpoint.Exception) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public com.leadway.projects.payment.endpoint.Subsystem[] getSubsystemList(java.lang.String userName, java.lang.String hostName) throws java.rmi.RemoteException, com.leadway.projects.payment.endpoint.Exception {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[9]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "getSubsystemList"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {userName, hostName});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.leadway.projects.payment.endpoint.Subsystem[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.leadway.projects.payment.endpoint.Subsystem[]) org.apache.axis.utils.JavaUtils.convert(_resp, com.leadway.projects.payment.endpoint.Subsystem[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.leadway.projects.payment.endpoint.Exception) {
              throw (com.leadway.projects.payment.endpoint.Exception) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public com.leadway.projects.payment.endpoint.Narration[] loadNarrationList(java.lang.String userName, java.lang.String hostName) throws java.rmi.RemoteException, com.leadway.projects.payment.endpoint.Exception {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[10]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "loadNarrationList"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {userName, hostName});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.leadway.projects.payment.endpoint.Narration[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.leadway.projects.payment.endpoint.Narration[]) org.apache.axis.utils.JavaUtils.convert(_resp, com.leadway.projects.payment.endpoint.Narration[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.leadway.projects.payment.endpoint.Exception) {
              throw (com.leadway.projects.payment.endpoint.Exception) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public com.leadway.projects.payment.endpoint.ChequeType[] loadChequeTypeList(java.lang.String userName, java.lang.String hostName) throws java.rmi.RemoteException, com.leadway.projects.payment.endpoint.Exception {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[11]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "loadChequeTypeList"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {userName, hostName});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.leadway.projects.payment.endpoint.ChequeType[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.leadway.projects.payment.endpoint.ChequeType[]) org.apache.axis.utils.JavaUtils.convert(_resp, com.leadway.projects.payment.endpoint.ChequeType[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.leadway.projects.payment.endpoint.Exception) {
              throw (com.leadway.projects.payment.endpoint.Exception) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public com.leadway.projects.payment.endpoint.DebitCreditNote findDebitNoteByDebitNoteNumber(java.lang.String debitNoteNumber, java.lang.String hostName) throws java.rmi.RemoteException, com.leadway.projects.payment.endpoint.Exception {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[12]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "findDebitNoteByDebitNoteNumber"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {debitNoteNumber, hostName});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.leadway.projects.payment.endpoint.DebitCreditNote) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.leadway.projects.payment.endpoint.DebitCreditNote) org.apache.axis.utils.JavaUtils.convert(_resp, com.leadway.projects.payment.endpoint.DebitCreditNote.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.leadway.projects.payment.endpoint.Exception) {
              throw (com.leadway.projects.payment.endpoint.Exception) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public com.leadway.projects.payment.endpoint.DebitCreditNote[] findDebitNoteByPolicyNumber(java.lang.String policyNumber, java.lang.String hostName) throws java.rmi.RemoteException, com.leadway.projects.payment.endpoint.Exception {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[13]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "findDebitNoteByPolicyNumber"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {policyNumber, hostName});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.leadway.projects.payment.endpoint.DebitCreditNote[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.leadway.projects.payment.endpoint.DebitCreditNote[]) org.apache.axis.utils.JavaUtils.convert(_resp, com.leadway.projects.payment.endpoint.DebitCreditNote[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.leadway.projects.payment.endpoint.Exception) {
              throw (com.leadway.projects.payment.endpoint.Exception) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public com.leadway.projects.payment.endpoint.DebitCreditNote[] findDebitNoteByBranchCode(java.lang.String branchCode, java.lang.String hostName) throws java.rmi.RemoteException, com.leadway.projects.payment.endpoint.Exception {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[14]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "findDebitNoteByBranchCode"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {branchCode, hostName});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.leadway.projects.payment.endpoint.DebitCreditNote[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.leadway.projects.payment.endpoint.DebitCreditNote[]) org.apache.axis.utils.JavaUtils.convert(_resp, com.leadway.projects.payment.endpoint.DebitCreditNote[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.leadway.projects.payment.endpoint.Exception) {
              throw (com.leadway.projects.payment.endpoint.Exception) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public com.leadway.projects.payment.endpoint.DebitCreditNote[] findPendingDebitNoteListByTransmitStatus(java.lang.String hostName) throws java.rmi.RemoteException, com.leadway.projects.payment.endpoint.Exception {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[15]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "findPendingDebitNoteListByTransmitStatus"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {hostName});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.leadway.projects.payment.endpoint.DebitCreditNote[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.leadway.projects.payment.endpoint.DebitCreditNote[]) org.apache.axis.utils.JavaUtils.convert(_resp, com.leadway.projects.payment.endpoint.DebitCreditNote[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.leadway.projects.payment.endpoint.Exception) {
              throw (com.leadway.projects.payment.endpoint.Exception) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public com.leadway.projects.payment.endpoint.DebitCreditNote[] saveDebitCreditNoteList(com.leadway.projects.payment.endpoint.DebitCreditNote[] dcNoteList, java.lang.String configCode, java.lang.String hostName) throws java.rmi.RemoteException, com.leadway.projects.payment.endpoint.Exception {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[16]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "saveDebitCreditNoteList"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {dcNoteList, configCode, hostName});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.leadway.projects.payment.endpoint.DebitCreditNote[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.leadway.projects.payment.endpoint.DebitCreditNote[]) org.apache.axis.utils.JavaUtils.convert(_resp, com.leadway.projects.payment.endpoint.DebitCreditNote[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.leadway.projects.payment.endpoint.Exception) {
              throw (com.leadway.projects.payment.endpoint.Exception) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public com.leadway.projects.payment.endpoint.DebitCreditNote saveDebitCreditNote(com.leadway.projects.payment.endpoint.DebitCreditNote debitNote, java.lang.String configCode, java.lang.String hostName) throws java.rmi.RemoteException, com.leadway.projects.payment.endpoint.Exception {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[17]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "saveDebitCreditNote"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {debitNote, configCode, hostName});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.leadway.projects.payment.endpoint.DebitCreditNote) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.leadway.projects.payment.endpoint.DebitCreditNote) org.apache.axis.utils.JavaUtils.convert(_resp, com.leadway.projects.payment.endpoint.DebitCreditNote.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.leadway.projects.payment.endpoint.Exception) {
              throw (com.leadway.projects.payment.endpoint.Exception) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public com.leadway.projects.payment.endpoint.DebitCreditNote reverseDebitCreditNote(com.leadway.projects.payment.endpoint.DebitCreditNote debitNote, java.lang.String configCode, java.lang.String hostName) throws java.rmi.RemoteException, com.leadway.projects.payment.endpoint.Exception {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[18]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "reverseDebitCreditNote"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {debitNote, configCode, hostName});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.leadway.projects.payment.endpoint.DebitCreditNote) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.leadway.projects.payment.endpoint.DebitCreditNote) org.apache.axis.utils.JavaUtils.convert(_resp, com.leadway.projects.payment.endpoint.DebitCreditNote.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.leadway.projects.payment.endpoint.Exception) {
              throw (com.leadway.projects.payment.endpoint.Exception) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public void updateDebitNoteOnPaymentSwitchSuccess(java.lang.String debitNoteNumber, java.lang.String hostName) throws java.rmi.RemoteException, com.leadway.projects.payment.endpoint.Exception {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[19]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "updateDebitNoteOnPaymentSwitchSuccess"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {debitNoteNumber, hostName});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        extractAttachments(_call);
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.leadway.projects.payment.endpoint.Exception) {
              throw (com.leadway.projects.payment.endpoint.Exception) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public void updateDebitCreditNote(com.leadway.projects.payment.endpoint.DebitCreditNote debitNote, java.lang.String hostName) throws java.rmi.RemoteException, com.leadway.projects.payment.endpoint.Exception {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[20]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "updateDebitCreditNote"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {debitNote, hostName});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        extractAttachments(_call);
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.leadway.projects.payment.endpoint.Exception) {
              throw (com.leadway.projects.payment.endpoint.Exception) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public void markDebitNoteAsDeleted(com.leadway.projects.payment.endpoint.DebitCreditNote debitNote, java.lang.String hostName) throws java.rmi.RemoteException, com.leadway.projects.payment.endpoint.Exception {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[21]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "markDebitNoteAsDeleted"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {debitNote, hostName});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        extractAttachments(_call);
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.leadway.projects.payment.endpoint.Exception) {
              throw (com.leadway.projects.payment.endpoint.Exception) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public void markDebitNoteAsNotDeleted(com.leadway.projects.payment.endpoint.DebitCreditNote debitNote, java.lang.String hostName) throws java.rmi.RemoteException, com.leadway.projects.payment.endpoint.Exception {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[22]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "markDebitNoteAsNotDeleted"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {debitNote, hostName});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        extractAttachments(_call);
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.leadway.projects.payment.endpoint.Exception) {
              throw (com.leadway.projects.payment.endpoint.Exception) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public void deleteDebitNote(java.lang.String debitNoteNumber, java.lang.String hostName) throws java.rmi.RemoteException, com.leadway.projects.payment.endpoint.Exception {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[23]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "deleteDebitNote"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {debitNoteNumber, hostName});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        extractAttachments(_call);
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.leadway.projects.payment.endpoint.Exception) {
              throw (com.leadway.projects.payment.endpoint.Exception) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public com.leadway.projects.payment.endpoint.DebitCreditNote[] findDebitCreditNoteByCriteria(com.leadway.projects.payment.endpoint.DebitCreditNote debitNoteCriteria, java.lang.String hostName) throws java.rmi.RemoteException, com.leadway.projects.payment.endpoint.Exception {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[24]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "findDebitCreditNoteByCriteria"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {debitNoteCriteria, hostName});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.leadway.projects.payment.endpoint.DebitCreditNote[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.leadway.projects.payment.endpoint.DebitCreditNote[]) org.apache.axis.utils.JavaUtils.convert(_resp, com.leadway.projects.payment.endpoint.DebitCreditNote[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.leadway.projects.payment.endpoint.Exception) {
              throw (com.leadway.projects.payment.endpoint.Exception) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public com.leadway.projects.payment.endpoint.BasePayment[] findInboundPaymentByDebitNoteNumber(java.lang.String debitNoteNumber, java.lang.String hostName) throws java.rmi.RemoteException, com.leadway.projects.payment.endpoint.Exception {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[25]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "findInboundPaymentByDebitNoteNumber"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {debitNoteNumber, hostName});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.leadway.projects.payment.endpoint.BasePayment[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.leadway.projects.payment.endpoint.BasePayment[]) org.apache.axis.utils.JavaUtils.convert(_resp, com.leadway.projects.payment.endpoint.BasePayment[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.leadway.projects.payment.endpoint.Exception) {
              throw (com.leadway.projects.payment.endpoint.Exception) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public com.leadway.projects.payment.endpoint.BasePayment[] findOutboundPaymentByDebitNoteNumber(java.lang.String debitNoteNumber, java.lang.String hostName) throws java.rmi.RemoteException, com.leadway.projects.payment.endpoint.Exception {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[26]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "findOutboundPaymentByDebitNoteNumber"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {debitNoteNumber, hostName});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.leadway.projects.payment.endpoint.BasePayment[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.leadway.projects.payment.endpoint.BasePayment[]) org.apache.axis.utils.JavaUtils.convert(_resp, com.leadway.projects.payment.endpoint.BasePayment[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.leadway.projects.payment.endpoint.Exception) {
              throw (com.leadway.projects.payment.endpoint.Exception) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public com.leadway.projects.payment.endpoint.BasePayment[] findInboundPaymentByPolicyNumber(java.lang.String policyNumber, java.lang.String hostName) throws java.rmi.RemoteException, com.leadway.projects.payment.endpoint.Exception {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[27]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "findInboundPaymentByPolicyNumber"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {policyNumber, hostName});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.leadway.projects.payment.endpoint.BasePayment[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.leadway.projects.payment.endpoint.BasePayment[]) org.apache.axis.utils.JavaUtils.convert(_resp, com.leadway.projects.payment.endpoint.BasePayment[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.leadway.projects.payment.endpoint.Exception) {
              throw (com.leadway.projects.payment.endpoint.Exception) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public com.leadway.projects.payment.endpoint.BasePayment[] findInboundPaymentByPayer(java.lang.String payer, java.lang.String hostName) throws java.rmi.RemoteException, com.leadway.projects.payment.endpoint.Exception {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[28]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "findInboundPaymentByPayer"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {payer, hostName});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.leadway.projects.payment.endpoint.BasePayment[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.leadway.projects.payment.endpoint.BasePayment[]) org.apache.axis.utils.JavaUtils.convert(_resp, com.leadway.projects.payment.endpoint.BasePayment[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.leadway.projects.payment.endpoint.Exception) {
              throw (com.leadway.projects.payment.endpoint.Exception) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public com.leadway.projects.payment.endpoint.BasePayment[] findInboundPaymentByAgentCode(java.lang.String agentCode, java.lang.String hostName) throws java.rmi.RemoteException, com.leadway.projects.payment.endpoint.Exception {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[29]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "findInboundPaymentByAgentCode"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {agentCode, hostName});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.leadway.projects.payment.endpoint.BasePayment[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.leadway.projects.payment.endpoint.BasePayment[]) org.apache.axis.utils.JavaUtils.convert(_resp, com.leadway.projects.payment.endpoint.BasePayment[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.leadway.projects.payment.endpoint.Exception) {
              throw (com.leadway.projects.payment.endpoint.Exception) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public com.leadway.projects.payment.endpoint.BasePayment[] findInboundPaymentByCriteria(com.leadway.projects.payment.endpoint.BasePayment paymentCriteria, com.leadway.projects.payment.endpoint.DateRange tranDateRange, com.leadway.projects.payment.endpoint.DateRange chequeDateRange, java.lang.String hostName) throws java.rmi.RemoteException, com.leadway.projects.payment.endpoint.Exception {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[30]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "findInboundPaymentByCriteria"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {paymentCriteria, tranDateRange, chequeDateRange, hostName});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.leadway.projects.payment.endpoint.BasePayment[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.leadway.projects.payment.endpoint.BasePayment[]) org.apache.axis.utils.JavaUtils.convert(_resp, com.leadway.projects.payment.endpoint.BasePayment[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.leadway.projects.payment.endpoint.Exception) {
              throw (com.leadway.projects.payment.endpoint.Exception) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public com.leadway.projects.payment.endpoint.BasePayment[] findInboundPaymentByPaymentDateRange(java.lang.String startDate, java.lang.String endDate, java.lang.String hostName) throws java.rmi.RemoteException, com.leadway.projects.payment.endpoint.Exception {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[31]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "findInboundPaymentByPaymentDateRange"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {startDate, endDate, hostName});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.leadway.projects.payment.endpoint.BasePayment[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.leadway.projects.payment.endpoint.BasePayment[]) org.apache.axis.utils.JavaUtils.convert(_resp, com.leadway.projects.payment.endpoint.BasePayment[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.leadway.projects.payment.endpoint.Exception) {
              throw (com.leadway.projects.payment.endpoint.Exception) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public com.leadway.projects.payment.endpoint.BasePayment[] findInboundPaymentByPaymentDate(java.lang.String paymentDate, java.lang.String hostName) throws java.rmi.RemoteException, com.leadway.projects.payment.endpoint.Exception {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[32]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "findInboundPaymentByPaymentDate"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {paymentDate, hostName});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.leadway.projects.payment.endpoint.BasePayment[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.leadway.projects.payment.endpoint.BasePayment[]) org.apache.axis.utils.JavaUtils.convert(_resp, com.leadway.projects.payment.endpoint.BasePayment[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.leadway.projects.payment.endpoint.Exception) {
              throw (com.leadway.projects.payment.endpoint.Exception) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public com.leadway.projects.payment.endpoint.BasePayment findInboundPaymentByReceiptNumber(java.lang.String receiptNumber, java.lang.String hostName) throws java.rmi.RemoteException, com.leadway.projects.payment.endpoint.Exception {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[33]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "findInboundPaymentByReceiptNumber"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {receiptNumber, hostName});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.leadway.projects.payment.endpoint.BasePayment) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.leadway.projects.payment.endpoint.BasePayment) org.apache.axis.utils.JavaUtils.convert(_resp, com.leadway.projects.payment.endpoint.BasePayment.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.leadway.projects.payment.endpoint.Exception) {
              throw (com.leadway.projects.payment.endpoint.Exception) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public com.leadway.projects.payment.endpoint.BasePayment[] findInboundPaymentByReceiptNumberList(java.lang.String[] receiptNumberList, java.lang.String hostName) throws java.rmi.RemoteException, com.leadway.projects.payment.endpoint.Exception {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[34]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "findInboundPaymentByReceiptNumberList"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {receiptNumberList, hostName});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.leadway.projects.payment.endpoint.BasePayment[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.leadway.projects.payment.endpoint.BasePayment[]) org.apache.axis.utils.JavaUtils.convert(_resp, com.leadway.projects.payment.endpoint.BasePayment[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.leadway.projects.payment.endpoint.Exception) {
              throw (com.leadway.projects.payment.endpoint.Exception) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public com.leadway.projects.payment.endpoint.BasePayment[] getInboundPaymentList(java.lang.String subsystem, java.lang.String startDate, java.lang.String endDate, java.lang.String hostName) throws java.rmi.RemoteException, com.leadway.projects.payment.endpoint.Exception {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[35]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "getInboundPaymentList"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {subsystem, startDate, endDate, hostName});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.leadway.projects.payment.endpoint.BasePayment[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.leadway.projects.payment.endpoint.BasePayment[]) org.apache.axis.utils.JavaUtils.convert(_resp, com.leadway.projects.payment.endpoint.BasePayment[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.leadway.projects.payment.endpoint.Exception) {
              throw (com.leadway.projects.payment.endpoint.Exception) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public long getPendingPaymentCountBySubsystem(java.lang.String subsystem, java.lang.String hostName) throws java.rmi.RemoteException, com.leadway.projects.payment.endpoint.Exception {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[36]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "getPendingPaymentCountBySubsystem"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {subsystem, hostName});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return ((java.lang.Long) _resp).longValue();
            } catch (java.lang.Exception _exception) {
                return ((java.lang.Long) org.apache.axis.utils.JavaUtils.convert(_resp, long.class)).longValue();
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.leadway.projects.payment.endpoint.Exception) {
              throw (com.leadway.projects.payment.endpoint.Exception) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public java.lang.String[] getReceiptNumberListForPendingPaymentsBySubsystem(java.lang.String subsystem, java.lang.String hostName) throws java.rmi.RemoteException, com.leadway.projects.payment.endpoint.Exception {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[37]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "getReceiptNumberListForPendingPaymentsBySubsystem"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {subsystem, hostName});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (java.lang.String[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (java.lang.String[]) org.apache.axis.utils.JavaUtils.convert(_resp, java.lang.String[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.leadway.projects.payment.endpoint.Exception) {
              throw (com.leadway.projects.payment.endpoint.Exception) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public com.leadway.projects.payment.endpoint.BasePayment[] findPendingPaymentListBySubsystem(java.lang.String subsystem, java.lang.String hostName) throws java.rmi.RemoteException, com.leadway.projects.payment.endpoint.Exception {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[38]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "findPendingPaymentListBySubsystem"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {subsystem, hostName});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.leadway.projects.payment.endpoint.BasePayment[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.leadway.projects.payment.endpoint.BasePayment[]) org.apache.axis.utils.JavaUtils.convert(_resp, com.leadway.projects.payment.endpoint.BasePayment[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.leadway.projects.payment.endpoint.Exception) {
              throw (com.leadway.projects.payment.endpoint.Exception) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public com.leadway.projects.payment.endpoint.BasePayment[] findInboundPaymentByRecentInsertionDate(java.lang.String subsystem, java.lang.String hostName) throws java.rmi.RemoteException, com.leadway.projects.payment.endpoint.Exception {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[39]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "findInboundPaymentByRecentInsertionDate"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {subsystem, hostName});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.leadway.projects.payment.endpoint.BasePayment[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.leadway.projects.payment.endpoint.BasePayment[]) org.apache.axis.utils.JavaUtils.convert(_resp, com.leadway.projects.payment.endpoint.BasePayment[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.leadway.projects.payment.endpoint.Exception) {
              throw (com.leadway.projects.payment.endpoint.Exception) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public void saveISPayment(com.leadway.projects.payment.endpoint.IsPayment payment, java.lang.String hostName) throws java.rmi.RemoteException, com.leadway.projects.payment.endpoint.Exception {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[40]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "saveISPayment"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {payment, hostName});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        extractAttachments(_call);
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.leadway.projects.payment.endpoint.Exception) {
              throw (com.leadway.projects.payment.endpoint.Exception) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public com.leadway.projects.payment.endpoint.BasePayment saveCashierDCPayment(com.leadway.projects.payment.endpoint.PaymentForDC payment, java.lang.String hostName) throws java.rmi.RemoteException, com.leadway.projects.payment.endpoint.Exception {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[41]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "saveCashierDCPayment"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {payment, hostName});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.leadway.projects.payment.endpoint.BasePayment) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.leadway.projects.payment.endpoint.BasePayment) org.apache.axis.utils.JavaUtils.convert(_resp, com.leadway.projects.payment.endpoint.BasePayment.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.leadway.projects.payment.endpoint.Exception) {
              throw (com.leadway.projects.payment.endpoint.Exception) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public com.leadway.projects.payment.endpoint.BasePayment saveCashierDCBankPayment(com.leadway.projects.payment.endpoint.BankPaymentForDC payment, java.lang.String hostName) throws java.rmi.RemoteException, com.leadway.projects.payment.endpoint.Exception {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[42]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "saveCashierDCBankPayment"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {payment, hostName});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.leadway.projects.payment.endpoint.BasePayment) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.leadway.projects.payment.endpoint.BasePayment) org.apache.axis.utils.JavaUtils.convert(_resp, com.leadway.projects.payment.endpoint.BasePayment.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.leadway.projects.payment.endpoint.Exception) {
              throw (com.leadway.projects.payment.endpoint.Exception) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public void saveISPaymentList(com.leadway.projects.payment.endpoint.BasePayment[] paymentList, java.lang.String hostName) throws java.rmi.RemoteException, com.leadway.projects.payment.endpoint.Exception {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[43]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "saveISPaymentList"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {paymentList, hostName});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        extractAttachments(_call);
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.leadway.projects.payment.endpoint.Exception) {
              throw (com.leadway.projects.payment.endpoint.Exception) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public void updatePayment(com.leadway.projects.payment.endpoint.BasePayment payment, java.lang.String hostName) throws java.rmi.RemoteException, com.leadway.projects.payment.endpoint.Exception {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[44]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "updatePayment"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {payment, hostName});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        extractAttachments(_call);
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.leadway.projects.payment.endpoint.Exception) {
              throw (com.leadway.projects.payment.endpoint.Exception) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public void updateInboundPaymentOnSubsystemSuccess(java.lang.String receiptNumber, java.lang.String hostName) throws java.rmi.RemoteException, com.leadway.projects.payment.endpoint.Exception {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[45]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "updateInboundPaymentOnSubsystemSuccess"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {receiptNumber, hostName});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        extractAttachments(_call);
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.leadway.projects.payment.endpoint.Exception) {
              throw (com.leadway.projects.payment.endpoint.Exception) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public java.lang.String savePolicyHolder(com.leadway.projects.payment.endpoint.PolicyHolder policyHolder, java.lang.String hostName) throws java.rmi.RemoteException, com.leadway.projects.payment.endpoint.Exception {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[46]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "savePolicyHolder"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {policyHolder, hostName});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (java.lang.String) _resp;
            } catch (java.lang.Exception _exception) {
                return (java.lang.String) org.apache.axis.utils.JavaUtils.convert(_resp, java.lang.String.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.leadway.projects.payment.endpoint.Exception) {
              throw (com.leadway.projects.payment.endpoint.Exception) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public void updatePolicyHolder(com.leadway.projects.payment.endpoint.PolicyHolder policyHolder, java.lang.String hostName) throws java.rmi.RemoteException, com.leadway.projects.payment.endpoint.Exception {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[47]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "updatePolicyHolder"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {policyHolder, hostName});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        extractAttachments(_call);
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.leadway.projects.payment.endpoint.Exception) {
              throw (com.leadway.projects.payment.endpoint.Exception) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public void updatePolicyHolderByName(java.lang.String policyNumber, java.lang.String newName, java.lang.String hostName) throws java.rmi.RemoteException, com.leadway.projects.payment.endpoint.Exception {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[48]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "updatePolicyHolderByName"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {policyNumber, newName, hostName});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        extractAttachments(_call);
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.leadway.projects.payment.endpoint.Exception) {
              throw (com.leadway.projects.payment.endpoint.Exception) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public void updatePolicyHolderByAgency(java.lang.String policyNumber, java.lang.String agentCode, java.lang.String agentName, java.lang.String hostName) throws java.rmi.RemoteException, com.leadway.projects.payment.endpoint.Exception {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[49]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "updatePolicyHolderByAgency"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {policyNumber, agentCode, agentName, hostName});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        extractAttachments(_call);
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.leadway.projects.payment.endpoint.Exception) {
              throw (com.leadway.projects.payment.endpoint.Exception) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public void updatePolicyHolderByAddress(java.lang.String policyNumber, java.lang.String holderAddress, java.lang.String hostName) throws java.rmi.RemoteException, com.leadway.projects.payment.endpoint.Exception {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[50]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "updatePolicyHolderByAddress"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {policyNumber, holderAddress, hostName});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        extractAttachments(_call);
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.leadway.projects.payment.endpoint.Exception) {
              throw (com.leadway.projects.payment.endpoint.Exception) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public void markPolicyHolderAsDeleted(com.leadway.projects.payment.endpoint.PolicyHolder policyHolder, java.lang.String hostName) throws java.rmi.RemoteException, com.leadway.projects.payment.endpoint.Exception {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[51]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "markPolicyHolderAsDeleted"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {policyHolder, hostName});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        extractAttachments(_call);
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.leadway.projects.payment.endpoint.Exception) {
              throw (com.leadway.projects.payment.endpoint.Exception) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public void deletePolicyHolder(com.leadway.projects.payment.endpoint.PolicyHolder policyHolder, java.lang.String hostName) throws java.rmi.RemoteException, com.leadway.projects.payment.endpoint.Exception {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[52]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "deletePolicyHolder"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {policyHolder, hostName});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        extractAttachments(_call);
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.leadway.projects.payment.endpoint.Exception) {
              throw (com.leadway.projects.payment.endpoint.Exception) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public com.leadway.projects.payment.endpoint.PolicyHolder[] findPolicyHolderByCriteria(com.leadway.projects.payment.endpoint.PolicyHolder policyHolder, java.lang.String hostName) throws java.rmi.RemoteException, com.leadway.projects.payment.endpoint.Exception {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[53]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "findPolicyHolderByCriteria"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {policyHolder, hostName});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.leadway.projects.payment.endpoint.PolicyHolder[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.leadway.projects.payment.endpoint.PolicyHolder[]) org.apache.axis.utils.JavaUtils.convert(_resp, com.leadway.projects.payment.endpoint.PolicyHolder[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.leadway.projects.payment.endpoint.Exception) {
              throw (com.leadway.projects.payment.endpoint.Exception) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public com.leadway.projects.payment.endpoint.PolicyHolder[] findPolicyHolderByPolicyNumber(java.lang.String policyNumber, java.lang.String hostName) throws java.rmi.RemoteException, com.leadway.projects.payment.endpoint.Exception {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[54]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "findPolicyHolderByPolicyNumber"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {policyNumber, hostName});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.leadway.projects.payment.endpoint.PolicyHolder[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.leadway.projects.payment.endpoint.PolicyHolder[]) org.apache.axis.utils.JavaUtils.convert(_resp, com.leadway.projects.payment.endpoint.PolicyHolder[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.leadway.projects.payment.endpoint.Exception) {
              throw (com.leadway.projects.payment.endpoint.Exception) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public com.leadway.projects.payment.endpoint.PolicyHolder[] getPolicyHolderList(java.lang.String hostName) throws java.rmi.RemoteException, com.leadway.projects.payment.endpoint.Exception {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[55]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "getPolicyHolderList"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {hostName});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.leadway.projects.payment.endpoint.PolicyHolder[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.leadway.projects.payment.endpoint.PolicyHolder[]) org.apache.axis.utils.JavaUtils.convert(_resp, com.leadway.projects.payment.endpoint.PolicyHolder[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.leadway.projects.payment.endpoint.Exception) {
              throw (com.leadway.projects.payment.endpoint.Exception) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public com.leadway.projects.payment.endpoint.PolicyHolder[] getPolicyHolderListByHolderName(java.lang.String policyHolderName, java.lang.String hostName) throws java.rmi.RemoteException, com.leadway.projects.payment.endpoint.Exception {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[56]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "getPolicyHolderListByHolderName"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {policyHolderName, hostName});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.leadway.projects.payment.endpoint.PolicyHolder[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.leadway.projects.payment.endpoint.PolicyHolder[]) org.apache.axis.utils.JavaUtils.convert(_resp, com.leadway.projects.payment.endpoint.PolicyHolder[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.leadway.projects.payment.endpoint.Exception) {
              throw (com.leadway.projects.payment.endpoint.Exception) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public com.leadway.projects.payment.endpoint.PolicyHolder[] getPendingPolicyHolderListAndUpdateTransStatusAsInserted(java.lang.String hostName) throws java.rmi.RemoteException, com.leadway.projects.payment.endpoint.Exception {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[57]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "getPendingPolicyHolderListAndUpdateTransStatusAsInserted"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {hostName});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.leadway.projects.payment.endpoint.PolicyHolder[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.leadway.projects.payment.endpoint.PolicyHolder[]) org.apache.axis.utils.JavaUtils.convert(_resp, com.leadway.projects.payment.endpoint.PolicyHolder[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.leadway.projects.payment.endpoint.Exception) {
              throw (com.leadway.projects.payment.endpoint.Exception) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public com.leadway.projects.payment.endpoint.PolicyHolder[] getPendingPolicyHolderList(java.lang.String hostName) throws java.rmi.RemoteException, com.leadway.projects.payment.endpoint.Exception {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[58]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "getPendingPolicyHolderList"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {hostName});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.leadway.projects.payment.endpoint.PolicyHolder[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.leadway.projects.payment.endpoint.PolicyHolder[]) org.apache.axis.utils.JavaUtils.convert(_resp, com.leadway.projects.payment.endpoint.PolicyHolder[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.leadway.projects.payment.endpoint.Exception) {
              throw (com.leadway.projects.payment.endpoint.Exception) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public void updatePolicyHolderByTransmitStatus(java.lang.String policyNumber, java.lang.String hostName) throws java.rmi.RemoteException, com.leadway.projects.payment.endpoint.Exception {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[59]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "updatePolicyHolderByTransmitStatus"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {policyNumber, hostName});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        extractAttachments(_call);
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.leadway.projects.payment.endpoint.Exception) {
              throw (com.leadway.projects.payment.endpoint.Exception) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public com.leadway.projects.payment.endpoint.PolicyHolder[] getPolicyHolderListByTransactionDate(java.lang.String startDate, java.lang.String endDate, java.lang.String hostName) throws java.rmi.RemoteException, com.leadway.projects.payment.endpoint.Exception {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[60]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "getPolicyHolderListByTransactionDate"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {startDate, endDate, hostName});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.leadway.projects.payment.endpoint.PolicyHolder[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.leadway.projects.payment.endpoint.PolicyHolder[]) org.apache.axis.utils.JavaUtils.convert(_resp, com.leadway.projects.payment.endpoint.PolicyHolder[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.leadway.projects.payment.endpoint.Exception) {
              throw (com.leadway.projects.payment.endpoint.Exception) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public com.leadway.projects.payment.endpoint.Transaction getTransactionByConfigCode(java.lang.String configCode, java.lang.String hostName) throws java.rmi.RemoteException, com.leadway.projects.payment.endpoint.Exception {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[61]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "getTransactionByConfigCode"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {configCode, hostName});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.leadway.projects.payment.endpoint.Transaction) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.leadway.projects.payment.endpoint.Transaction) org.apache.axis.utils.JavaUtils.convert(_resp, com.leadway.projects.payment.endpoint.Transaction.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.leadway.projects.payment.endpoint.Exception) {
              throw (com.leadway.projects.payment.endpoint.Exception) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public com.leadway.projects.payment.endpoint.Transaction[] getTransactionList(java.lang.String hostName) throws java.rmi.RemoteException, com.leadway.projects.payment.endpoint.Exception {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[62]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "getTransactionList"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {hostName});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.leadway.projects.payment.endpoint.Transaction[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.leadway.projects.payment.endpoint.Transaction[]) org.apache.axis.utils.JavaUtils.convert(_resp, com.leadway.projects.payment.endpoint.Transaction[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.leadway.projects.payment.endpoint.Exception) {
              throw (com.leadway.projects.payment.endpoint.Exception) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public java.lang.String getNextReceiptNumber(java.lang.String hostName) throws java.rmi.RemoteException, com.leadway.projects.payment.endpoint.Exception {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[63]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "getNextReceiptNumber"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {hostName});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (java.lang.String) _resp;
            } catch (java.lang.Exception _exception) {
                return (java.lang.String) org.apache.axis.utils.JavaUtils.convert(_resp, java.lang.String.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.leadway.projects.payment.endpoint.Exception) {
              throw (com.leadway.projects.payment.endpoint.Exception) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public com.leadway.projects.payment.endpoint.PaymentSourceConstants getPaymentSourceConstants() throws java.rmi.RemoteException, com.leadway.projects.payment.endpoint.Exception {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[64]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "getPaymentSourceConstants"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.leadway.projects.payment.endpoint.PaymentSourceConstants) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.leadway.projects.payment.endpoint.PaymentSourceConstants) org.apache.axis.utils.JavaUtils.convert(_resp, com.leadway.projects.payment.endpoint.PaymentSourceConstants.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.leadway.projects.payment.endpoint.Exception) {
              throw (com.leadway.projects.payment.endpoint.Exception) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public void dummyMethod(com.leadway.projects.payment.endpoint.Subsystem subsystem, com.leadway.projects.payment.endpoint.ExceptionMessage exceptionMssg, com.leadway.projects.payment.endpoint.BankPaymentForDC bankPayment, com.leadway.projects.payment.endpoint.PaymentForDC paymentForDC, com.leadway.projects.payment.endpoint.IsPayment isPayment) throws java.rmi.RemoteException, com.leadway.projects.payment.endpoint.Exception {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[65]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "dummyMethod"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {subsystem, exceptionMssg, bankPayment, paymentForDC, isPayment});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        extractAttachments(_call);
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.leadway.projects.payment.endpoint.Exception) {
              throw (com.leadway.projects.payment.endpoint.Exception) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

}
