package com.boylql.Experiment_1;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

import org.apache.commons.codec.digest.DigestUtils;
public class register {
    public static void main(String[] args) throws IOException {
    	FileOutputStream fos = new FileOutputStream("C:\\Users\\青柠\\Desktop\\web高级编程\\id_password.txt",true);
    	Scanner sc = new Scanner(System.in);
    	System.out.println("请输入账号:");
    	String id = sc.next();
    	System.out.println("请输入密码:");
    	String password = sc.next();
        if (id.length() < 1||password.length() < 1) {
            System.err.println("请输入正确的账号或者密码!");
            System.exit(0);
        }
        String str = id+" "+sha256hex(password)+"  ";
        fos.write(str.getBytes());
        fos.close();
        System.out.println("注册成功！");
    }
    public static String sha256hex(String input) {
        return DigestUtils.sha256Hex(input);
    }
}