/**
 * model.test.UNIbook_Stub.java
 * Stub v.1.0
 *
 * Generated on 13/04/11 16:50
 * Based on WSDL at http://goanna.cs.rmit.edu.au:8309/ws/UNIbookService?wsdl
 */

package MAD_UnibookService;

import javax.microedition.xml.rpc.Element;
import javax.microedition.xml.rpc.Operation;

public class UNIbook_Stub implements javax.xml.rpc.Stub, MAD_UnibookService.UNIbook{

    public javax.microedition.xml.rpc.Operation operation = null;
    public java.util.Hashtable typeMap = new java.util.Hashtable();
    public java.util.Hashtable properties = new java.util.Hashtable(); {
        properties.put(javax.xml.rpc.Stub.ENDPOINT_ADDRESS_PROPERTY, "http://goanna.cs.rmit.edu.au:8309/ws/UNIbookService");
//        properties.put(javax.xml.rpc.Stub.USERNAME_PROPERTY, "");
//        properties.put(javax.xml.rpc.Stub.PASSWORD_PROPERTY, "");
//        properties.put(javax.xml.rpc.Stub.SESSION_MAINTAIN_PROPERTY, new java.lang.Boolean(true));
    }
    public static java.util.Vector propertyNames = new java.util.Vector(); {
        propertyNames.addElement(javax.xml.rpc.Stub.ENDPOINT_ADDRESS_PROPERTY);
        propertyNames.addElement(javax.xml.rpc.Stub.USERNAME_PROPERTY);
        propertyNames.addElement(javax.xml.rpc.Stub.PASSWORD_PROPERTY);
        propertyNames.addElement(javax.xml.rpc.Stub.SESSION_MAINTAIN_PROPERTY);
    }

    public void _setProperty(java.lang.String name, java.lang.Object value) throws javax.xml.rpc.JAXRPCException {
        if (!propertyNames.contains(name))
            throw new javax.xml.rpc.JAXRPCException("property not supported: " + name);
        properties.put(name, value);
    }

    public java.lang.Object _getProperty(java.lang.String name) throws javax.xml.rpc.JAXRPCException {
        if (!propertyNames.contains(name))
            throw new javax.xml.rpc.JAXRPCException("property not supported: " + name);
        return properties.get(name);
    }

    private void setPropertiesOnOperation(javax.microedition.xml.rpc.Operation operation) throws javax.xml.rpc.JAXRPCException {
        java.util.Enumeration iterator = properties.keys();
        while (iterator.hasMoreElements()) {
        	java.lang.String s = (java.lang.String) iterator.nextElement();
        	if ( s.equals(javax.xml.rpc.Stub.SESSION_MAINTAIN_PROPERTY)) {
        	   operation.setProperty(s, ((java.lang.Boolean)properties.get(s)).toString());
        	} else { 
	           operation.setProperty(s, (java.lang.String) properties.get(s));
            }
        }
    }
    public MAD_UnibookServiceTypes.MemberSummary[] findAllMembers() throws java.rmi.RemoteException, javax.xml.rpc.JAXRPCException
    {
        Element[] inputTypes = new Element[0];

        Element __ELEM_findAllMembers= null;
        Element[] outTypes = new Element[1];
        Element __ELEM_findAllMembersResponse = null;
        if (typeMap.containsKey( "__ELEM_findAllMembers" ) ) {
           __ELEM_findAllMembers = (Element)typeMap.get( "__ELEM_findAllMembers"); 
           __ELEM_findAllMembersResponse = (Element)typeMap.get( "__ELEM_findAllMembersResponse"); 
        } else {

          {
          javax.xml.namespace.QName __QNAME_result = new javax.xml.namespace.QName("", "result");
           javax.microedition.xml.rpc.Element __ELEM_result = new javax.microedition.xml.rpc.Element (__QNAME_result, MAD_UnibookServiceTypes.MemberSummary.populateTypeMap( null, typeMap ) , 0, -1, true);
          outTypes[0] = __ELEM_result;
          }

          javax.microedition.xml.rpc.ComplexType findAllMembers = new javax.microedition.xml.rpc.ComplexType();
          findAllMembers.elements = (Element[])inputTypes;
          javax.xml.namespace.QName __QNAME_findAllMembers = new javax.xml.namespace.QName("urn:MAD_UNIbookServiceTypes", "findAllMembers");
          __ELEM_findAllMembers = new Element (__QNAME_findAllMembers, findAllMembers,1 ,1, false); 

          javax.microedition.xml.rpc.ComplexType findAllMembersResponse = new javax.microedition.xml.rpc.ComplexType();
          findAllMembersResponse.elements = (Element[])outTypes;
          javax.xml.namespace.QName __QNAME_findAllMembersResponse = new javax.xml.namespace.QName("urn:MAD_UNIbookServiceTypes", "findAllMembersResponse");
          __ELEM_findAllMembersResponse = new Element (__QNAME_findAllMembersResponse, findAllMembersResponse,1 ,1, false); 

          typeMap.put( "__ELEM_findAllMembers" , __ELEM_findAllMembers);
          typeMap.put( "__ELEM_findAllMembersResponse" , __ELEM_findAllMembersResponse);

        }
        javax.xml.namespace.QName __QNAME_findAllMembers = new javax.xml.namespace.QName("urn:MAD_UNIbookServiceTypes", "findAllMembers");

          Object[] inputObjects = new Object[] {          };
        Operation operation = Operation.newInstance(__QNAME_findAllMembers, __ELEM_findAllMembers, __ELEM_findAllMembersResponse);
        setPropertiesOnOperation(operation);

        Object[] returnObjectArray = (Object[])operation.invoke(inputObjects);
        Object returnObject = returnObjectArray[0];
        MAD_UnibookServiceTypes.MemberSummary[] result = null;
        result = deserialize_model_test_MemberSummary( returnObject );
        return result;
    }

