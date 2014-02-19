/**
 * MemberProfile.java
 *
 * Generated on 13/04/11 16:50
 * Generated from http://goanna.cs.rmit.edu.au:8309/ws/UNIbookService?wsdl
 */

package MAD_UnibookServiceTypes;

public class MemberProfile {
    private int[] photo;
    private java.lang.String profile;
	private java.lang.String profileName;

    public MemberProfile() {
    }

    public int[] getPhoto() {
        return photo;
    }

    public void setPhoto(int[] photo) {
        this.photo = photo;
    }
    
    public int getPhoto(int i) {
        return photo[i];
    }
    

    public void setPhoto(int i, int value) {
        this.photo[i] = value;
    }

    public java.lang.String getProfile() {
        return profile;
    }

    public void setProfile(java.lang.String profile) {
        this.profile = profile;
    }
    
	public void setProfileName(java.lang.String profileName) {
		this.profileName = profileName;
	}
  
   public static javax.microedition.xml.rpc.Type populateTypeMap( javax.xml.namespace.QName targetName, java.util.Hashtable typeMap )
   {
      if (typeMap == null) {
         typeMap = new java.util.Hashtable();
      }

      String complexTypeName = "model_test_MemberProfile";

      if (typeMap.containsKey( complexTypeName )) {
         return (javax.microedition.xml.rpc.Type)typeMap.get( complexTypeName ); 
      }

      javax.microedition.xml.rpc.ComplexType model_test_MemberProfile = new javax.microedition.xml.rpc.ComplexType();
      model_test_MemberProfile.elements = new javax.microedition.xml.rpc.Element[2];
          {
          javax.xml.namespace.QName __QNAME_photo = new javax.xml.namespace.QName("", "photo");
          javax.microedition.xml.rpc.Element __ELEM_photo = new javax.microedition.xml.rpc.Element (__QNAME_photo, javax.microedition.xml.rpc.Type.INT, 0, -1, false);
          model_test_MemberProfile.elements[0] = __ELEM_photo;
          }

          {
          javax.xml.namespace.QName __QNAME_profile = new javax.xml.namespace.QName("", "profile");
          javax.microedition.xml.rpc.Element __ELEM_profile = new javax.microedition.xml.rpc.Element (__QNAME_profile, javax.microedition.xml.rpc.Type.STRING, 1, 1, true);
          model_test_MemberProfile.elements[1] = __ELEM_profile;
          }

      typeMap.put(complexTypeName, model_test_MemberProfile);
      return model_test_MemberProfile;
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
          getPhoto(),
          getProfile(),
      };
      recursionCheck = false;
      return (Object)objs;
	}


   public void deserialize( Object value )
   {
      Object[] values = (Object[])value;
      if ((values != null) && (values.length == 2)) {
         setPhoto( (int[])values[0] );
         setProfile( (String)values[1] );
      }
   }

}
