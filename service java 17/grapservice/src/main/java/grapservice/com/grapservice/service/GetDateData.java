package grapservice.com.grapservice.service;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Service;

@Service
public class GetDateData {

//    public String getDateNow(String fomatString){
//    LocalDate date = LocalDate.now();
//    DateTimeFormatter formatter = DateTimeFormatter.ofPattern(fomatString);
//    String formattedDate = date.format(formatter);
//    return formattedDate;
//
//}

public  Date getDateNow(){
    LocalDate date = LocalDate.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    String formattedDate = date.format(formatter);
//    System.out.printf("date"+ Date.valueOf(formattedDate));
    return Date.valueOf(formattedDate);
}
	
}
