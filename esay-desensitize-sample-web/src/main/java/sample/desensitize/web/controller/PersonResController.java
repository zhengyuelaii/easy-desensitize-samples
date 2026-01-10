package sample.desensitize.web.controller;

import java.util.Collections;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.zhengyuelaii.desensitize.autoconfigure.ResponseMasking;

import sample.desensitize.web.domain.Person;

@RestController
@RequestMapping("/person")
public class PersonResController {
	
	@GetMapping("/list")
	@ResponseMasking
	public List<Person> list() {
		
		Person person = new Person();
		person.setName("张小凡");
		person.setMobile("13700004586");
		person.setIdNumber("130535202206145195");
		
		return Collections.singletonList(person);
	}

}
