package org.springframework.social.wish.api;

 
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.dozer.CustomConverter;
 

public class TagDozerConverter  implements CustomConverter {

	public TagDozerConverter() {
		super();
		// TODO Auto-generated constructor stub
	}

 

	public Object convert(Object existingDestinationFieldValue, Object source, Class<?> destinationClass,
			Class<?> sourceClass) {
		if (source == null) {
			return null;
		}
		if (sourceClass.equals(ArrayList.class)){
			@SuppressWarnings("unchecked")
			List<Tag> list = (List<Tag>)source;
			String tagStr = (String)existingDestinationFieldValue;
			Integer i = 0;
			for(Tag tag: list){
				if (i == 0)
					tagStr += tag.name;
				else 
					tagStr += ","+tag.name;
				i++;
			}
			return tagStr;
		} else {
			String listStr = (String)source;
			List<Tag> list = new ArrayList<Tag>();
			for (String tagStr : (StringUtils.split(listStr, "|"))){
				String parts[] = tagStr.split(",");
				String idStr = parts[0].replace("id:", "");
				String nameStr = parts[1].replace("name:", "");
				Tag tag = new Tag();
				tag.setId(idStr);
				tag.setName(nameStr);
				list.add(tag);
			}
			return list;
			
		}
		
		
 
	}

    
}