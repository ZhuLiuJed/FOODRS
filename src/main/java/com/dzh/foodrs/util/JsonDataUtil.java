package com.dzh.foodrs.util;
import org.springframework.data.domain.Page;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by holyfrans on 2017/3/10.
 * ������Ҫ����������ת��Ϊ�ϸ�Ҫ���Map��ͨ��springmvc�Ϳ�
 * ��ת��Ϊjson
 */
public class JsonDataUtil {
//	��ҳ
    public static Map<String, Object> toLayUiMap(Page page){
        Map map = new HashMap<String, Object>();
        map.put("code", 0);
        map.put("msg", "��ȡ�ɹ�");
        map.put("list", page.getContent());
        map.put("count", page.getTotalElements());
        return map;
    }
//  ͨ��
    public static Map<String, Object> toMapCorrectly(String code,String msg,Object object){
    	Map map = new HashMap<String, Object>();
    	map.put("code", code);
        map.put("msg", msg);
        map.put("content", object);
		return map;
    }
}