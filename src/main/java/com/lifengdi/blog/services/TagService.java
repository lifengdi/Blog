package com.lifengdi.blog.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lifengdi.blog.bean.Tag;
import com.lifengdi.blog.bean.TagExample;
import com.lifengdi.blog.mybatis.mapper.TagMapper;

@Service
public class TagService {

	@Autowired
	private TagMapper tagMapper;

	/**
	 * 根据类型查询标签
	 * @author LiFengdi
	 * @date 2017年12月12日 下午4:16:16
	 * @param type
	 * @return
	 */
	public List<Tag> selectByType(int type) {
		try {
			TagExample tagExample = new TagExample();
			if (type >= 0) {
				tagExample.createCriteria().andTypeEqualTo(type);
			}
			return tagMapper.selectByExample(tagExample);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	/**
	 * 插入数据
	 * @author LiFengdi
	 * @date 2018年3月2日 下午5:31:13
	 * @param record
	 * @return
	 */
	public int insert(Tag record) {
		return tagMapper.insert(record);
	}
	
	/**
	 * 更新数据
	 * @author LiFengdi
	 * @date 2018年3月2日 下午5:32:22
	 * @param record
	 * @return
	 */
	public int update(Tag record) {
		return tagMapper.updateByPrimaryKey(record);
	}
}
