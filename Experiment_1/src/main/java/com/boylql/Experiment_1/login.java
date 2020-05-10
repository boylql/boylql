package com.boylql.Experiment_1;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

import org.apache.commons.codec.digest.DigestUtils;
public class login {
    public static void main(String[] args) throws IOException {
    	FileInputStream fis = new FileInputStream("C:\\Users\\青柠\\Desktop\\web高级编程\\id_password.txt");
    	Scanner sc = new Scanner(System.in);
    	System.out.println("请输入账号:");
    	String id = sc.next();
    	System.out.println("请输入密码:");
    	String password = sc.next();
        if (id.length() < 1||password.length() < 1) {
            System.err.println("请输入正确的账号或者密码!");
            System.exit(0);
        }else {
        	int n=0;
        	int length=fis.available();
        	byte bytes[] = new byte[length];
        	fis.read(bytes);
        	String[] str = new String(bytes).split("  ");
        	for(int i=0;i<str.length;i++) {   		
        		String[] id_password = str[i].split(" ");
        		if(id.equals(id_password[0])&&sha256hex(password).equals(id_password[1])) {
        			System.out.println("登录成功！");
        			System.exit(0);
        		}
        		n++;
	        }
        	if(n==str.length) {
	        	System.out.println("登录失败，请检查账号密码！");
	        }
        	
        }
    }
    public static String sha256hex(String input) {
        return DigestUtils.sha256Hex(input);
    }
}
