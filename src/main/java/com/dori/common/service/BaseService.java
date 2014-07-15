/**
 *
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.dori.common.service;

import com.dori.modules.sys.entity.User;
import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Junction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Iterator;
import java.util.List;

/**
 * Service基类
 *
 *
 * @version 2013-05-15
 */
public abstract class BaseService {

    /**
     * 日志对象
     */
    protected Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * 数据范围过滤
     *
     * @param user        当前用户对象，通过“UserUtils.getUser()”获取
     * @param officeAlias 机构表别名，例如：dc.createAlias("office", "office");
     * @param userAlias   用户表别名，传递空，忽略此参数
     * @return 标准连接条件对象
     */
    protected static Junction dataScopeFilter(User user, String officeAlias, String userAlias) {


        return null;
    }

    /**
     * 数据范围过滤
     *
     * @param user        当前用户对象，通过“UserUtils.getUser()”获取
     * @param officeAlias 机构表别名，例如：dc.createAlias("office", "office");
     * @param userAlias   用户表别名，传递空，忽略此参数
     * @return ql查询字符串
     */
    protected static String dataScopeFilterString(User user, String officeAlias, String userAlias) {
        Junction junction = dataScopeFilter(user, officeAlias, userAlias);
        Iterator<Criterion> it = junction.conditions().iterator();
        StringBuilder ql = new StringBuilder();
        ql.append(" and (");
        if (it.hasNext()) {
            ql.append(it.next());
        }
        String[] strField = {".parentIds like ", ".type="}; // 需要给字段增加“单引号”的字段。
        while (it.hasNext()) {
            ql.append(" or (");
            String s = it.next().toString();
            for (String field : strField) {
                s = s.replaceAll(field + "(\\w.*)", field + "'$1'");
            }
            ql.append(s).append(")");
        }
        ql.append(")");
        return ql.toString();
    }

    protected List<Long> getIdList(String ids) {
        List<Long> idList = Lists.newArrayList();
        if (StringUtils.isNotBlank(ids)) {
            ids = ids.trim().replace("　", ",").replace(" ", ",").replace("，", ",");
            String[] arrId = ids.split(",");
            for (String id : arrId) {
                if (id.matches("\\d*")) {
                    idList.add(Long.valueOf(id));
                }
            }
        }
        return idList;
    }
}
