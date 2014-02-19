/**
 * Message.java
 *
 * Generated on 13/04/11 16:50
 * Generated from http://goanna.cs.rmit.edu.au:8309/ws/UNIbookService?wsdl
 */

package MAD_UnibookServiceTypes;

public class Message {
    private java.lang.String content;
    private java.lang.String sender;

    public Message() {
    }

    public java.lang.String getContent() {
        return content;
    }

    public void setContent(java.lang.String content) {
        this.content = content;
    }

    public java.lang.String getSender() {
        return sender;
    }

    public void setSender(java.lang.String sender) {
        this.sender = sender;
    }

   public static javax.microedition.xml.rpc.Type populateTypeMap( javax.xml.namespace.QName targetName, java.util.Hashtable typeMap )
   {
      if (typeMap == null) {
         typeMap = new java.util.Hashtable();
      }

      String complexTypeName = "model_test_Message";

      if (typeMap.containsKey( complexTypeName )) {
         return (javax.microedition.xml.rpc.Type)typeMap.get( complexTypeName ); 
      }

      javax.microedition.xml.rpc.ComplexType model_test_Message = new javax.microedition.xml.rpc.ComplexType();
      model_test_Message.elements = new javax.microedition.xml.rpc.Element[2];
          {
          javax.xml.namespace.QName __QNAME_content = new javax.xml.namespace.QName("", "content");
          javax.microedition.xml.rpc.Element __ELEM_content = new javax.microedition.xml.rpc.Element (__QNAME_content, javax.microedition.xml.rpc.Type.STRING, 1, 1, true);
          model_test_Message.elements[0] = __ELEM_content;
          }

          {
          javax.xml.namespace.QName __QNAME_sender = new javax.xml.namespace.QName("", "sender");
          javax.microedition.xml.rpc.Element __ELEM_sender = new javax.microedition.xml.rpc.Element (__QNAME_sender, javax.microedition.xml.rpc.Type.STRING, 1, 1, true);
          model_test_Message.elements[1] = __ELEM_sender;
          }

      typeMap.put(complexTypeName, model_test_Message);
      return model_test_Message;
   }

   private boolean recursionCheck = false;
   public Object serialize() throws javax.xml.rpc.JAXRPCException
   {
      if (recursionCheck) {
         throw new javax.xml.rpc.JAXRPCException( "An instance of " + getClass().getName() + " exists in a circular reference.  Serialization of this instance will fail." );
      } else {
         recursionCheck = true;
      }
      Object[] objs = new Object[] {
          getContent(),
          getSender(),
      };
      recursionCheck = false;
      return (Object)objs;
	}


   public void deserialize( Object value )
   {
      Object[] values = (Object[])value;
      if ((values != null) && (values.length == 2)) {
         setContent( (String)values[0] );
         setSender( (String)values[1] );
      }
   }

}
