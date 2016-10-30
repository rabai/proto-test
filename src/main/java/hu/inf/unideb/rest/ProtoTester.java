package hu.inf.unideb.rest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.commons.io.FileUtils;

import com.google.protobuf.ByteString;

import hu.inf.unideb.proto.ProtoUser;
import hu.inf.unideb.proto.ProtoUser.User;

@Path("/protoTester")
public class ProtoTester extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public ProtoTester() {
	}

	@GET
	@Path("/hello")
	@Produces(MediaType.APPLICATION_JSON)
	public String helloWorld() {
		return "Hello World";
	}

	@GET
	@Path("/get_user")
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<String> roles = new ArrayList<>();
		roles.addAll(Arrays.asList("ADMIN", "USER", "ALL"));
		// Kép beolvasása a resources-ból
		File sourceimage = new File(getClass().getResource("/mypic.jpg").getPath());
		byte[] readFileToByteArray = FileUtils.readFileToByteArray(sourceimage);
		User user = ProtoUser.User.newBuilder()
				.setName("RFT")
				.setRank("1")
				.addAllAuthorites(roles)
				.setAuthorites(2, "Auth3")
				.setImage(ByteString.copyFrom(readFileToByteArray)) // Kép
				.build();
		FileOutputStream output = new FileOutputStream("user.ser");
		user.writeTo(output); // Fájlba írás
		// User felolvasása a fájlból
		User userFromFile = User.parseFrom(new FileInputStream("user.ser"));
		output.close();
		// Az új kép lemásolása egy másik mappába, szemléltetés céljából
		byte[] outputFileArray = userFromFile.getImage().toByteArray();
		File theDir = new File(System.getProperty("user.home"), "prototest");
		theDir.mkdir();
		File outputImage = new File(theDir, "output.jpg");
		FileUtils.writeByteArrayToFile(outputImage, outputFileArray);
	}

}