    public MAD_UnibookServiceTypes.MemberSummary[] findMembersByCriteria(int _int_1, int _int_2, java.lang.String _String_3, java.lang.String _String_4) throws java.rmi.RemoteException, javax.xml.rpc.JAXRPCException
    {
        Element[] inputTypes = new Element[4];

        Element __ELEM_findMembersByCriteria= null;
        Element[] outTypes = new Element[1];
        Element __ELEM_findMembersByCriteriaResponse = null;
        if (typeMap.containsKey( "__ELEM_findMembersByCriteria" ) ) {
           __ELEM_findMembersByCriteria = (Element)typeMap.get( "__ELEM_findMembersByCriteria"); 
           __ELEM_findMembersByCriteriaResponse = (Element)typeMap.get( "__ELEM_findMembersByCriteriaResponse"); 
        } else {

          {
          javax.xml.namespace.QName __QNAME_int_1 = new javax.xml.namespace.QName("", "int_1");
          javax.microedition.xml.rpc.Element __ELEM_int_1 = new javax.microedition.xml.rpc.Element (__QNAME_int_1, javax.microedition.xml.rpc.Type.INT, 0, 1, false);
          inputTypes[0] = __ELEM_int_1;
          }

          {
          javax.xml.namespace.QName __QNAME_int_2 = new javax.xml.namespace.QName("", "int_2");
          javax.microedition.xml.rpc.Element __ELEM_int_2 = new javax.microedition.xml.rpc.Element (__QNAME_int_2, javax.microedition.xml.rpc.Type.INT, 0, 1, false);
          inputTypes[1] = __ELEM_int_2;
          }

          {
          javax.xml.namespace.QName __QNAME_string_3 = new javax.xml.namespace.QName("", "String_3");
          javax.microedition.xml.rpc.Element __ELEM_string_3 = new javax.microedition.xml.rpc.Element (__QNAME_string_3, javax.microedition.xml.rpc.Type.STRING, 0, 1, true);
          inputTypes[2] = __ELEM_string_3;
          }

          {
          javax.xml.namespace.QName __QNAME_string_4 = new javax.xml.namespace.QName("", "String_4");
          javax.microedition.xml.rpc.Element __ELEM_string_4 = new javax.microedition.xml.rpc.Element (__QNAME_string_4, javax.microedition.xml.rpc.Type.STRING, 0, 1, true);
          inputTypes[3] = __ELEM_string_4;
          }

          {
          javax.xml.namespace.QName __QNAME_result = new javax.xml.namespace.QName("", "result");
           javax.microedition.xml.rpc.Element __ELEM_result = new javax.microedition.xml.rpc.Element (__QNAME_result, MAD_UnibookServiceTypes.MemberSummary.populateTypeMap( null, typeMap ) , 0, -1, true);
          outTypes[0] = __ELEM_result;
          }

          javax.microedition.xml.rpc.ComplexType findMembersByCriteria = new javax.microedition.xml.rpc.ComplexType();
          findMembersByCriteria.elements = (Element[])inputTypes;
          javax.xml.namespace.QName __QNAME_findMembersByCriteria = new javax.xml.namespace.QName("urn:MAD_UNIbookServiceTypes", "findMembersByCriteria");
          __ELEM_findMembersByCriteria = new Element (__QNAME_findMembersByCriteria, findMembersByCriteria,1 ,1, false); 

          javax.microedition.xml.rpc.ComplexType findMembersByCriteriaResponse = new javax.microedition.xml.rpc.ComplexType();
          findMembersByCriteriaResponse.elements = (Element[])outTypes;
          javax.xml.namespace.QName __QNAME_findMembersByCriteriaResponse = new javax.xml.namespace.QName("urn:MAD_UNIbookServiceTypes", "findMembersByCriteriaResponse");
          __ELEM_findMembersByCriteriaResponse = new Element (__QNAME_findMembersByCriteriaResponse, findMembersByCriteriaResponse,1 ,1, false); 

          typeMap.put( "__ELEM_findMembersByCriteria" , __ELEM_findMembersByCriteria);
          typeMap.put( "__ELEM_findMembersByCriteriaResponse" , __ELEM_findMembersByCriteriaResponse);

        }
        javax.xml.namespace.QName __QNAME_findMembersByCriteria = new javax.xml.namespace.QName("urn:MAD_UNIbookServiceTypes", "findMembersByCriteria");

          Object[] inputObjects = new Object[] { new java.lang.Integer(_int_1) ,new java.lang.Integer(_int_2) ,_String_3 ,_String_4          };
        Operation operation = Operation.newInstance(__QNAME_findMembersByCriteria, __ELEM_findMembersByCriteria, __ELEM_findMembersByCriteriaResponse);
        setPropertiesOnOperation(operation);

        Object[] returnObjectArray = (Object[])operation.invoke(inputObjects);
        Object returnObject = returnObjectArray[0];
        MAD_UnibookServiceTypes.MemberSummary[] result = null;
        result = deserialize_model_test_MemberSummary( returnObject );
        return result;
    }

