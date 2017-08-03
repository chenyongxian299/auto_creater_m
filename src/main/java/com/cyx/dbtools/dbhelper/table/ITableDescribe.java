package com.cyx.dbtools.dbhelper.table;


import com.cyx.dbtools.bean.TableField;

import java.util.List;

public interface ITableDescribe {

    List<TableField> getTableDescribe(String tableName);
    String getTableFields(String tableName);
}
