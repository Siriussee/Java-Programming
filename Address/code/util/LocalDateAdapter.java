package address.util;

import java.time.LocalDate;

import javax.xml.bind.annotation.adapters.XmlAdapter;
//this class tell Marshaler in MainApp how to generate Date into XML
public class LocalDateAdapter extends XmlAdapter<String, LocalDate> {

	@Override
	public LocalDate unmarshal(String v) throws Exception {
		return LocalDate.parse(v);
	}

	@Override
	public String marshal(LocalDate v) throws Exception {
		return v.toString();
	}
}
