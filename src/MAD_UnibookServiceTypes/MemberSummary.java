/**
 * MemberSummary.java
 *
 * Generated on 13/04/11 16:50
 * Generated from http://goanna.cs.rmit.edu.au:8309/ws/UNIbookService?wsdl
 */

package MAD_UnibookServiceTypes;

public class MemberSummary {
   
	private int age;
    private java.lang.String gender;
    private java.lang.String programCode;
    private java.lang.String username;

    public MemberSummary() {
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public java.lang.String getGender() {
        return gender;
    }

    public void setGender(java.lang.String gender) {
        this.gender = gender;
    }

    public java.lang.String getProgramCode() {
        return programCode;
    }

    public void setProgramCode(java.lang.String programCode) {
        this.programCode = programCode;
    }

    public java.lang.String getUsername() {
        return username;
    }

    public void setUsername(java.lang.String username) {
        this.username = username;
    }

   public static javax.microedition.xml.rpc.Type populateTypeMap( javax.xml.namespace.QName targetName, java.util.Hashtable typeMap )
   {
      if (typeMap == null) {
         typeMap = new java.util.Hashtable();
      }

      String complexTypeName = "model_test_MemberSummary";

      if (typeMap.containsKey( complexTypeName )) {
         return (javax.microedition.xml.rpc.Type)typeMap.get( complexTypeName ); 
      }

      javax.microedition.xml.rpc.ComplexType model_test_MemberSummary = new javax.microedition.xml.rpc.ComplexType();
      model_test_MemberSummary.elements = new javax.microedition.xml.rpc.Element[4];
          {
          javax.xml.namespace.QName __QNAME_age = new javax.xml.namespace.QName("", "age");
          javax.microedition.xml.rpc.Element __ELEM_age = new javax.microedition.xml.rpc.Element (__QNAME_age, javax.microedition.xml.rpc.Type.INT, 1, 1, false);
          model_test_MemberSummary.elements[0] = __ELEM_age;
          }

          {
          javax.xml.namespace.QName __QNAME_gender = new javax.xml.namespace.QName("", "gender");
          javax.microedition.xml.rpc.Element __ELEM_gender = new javax.microedition.xml.rpc.Element (__QNAME_gender, javax.microedition.xml.rpc.Type.STRING, 1, 1, true);
          model_test_MemberSummary.elements[1] = __ELEM_gender;
          }

          {
          javax.xml.namespace.QName __QNAME_programCode = new javax.xml.namespace.QName("", "programCode");
          javax.microedition.xml.rpc.Element __ELEM_programCode = new javax.microedition.xml.rpc.Element (__QNAME_programCode, javax.microedition.xml.rpc.Type.STRING, 1, 1, true);
          model_test_MemberSummary.elements[2] = __ELEM_programCode;
          }

          {
          javax.xml.namespace.QName __QNAME_username = new javax.xml.namespace.QName("", "username");
          javax.microedition.xml.rpc.Element __ELEM_username = new javax.microedition.xml.rpc.Element (__QNAME_username, javax.microedition.xml.rpc.Type.STRING, 1, 1, true);
          model_test_MemberSummary.elements[3] = __ELEM_username;
          }

      typeMap.put(complexTypeName, model_test_MemberSummary);
      return model_test_MemberSummary;
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
          new Integer( getAge() ),
          getGender(),
          getProgramCode(),
          getUsername(),
      };
      recursionCheck = false;
      return (Object)objs;
	}


   public void deserialize( Object value )
   {
      Object[] values = (Object[])value;
      if ((values != null) && (values.length == 4)) {
         setAge( ((Integer)values[0]).intValue() );
         setGender( (String)values[1] );
         setProgramCode( (String)values[2] );
         setUsername( (String)values[3] );
      }
   }

}