    public MAD_UnibookServiceTypes.MemberProfile getMemberProfile(java.lang.String _String_1) throws java.rmi.RemoteException, javax.xml.rpc.JAXRPCException
    {
        Element[] inputTypes = new Element[1];

        Element __ELEM_getMemberProfile= null;
        Element[] outTypes = new Element[1];
        Element __ELEM_getMemberProfileResponse = null;
        if (typeMap.containsKey( "__ELEM_getMemberProfile" ) ) {
           __ELEM_getMemberProfile = (Element)typeMap.get( "__ELEM_getMemberProfile"); 
           __ELEM_getMemberProfileResponse = (Element)typeMap.get( "__ELEM_getMemberProfileResponse"); 
        } else {

          {
          javax.xml.namespace.QName __QNAME_string_1 = new javax.xml.namespace.QName("", "String_1");
          javax.microedition.xml.rpc.Element __ELEM_string_1 = new javax.microedition.xml.rpc.Element (__QNAME_string_1, javax.microedition.xml.rpc.Type.STRING, 0, 1, true);
          inputTypes[0] = __ELEM_string_1;
          }

          {
          javax.xml.namespace.QName __QNAME_result = new javax.xml.namespace.QName("", "result");
           javax.microedition.xml.rpc.Element __ELEM_result = new javax.microedition.xml.rpc.Element (__QNAME_result, MAD_UnibookServiceTypes.MemberProfile.populateTypeMap( null, typeMap ) , 0, 1, true);
          outTypes[0] = __ELEM_result;
          }

          javax.microedition.xml.rpc.ComplexType getMemberProfile = new javax.microedition.xml.rpc.ComplexType();
          getMemberProfile.elements = (Element[])inputTypes;
          javax.xml.namespace.QName __QNAME_getMemberProfile = new javax.xml.namespace.QName("urn:MAD_UNIbookServiceTypes", "getMemberProfile");
          __ELEM_getMemberProfile = new Element (__QNAME_getMemberProfile, getMemberProfile,1 ,1, false); 

          javax.microedition.xml.rpc.ComplexType getMemberProfileResponse = new javax.microedition.xml.rpc.ComplexType();
          getMemberProfileResponse.elements = (Element[])outTypes;
          javax.xml.namespace.QName __QNAME_getMemberProfileResponse = new javax.xml.namespace.QName("urn:MAD_UNIbookServiceTypes", "getMemberProfileResponse");
          __ELEM_getMemberProfileResponse = new Element (__QNAME_getMemberProfileResponse, getMemberProfileResponse,1 ,1, false); 

          typeMap.put( "__ELEM_getMemberProfile" , __ELEM_getMemberProfile);
          typeMap.put( "__ELEM_getMemberProfileResponse" , __ELEM_getMemberProfileResponse);

        }
        javax.xml.namespace.QName __QNAME_getMemberProfile = new javax.xml.namespace.QName("urn:MAD_UNIbookServiceTypes", "getMemberProfile");

          Object[] inputObjects = new Object[] { _String_1          };
        Operation operation = Operation.newInstance(__QNAME_getMemberProfile, __ELEM_getMemberProfile, __ELEM_getMemberProfileResponse);
        setPropertiesOnOperation(operation);

        Object[] returnObjectArray = (Object[])operation.invoke(inputObjects);
        Object returnObject = returnObjectArray[0];
        MAD_UnibookServiceTypes.MemberProfile result = null;
        if (returnObject != null) {
           result = new MAD_UnibookServiceTypes.MemberProfile();
           result.deserialize( returnObject );
        }
        return result;
    }

   

    public java.lang.String getMemberStatus(java.lang.String _String_1) throws java.rmi.RemoteException, javax.xml.rpc.JAXRPCException
    {
        Element[] inputTypes = new Element[1];

        Element __ELEM_getMemberStatus= null;
        Element[] outTypes = new Element[1];
        Element __ELEM_getMemberStatusResponse = null;
        if (typeMap.containsKey( "__ELEM_getMemberStatus" ) ) {
           __ELEM_getMemberStatus = (Element)typeMap.get( "__ELEM_getMemberStatus"); 
           __ELEM_getMemberStatusResponse = (Element)typeMap.get( "__ELEM_getMemberStatusResponse"); 
        } else {

          {
          javax.xml.namespace.QName __QNAME_string_1 = new javax.xml.namespace.QName("", "String_1");
          javax.microedition.xml.rpc.Element __ELEM_string_1 = new javax.microedition.xml.rpc.Element (__QNAME_string_1, javax.microedition.xml.rpc.Type.STRING, 0, 1, true);
          inputTypes[0] = __ELEM_string_1;
          }

          {
          javax.xml.namespace.QName __QNAME_result = new javax.xml.namespace.QName("", "result");
          javax.microedition.xml.rpc.Element __ELEM_result = new javax.microedition.xml.rpc.Element (__QNAME_result, javax.microedition.xml.rpc.Type.STRING, 0, 1, true);
          outTypes[0] = __ELEM_result;
          }

          javax.microedition.xml.rpc.ComplexType getMemberStatus = new javax.microedition.xml.rpc.ComplexType();
          getMemberStatus.elements = (Element[])inputTypes;
          javax.xml.namespace.QName __QNAME_getMemberStatus = new javax.xml.namespace.QName("urn:MAD_UNIbookServiceTypes", "getMemberStatus");
          __ELEM_getMemberStatus = new Element (__QNAME_getMemberStatus, getMemberStatus,1 ,1, false); 

          javax.microedition.xml.rpc.ComplexType getMemberStatusResponse = new javax.microedition.xml.rpc.ComplexType();
          getMemberStatusResponse.elements = (Element[])outTypes;
          javax.xml.namespace.QName __QNAME_getMemberStatusResponse = new javax.xml.namespace.QName("urn:MAD_UNIbookServiceTypes", "getMemberStatusResponse");
          __ELEM_getMemberStatusResponse = new Element (__QNAME_getMemberStatusResponse, getMemberStatusResponse,1 ,1, false); 

          typeMap.put( "__ELEM_getMemberStatus" , __ELEM_getMemberStatus);
          typeMap.put( "__ELEM_getMemberStatusResponse" , __ELEM_getMemberStatusResponse);

        }
        javax.xml.namespace.QName __QNAME_getMemberStatus = new javax.xml.namespace.QName("urn:MAD_UNIbookServiceTypes", "getMemberStatus");

          Object[] inputObjects = new Object[] { _String_1          };
        Operation operation = Operation.newInstance(__QNAME_getMemberStatus, __ELEM_getMemberStatus, __ELEM_getMemberStatusResponse);
        setPropertiesOnOperation(operation);

        Object[] returnObjectArray = (Object[])operation.invoke(inputObjects);
        Object returnObject = returnObjectArray[0];
        return (java.lang.String) returnObject;
    }

