package com.dao;
import org.mindrot.jbcrypt.BCrypt;
public class BcryptDemo {

	public static String genpasskey(String password)
	{
		String hasedPassword=BCrypt.hashpw(password, BCrypt.gensalt());
		return hasedPassword;
	}
	
	
	public static void main(String[] args) {
		
		String password="abc123";
		String hashedPassword=BCrypt.hashpw(password,BCrypt.gensalt(18));
		
		System.out.println("pass->"+password);
		System.out.println("hashed password-->"+hashedPassword);
		
		System.out.println(BCrypt.checkpw("abc123",hashedPassword));
		System.out.println(BCrypt.checkpw("abc12",hashedPassword));
		
		
	}

}
