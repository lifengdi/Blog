package com.lifengdi.blog.controller.admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.lifengdi.blog.bean.Tag;
import com.lifengdi.blog.common.StatueEnum;
import com.lifengdi.blog.controller.BaseController;
import com.lifengdi.blog.services.TagService;
import com.lifengdi.blog.util.DateTimeUtil;

/**
 * 标签
 * @author LiFengdi
 * @date 2018年3月2日 下午5:34:11
 */
@Controller
@RequestMapping("/admin/tag")
public class TagController extends BaseController{
	
	@Autowired
	private TagService tagService;
	
	@ResponseBody
	@RequestMapping(value="/list")
	Object list(HttpServletRequest request, HttpServletResponse response, @RequestParam int type) {
		if (type < 0) {
			type = 0;
		}
		JSONObject jsonObject = new JSONObject();
		List<Tag> tags = tagService.selectByType(type);
		JSONArray jsonArray = new JSONArray();
		if (!CollectionUtils.isEmpty(tags)) {
			for (Tag tag : tags) {
				jsonArray.add(JSON.toJSON(tag));
			}
		}
		jsonObject.put("tags", jsonArray);
		return success(jsonObject);
	}
	
	@ResponseBody
	@RequestMapping(value="/add")
	Object add(HttpServletRequest request, HttpServletResponse response) {
		
		return null;
	}
	
	@ResponseBody
	@RequestMapping(value="/save")
	Object save(HttpServletRequest request, HttpServletResponse response, Tag tag) {
		int result = -1;
		if (tag.getName() == null || tag.getType() == null) {
			return null;
		}
		if (tag.getStatus() == null) {
			tag.setStatus(StatueEnum.VALID.getValue());
		}
		if (tag.getId() == null) {
			// 新增
			tag.setCreatetime(DateTimeUtil.getNow());
			result = tagService.insert(tag);
		} else {
			// 修改
			tag.setModifytime(DateTimeUtil.getNow());
			result = tagService.update(tag);
		}
		return success(result);
	}

}