    public MAD_UnibookServiceTypes.MemberSummary getMemberSummary(java.lang.String _String_1) throws java.rmi.RemoteException, javax.xml.rpc.JAXRPCException
    {
        Element[] inputTypes = new Element[1];

        Element __ELEM_getMemberSummary= null;
        Element[] outTypes = new Element[1];
        Element __ELEM_getMemberSummaryResponse = null;
        if (typeMap.containsKey( "__ELEM_getMemberSummary" ) ) {
           __ELEM_getMemberSummary = (Element)typeMap.get( "__ELEM_getMemberSummary"); 
           __ELEM_getMemberSummaryResponse = (Element)typeMap.get( "__ELEM_getMemberSummaryResponse"); 
        } else {

          {
          javax.xml.namespace.QName __QNAME_string_1 = new javax.xml.namespace.QName("", "String_1");
          javax.microedition.xml.rpc.Element __ELEM_string_1 = new javax.microedition.xml.rpc.Element (__QNAME_string_1, javax.microedition.xml.rpc.Type.STRING, 0, 1, true);
          inputTypes[0] = __ELEM_string_1;
          }

          {
          javax.xml.namespace.QName __QNAME_result = new javax.xml.namespace.QName("", "result");
           javax.microedition.xml.rpc.Element __ELEM_result = new javax.microedition.xml.rpc.Element (__QNAME_result, MAD_UnibookServiceTypes.MemberSummary.populateTypeMap( null, typeMap ) , 0, 1, true);
          outTypes[0] = __ELEM_result;
          }

          javax.microedition.xml.rpc.ComplexType getMemberSummary = new javax.microedition.xml.rpc.ComplexType();
          getMemberSummary.elements = (Element[])inputTypes;
          javax.xml.namespace.QName __QNAME_getMemberSummary = new javax.xml.namespace.QName("urn:MAD_UNIbookServiceTypes", "getMemberSummary");
          __ELEM_getMemberSummary = new Element (__QNAME_getMemberSummary, getMemberSummary,1 ,1, false); 

          javax.microedition.xml.rpc.ComplexType getMemberSummaryResponse = new javax.microedition.xml.rpc.ComplexType();
          getMemberSummaryResponse.elements = (Element[])outTypes;
          javax.xml.namespace.QName __QNAME_getMemberSummaryResponse = new javax.xml.namespace.QName("urn:MAD_UNIbookServiceTypes", "getMemberSummaryResponse");
          __ELEM_getMemberSummaryResponse = new Element (__QNAME_getMemberSummaryResponse, getMemberSummaryResponse,1 ,1, false); 

          typeMap.put( "__ELEM_getMemberSummary" , __ELEM_getMemberSummary);
          typeMap.put( "__ELEM_getMemberSummaryResponse" , __ELEM_getMemberSummaryResponse);

        }
        javax.xml.namespace.QName __QNAME_getMemberSummary = new javax.xml.namespace.QName("urn:MAD_UNIbookServiceTypes", "getMemberSummary");

          Object[] inputObjects = new Object[] { _String_1          };
        Operation operation = Operation.newInstance(__QNAME_getMemberSummary, __ELEM_getMemberSummary, __ELEM_getMemberSummaryResponse);
        setPropertiesOnOperation(operation);

        Object[] returnObjectArray = (Object[])operation.invoke(inputObjects);
        Object returnObject = returnObjectArray[0];
        MAD_UnibookServiceTypes.MemberSummary result = null;
        if (returnObject != null) {
           result = new MAD_UnibookServiceTypes.MemberSummary();
           result.deserialize( returnObject );
        }
        return result;
    }

