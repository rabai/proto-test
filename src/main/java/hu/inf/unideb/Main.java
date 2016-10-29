package hu.inf.unideb;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import hu.inf.unideb.proto.ProtoUser;
import hu.inf.unideb.proto.ProtoUser.User;

public class Main {
	public static void main(String[] args) {
		List<String> roles = new ArrayList<>();
		roles.addAll(Arrays.asList("ADMIN", "USER", "ALL"));
	    User user= ProtoUser.User.newBuilder()
	    		.setName("RFT")
	    		.setRank("2")
	    		.addAllAuthorites(roles)
	    		.setAuthorites(2, "Auth3")
	            .build();
	    try {
	       // write
	        FileOutputStream output = new FileOutputStream("user.ser");
	        user.writeTo(output);
	        output.close();
	 
	       // read
	        User userFromFile = User.parseFrom(new FileInputStream("user.ser"));
	        System.out.println(userFromFile);
	 
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}
}
