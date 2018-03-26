package com.story.action;

import java.util.ArrayList;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import com.story.dao.PersonDao;
import com.story.model.Person;



@Controller @Scope("prototype")
public class PersonAction {
	
	private Map<String,Object> session ;   //用作登录拦截，要添加setter和getter
	private String prePage ;
	public Map<String, Object> getSession() {
		return session;
	}
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	public String getPrePage() {
		return prePage;
	}
	public void setPrePage(String prePage) {
		this.prePage = prePage;
	}
	
	@Resource PersonDao persondao;
	
	private Person person;
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	
	/*注册方法*/
	public String reg() throws Exception{
		persondao.AddPerson(person);
		session.put("person",person);
		return "show_view";		
	}
	
	private String errMessage;
	public String getErrMessage() {
		return errMessage;
	}
	public void setErrMessage(String errMessage) {
		this.errMessage = errMessage;
	}
	
	/*登陆方法*/
	public String login(){
		ArrayList<Person> listPerson = persondao.QueryUserInfo(person.getAccount());
		if(listPerson.size() == 0){ 
			this.errMessage = "账号不存在";
			System.out.print(this.errMessage);
			return "input";
		}
		else{
			Person db_person = listPerson.get(0);				
		    if( !db_person.getPassword().equals(person.getPassword())) {   
		    	this.errMessage = " 密码不正确! ";
			    System.out.print(this.errMessage);
			    return "input";
		    }
		    else{
		    	session.put("person",db_person);  		    	
		    	return "success";
		    }
		}
		
	}

}