    public boolean login(java.lang.String _String_1, java.lang.String _String_2) throws java.rmi.RemoteException, javax.xml.rpc.JAXRPCException
    {
        Element[] inputTypes = new Element[2];

        Element __ELEM_login= null;
        Element[] outTypes = new Element[1];
        Element __ELEM_loginResponse = null;
        if (typeMap.containsKey( "__ELEM_login" ) ) {
           __ELEM_login = (Element)typeMap.get( "__ELEM_login"); 
           __ELEM_loginResponse = (Element)typeMap.get( "__ELEM_loginResponse"); 
        } else {

          {
          javax.xml.namespace.QName __QNAME_string_1 = new javax.xml.namespace.QName("", "String_1");
          javax.microedition.xml.rpc.Element __ELEM_string_1 = new javax.microedition.xml.rpc.Element (__QNAME_string_1, javax.microedition.xml.rpc.Type.STRING, 0, 1, true);
          inputTypes[0] = __ELEM_string_1;
          }

          {
          javax.xml.namespace.QName __QNAME_string_2 = new javax.xml.namespace.QName("", "String_2");
          javax.microedition.xml.rpc.Element __ELEM_string_2 = new javax.microedition.xml.rpc.Element (__QNAME_string_2, javax.microedition.xml.rpc.Type.STRING, 0, 1, true);
          inputTypes[1] = __ELEM_string_2;
          }

          {
          javax.xml.namespace.QName __QNAME_result = new javax.xml.namespace.QName("", "result");
          javax.microedition.xml.rpc.Element __ELEM_result = new javax.microedition.xml.rpc.Element (__QNAME_result, javax.microedition.xml.rpc.Type.BOOLEAN, 0, 1, false);
          outTypes[0] = __ELEM_result;
          }

          javax.microedition.xml.rpc.ComplexType login = new javax.microedition.xml.rpc.ComplexType();
          login.elements = (Element[])inputTypes;
          javax.xml.namespace.QName __QNAME_login = new javax.xml.namespace.QName("urn:MAD_UNIbookServiceTypes", "login");
          __ELEM_login = new Element (__QNAME_login, login,1 ,1, false); 

          javax.microedition.xml.rpc.ComplexType loginResponse = new javax.microedition.xml.rpc.ComplexType();
          loginResponse.elements = (Element[])outTypes;
          javax.xml.namespace.QName __QNAME_loginResponse = new javax.xml.namespace.QName("urn:MAD_UNIbookServiceTypes", "loginResponse");
          __ELEM_loginResponse = new Element (__QNAME_loginResponse, loginResponse,1 ,1, false); 

          typeMap.put( "__ELEM_login" , __ELEM_login);
          typeMap.put( "__ELEM_loginResponse" , __ELEM_loginResponse);

        }
        javax.xml.namespace.QName __QNAME_login = new javax.xml.namespace.QName("urn:MAD_UNIbookServiceTypes", "login");

          Object[] inputObjects = new Object[] { _String_1 ,_String_2          };
        Operation operation = Operation.newInstance(__QNAME_login, __ELEM_login, __ELEM_loginResponse);
        setPropertiesOnOperation(operation);

        Object[] returnObjectArray = (Object[])operation.invoke(inputObjects);
        Object returnObject = returnObjectArray[0];
        return ((java.lang.Boolean) (returnObject)).booleanValue();
    }

    public MAD_UnibookServiceTypes.Message[] readNewMessages(java.lang.String _String_1, java.lang.String _String_2) throws java.rmi.RemoteException, javax.xml.rpc.JAXRPCException
    {
        Element[] inputTypes = new Element[2];

        Element __ELEM_readNewMessages= null;
        Element[] outTypes = new Element[1];
        Element __ELEM_readNewMessagesResponse = null;
        if (typeMap.containsKey( "__ELEM_readNewMessages" ) ) {
           __ELEM_readNewMessages = (Element)typeMap.get( "__ELEM_readNewMessages"); 
           __ELEM_readNewMessagesResponse = (Element)typeMap.get( "__ELEM_readNewMessagesResponse"); 
        } else {

          {
          javax.xml.namespace.QName __QNAME_string_1 = new javax.xml.namespace.QName("", "String_1");
          javax.microedition.xml.rpc.Element __ELEM_string_1 = new javax.microedition.xml.rpc.Element (__QNAME_string_1, javax.microedition.xml.rpc.Type.STRING, 0, 1, true);
          inputTypes[0] = __ELEM_string_1;
          }

          {
          javax.xml.namespace.QName __QNAME_string_2 = new javax.xml.namespace.QName("", "String_2");
          javax.microedition.xml.rpc.Element __ELEM_string_2 = new javax.microedition.xml.rpc.Element (__QNAME_string_2, javax.microedition.xml.rpc.Type.STRING, 0, 1, true);
          inputTypes[1] = __ELEM_string_2;
          }

          {
          javax.xml.namespace.QName __QNAME_result = new javax.xml.namespace.QName("", "result");
           javax.microedition.xml.rpc.Element __ELEM_result = new javax.microedition.xml.rpc.Element (__QNAME_result, MAD_UnibookServiceTypes.Message.populateTypeMap( null, typeMap ) , 0, -1, true);
          outTypes[0] = __ELEM_result;
          }

          javax.microedition.xml.rpc.ComplexType readNewMessages = new javax.microedition.xml.rpc.ComplexType();
          readNewMessages.elements = (Element[])inputTypes;
          javax.xml.namespace.QName __QNAME_readNewMessages = new javax.xml.namespace.QName("urn:MAD_UNIbookServiceTypes", "readNewMessages");
          __ELEM_readNewMessages = new Element (__QNAME_readNewMessages, readNewMessages,1 ,1, false); 

          javax.microedition.xml.rpc.ComplexType readNewMessagesResponse = new javax.microedition.xml.rpc.ComplexType();
          readNewMessagesResponse.elements = (Element[])outTypes;
          javax.xml.namespace.QName __QNAME_readNewMessagesResponse = new javax.xml.namespace.QName("urn:MAD_UNIbookServiceTypes", "readNewMessagesResponse");
          __ELEM_readNewMessagesResponse = new Element (__QNAME_readNewMessagesResponse, readNewMessagesResponse,1 ,1, false); 

          typeMap.put( "__ELEM_readNewMessages" , __ELEM_readNewMessages);
          typeMap.put( "__ELEM_readNewMessagesResponse" , __ELEM_readNewMessagesResponse);

        }
        javax.xml.namespace.QName __QNAME_readNewMessages = new javax.xml.namespace.QName("urn:MAD_UNIbookServiceTypes", "readNewMessages");

          Object[] inputObjects = new Object[] { _String_1 ,_String_2          };
        Operation operation = Operation.newInstance(__QNAME_readNewMessages, __ELEM_readNewMessages, __ELEM_readNewMessagesResponse);
        setPropertiesOnOperation(operation);

        Object[] returnObjectArray = (Object[])operation.invoke(inputObjects);
        Object returnObject = returnObjectArray[0];
        MAD_UnibookServiceTypes.Message[] result = null;
        result = deserialize_model_test_Message( returnObject );
        return result;
    }

