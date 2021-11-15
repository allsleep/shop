package com.service.goods.service.impl;

import com.service.goods.dao.SpecMapper;
import com.service.goods.service.SpecService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;

@Service
public class SpecServiceImpl implements SpecService {
    @Autowired
    private SpecMapper specMapper;

    @Override
    public List<Map> findSpecListByCategoryName(String categoryName) {
        List<Map> specListByCategoryName = specMapper.findSpecListByCategoryName(categoryName);
        for (Map map : specListByCategoryName) {
            String[] options = ((String) map.get("options")).split(",");
            map.put("option", options);
        }
        return specListByCategoryName;
    }
}
