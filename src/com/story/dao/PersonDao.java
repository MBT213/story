package com.story.dao;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.story.model.Person;



@Service @Transactional
public class PersonDao {
	@Resource SessionFactory factory;
	/*添加用户信息*/
	public void AddPerson(Person person) throws Exception {
	    	Session s = factory.getCurrentSession();
	    	s.save(person);
	}
	/*删除用户信息*/
    public void DeletePerson (Integer personid) throws Exception {
        Session s = factory.getCurrentSession(); 
        Object person = s.load(Person.class, personid);
        s.delete(person);
    }
    
    /*更新用户信息*/
    public void UpdateUser(Person person) throws Exception {
        Session s = factory.getCurrentSession();
        s.update(person);
    }
    
    /*查询所有用户信息*/
    public ArrayList<Person> QueryAllUser() {
        Session s = factory.getCurrentSession();
        String hql = "From Person";
        Query q = s.createQuery(hql);
        List userList = q.list();
        return (ArrayList<Person>) userList;
    }

    /*根据主键获取对象*/
    public Person GetUserById(Integer personid) {
        Session s = factory.getCurrentSession();
        Person person = (Person)s.get(Person.class, personid);
        return person;
    }
    
    /*根据查询条件查询*/
    public ArrayList<Person> QueryUserInfo(String name) {
    	Session s = factory.getCurrentSession();
    	List personList;
    	String hql = "From Person person where 1=1";
    	if(!name.equals("")) {
    		hql = hql + " and person.name like '%" + name + "%'";
    	 	Query q = s.createQuery(hql);
    	 	personList=q.list();
    	}else{
    		personList=null;
    	}
  
    	return (ArrayList<Person>) personList;
    }


}
