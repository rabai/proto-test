package hu.inf.unideb.rest;
import java.util.HashSet;
import java.util.Set;
import javax.ws.rs.core.Application;

public class Services extends Application {

	private Set<Object> singletons = new HashSet<Object>();

	public Services() {
		singletons.add(new ProtoTester());
	}

	@Override
	public Set<Object> getSingletons() {
		return singletons;
	}

}