    public boolean registerMember(java.lang.String _String_1, java.lang.String _String_2, java.lang.String _String_3, int _int_4, java.lang.String _String_5, java.lang.String _String_6, java.lang.String _String_7) throws java.rmi.RemoteException, javax.xml.rpc.JAXRPCException
    {
        Element[] inputTypes = new Element[7];

        Element __ELEM_registerMember= null;
        Element[] outTypes = new Element[1];
        Element __ELEM_registerMemberResponse = null;
        if (typeMap.containsKey( "__ELEM_registerMember" ) ) {
           __ELEM_registerMember = (Element)typeMap.get( "__ELEM_registerMember"); 
           __ELEM_registerMemberResponse = (Element)typeMap.get( "__ELEM_registerMemberResponse"); 
        } else {

          {
          javax.xml.namespace.QName __QNAME_string_1 = new javax.xml.namespace.QName("", "String_1");
          javax.microedition.xml.rpc.Element __ELEM_string_1 = new javax.microedition.xml.rpc.Element (__QNAME_string_1, javax.microedition.xml.rpc.Type.STRING, 0, 1, true);
          inputTypes[0] = __ELEM_string_1;
          }

          {
          javax.xml.namespace.QName __QNAME_string_2 = new javax.xml.namespace.QName("", "String_2");
          javax.microedition.xml.rpc.Element __ELEM_string_2 = new javax.microedition.xml.rpc.Element (__QNAME_string_2, javax.microedition.xml.rpc.Type.STRING, 0, 1, true);
          inputTypes[1] = __ELEM_string_2;
          }

          {
          javax.xml.namespace.QName __QNAME_string_3 = new javax.xml.namespace.QName("", "String_3");
          javax.microedition.xml.rpc.Element __ELEM_string_3 = new javax.microedition.xml.rpc.Element (__QNAME_string_3, javax.microedition.xml.rpc.Type.STRING, 0, 1, true);
          inputTypes[2] = __ELEM_string_3;
          }

          {
          javax.xml.namespace.QName __QNAME_int_4 = new javax.xml.namespace.QName("", "int_4");
          javax.microedition.xml.rpc.Element __ELEM_int_4 = new javax.microedition.xml.rpc.Element (__QNAME_int_4, javax.microedition.xml.rpc.Type.INT, 0, 1, false);
          inputTypes[3] = __ELEM_int_4;
          }

          {
          javax.xml.namespace.QName __QNAME_string_5 = new javax.xml.namespace.QName("", "String_5");
          javax.microedition.xml.rpc.Element __ELEM_string_5 = new javax.microedition.xml.rpc.Element (__QNAME_string_5, javax.microedition.xml.rpc.Type.STRING, 0, 1, true);
          inputTypes[4] = __ELEM_string_5;
          }

          {
          javax.xml.namespace.QName __QNAME_string_6 = new javax.xml.namespace.QName("", "String_6");
          javax.microedition.xml.rpc.Element __ELEM_string_6 = new javax.microedition.xml.rpc.Element (__QNAME_string_6, javax.microedition.xml.rpc.Type.STRING, 0, 1, true);
          inputTypes[5] = __ELEM_string_6;
          }

          {
          javax.xml.namespace.QName __QNAME_string_7 = new javax.xml.namespace.QName("", "String_7");
          javax.microedition.xml.rpc.Element __ELEM_string_7 = new javax.microedition.xml.rpc.Element (__QNAME_string_7, javax.microedition.xml.rpc.Type.STRING, 0, 1, true);
          inputTypes[6] = __ELEM_string_7;
          }

          {
          javax.xml.namespace.QName __QNAME_result = new javax.xml.namespace.QName("", "result");
          javax.microedition.xml.rpc.Element __ELEM_result = new javax.microedition.xml.rpc.Element (__QNAME_result, javax.microedition.xml.rpc.Type.BOOLEAN, 0, 1, false);
          outTypes[0] = __ELEM_result;
          }

          javax.microedition.xml.rpc.ComplexType registerMember = new javax.microedition.xml.rpc.ComplexType();
          registerMember.elements = (Element[])inputTypes;
          javax.xml.namespace.QName __QNAME_registerMember = new javax.xml.namespace.QName("urn:MAD_UNIbookServiceTypes", "registerMember");
          __ELEM_registerMember = new Element (__QNAME_registerMember, registerMember,1 ,1, false); 

          javax.microedition.xml.rpc.ComplexType registerMemberResponse = new javax.microedition.xml.rpc.ComplexType();
          registerMemberResponse.elements = (Element[])outTypes;
          javax.xml.namespace.QName __QNAME_registerMemberResponse = new javax.xml.namespace.QName("urn:MAD_UNIbookServiceTypes", "registerMemberResponse");
          __ELEM_registerMemberResponse = new Element (__QNAME_registerMemberResponse, registerMemberResponse,1 ,1, false); 

          typeMap.put( "__ELEM_registerMember" , __ELEM_registerMember);
          typeMap.put( "__ELEM_registerMemberResponse" , __ELEM_registerMemberResponse);

        }
        javax.xml.namespace.QName __QNAME_registerMember = new javax.xml.namespace.QName("urn:MAD_UNIbookServiceTypes", "registerMember");

          Object[] inputObjects = new Object[] { _String_1 ,_String_2 ,_String_3 ,new java.lang.Integer(_int_4) ,_String_5 ,_String_6 ,_String_7          };
        Operation operation = Operation.newInstance(__QNAME_registerMember, __ELEM_registerMember, __ELEM_registerMemberResponse);
        setPropertiesOnOperation(operation);

        Object[] returnObjectArray = (Object[])operation.invoke(inputObjects);
        Object returnObject = returnObjectArray[0];
        return ((java.lang.Boolean) (returnObject)).booleanValue();
    }

