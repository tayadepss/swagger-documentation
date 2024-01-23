package personservice.module;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection="persons")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Person {
	
	@Id
	private Integer id;
	private String name;
	private String gender;
	private Date dob;

}
