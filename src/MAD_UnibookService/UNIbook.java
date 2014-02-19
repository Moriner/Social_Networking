/**
 * model.test.UNIbookStub.java
 * Interface v.1.0
 *
 * Generated on 13/04/11 16:50
 * Based on WSDL at http://goanna.cs.rmit.edu.au:8309/ws/UNIbookService?wsdl
 */

package MAD_UnibookService;

public interface UNIbook extends java.rmi.Remote {
	public MAD_UnibookServiceTypes.MemberSummary[] findAllMembers() throws java.rmi.RemoteException, javax.xml.rpc.JAXRPCException;
    
		// params (min_age, max_age, gender, program code)
		public MAD_UnibookServiceTypes.MemberSummary[] findMembersByCriteria(int _int_1, int _int_2, java.lang.String _String_3, java.lang.String _String_4) throws java.rmi.RemoteException, javax.xml.rpc.JAXRPCException;
    
		// params (user name)
		public MAD_UnibookServiceTypes.MemberProfile getMemberProfile(java.lang.String _String_1) throws java.rmi.RemoteException, javax.xml.rpc.JAXRPCException;
    
		// params (user name)
		public java.lang.String getMemberStatus(java.lang.String _String_1) throws java.rmi.RemoteException, javax.xml.rpc.JAXRPCException;
    
		// params (user name)
		public MAD_UnibookServiceTypes.MemberSummary getMemberSummary(java.lang.String _String_1) throws java.rmi.RemoteException, javax.xml.rpc.JAXRPCException;
    
		// params (user name, password)
		public boolean login(java.lang.String _String_1, java.lang.String _String_2) throws java.rmi.RemoteException, javax.xml.rpc.JAXRPCException;
    
		// params (user name, password)
		public MAD_UnibookServiceTypes.Message[] readNewMessages(java.lang.String _String_1, java.lang.String _String_2) throws java.rmi.RemoteException, javax.xml.rpc.JAXRPCException;
   
		// params (sender's user name, sender's password, receiver's user name, message)
		public boolean sendMessage(java.lang.String _String_1, java.lang.String _String_2, java.lang.String _String_3, java.lang.String _String_4) throws java.rmi.RemoteException, javax.xml.rpc.JAXRPCException;
    
		// params (user name, status message)
		public boolean updateMemberStatus(java.lang.String _String_1, java.lang.String _String_2, java.lang.String _String_3) throws java.rmi.RemoteException, javax.xml.rpc.JAXRPCException;
}
