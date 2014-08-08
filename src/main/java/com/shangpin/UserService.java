package com.shangpin;

import java.util.HashMap;
import java.util.Map;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.google.code.ssm.api.InvalidateSingleCache;
import com.google.code.ssm.api.ParameterDataUpdateContent;
import com.google.code.ssm.api.ParameterValueKeyProvider;
import com.google.code.ssm.api.ReadThroughSingleCache;
import com.google.code.ssm.api.UpdateSingleCache;
import com.shangpin.entity.User;

@Service
public class UserService {
	private static final String NAMESPACE = "hello";
	private Map<String, User> users = new HashMap<String, User>();

	public void saveUser(User user) {
		users.put(user.getId(), user);
	}

	/**
	 * 创建缓存<br>
	 * 
	 * 当执行getById查询方法时，系统首先会从缓存中获取userId对应的实体 如果实体还没有被缓存，则执行查询方法并将查询结果放入缓存中
	 * 
	 * @param id
	 * @return
	 */
//	@ReadThroughSingleCache(namespace = NAMESPACE, expiration = 3600)
    @Cacheable(value="defaultCache")
	public User getUser(String id) {
		System.out.println("==================" + id);
		return users.get(id);
	}

	/**
	 * 更新緩存 <br>
	 * 当执行updateUser方法时，系统会更新缓存中userId对应的实体 将实体内容更新成@*DataUpdateContent标签所描述的实体
	 * 
	 * @param user
	 */
	@UpdateSingleCache(namespace = NAMESPACE, expiration = 3600)
	public void updateUser(
			@ParameterValueKeyProvider @ParameterDataUpdateContent User user) {
		users.put(user.getId(), user);
	}

	/**
	 * 删除缓存<br>
	 * 
	 * 当执行deleteUser方法时，系统会删除缓存中userId对应的实体
	 * 
	 * @param id
	 */
	@InvalidateSingleCache(namespace = NAMESPACE)
	public void deleteUser(@ParameterValueKeyProvider String id) {
		users.remove(id);
	}
}
