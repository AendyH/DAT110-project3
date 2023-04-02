package no.hvl.dat110.util;

/**
 * exercise/demo purpose in dat110
 * @author tdoy
 *
 */

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Hash { 
	
	private static MessageDigest md = null;
	public static BigInteger hashOf(String entity) {	
		
		BigInteger hashint = null;
		
		// Task: Hash a given string using MD5 and return the result as a BigInteger.
		
		// we use MD5 with 128 bits digest
		try {
			md = MessageDigest.getInstance("MD5");
			// compute the hash of the input 'entity'
			byte[] byteArr = md.digest(entity.getBytes());
//			md.update(byteArr);
//			byteArr = md.digest();
			// convert the hash into hex format
			String hex = toHex(byteArr);
			// convert the hex into BigInteger
			hashint = new BigInteger(hex,16);
			// return the BigInteger
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}


		return hashint;
	}
	
	public static BigInteger addressSize() {
		
		BigInteger out = null;
		// Task: compute the address size of MD5
		
		// get the digest length
		// compute the number of bits = digest length * 8
		int length = bitSize();
		// compute the address size = 2 ^ number of bits
		out = (new BigInteger("2").pow(length));
		// return the address size
		
	
		
		return out;
	}
	
	public static int bitSize() {
		
		int digestlen = 0;
		
		try {
			digestlen = MessageDigest.getInstance("MD5").getDigestLength();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// find the digest length
		
		return digestlen*8;
	}
	
	public static String toHex(byte[] digest) {
		StringBuilder strbuilder = new StringBuilder();
		for(byte b : digest) {
			strbuilder.append(String.format("%02x", b&0xff));
		}
		return strbuilder.toString();
	}

}