    public boolean sendMessage(java.lang.String _String_1, java.lang.String _String_2, java.lang.String _String_3, java.lang.String _String_4) throws java.rmi.RemoteException, javax.xml.rpc.JAXRPCException
    {
        Element[] inputTypes = new Element[4];

        Element __ELEM_sendMessage= null;
        Element[] outTypes = new Element[1];
        Element __ELEM_sendMessageResponse = null;
        if (typeMap.containsKey( "__ELEM_sendMessage" ) ) {
           __ELEM_sendMessage = (Element)typeMap.get( "__ELEM_sendMessage"); 
           __ELEM_sendMessageResponse = (Element)typeMap.get( "__ELEM_sendMessageResponse"); 
        } else {

          {
          javax.xml.namespace.QName __QNAME_string_1 = new javax.xml.namespace.QName("", "String_1");
          javax.microedition.xml.rpc.Element __ELEM_string_1 = new javax.microedition.xml.rpc.Element (__QNAME_string_1, javax.microedition.xml.rpc.Type.STRING, 0, 1, true);
          inputTypes[0] = __ELEM_string_1;
          }

          {
          javax.xml.namespace.QName __QNAME_string_2 = new javax.xml.namespace.QName("", "String_2");
          javax.microedition.xml.rpc.Element __ELEM_string_2 = new javax.microedition.xml.rpc.Element (__QNAME_string_2, javax.microedition.xml.rpc.Type.STRING, 0, 1, true);
          inputTypes[1] = __ELEM_string_2;
          }

          {
          javax.xml.namespace.QName __QNAME_string_3 = new javax.xml.namespace.QName("", "String_3");
          javax.microedition.xml.rpc.Element __ELEM_string_3 = new javax.microedition.xml.rpc.Element (__QNAME_string_3, javax.microedition.xml.rpc.Type.STRING, 0, 1, true);
          inputTypes[2] = __ELEM_string_3;
          }

          {
          javax.xml.namespace.QName __QNAME_string_4 = new javax.xml.namespace.QName("", "String_4");
          javax.microedition.xml.rpc.Element __ELEM_string_4 = new javax.microedition.xml.rpc.Element (__QNAME_string_4, javax.microedition.xml.rpc.Type.STRING, 0, 1, true);
          inputTypes[3] = __ELEM_string_4;
          }

          {
          javax.xml.namespace.QName __QNAME_result = new javax.xml.namespace.QName("", "result");
          javax.microedition.xml.rpc.Element __ELEM_result = new javax.microedition.xml.rpc.Element (__QNAME_result, javax.microedition.xml.rpc.Type.BOOLEAN, 0, 1, false);
          outTypes[0] = __ELEM_result;
          }

          javax.microedition.xml.rpc.ComplexType sendMessage = new javax.microedition.xml.rpc.ComplexType();
          sendMessage.elements = (Element[])inputTypes;
          javax.xml.namespace.QName __QNAME_sendMessage = new javax.xml.namespace.QName("urn:MAD_UNIbookServiceTypes", "sendMessage");
          __ELEM_sendMessage = new Element (__QNAME_sendMessage, sendMessage,1 ,1, false); 

          javax.microedition.xml.rpc.ComplexType sendMessageResponse = new javax.microedition.xml.rpc.ComplexType();
          sendMessageResponse.elements = (Element[])outTypes;
          javax.xml.namespace.QName __QNAME_sendMessageResponse = new javax.xml.namespace.QName("urn:MAD_UNIbookServiceTypes", "sendMessageResponse");
          __ELEM_sendMessageResponse = new Element (__QNAME_sendMessageResponse, sendMessageResponse,1 ,1, false); 

          typeMap.put( "__ELEM_sendMessage" , __ELEM_sendMessage);
          typeMap.put( "__ELEM_sendMessageResponse" , __ELEM_sendMessageResponse);

        }
        javax.xml.namespace.QName __QNAME_sendMessage = new javax.xml.namespace.QName("urn:MAD_UNIbookServiceTypes", "sendMessage");

          Object[] inputObjects = new Object[] { _String_1 ,_String_2 ,_String_3 ,_String_4          };
        Operation operation = Operation.newInstance(__QNAME_sendMessage, __ELEM_sendMessage, __ELEM_sendMessageResponse);
        setPropertiesOnOperation(operation);

        Object[] returnObjectArray = (Object[])operation.invoke(inputObjects);
        Object returnObject = returnObjectArray[0];
        return ((java.lang.Boolean) (returnObject)).booleanValue();
    }

