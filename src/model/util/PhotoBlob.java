package model.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.SQLException;

/**
 * @author Chen Chao
 *
 */
public class PhotoBlob implements Blob{
	private byte[] blob;
	
	public PhotoBlob(){
		blob = null;
	}
	
	public PhotoBlob(byte[] blob){
		this.blob = blob;
	}
	
	public InputStream getBinaryStream(){
		return new ByteArrayInputStream(blob);
	}

	public OutputStream setBinaryStream(long pos) throws SQLException {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		baos.write(this.blob, (int) pos, this.blob.length - (int) pos );
		return baos;
	}
	
	public byte[] getBytes(long pos, int length) throws SQLException {
		return this.blob;
	}
	
	public byte[] getBytes(){
		return this.blob;
	}
	
	public int setBytes(long pos, byte[] bytes) throws SQLException {
		this.blob = bytes;
		return bytes.length;
	}
	
	public int setBytes(long pos, byte[] bytes, int i, int j){
		this.blob = bytes;
		return bytes.length;
	}

	public long length(){
		return this.blob.length;
	}

	public long position(byte[] pattern, long start) throws SQLException {
		return 1;
	}

	public long position(Blob pattern, long start) throws SQLException {
		return 1;
	}
	
	public void truncate(long len)  {
	}

}
