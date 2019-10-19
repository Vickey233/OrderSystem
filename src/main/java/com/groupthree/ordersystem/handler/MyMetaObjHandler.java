package com.groupthree.ordersystem.handler;

import com.baomidou.mybatisplus.mapper.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class MyMetaObjHandler extends MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {
        //新增时填充的字段
        setFieldValByName("createDate", new Date(), metaObject);

    }

    @Override
    public void updateFill(MetaObject metaObject) {
        //更新时 需要填充字段
        setFieldValByName("updateDate", new Date(), metaObject);
    }
}