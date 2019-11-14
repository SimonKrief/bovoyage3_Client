package fr.gtm.util;

import java.time.LocalDate;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class LocalDateXmlAdapter extends XmlAdapter<String, LocalDate>{
	@Override
	public String marshal(LocalDate ld) throws Exception {
		return String.format("%4d-%02d-%02d",ld.getYear(),ld.getMonthValue(),ld.getDayOfMonth());
	}

	@Override
	public LocalDate unmarshal(String s) throws Exception {
		String[] fields = s.split("-");
		
		return LocalDate.of(Integer.valueOf(fields[0]),Integer.valueOf(fields[1]),Integer.valueOf(fields[2]));
	}
	

}