    public boolean updateMemberStatus(java.lang.String _String_1, java.lang.String _String_2, java.lang.String _String_3) throws java.rmi.RemoteException, javax.xml.rpc.JAXRPCException
    {
        Element[] inputTypes = new Element[3];

        Element __ELEM_updateMemberStatus= null;
        Element[] outTypes = new Element[1];
        Element __ELEM_updateMemberStatusResponse = null;
        if (typeMap.containsKey( "__ELEM_updateMemberStatus" ) ) {
           __ELEM_updateMemberStatus = (Element)typeMap.get( "__ELEM_updateMemberStatus"); 
           __ELEM_updateMemberStatusResponse = (Element)typeMap.get( "__ELEM_updateMemberStatusResponse"); 
        } else {

          {
          javax.xml.namespace.QName __QNAME_string_1 = new javax.xml.namespace.QName("", "String_1");
          javax.microedition.xml.rpc.Element __ELEM_string_1 = new javax.microedition.xml.rpc.Element (__QNAME_string_1, javax.microedition.xml.rpc.Type.STRING, 0, 1, true);
          inputTypes[0] = __ELEM_string_1;
          }

          {
          javax.xml.namespace.QName __QNAME_string_2 = new javax.xml.namespace.QName("", "String_2");
          javax.microedition.xml.rpc.Element __ELEM_string_2 = new javax.microedition.xml.rpc.Element (__QNAME_string_2, javax.microedition.xml.rpc.Type.STRING, 0, 1, true);
          inputTypes[1] = __ELEM_string_2;
          }

          {
          javax.xml.namespace.QName __QNAME_string_3 = new javax.xml.namespace.QName("", "String_3");
          javax.microedition.xml.rpc.Element __ELEM_string_3 = new javax.microedition.xml.rpc.Element (__QNAME_string_3, javax.microedition.xml.rpc.Type.STRING, 0, 1, true);
          inputTypes[2] = __ELEM_string_3;
          }

          {
          javax.xml.namespace.QName __QNAME_result = new javax.xml.namespace.QName("", "result");
          javax.microedition.xml.rpc.Element __ELEM_result = new javax.microedition.xml.rpc.Element (__QNAME_result, javax.microedition.xml.rpc.Type.BOOLEAN, 0, 1, false);
          outTypes[0] = __ELEM_result;
          }

          javax.microedition.xml.rpc.ComplexType updateMemberStatus = new javax.microedition.xml.rpc.ComplexType();
          updateMemberStatus.elements = (Element[])inputTypes;
          javax.xml.namespace.QName __QNAME_updateMemberStatus = new javax.xml.namespace.QName("urn:MAD_UNIbookServiceTypes", "updateMemberStatus");
          __ELEM_updateMemberStatus = new Element (__QNAME_updateMemberStatus, updateMemberStatus,1 ,1, false); 

          javax.microedition.xml.rpc.ComplexType updateMemberStatusResponse = new javax.microedition.xml.rpc.ComplexType();
          updateMemberStatusResponse.elements = (Element[])outTypes;
          javax.xml.namespace.QName __QNAME_updateMemberStatusResponse = new javax.xml.namespace.QName("urn:MAD_UNIbookServiceTypes", "updateMemberStatusResponse");
          __ELEM_updateMemberStatusResponse = new Element (__QNAME_updateMemberStatusResponse, updateMemberStatusResponse,1 ,1, false); 

          typeMap.put( "__ELEM_updateMemberStatus" , __ELEM_updateMemberStatus);
          typeMap.put( "__ELEM_updateMemberStatusResponse" , __ELEM_updateMemberStatusResponse);

        }
        javax.xml.namespace.QName __QNAME_updateMemberStatus = new javax.xml.namespace.QName("urn:MAD_UNIbookServiceTypes", "updateMemberStatus");

          Object[] inputObjects = new Object[] { _String_1 ,_String_2 ,_String_3          };
        Operation operation = Operation.newInstance(__QNAME_updateMemberStatus, __ELEM_updateMemberStatus, __ELEM_updateMemberStatusResponse);
        setPropertiesOnOperation(operation);

        Object[] returnObjectArray = (Object[])operation.invoke(inputObjects);
        Object returnObject = returnObjectArray[0];
        return ((java.lang.Boolean) (returnObject)).booleanValue();
    }


   private MAD_UnibookServiceTypes.MemberSummary[] deserialize_model_test_MemberSummary( Object obj )
   {
      Object[] objs = (Object[])obj;
      MAD_UnibookServiceTypes.MemberSummary[] result = null;
      if (objs != null) {
         result = new MAD_UnibookServiceTypes.MemberSummary[ objs.length ];
         for (int i = 0; i < objs.length; i++ ) {
            if (objs[i] != null) {
               result[i] = new MAD_UnibookServiceTypes.MemberSummary();
               result[i].deserialize( (Object[])objs[ i ] );
            }
         }
      }
      return result;
   }


   private MAD_UnibookServiceTypes.Message[] deserialize_model_test_Message( Object obj )
   {
      Object[] objs = (Object[])obj;
      MAD_UnibookServiceTypes.Message[] result = null;
      if (objs != null) {
         result = new MAD_UnibookServiceTypes.Message[ objs.length ];
         for (int i = 0; i < objs.length; i++ ) {
            if (objs[i] != null) {
               result[i] = new MAD_UnibookServiceTypes.Message();
               result[i].deserialize( (Object[])objs[ i ] );
            }
         }
      }
      return result;
   }

}
